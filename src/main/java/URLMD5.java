import org.apache.commons.codec.digest.DigestUtils;

import java.util.Date;

/**
 * Created by zhoubo on 2017/4/26.
 */
public class URLMD5 {
    public static String sign() {
        StringBuilder buf = new StringBuilder();
        String url = "POSThttps://200.200.200.50/v1/device/config/set";
//        String accessToken = "45e607d4332940b7bbcbb453edcc2b1d";
        String accessToken = "a1d24479e30d40d6a8c0f30f3fd5c5e0";
        String appId = "10101";
//        String deviceId = "AA854476FAEE2C5051B35A918378E63D";
        String deviceId = "B7767DEB45B551D231163B91E9B88E00";
        String json = "{    \"switchStatus\": 4,       \"runTime\": 5,      \"busiSwitch\": 1,          \"configMode\": 2, \"runDataSources\" : 6, \"updateFlag\" : 2}";
        String source = "2";
        String timestamp = ((Long)(new Date().getTime())).toString();
        String appSecret = "afd55f877bad4aaeab45fb4ca567d234";

//        String timestampStr = timestamp.toString();
        System.out.println("timestamp = " + timestamp);
        buf.append(url);
        buf.append("accessToken=" + accessToken);
        buf.append("&");
        buf.append("appId=" + appId);
        buf.append("&");
        buf.append("deviceId=" + deviceId);
        buf.append("&");
        buf.append("json=" + json);
        buf.append("&");
        buf.append("source=" + source);
        buf.append("&");
        buf.append("timestamp=" + timestamp);
        String finalUrl = buf.toString().replace("POST", "").replace("setaccessToken", "set?accessToken");
        System.out.println(buf.toString().replace("POST", "").replace("setaccessToken", "set?accessToken"));
        buf.append("&");
        buf.append(appSecret);

        String md5 = DigestUtils.md5Hex(buf.toString());
        finalUrl = finalUrl + "&" + "sign=" + md5;
        System.out.println(finalUrl);

        return md5;
    }

    public static void main(String[] args) {
        System.out.println(URLMD5.sign());
    }

}
