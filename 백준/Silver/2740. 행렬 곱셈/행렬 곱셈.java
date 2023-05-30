import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for (int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for (int j=0;j<m;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        st=new StringTokenizer(br.readLine());
        st.nextToken();
        int c=Integer.parseInt(st.nextToken());
        int[][] arr2 = new int[m][c];
        for (int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            for (int j=0;j<c;j++){
                arr2[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int k=0; k<n;k++){
            for (int i=0; i<c; i++){
                int sum=0;
                for (int j=0; j<m; j++){
                    sum+=arr[k][j]*arr2[j][i];
                }
                sb.append(sum).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}