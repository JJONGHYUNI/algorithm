import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigDecimal a = new BigDecimal(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        BigDecimal result = a.pow(b);

        System.out.print(result.toPlainString());


    }
}