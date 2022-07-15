package secondquarter.lesson3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PhoneBook {
    private static PhoneBook phoneBook;
    private final Map<Integer, String> phoneBookMap = new HashMap<>();

    private  PhoneBook(){
    };

    public static PhoneBook getInstance(){
        if (phoneBook == null){
            phoneBook = new PhoneBook();
        }
        return phoneBook;
    }

    public void add(int number, String lastName){
        phoneBookMap.put(number,lastName);
    }

    public List<Map.Entry<Integer, String>> get(String lastname){
        return phoneBookMap.entrySet()
                .stream()
                .filter(e -> e.getValue().equals(lastname))
                .collect(Collectors.toList());
    }
}
