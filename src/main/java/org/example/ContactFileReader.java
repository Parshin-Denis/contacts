package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Component
@Profile("init")
public class ContactFileReader {
    @Value("${app.storage.input-filename}")
    private String fileName;

    public List<Contact> getContactList(){
        List<Contact> contactList = new ArrayList<>();
        try {
            List<String> defaultsContacts = Files.readAllLines(Path.of(fileName));
            defaultsContacts.forEach(c -> {
                Contact contact = new Contact();
                String[] contactData = c.split(";");
                contact.setName(contactData[0]);
                contact.setPhone(contactData[1]);
                contact.setMail(contactData[2]);
                contactList.add(contact);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return contactList;
    }
}
