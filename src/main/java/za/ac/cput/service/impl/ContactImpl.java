package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Contact;
import za.ac.cput.repository.ContactRepository;
import za.ac.cput.service.IContactService;

import java.util.HashSet;
import java.util.Set;

@Service
public class ContactImpl implements IContactService {
    private final ContactRepository repository;
    @Autowired
    public ContactImpl(ContactRepository repository) {
        this.repository = repository;
    }

    @Override
    public Contact create(Contact contact) {
        return repository.save(contact);
    }

    @Override
    public Contact read(String email) {
        return repository.findById(email).orElseThrow();
    }

    @Override
    public Contact update(Contact contact) {
        return repository.save(contact);
    }

    @Override
    public Set<Contact> getAll() {
        return new HashSet<>(repository.findAll());
    }

}
