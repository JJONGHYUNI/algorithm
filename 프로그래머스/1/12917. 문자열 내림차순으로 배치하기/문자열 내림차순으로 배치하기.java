import java.util.*;
class Solution {
    public String solution(String s) {
        String lowerCase = "";
        String upperCase = "";
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        for(int i = charArr.length-1; i >= 0; i--){
            char c = charArr[i];
            if(Character.isLowerCase(c)){
                lowerCase += c;
                continue;
            }
            upperCase += c;
        }
        return lowerCase + upperCase;
    }
}