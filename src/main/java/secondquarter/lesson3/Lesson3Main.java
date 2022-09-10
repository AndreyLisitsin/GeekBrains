package secondquarter.lesson3;

import java.util.HashMap;
import java.util.Map;

public class Lesson3Main {
    public static void main(String[] args) {

        String [] s = new String[5];
        s[0] = "123";
        s[1] = "22";
        s[2] = "123";
        s[3] = "123";
        s[4] = "22";
        findDuplicate(s);

    }

    public static Map<String, Integer> findDuplicate(String[] array){

        Map<String, Integer> hashmap = new HashMap<>();
        for (String s: array) {
            if (hashmap.containsKey(s)){
                hashmap.replace(s,hashmap.get(s)+1);
            }
            else {
                hashmap.put(s,1);
            }
        }
        for (Map.Entry<String, Integer> entry: hashmap.entrySet()) {
            System.out.println(entry);
        }
        return hashmap;
    }
}
