public class startwith {
    static class Node{
        Node[] children=new Node[26];
        boolean eow=false;

        public Node()
        {
            for(int i=0;i<26;i++)
            {
                children[i]=null;
            }
        }
    }

    public static Node root=new Node();

    public static void insert(String word)
    {
        Node curr=root;
        for(int level=0;level<word.length();level++)
        {
            int idx=word.charAt(level)-'a';
            if(curr.children[idx]==null)
            {
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }

    public static boolean startsWith(String prefix)   //O(l)
    {
        Node curr=root;
        for(int i=0;i<prefix.length();i++)
        {
            int idx=prefix.charAt(i)-'a';
            if(curr.children[idx]==null)return false;
            curr=curr.children[idx];
        }
        return true;

    }
    public static void main(String[] args) {
        String[] words={"apple","app","mango","man","woman"};
        String prefix="app";
        String prefix2="moon";
        for(String w:words)
        {
            insert(w);
        }
        System.out.println(startsWith("app"));
        System.out.println(startsWith("moon"));
        
    }
}
