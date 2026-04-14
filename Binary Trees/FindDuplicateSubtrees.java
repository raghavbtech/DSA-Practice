import java.util.*;


//this is slow

// public class Main {

//     static HashMap<String,Integer> map = new HashMap<>();
//     static ArrayList<Node> result = new ArrayList<>();

//     static String serialize(Node root){
//         if(root == null) return "#";

//         String s = root.data + "," +
//                    serialize(root.left) + "," +
//                    serialize(root.right);

//         int freq = map.getOrDefault(s, 0);

//         if(freq == 1) {        // seen before once → duplicate
//             result.add(root);
//         }

//         map.put(s, freq + 1);
//         return s;
//     }

//     static List<Node> findDuplicateSubtrees(Node root){
//         map.clear();
//         result.clear();
//         serialize(root);
//         return result;
//     }
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
    }
}
public class FindDuplicateSubtrees {
    Map<String,Integer>patternToId=new HashMap<>();
    Map<Integer,Integer>freq=new HashMap<>();

    List<Node>result=new ArrayList<>();
    int nextId=1;
    int dfs(Node root)
    {
        if(root==null) return 0;
        int leftId=dfs(root.left);
        int rightId=dfs(root.right);

        String key=root.data+","+leftId+","+rightId;

        int id=patternToId.computeIfAbsent(key, k->nextId++);
        // If key is missing → compute value using function → store it → return it
        // If key exists → just return existing value

        freq.put(id, freq.getOrDefault(id, 0)+1);
        if(freq.get(id)==2){
             result.add(root);
        }
        return id;
    }

    List<Node>findDuplicateSubtrees(Node root)
    {
        dfs(root);
        return result;
    }

}
