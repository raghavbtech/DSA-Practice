public class RemoveDuplicates {
    public static void remove(String str,int idx,StringBuilder newStr,boolean[] map){
        if(idx==str.length()){
            System.out.println(newStr);
            return;
        }

        //kaam
        char curr=str.charAt(idx);
        if(map[curr-'a']==true){
            //duplicate
            remove(str, idx+1, newStr, map);
        }
        else{
            map[curr-'a']=true;
            remove(str, idx+1, newStr.append(curr), map);
        }
        

    }
}
