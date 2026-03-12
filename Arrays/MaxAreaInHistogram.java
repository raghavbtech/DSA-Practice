import java.util.*;
public class MaxAreaInHistogram {
    public int largestArea(int[] heights){
        int n=heights.length;
        Stack<Integer>index=new Stack<>();
        int maxArea=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            while(!index.isEmpty() && heights[i]<heights[index.peek()]){
                int topidx=index.pop();
                int height=heights[topidx];

                int width=index.isEmpty()?i:(i-index.peek()-1);
                int area=height*width;

                maxArea=Math.max(maxArea, area);
            }
        }

        while(!index.isEmpty()){
            int topidx=index.pop();
            int height=heights[topidx];

            int width=index.isEmpty()?n:(n-index.peek()-1);
            int area=height*width;
            maxArea=Math.max(maxArea, area);
        }
        return maxArea;
    }
}
