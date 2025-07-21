package com.example.hello_world;

import com.example.hello_world.Contact;
import com.example.hello_world.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void populateDatabase() {
        Faker faker = new Faker();
        List<Contact> contacts = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String phone = faker.phoneNumber().cellPhone();
            String email = faker.internet().emailAddress();

            contacts.add(new Contact(firstName, lastName, phone, email));
        }

        contactRepository.saveAll(contacts);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public List<Contact> getContactByLastName(String lastName) {
        return contactRepository.findByLastName(lastName);
    }

    @Override
    public Optional<Contact> getContactById(Long id) {
        return contactRepository.findById(id);
    }

    @Override
    public Contact updateContact(Long id, Contact updatedContact) {
        return contactRepository.findById(id)
                .map(contact -> {
                    contact.setFirstName(updatedContact.getFirstName());
                    contact.setLastName(updatedContact.getLastName());
                    contact.setPhone(updatedContact.getPhone());
                    contact.setEmail(updatedContact.getEmail());
                    return contactRepository.save(contact);
                })
                .orElseThrow(() -> new RuntimeException("Contact not found by id " + id));
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}
