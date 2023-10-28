package org.example;

public class MessageStorage {
    static final String MENU = "Главное меню:" + System.lineSeparator() + System.lineSeparator() +
            "1 - вывод всех контактов" + System.lineSeparator() + "2 - добавить новый контакт" + System.lineSeparator() +
            "3 - удалить контакт" + System.lineSeparator() + "4 - сохранить контакты в файл" + System.lineSeparator() +
            "0 - завершение работы" + System.lineSeparator() + System.lineSeparator() + "Введите номер пункта  меню: ";

    static final String INPUT_CONTACT = "Введите контакт в формате: Ф. И. О.; номер телефона; адрес электронной почты: ";
    static final String INPUT_CONTACT_EMAIL = "Введите e-mail контакта: ";
    static final String FILE_SAVED = "Список контактов записан в файл";
    static final String CONTACT_LIST = "Список контактов:";
    static final String NO_CONTACTS = "Список контактов пуст";
    static final String CONTACT_NOT_FOUND = "Контакт с таким e-mail не найден";
    static final String SHUTDOWN = "Работа завершена";
    static final String WRONG_MENU_NUMBER = "Введен некорректный пункт меню.";
    static final String WRONG_FORMAT = "Неверный формат, повторите ввод: ";
}
