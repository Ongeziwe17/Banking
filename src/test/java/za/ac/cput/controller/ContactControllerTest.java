package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.Contact;
import za.ac.cput.factory.ContactFactory;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContactControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private static final String Base_URL = "http://localhost:8080/manage/contacts";
    private static Contact contact1, contact2, contact3;
    @BeforeAll
    static void setUp() {
        contact1 = ContactFactory.buildContact("jay@gmail.com", "0711622622");
        contact2 = ContactFactory.buildContact("yonda@gmail.com", "0795109767");
        contact3 = ContactFactory.buildContact("kwanda@gmail.com", "0784909331");
    }

    @Test
    @Order(1)
    void create() {
        String createURL = Base_URL + "/create";
        System.out.println("URL: " + createURL);
        ResponseEntity<Contact> response1 = restTemplate.postForEntity(createURL, contact1, Contact.class);
        ResponseEntity<Contact> response2 = restTemplate.postForEntity(createURL, contact2, Contact.class);
        ResponseEntity<Contact> response3 = restTemplate.postForEntity(createURL, contact3, Contact.class);
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
        String email = contact2.getEmail();
        String readURL = Base_URL + "/read/" + email;
        System.out.println("URL: " + readURL);
        ResponseEntity<Contact> response = restTemplate.getForEntity(readURL, Contact.class);
        assertNotNull(response);
        System.out.println(response.getBody());
    }

    @Test
    @Order(3)
    void update() {
        String updateURL = Base_URL + "/update";
        System.out.println("URL: " + updateURL);
        Contact contactUpdate = new Contact.Builder().copy(contact3).setCellNumber("0617890976").build();
        HttpEntity<Contact> entity = new HttpEntity<>(contactUpdate);
        ResponseEntity<Contact> response = restTemplate.exchange(updateURL, HttpMethod.PUT, entity, Contact.class);
        assertNotNull(response);
        System.out.println(response.getBody());
    }

    @Test
    @Order(4)
    void getAll() {
        String getallURL = Base_URL + "/getallcontacts";
        System.out.println("URL: " + getallURL);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getallURL, HttpMethod.GET, entity, String.class);
        assertNotNull(response);
        System.out.println(response.getBody());
    }
}