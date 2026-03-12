class Solution {
    public double myPow(double x, int n) {
        long power = n; // use long to handle overflow when n = -2^31
        if (power < 0) {
            x = 1 / x;
            power = -power;
        }
        double result = 1;
        while (power > 0) {
            if (power % 2 == 1) {
                result *= x;  
            }
            x *= x;  
            power /= 2; 
        }
        return result;
    }
}


class Practice{
    public double myPow(double x,int n){
        long power=n;
        if(power<0){
            x=1/x;
            power=-power;
        }

        double result=1;
        while(power>0){
            if(power%2==1){
                result*=x;
            }
            x*=x;
            n/=2;
        }
        return result;
    }
}