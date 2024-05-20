import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] clothes) {
        int cnt = 1;
        Map<String, Integer> clothesList = new HashMap<>();
        
        for (String[] c : clothes) {
            clothesList.put(c[1], clothesList.getOrDefault(c[1], 0) + 1);
        }
        
        for (int tmp : clothesList.values()) {
            cnt *= (tmp + 1);
        }
        
        return cnt - 1;
    }
}