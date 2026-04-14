import java.util.*;
public class Hashset {
    public static void main(String[] args) {
        HashSet<Integer>set=new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(4);
        set.add(3);
        set.add(2);
        set.add(4);
        // System.out.println(set);
        // System.out.println(set.contains(2));
        // set.clear();
        // System.out.println(set.size());
        // System.out.println(set.isEmpty());


        //Iteration on hashset
        Iterator it=set.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }

        for(int i:set)System.out.println(i);
        
    }
}
