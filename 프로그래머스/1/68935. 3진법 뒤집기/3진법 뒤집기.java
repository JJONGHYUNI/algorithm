import java.util.*;

class Solution {
    public int solution(int n) {
        String s = Integer.toString(n,3);
        s = new StringBuilder(s).reverse().toString();
        return Integer.parseInt(s,3);
    }
}