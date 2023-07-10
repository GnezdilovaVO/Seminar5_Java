// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут 
// повторяющиеся имена с разными телефонами, их необходимо считать, 
// как одного человека с разными телефонами. 
// Вывод должен быть отсортирован по убыванию числа телефонов.
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;


public class program5_1 {
    public static void main(String[] args) {
        System.out.println(numerateNumber());
    }

    public static Map<Integer, String> fillMap() {
        Map<Integer, String> data = new HashMap<>();
        data.put(1234567, "Иванов Иван");
        data.put(2345678, "Иванов Иван");
        data.put(3456789, "Петров Петр");
        data.put(4567891, "Сергеев Сергей");
        data.put(5678912, "Петров Петр");
        data.put(6789123, "Петров Петр");
        return data;
    }
    public static TreeMap<Integer, String> numerateNumber() {
        Map<Integer, String> dataBase = fillMap();
        ArrayList<String> countUser = new ArrayList<String>(dataBase.values());
        TreeMap<Integer, String> result = new TreeMap<>((Collections.reverseOrder()));
        Collections.sort(countUser);
        int count = 1;
        String userName = countUser.get(0);
        for (int i = 1; i < countUser.size(); i++) {
            String nextUserName = countUser.get(i);
            if (userName.equals(nextUserName)) {
                count++;
            } else {
                result.put(count, userName);
                count = 1;
                userName = nextUserName;
            }
        }
        result.put(count, userName);
        return result;
    }

}
