class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        long tmp = 10;
        int idx = 1;
        while (n/tmp>0){
            idx+=1;
            tmp*=10;
        }
        System.out.println(idx);
        int[] arr = new int[idx];
        for (int i = 0; i<idx;i++){
            arr[i]=(int)(n%10);
            n/=10;
        }
        return arr;
    }
}