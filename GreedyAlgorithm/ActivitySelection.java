import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection{   //O(n)
    public static void main(String[] args) {
        int[] start={1,3,0,5,8,5};
        int[] end={2,4,6,7,9,9};


        //if not sorted
        int[][] activites=new int[start.length][3];
        for(int i=0;i<start.length;i++){
            activites[i][0]=i;
            activites[i][1]=start[i];
            activites[i][2]=end[i];
        }
        Arrays.sort(activites,Comparator.comparingInt(o->o[2]));

        //end time basis sorted
        int maxAct=0;
        ArrayList<Integer>ans=new ArrayList<>();

        //1st activity
        maxAct=1;
        ans.add(0);

        int lastEnd=end[0];
        for(int i=1;i<start.length;i++){
            if(start[i]>=lastEnd){
                maxAct++;
                ans.add(i);
                lastEnd=end[i];
            }
        }

        System.out.println("Max activites: "+maxAct);

        for(int i=0;i<ans.size();i++){
            System.out.println("A"+ans.get(i)+" ");
        }
        System.out.println();

    }
}