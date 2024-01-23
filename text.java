import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();
        
        // Добавление номеров телефонов
        addPhone(phoneBook, "Иванов", "123456789");
        addPhone(phoneBook, "Петров", "987654321");
        addPhone(phoneBook, "Сидоров", "456789123");
        addPhone(phoneBook, "Иванов", "654321987");
        addPhone(phoneBook, "Петров", "789456123");
        
        // Вывод телефонной книги
        printPhoneBook(phoneBook);
    }
    
    // Метод для добавления номера телефона в телефонную книгу
    public static void addPhone(HashMap<String, ArrayList<String>> phoneBook, String name, String phone) {
        if (phoneBook.containsKey(name)) {
            ArrayList<String> phones = phoneBook.get(name);
            phones.add(phone);
            phoneBook.put(name, phones);
        } else {
            ArrayList<String> phones = new ArrayList<>();
            phones.add(phone);
            phoneBook.put(name, phones);
        }
    }
    
    // Метод для вывода телефонной книги
    public static void printPhoneBook(HashMap<String, ArrayList<String>> phoneBook) {
        // Создание списка Entry из элементов телефонной книги
        List<Map.Entry<String, ArrayList<String>>> entries = new LinkedList<>(phoneBook.entrySet());
        
        // Сортировка списка Entry по убыванию числа телефонов
        Collections.sort(entries, new Comparator<Map.Entry<String, ArrayList<String>>>() {
            @Override
            public int compare(Map.Entry<String, ArrayList<String>> entry1, Map.Entry<String, ArrayList<String>> entry2) {
                return entry2.getValue().size() - entry1.getValue().size();
            }
        });
        
        // Вывод телефонной книги
        for (Map.Entry<String, ArrayList<String>> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}