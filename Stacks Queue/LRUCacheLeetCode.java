import java.util.*;
public class LRUCacheLeetCode {
    class LRUCache{
        private int capacity;
        private LinkedHashMap<Integer,Integer>lhm;

        public LRUCache(int capacity){
            this.capacity=capacity;
            this.lhm=new LinkedHashMap<>(capacity,0.75f,true);
        }

        public int get(int key){
            return lhm.getOrDefault(key, -1);
        }

        public void put(int key,int val){
            if(lhm.size()>=capacity && !lhm.containsKey(key)){
                int lruKey=lhm.entrySet().iterator().next().getKey();
                lhm.remove(lruKey);
            }
            lhm.put(key, val);

        }
    }
    public static void main(String[] args) {
        
    }
}
