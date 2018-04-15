package onlineCoding;
import java.util.*;

public class Main01{
    // 1,A,0;2,B,1;3,C,2
     private void dfs(String[][] data, int t, String pre, List<String> ans){
        boolean flag = false;
        for (int i = 0; i < data.length; i++){
            if (data[t][0].equals(data[i][2])) {
                dfs(data, i, pre + "-" + data[i][1], ans);
                flag = true;
            }
        }
        if (!flag) ans.add(pre);
    }
    public static void main(String[] args){
        Main01 main = new Main01();
        String sc = "1,A,0;2,B,1;3,C,2";
            String[] inputs = sc.split(";");
            if (inputs.length < 3){
                System.out.println("incorrect data");
            }
            String[][] data = new String[inputs.length][];
            for (int i = 0; i < inputs.length; i++){
                data[i] = inputs[i].split(",");
            }
            List<String> ans = new ArrayList<>();
            main.dfs(data, 0, data[0][1], ans);
            String t = "";
            for (String s : ans){
                t += (";" + s);
            }
            System.out.println(t.substring(1));


    }
}