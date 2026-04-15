import java.util.*;

public class groupAnagramsTrie {
    static class Node{
        Node[] children=new Node[26];
        List<String>list;

        public Node()
        {
            for(int i=0;i<26;i++)
            {
                children[i]=null;
            }
            list=new ArrayList<>();
        }
    }
    static Node root=new Node();
    public static void insert(String word)
    {
        Node curr=root;

        char[] arr=word.toCharArray();
        Arrays.sort(arr);
        for(char ch:arr)
        {
            int idx=ch-'a';
            if(curr.children[idx]==null)curr.children[idx]=new Node();
            curr=curr.children[idx];
        }
        curr.list.add(word);
    }
    public static List<List<String>>groupAnagrams(String[] strs)
    {
        for(String word:strs)
        {
            insert(word);
        }
        List<List<String>>result=new ArrayList<>();
        collect(root,result);
        return result;
    }

    public static void collect(Node root,List<List<String>>result)
    {
        if(root==null)return;
        if(root.list.size()>0)
        {
            result.add(root.list);
        }
        for(int i=0;i<26;i++)
        {
            collect(root.children[i], result);
        }
    }
    public static void main(String[] args) {
        String strs[]={"eat","tea","ate","tan","nat","nat","bat"};
        List<List<String>>ans=groupAnagrams(strs);
        for(List w:ans)
        {
            System.out.println(w);
        }
        
    }
}
