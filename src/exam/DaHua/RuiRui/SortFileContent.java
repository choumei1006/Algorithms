package exam.DaHua.RuiRui;
import java.io.*;
import java.util.*;

/**
 * @author:choumei
 * @date:2020/10/3 20:05
 * @Description:
 */

public class SortFileContent {
    public static void sortObserve() throws IOException {
        File fin = new File("c:\\input.txt");
        File fout = new File("c:\\out.txt");


        FileInputStream fis = new FileInputStream(fin);
        FileOutputStream fos = new FileOutputStream(fout);

        BufferedReader in = new BufferedReader(new InputStreamReader(fis));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

        String aLine;
        ArrayList<String> al = new ArrayList<String> ();


        int i = 0;
        while ((aLine = in.readLine()) != null) {
            if ( aLine.trim().length() > 0) {
                al.add(aLine);
                i++;
            }
        }

        Collections.sort(al);
        //将排序后的内容输出到文件中，
        for (String s : al) {
            out.write(s);
            out.newLine();
        }

        in.close();
        out.close();
    }
}
