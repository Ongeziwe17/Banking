package za.ac.cput.service;

import za.ac.cput.entity.Contact;

import java.util.Set;

public interface IContactService extends IService<Contact, String> {
    Set<Contact> getAll();
}
