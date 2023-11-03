package org.example;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
@Data
public class ContactStorage {
    @Value("${app.storage.output-filename}")
    private String fileName;
    private List<Contact> contactList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    @Autowired(required = false)
    private ContactFileReader contactFileReader;

    public void Manage() {
        if (contactFileReader != null) {
            contactList.addAll(contactFileReader.getContactList());
        }
        String input;
        do {
            System.out.print(MessageStorage.MENU);
            input = scanner.nextLine();
            switch (input) {
                case "1" -> printAllContacts();
                case "2" -> addContact();
                case "3" -> deleteContact();
                case "4" -> printFile();
                case "0" -> System.out.println(MessageStorage.SHUTDOWN);
                default -> System.out.println(MessageStorage.WRONG_MENU_NUMBER);
            }
        } while (!input.equals("0"));
    }

    private void printAllContacts() {
        if (contactList.size() == 0) {
            System.out.println(MessageStorage.NO_CONTACTS + System.lineSeparator());
        } else {
            System.out.println(MessageStorage.CONTACT_LIST);
            contactList.forEach(System.out::println);
            System.out.println("");
        }
    }

    private void addContact() {
        System.out.print(MessageStorage.INPUT_CONTACT);
        String[] contactData;
        do {
            String input = scanner.nextLine();
            contactData = input.split(";");
            if (contactData.length != 3) {
                System.out.print(MessageStorage.WRONG_FORMAT);
            }
        } while (contactData.length != 3);
        Contact contact = new Contact();
        contact.setName(contactData[0].trim());
        contact.setPhone(contactData[1].trim());
        contact.setMail(contactData[2].trim());
        contactList.add(contact);
        System.out.println(System.lineSeparator() + "Контакт " + contact + " добавлен" + System.lineSeparator());
    }

    private void deleteContact() {
        System.out.print(MessageStorage.INPUT_CONTACT_EMAIL);
        String input = scanner.nextLine();
        if (contactList.stream().noneMatch(contact -> contact.getMail().equals(input))){
            System.out.println(MessageStorage.CONTACT_NOT_FOUND + System.lineSeparator());
            return;
        }
        Contact contact = contactList.stream().filter(c -> c.getMail().equals(input)).findFirst().get();
        contactList.remove(contact);
        System.out.println(System.lineSeparator() + "Контакт" + contact + " удалён" + System.lineSeparator());
    }

    private void printFile() {
        List<String> contacts = contactList.stream()
                                           .map(c -> c.toString().replace('|', ';'))
                                           .toList();
        try {
            Files.write(Path.of(fileName), contacts);
            System.out.println(MessageStorage.FILE_SAVED + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
