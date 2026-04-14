public class KthLargestOddNumberInArange {
    public static void main(String[] args) {
        int L=-3,R=3;
        int k=1;
        int curr=0;
        for(int i=R;i>=L;i--){
            if(i%2!=0)curr++;
            if(curr==k){
                System.out.println(i);
                break;
            }
        }
    }
}

public class Main {
    static int kthLargestOdd(int L, int R, int K) {
        int largestOdd = (R % 2 != 0) ? R : R - 1;

        int ans = largestOdd - 2 * (K - 1);

        if (ans < L) return 0;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(kthLargestOdd(-3, 3, 1)); // 3
    }
}
