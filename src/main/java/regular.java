import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhoubo on 2017/5/9.
 */
public class regular {
    public static void main(String[] args) {
        System.out.println("hello world !");
        String remindBeginTimeStr = "2233dfhsdjf";
        Matcher beginMer = Pattern.compile("^[0-9]+[+]?[a-z]+$")
                .matcher(remindBeginTimeStr);
        System.out.println(beginMer.find());
    }
}
