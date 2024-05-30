package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.*;
import za.ac.cput.entity.enums.AccountType;
import za.ac.cput.factory.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountHolderControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private static final String Base_URL = "http://localhost:8080/manage/accountholders";
    private static Name name1, name2, name3;
    private static Contact contact1, contact2, contact3;
    private static Address address1, address2, address3;
    private static Account account1, account2, account3;
    private static AccountHolder accountHolder1, accountHolder2, accountHolder3;


    @BeforeAll
    public static void setUp() {
        // 1st account holder
        name1 = NameFactory.buildName("Tomas", "Inga");
        contact1 = ContactFactory.buildContact("tom@gmail.com", "0768622622");
        address1 = AddressFactory.buildAddress(10, "Dorset Street", "Cape Town", 8001);
        account1 = AccountFactory.buildAccount(18764528L, AccountType.SAVINGS_ACCOUNT, LocalDateTime.of(2024, 8, 5, 10,30), LocalDate.of(2028, 8, 5));
        accountHolder1 = AccountHolderFactory.accountHolderFactory(99867098765437L, name1, contact1, address1, account1);
        // 2nd account holder
        name2 = NameFactory.buildName("Sindiswa", "Hlophe");
        contact2 = ContactFactory.buildContact("sindi@gmail.com", "0784851014");
        address2 = AddressFactory.buildAddress(143, "Sir Lowry Road", "Woodstock", 7925);
        LocalDateTime openingDate = LocalDateTime.of(2023, 5, 17, 10, 10);
        LocalDate expiryDate = LocalDate.of(2027, 5, 17);
        account2 = AccountFactory.buildAccount(23478272L, AccountType.INVESTMENT_ACCOUNT, openingDate, expiryDate);
        accountHolder2 = AccountHolderFactory.accountHolderFactory(46728986143576L, name2, contact2, address2, account2);
        // 3rd account holder
        name3 = NameFactory.buildName("John", "Doe");
        contact3 = ContactFactory.buildContact("john.doe@example.com", "0712345678");
        address3 = AddressFactory.buildAddress(25, "Main Street", "Johannesburg", 2000);
        LocalDateTime openingDate3 = LocalDateTime.of(2022, 10, 15, 9, 45);
        LocalDate expiryDate3 = LocalDate.of(2026, 10, 15);
        account3 = AccountFactory.buildAccount(34897632L, AccountType.BUSINESS_ACCOUNT, openingDate3, expiryDate3);
        accountHolder3 = AccountHolderFactory.accountHolderFactory(12345678901234L, name3, contact3, address3, account3);

    }

    @Test
    @Order(1)
    void create() {
        String createURL = Base_URL + "/create";
        System.out.println("URL: " + createURL);
        ResponseEntity<AccountHolder> response1 = restTemplate.postForEntity(createURL, accountHolder1, AccountHolder.class);
        ResponseEntity<AccountHolder> response2 = restTemplate.postForEntity(createURL, accountHolder2, AccountHolder.class);
        ResponseEntity<AccountHolder> response3 = restTemplate.postForEntity(createURL, accountHolder3, AccountHolder.class);
        assertNotNull(response1);
        assertNotNull(response2);
        assertNotNull(response3);
        System.out.println(response1.getBody());
        System.out.println(response2.getBody());
        System.out.println(response3.getBody());
    }

    @Test
    @Order(2)
    void read() {
        long accountHolderId = accountHolder1.getAccountHolderId();
        String readURL = Base_URL + "/read/" + accountHolderId;
        System.out.println("URL: " + readURL);
        ResponseEntity<AccountHolder> response = restTemplate.getForEntity(readURL, AccountHolder.class);
        assertNotNull(response);
        System.out.println(response.getBody());
    }

    @Test
    @Order(3)
    void update() {
        String updateURL = Base_URL + "/update";
        System.out.println("URL: " + updateURL);
        Name nameUpdate = new Name.Builder().copy(name1).setFirstName("Tomas Joe").build();
        Contact contactUpdate = new Contact.Builder().copy(contact1).setCellNumber("0768818989").build();
        AccountHolder accountHolderUpdated = new AccountHolder.Builder().copy(accountHolder1).setName(nameUpdate).setContact(contactUpdate).build();
        HttpEntity<AccountHolder> entity = new HttpEntity<>(accountHolderUpdated);
        ResponseEntity<AccountHolder> response = restTemplate.exchange(updateURL, HttpMethod.PUT, entity, AccountHolder.class);
        assertNotNull(response);
        System.out.println(response.getBody());
    }

    @Test
    @Disabled
    @Order(5)
    void delete() {
        long accountHolderId = accountHolder3.getAccountHolderId();
        String deleteURL = Base_URL + "/delete/" + accountHolderId;
        System.out.println("URL: " + deleteURL);
        restTemplate.delete(deleteURL);
        System.out.println("DELETED");
    }

    @Test
    @Order(4)
    void getAll() {
        String getAllURL = Base_URL + "/getallaccountholders";
        System.out.println("URL: " + getAllURL);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getAllURL, HttpMethod.GET, entity, String.class);
        assertNotNull(response);
        System.out.println(response.getBody());
    }
}