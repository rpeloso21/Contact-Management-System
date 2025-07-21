package com.example.hello_world;

import com.example.hello_world.Contact;

import java.util.List;
import java.util.Optional;


public interface ContactService {
    Contact createContact(Contact contact);
    List<Contact> getAllContacts();
    List<Contact> getContactByLastName(String lastName);
    Optional<Contact> getContactById(Long id);
    Contact updateContact(Long id, Contact contact);
    void deleteContact(Long id);
    void populateDatabase();
}
