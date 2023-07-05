import java.lang.Math;
class Solution {
    public long solution(long n) {
        double x = (double) n;
        x=Math.sqrt(n);
        if (!isInteger(x)){
            return -1;
        }
        return (long)((x+1)*(x+1));
    }
    private boolean isInteger(double a){
        return a % 1 == 0.0;
    }
}