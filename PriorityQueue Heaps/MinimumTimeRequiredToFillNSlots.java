import java.util.*;;
public class MinimumTimeRequiredToFillNSlots {
    public static int minTime(int arr[],int N,int k)
    {
        Queue<Integer>q=new LinkedList<>();

        boolean[] vis=new boolean[N+1];
        int time=0;

        for(int i=0;i<k;i++)
        {
            q.add(arr[i]);
            vis[arr[i]]=true;
        }

        while(!q.isEmpty())
        {
            for(int i=0;i<q.size();i++)
            {
                int curr=q.poll();
                if(curr-1>=1 && !vis[curr-1])
                {
                    vis[curr-1]=true;
                    q.add(curr-1);
                }

                if(curr+1<=N && !vis[curr+1])
                {
                    vis[curr+1]=true;
                    q.add(curr+1);
                }
            }
            time++;
        }
        return time;
    }
}
