public class longestwordwithallprefixes {
     static class Node{
        Node[] children=new Node[26];
        boolean eow;

        public Node()
        {
            for(int i=0;i<children.length;i++)
            {
                children[i]=null;
            }
            eow=false;
        }
    }

    public static Node root=new Node();

    public static void insert(String word)
    {
        Node curr=root;
        for(int i=0;i<word.length();i++)
        {
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null)
            {
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }
    static String ans="";
    public static void longestWord(Node root,StringBuilder temp)
    {
        if(root==null)return;

        for(int i=0;i<26;i++)
        {
            if(root.children[i] != null && root.children[i].eow)
            {
                char ch=(char)(i+'a');
                temp.append(ch);
                if(temp.length()>ans.length())
                {
                    ans=temp.toString();
                }
                longestWord(root.children[i], temp);
                //backtrack
                temp.deleteCharAt(temp.length()-1);
            }
        }

    }


    public static void main(String[] args) {
        String[] words={"a","banana","app","appl","ap","apply","apple"};
        for(String w:words)
        {
            insert(w);
        }
        longestWord(root, new StringBuilder(""));
        System.out.println(ans);

        
    }
}
