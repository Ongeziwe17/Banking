package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Contact;
import za.ac.cput.service.impl.ContactServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    private final ContactServiceImpl contactService;
    @Autowired
    public ContactController(ContactServiceImpl contactService) { this.contactService = contactService; }
    @PostMapping("/create")
    public Contact create(@RequestBody Contact contact){ return contactService.create(contact); }
    @GetMapping("/read/{email}")
    public Contact read(@PathVariable String email){ return contactService.read(email); }
    @PutMapping("/update")
    public Contact update(@RequestBody Contact contact){ return contactService.update(contact); }
    @GetMapping("/getallcontacts")
    public Set<Contact> getAll(){ return contactService.getAll(); }

}
