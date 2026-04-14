import java.util.Stack;

// 🧠 Logic Explanation (Interview Style)
// Definition of Celebrity

// A celebrity:

// knows nobody
// is known by everyone


// Matrix meaning:

// arr[i][j] = 1 → i knows j
// arr[i][j] = 0 → i does not know j

// ✅ Stack Elimination Logic

// Take two people: a and b

// Case 1
// a knows b → a cannot be celebrity


// Push b

// Case 2
// a does not know b → b cannot be celebrity


// Push a

// Each comparison eliminates one person.

// So after loop → only one candidate remains.

// ✅ Final Verification (Very Important)

// Stack gives only a candidate, not guaranteed celebrity.

// We verify:

// arr[i][celeb] == 1   for all i ≠ celeb   (everyone knows celeb)
// arr[celeb][i] == 0   for all i ≠ celeb   (celeb knows nobody)


// If not → return -1.
public class CelebrityProblem {
    static int getCelebrity(int[][] arr){
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            st.push(i);
        }

        while(st.size()>1){
            int i=st.pop();
            int j=st.pop();

            if(arr[i][j]==0){
                // a doesn't know b → b not celeb
                st.push(i);
            }
            else if(arr[i][j]==1){
                // a knows b → a not celeb
                st.push(j);
            }

        }
        int celeb=st.peek();
        // verify candidate
        for(int i=0;i<arr.length;i++){
            if(i!=celeb && (arr[i][celeb]==0 || arr[celeb][i]==1)){
                return -1;
            }
        }
        return celeb;
    }
    public static void main(String[] args) {
        
    }
}
