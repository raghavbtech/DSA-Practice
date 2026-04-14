public class bit{
    static void checkOddOrEven(int n){
        if((n&1)==1){
            System.out.println("odd"); 
        }
        else if((n&1)==0){
            System.out.println("Even");
        }
    }

    static int getIthBit(int n,int i){
        int bitmask=1<<i;
        if((n&bitmask)==0){
            return 0;
        }
        else{
            return 1;
        }
    }
    static int setIthBit(int n,int i){
        int bitmask=1<<i;
        return n|bitmask;
    }

    static int clearIthBit(int n,int i){
        int bitmask=~(1<<i);
        return n&bitmask;
    }

    static int updateIthBit(int n,int i,int newBit){
        // if(newBit==0){
        //     return clearIthBit(n, i);
        // }
        // else{
        //     return setIthBit(n, i);
        // }

        n=clearIthBit(n, i);
        int Bitmask=newBit<<i;
        return n|Bitmask;

    }

    static int clearIBits(int n,int i){
        int bitMask=(~0)<<i;
        return n&bitMask;
    }

    static int clearIBitsInRange(int n,int i,int j){
        int a=((~0)<<(j+1));
        int b=(1<<i)-1;
        int bitmask=a|b;
        return n&bitmask;
    }

    public static boolean isPowerOfTwo(int n){
        return (n&(n-1))==0;
    }

    public static int countSetBits(int n){
        int count=0;
        while(n>0){
            if((n&1)!=0){
                count++;
            }
            n=n>>1;
        }
        return count;
    }
    public static void main(String[] args) {
        checkOddOrEven(3);
    }
}