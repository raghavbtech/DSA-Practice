import java.util.*;

public class HashMapBasics {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        // Insert
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);

        System.out.println(hm);

        // Get - 0(1)
        int population = hm.get("India");
        System.out.println(population);

        System.out.println(hm.get("Indonesia"));

        // ContainsKey - 0(1)
        System.out.println(hm.containsKey("India")); // true
        System.out.println(hm.containsKey("Indonesia")); // false

        // Remove O(1)
        System.out.println(hm.remove("China"));
        System.out.println(hm);

        System.out.println(hm.size());

        System.out.println(hm.isEmpty());
        // hm.clear();
        // Iterate
        //hm.entrySet
        Set<String> keys = hm.keySet();
        System.out.println(keys);

        for (String k: keys) {
            System.out.println(k+hm.get(k));
        }
    }
}
