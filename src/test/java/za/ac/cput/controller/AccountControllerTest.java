package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.Account;
import za.ac.cput.entity.enums.AccountType;
import za.ac.cput.factory.AccountFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private static final String Base_URL = "http://localhost:8080/manage/accounts";
    private static Account account1, account2, account3;


    @BeforeEach
    void setUp() {
        // 1st account
        LocalDateTime dateCreated1 = LocalDateTime.of(2024, 8, 5, 10,30);
        LocalDate expiryDate1 = LocalDate.of(2028, 8, 5);
        account1 = AccountFactory.buildAccount(28543282L, AccountType.SAVINGS_ACCOUNT, dateCreated1, expiryDate1);
        // 2nd account
        LocalDateTime dateCreated2 = LocalDateTime.of(2024, 1, 5, 15,30);
        LocalDate expiryDate2 = LocalDate.of(2028, 1, 5);
        account2 = AccountFactory.buildAccount(76548976L, AccountType.BUSINESS_ACCOUNT, dateCreated2, expiryDate2);
        // 3rd account
        LocalDateTime dateCreated3 = LocalDateTime.of(2024, 12, 15, 11,10);
        LocalDate expiryDate3 = LocalDate.of(2028, 12, 15);
        account3 = AccountFactory.buildAccount(42672865L, AccountType.INVESTMENT_ACCOUNT, dateCreated3, expiryDate3);


    }

    @Test
    @Order(1)
    void create() {
        String createURL = Base_URL + "/create";
        System.out.println("URL: " + createURL);
        ResponseEntity<Account> response1 = restTemplate.postForEntity(createURL, account1, Account.class);
        ResponseEntity<Account> response2 = restTemplate.postForEntity(createURL, account2, Account.class);
        ResponseEntity<Account> response3 = restTemplate.postForEntity(createURL, account3, Account.class);
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
        long accountId = account2.getAccountId();
        String readURL = Base_URL + "/read/" + accountId;
        System.out.println("URL: " + readURL);
        ResponseEntity<Account> response = restTemplate.getForEntity(readURL, Account.class);
        assertNotNull(response);
        System.out.println(response.getBody());
    }

    @Test
    @Order(3)
    void update() {
        String updateURL = Base_URL + "/update";
        System.out.println("URL: " + updateURL);
        Account accountUpdate = new Account.Builder().copy(account3).setAccountType(AccountType.BUSINESS_ACCOUNT).build();
        HttpEntity<Account> entity = new HttpEntity<>(accountUpdate);
        ResponseEntity<Account> response = restTemplate.exchange(updateURL, HttpMethod.PUT, entity, Account.class);
        assertNotNull(response);
        System.out.println(response.getBody());
    }

    @Test
    @Order(4)
    void getAll() {
        String getAllURL = Base_URL + "/getallaccounts";
        System.out.println("URL: " + getAllURL);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getAllURL, HttpMethod.GET, entity, String.class);
        assertNotNull(response);
        System.out.println(response.getBody());
    }
}