package com.example.hello_world;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public List<Contact> getAllContacts() {
        logger.info("GET request received: getAllContacts");
        List<Contact> contacts = contactService.getAllContacts();
        logger.debug("Returning {} contacts", contacts.size());
        return contacts;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
        logger.info("GET request received: getContactById with id={}", id);
        return contactService.getContactById(id)
                .map(contact -> {
                    logger.debug("Contact found: {}", contact);
                    return ResponseEntity.ok(contact);
                })
                .orElseGet(() -> {
                    logger.warn("Contact not found with id={}", id);
                    return ResponseEntity.notFound().build();
                });
    }

    @GetMapping("/search")
    public List<Contact> getContactByLastName(@RequestParam String lastName) {
        logger.info("GET request received: getContactByLastName with lastName={}", lastName);
        List<Contact> results = contactService.getContactByLastName(lastName);
        logger.debug("Found {} contacts with lastName={}", results.size(), lastName);
        return results;
    }

    @PostMapping
    public Contact createContact(@RequestBody Contact contact) {
        logger.info("POST request received: createContact");
        Contact created = contactService.createContact(contact);
        logger.debug("Contact created: {}", created);
        return created;
    }

    @PostMapping("/populate")
    public ResponseEntity<String> populateDatabase() {
        logger.info("POST request received: populateDatabase");
        contactService.populateDatabase();
        logger.info("Database populated successfully.");
        return ResponseEntity.ok("Database populated successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contact) {
        logger.info("PUT request received: updateContact with id={}", id);
        try {
            Contact updated = contactService.updateContact(id, contact);
            logger.debug("Contact updated: {}", updated);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            logger.error("Failed to update contact with id={}. Reason: {}", id, e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        logger.info("DELETE request received: deleteContact with id={}", id);
        contactService.deleteContact(id);
        logger.info("Contact with id={} deleted successfully.", id);
        return ResponseEntity.ok("Contact deleted successfully.");
    }
}

