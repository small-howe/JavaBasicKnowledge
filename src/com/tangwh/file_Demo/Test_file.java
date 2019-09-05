package com.tangwh.file_Demo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test_file {
    public static void main(String[] args) {
        // 创建file 对象
            File file = new File("D:\\test\\twh.txt");
        //通过这个对象  回头在硬盘上 创建文件
        try {
            boolean newFile = file.createNewFile();
            System.out.println(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }


//        File file = new File("D:\\test\\test.txt");
        // 文件自身的属性
//        boolean canExecute = file.canExecute();
//        boolean canRead = file.canRead();
//        boolean write = file.canWrite();
//        boolean directory = file.isDirectory();
//        System.out.println("文件是否可执行"+canExecute);
//        System.out.println("文件是否可读取"+canRead);
//        System.out.println("文件是否可写入"+write);
//        System.out.println("文件是否是目录"+directory);
//        long length = file.length();
//        System.out.println("文件的长度是(字节的长度):"+length);
//        long lastModified = file.lastModified();// 文件最后的修改时间
//        System.out.println("文件最后的修改时间："+lastModified);
//        Date date =new Date(lastModified);
//        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String format = time.format(date);
//        System.out.println(format);
//
//        String absolutePath = file.getAbsolutePath();
//        System.out.println("文件的绝对路径为:"+absolutePath);
//        StringBuilder sb = new StringBuilder();
//        sb.append(absolutePath);
//        String substring = sb.substring(2);
//
//        System.out.println(substring);
//        String name = file.getName();
//        System.out.println("文件名:"+name);


    }
}
