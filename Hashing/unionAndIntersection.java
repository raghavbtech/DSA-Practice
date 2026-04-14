import java.util.*;
public class unionAndIntersection {
    public static void main(String[] args) {
        int[] arr1={7,3,9};
        int[] arr2={6,3,9,2,9,4};

        HashSet<Integer>set=new HashSet<>();
        //union
        for(int i:arr1)set.add(i);
        for(int i:arr2)set.add(i);

        System.out.println("Union: "+set.size());

        set.clear();
        //intersection
        int count=0;
        for(int i:arr1)set.add(i);
        for(int i:arr2){
            if(set.contains(i)){
                count++;
                set.remove(i);
            }
        }

        System.out.println("Intersection: "+count);
    }
}
