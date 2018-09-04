import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * 密码加密
 *
 * @author zhoubo
 * @create 2018-03-22 11:43
 */
public class EncodePasswd {
    public static void main(String[] args) {
        System.out.println(DigestUtils.md5Hex(new String(Base64.encodeBase64(DigestUtils.md5("123456".getBytes()))) + "afd55f877bad4aaeab45fb4ca567d234"));
    }
}
