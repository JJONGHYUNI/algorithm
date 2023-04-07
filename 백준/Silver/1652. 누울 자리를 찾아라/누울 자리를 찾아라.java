import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr =new int[101][101];
        for (int i = 0; i<n;i++){
            char[] val = br.readLine().toCharArray();
            for(int j=0;j<n;j++){
                if(val[j]=='.'){
                    arr[i][j] = 0;
                }else{
                    arr[i][j] = 1;
                }
            }
        }
        int wid =0,len = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i+1<n){
                    if(arr[i][j]==0 && arr[i+1][j]==0 && (i+2>=n || arr[i+2][j]==1)){
                        wid+=1;
                    }
                }
                if(j+1<n){
                    if(arr[i][j]==0 && arr[i][j+1]==0 &&(j+2>=n || arr[i][j+2]==1)){
                        len+=1;
                    }
                }
            }
        }
        bw.write(len+" "+wid);
        bw.flush();
    }
}