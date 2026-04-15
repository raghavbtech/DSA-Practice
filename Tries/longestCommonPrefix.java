public class longestCommonPrefix {
    static class Node{
        Node[] children=new Node[26];
        boolean eow=false;
        int childCount=0;
    }
    static Node root=new Node();
    public static void insert(String word)
    {
        Node curr=root;
        for(char ch:word.toCharArray())
        {
            int idx=ch-'a';
            if(curr.children[idx]==null)
            {
                curr.children[idx]=new Node();
                curr.childCount++;
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }

    public static String longestCommonpre(String[] strs)
    {
        for(String w:strs)insert(w);
        StringBuilder ans=new StringBuilder();
        Node curr=root;
        while(curr.childCount==1 && curr.eow==false)
        {
            for(int i=0;i<26;i++)
            {
                if(curr.children[i]!=null)
                {
                    ans.append((char)(i+'a'));
                    curr=curr.children[i];
                    break;
                }
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        String strs[] ={"flower","flow","flight"};
        System.out.println(longestCommonpre(strs));
        
    }
}
