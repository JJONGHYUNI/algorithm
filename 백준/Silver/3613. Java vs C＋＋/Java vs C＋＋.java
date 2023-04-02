import java.io.*;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine();
        String regex = "(?:_([a-z]))", regex2 = "([A-Z])";
        if(word.matches(".*[A-Z].*")&&word.matches(".*_.*")||word.matches(".*(_){2,}.*|^([A-Z]|_).*|.*(_)$")||word.equals("")){
            bw.write("Error!");
            bw.flush();
        }else{
            Matcher matcher;
            if(word.contains("_")){
                matcher = Pattern.compile(regex).matcher(word);
                while(matcher.find()){
                    word=word.replace(matcher.group(),matcher.group(1).toUpperCase());
                }
                }else if(word.matches(".*([A-Z]).*")){
                matcher = Pattern.compile(regex2).matcher(word);
                while(matcher.find()){
                    word=word.replace(matcher.group(),"_"+matcher.group().toLowerCase());
                }
            }
            bw.write(word);
            bw.flush();
        }
    }

}