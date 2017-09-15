import org.apache.commons.codec.digest.DigestUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by zhoubo on 2017/4/26.
 */
public class BeautySalonSign {
    public static String sign() {
        //https://test.cms.clife.cn/v1/app/open/cloud/skinMeasure/getUserSkinMeasure?appId=30681&accessToken=4fe240eb403140ef9a5d5bd01d29f4b5&openId=kdjfk2342342&phone=13713771512&timestamp=1497335438111
        StringBuilder buf = new StringBuilder();
        String url = "GEThttps://test.cms.clife.cn/v1/app/open/cloud/skinMeasure/getUserSkinMeasure";
//        String accessToken = "45e607d4332940b7bbcbb453edcc2b1d";
        String accessToken = "0bc4871e63fe401c9337a02db0ee9044";
        String appId = "30681";
//        String deviceId = "AA854476FAEE2C5051B35A918378E63D";
//        String deviceId = "704EA2A805C19C7753F60E4AB9F4D458";
        String openId = "kdjfk2342342";
//        String json = "{\"runTime\": 50,\"busiSwitch\": 1,\"configMode\": 3,\"runDataSources\": 6,\"gears1\":0,\"gears2\":0,\"gears3\":1,\"gears4\":2,\"gears5\":1,\"runTime\":3,\"timeType\":1,\"year\":17,\"month\":5,\"day\":25,\"hour\":20,\"minute\":20,\"second\":20,\"week\":3}";
//        String json = "{  \"week\" : 0,  \"gears5\" : 1,  \"runtime4\" : 10,  \"second\" : 0,  \"month\" : 0,  \"gears2\" : 5,  \"runtime1\" : 20,  \"runDataSources\" : 0,  \"day\" : 0,  \"runtime5\" : 10,  \"year\" : 0,  \"gears4\" : 1,  \"hour\" : 0,  \"timeType\" : 0,  \"minute\" : 0,  \"configMode\" : 0,  \"runtime2\" : 13,  \"electricity\" : 0,  \"gears1\" : 2,  \"requestType\" : 0,  \"chargeStatus\" : 0,  \"gears3\" : 2,  \"runtime3\" : 10}";
//        String source = "3";
        String phone = "13713771512";
        String timestamp = ((Long)(new Date().getTime())).toString();
        String appSecret = "1ab38f2036544485b930a9bd1b3b0697";

//        String timestampStr = timestamp.toString();
        System.out.println("timestamp = " + timestamp);
        buf.append(url);
        buf.append("accessToken=" + accessToken);
        buf.append("&");
        buf.append("appId=" + appId);
        //&openId=kdjfk2342342&phone=13713771512&
        buf.append("&");
        buf.append("openId=" + openId);
//        buf.append("&");
//        buf.append("json=" + json);
        buf.append("&");
        buf.append("phone=" + phone);
        buf.append("&");
        buf.append("timestamp=" + timestamp);
        String finalUrl = buf.toString().replace("GET", "").replace("getUserSkinMeasureaccessToken", "getUserSkinMeasure?accessToken");
        System.out.println(buf.toString().replace("GET", "").replace("getUserSkinMeasureaccessToken", "getUserSkinMeasure?accessToken"));
        buf.append("&");
        buf.append(appSecret);

        System.out.println("sign url = " + buf.toString());

        String md5 = DigestUtils.md5Hex(buf.toString());
        finalUrl = finalUrl + "&" + "sign=" + md5;
        System.out.println(finalUrl);

        return md5;
    }

    public static void main(String[] args) {
        System.out.println(BeautySalonSign.sign());


        Calendar cal = Calendar.getInstance();
        int week = cal.get(Calendar.DAY_OF_MONTH);
        week = week == 0 ? 7 : week - 1;
        System.out.println(cal.get(Calendar.DAY_OF_WEEK));
    }

}
