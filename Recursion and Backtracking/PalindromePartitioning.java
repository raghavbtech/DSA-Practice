import java.util.*;

public class PalindromePartitioning {
//     public List<List<String>> partition(String s) {
//     List<List<String>> ans = new ArrayList<>();
//     backtrack(0, s, new ArrayList<>(), ans);
//     return ans;
// }
//     private void backtrack(int index, String s,
//                        List<String> path,
//                        List<List<String>> ans) {

//     // base case: whole string is used
//     if (index == s.length()) {
//         ans.add(new ArrayList<>(path));
//         return;
//     }

//     for (int end = index; end < s.length(); end++) {
//         if (isPalindrome(s, index, end)) {
//             // choose
//             path.add(s.substring(index, end + 1));

//             // explore
//             backtrack(end + 1, s, path, ans);

//             // un-choose (backtrack)
//             path.remove(path.size() - 1); 
//         }
//     }
// }
// private boolean isPalindrome(String s, int i, int j) {
//     while (i < j) {
//         if (s.charAt(i) != s.charAt(j)) return false;
//         i++;
//         j--;
//     }
//     return true;
// }

    




    public static void main(String[] args) {
        
    }
}
