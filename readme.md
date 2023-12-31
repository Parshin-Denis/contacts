# Консольное SPRING приложение для управления списком контактов.

## Описание работы
Программа по запросу пользователя добавляет, удаляет и выводит список контактов в консоль или в файл на жестком диске.
Контакт состоит из имени, номер телефона и e@mail.


## Настройки
В файле конфигурации `src/resources/application.properties` можно установить следующие 3 параметра:

```Java Properties
spring.profiles.active=init
app.storage.input-filename=src/main/resources/contacts.txt
app.storage.output-filename=out/contacts.txt
```
В параметре `spring.profiles.active` указывается профиль, если его значение равно `init`, то при запуске приложения
будет загружен список контактов из файла указанного в параметре `app.storage.input-filename`.
В параметре `app.storage.output-filename` указывается файл, в который будет выгружаться список контактов
по команде пользователя.  

## Управление
Управляется приложение вводом в консоли номера нужного пункта меню
```
Главное меню:
    1 - вывод всех контактов
    2 - добавить новый контакт
    3 - удалить контакт
    4 - сохранить контакты в файл
    0 - завершение работы
```
1. Выводится в консоль спсиок всех контактов в формате: `Ф. И. О. | Номер телефона | Адрес электронной почты`
2. Вводится новый контакт в формате: `Ф. И. О.; номер телефона; адрес электронной почты`
3. Удаляется из списка контакт по его e-mail
4. Выгружается в файл, указанный в параметрах, список всех контактов в формате
`Ф. И. О. | Номер телефона | Адрес электронной почты`
