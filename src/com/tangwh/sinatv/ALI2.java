package com.tangwh.sinatv;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class ALI2 {

    public static void main(String[] args) throws ParseException {

        /**
         * 传入参数, 即传入应用名称和流名称
         */
        String AppName = "AppName"; //自定义的AppNmae
        String StreamName = "StreamName"; // 自定义的StreaNmae
        String host = "live.bajie188.com"; //播流的域名
        String key = "xixian123";// 鉴权KEY

        /**
         * 时间戳 有效十几件
         */
        String time = dateToStamp();



        String strpush = "/" + AppName + "/" + StreamName + "/" + time + "-0-0-" + key;


        String pushurl = "rtmp://" + host + "/" + AppName + "/" + StreamName + "?auth_key=" + time + "-0-0-" + MD5Utils.getMD5(strpush);
        String strviewrtmp = "/"+AppName+"/"+StreamName+"-"+time+"0-0-"+key;
        String sruviewflv ="/"+AppName+"/"+StreamName+".flv"+"-"+time+"0-0-"+key;
        String sruviewm3u8 = "/"+AppName+"/"+StreamName+".m3u8"+"-"+time+"0-0-"+key;


        String rtmpurl = "rtmp://"+host+"/"+AppName+"/"+StreamName+"?auth_key=" + time + "-0-0-" + MD5Utils.getMD5(strviewrtmp);
        String flvurl="http://"+AppName+"/"+StreamName+".flv"+"auth_key="+time+"0-0-"+MD5Utils.getMD5(sruviewflv);
        String m3u8url ="http://"+AppName+"/"+StreamName+".m3u8"+"auth_key="+time+"0-0-"+MD5Utils.getMD5(sruviewm3u8);


        /**
         *  打印推流地址
         */
        System.out.println("推流地址:");
        System.out.println(pushurl);
        /**
         * 打印三种中直播协议 播放地址
         */
        System.out.println("播流地址");
        System.out.println(rtmpurl);
        System.out.println(flvurl);
        System.out.println(m3u8url);



    }

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

    public static String getMD5(String str) {

        try {
            // 生成一个MD5 加密计算的摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5的函数
            md.update(str.getBytes());
            String md5 = new BigInteger(1, md.digest()).toString(16);
            return fillMD5(md5);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5加密错误"+e.getMessage(),e);
        }

    }

    private static String fillMD5(String md5) {

        return md5.length() == 32 ? md5 : fillMD5("0" + md5);
    }


    public static String getUUID() {

        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
