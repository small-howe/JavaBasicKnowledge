package com.tangwh.sinatv;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class sinatvHowe {
    /**
     * 推流域名 阿里云配置的推流域名
     */
    private static final String pushDomain = "推流域名";
    /**
     * 拉流域名 阿里云配置的拉流域名
     */
    private static final String pullDomain = "拉流域名";
    /**
     * appName
     */
    private static final String appName = "随便起一个";

    private static final String streamName = "随便起一个";
    /**
     * 推流的鉴权key:
     */
    private static final String pushAuthKey = "xx";
    /**
     * 播流的Key
     */
    private static final String pullAuthKey = "xxx";

    /**
     * 时间(单位是秒)
     */

    public static String dateToStamp() throws ParseException, ParseException {

        Long time = System.currentTimeMillis();

        time += 30 * 100 * 60;

        String res;
        // 获取当前系统时间为
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time));


        long ts = date.getTime(); // 得出的是毫秒 阿里云不需要毫秒,除以1000
        ts = ts / 1000;
        res = String.valueOf(ts);
        return res;

    }


    public static void main(String[] args) throws ParseException {

        // 过期时间
        String timestamp = sinatvHowe.dateToStamp();

        String strviewrtmpl = "/"+appName+"/"+streamName+"-"+timestamp+"-0-0-"+pullAuthKey;
        String strviewflvl = "/"+appName+"/"+sinatvHowe.streamName+".flv-"+timestamp+"-0-0-"+pullAuthKey;
        String strviewm3u81 = "/"+appName+"/"+streamName+".m3u8-"+timestamp+"-0-0-"+pullAuthKey;



        String rtmpUrl = "rtmp://"+pullDomain+"/"+appName+"/"+streamName+"?auth_key="+timestamp+"-0-0-"+MD5Utils.getMD5(strviewrtmpl);
        String flvlUrl =
                "http://"+pullDomain+"/"+appName+"/"+streamName+".flv?auth_key="+timestamp+"-0" +
                        "-0-"+MD5Utils.getMD5(strviewflvl);
        String m3u81Url = "http://"+pullDomain+"/"+appName+"/"+streamName+"m3u8.?auth_key="+timestamp+
                "-0-0-"+MD5Utils.getMD5(strviewm3u81);


        System.out.println("播流的地址>>>"+rtmpUrl);
        System.out.println("播流的地址>>>"+flvlUrl);
        System.out.println("播流的地址>>>"+m3u81Url);
        System.out.println("---------------------------------------------------------------------------------");

        String strpush = "/" + appName + "/" + streamName + "-" + timestamp + "-0-0-" + pushAuthKey;
        String pushUrl = "rtmp://" + pushDomain + "/" + appName + "/" + streamName + "?auth_key=" + timestamp + "-0-0-" + MD5Utils.getMD5(strpush);

        System.out.println("推的地址>>>"+pushUrl);

    }


}
