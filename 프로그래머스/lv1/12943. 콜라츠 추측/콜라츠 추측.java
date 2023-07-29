class Solution {
    public int solution(int num) {
        int cnt=0;
        long number=(long)num;
        while(cnt<=500){
            if (number==1){
                return cnt;
            }
            if (number%2l==0){
                number/=2l;
            }else{
                number*=3l;
                number+=1l;
            }
            cnt+=1;
        }
        return -1;
    }
}