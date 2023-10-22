import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Phonebook {
    public static void main(String[] args) {
        Book phoneBook = new Book();
        phoneBook.add("659803","Иванов");
        phoneBook.add("5550156","Петров");
        phoneBook.add("222456","Иванов");
        phoneBook.add("333456","Иванов");
        phoneBook.add("11156","Сидоров");
        phoneBook.add("123456","Иванов");
        phoneBook.add("6655856","Иванов");

        System.out.println(phoneBook.getAll());
    }
}

class Book {
    private Map<String, List<String>> map = new HashMap<>();

    void add(String phoneNum, String name) {
        if (map.containsKey(name)) {
            List<String> phoneNumbers = map.get(name);
            phoneNumbers.add(phoneNum);

        } else {
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNum);
            map.put(name, phoneNumbers);
        }
    }

    String getAll() {
        StringBuilder stringBuilder = new StringBuilder();
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(map.entrySet());
        entries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));
        for (Map.Entry<String, List<String>> entry : entries) {
            List<String> phoneNumbers = entry.getValue();
            stringBuilder.append(entry.getKey());
            stringBuilder.append(" : ");
            stringBuilder.append(phoneNumbers);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
