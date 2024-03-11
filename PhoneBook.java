import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        // Создаем HashMap для хранения данных (имя - список телефонов)
        Map<String, List<String>> phoneBook = new HashMap<>();

        // Пример входных данных
        addContact(phoneBook, "Иванов", "1234567890");
        addContact(phoneBook, "Петров", "9876543210");
        addContact(phoneBook, "Сидоров", "5555555555");
        addContact(phoneBook, "Иванов", "7777777777");
        addContact(phoneBook, "Петров", "8888888888");

        // Сортируем записи по убыванию числа телефонов
        List<Map.Entry<String, List<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        // Выводим результат
        for (Map.Entry<String, List<String>> entry : sortedEntries) {
            System.out.println("Имя: " + entry.getKey());
            System.out.println("Телефоны: " + entry.getValue());
            System.out.println();
        }
    }

    // Метод для добавления контакта в телефонную книгу
    public static void addContact(Map<String, List<String>> phoneBook, String name, String phoneNumber) {
        List<String> phoneNumbers = phoneBook.getOrDefault(name, new ArrayList<>());
        phoneNumbers.add(phoneNumber);
        phoneBook.put(name, phoneNumbers);
    }
}