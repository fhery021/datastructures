import java.util.LinkedHashMap;
import java.util.Map;

public class UniqueProduct {
    public static String firstUniqueProduct(String[] products) {
        Map<String, Integer> countMap = new LinkedHashMap<>();

        for (String value: products) {
            countMap.put(value, countMap.getOrDefault(value, 0) + 1);

        }
        for (Map.Entry<String, Integer> entry: countMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqueProduct(new String[] { "Apple", "Computer", "Apple", "Bag"  }));
    }
}
