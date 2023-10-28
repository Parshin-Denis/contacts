package org.example;

import lombok.Data;

@Data
public class Contact {
    private String name;
    private String phone;
    private String mail;

    @Override
    public String toString() {
        return name + "|" + phone + "|" + mail;
    }
}
