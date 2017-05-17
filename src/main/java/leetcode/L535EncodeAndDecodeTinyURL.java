package leetcode;

import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 * Created by zhoubo on 2017/5/11.
 */
public class L535EncodeAndDecodeTinyURL {
    public static void main(String[] args) {
        Deflater deflater = new Deflater();
        String str = "hello world";
        int  def = deflater.deflate(str.getBytes(),0,str.length());
        System.out.println(def);
        Inflater inflater = new Inflater();
//        inflater.i
    }
}
