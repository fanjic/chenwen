package com.chen.chenwen;

import com.chen.chenwen.common.constant.Color;
import com.chen.chenwen.common.util.FileUtil;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DoSomething {
    public static void main(String[] args) {
        System.out.println("枚举====================");
        System.out.println(Color.YELLOW.getColor());
        System.out.println(Color.getName(2));

        System.out.println("\n" + "时间类，往后三个月====================");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(new Date()));
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 3);
        Date future = calendar.getTime();
        System.out.println(format.format(future));

        System.out.println("\n" + "获取项目根路劲====================");
        System.out.println(System.getProperty("user.dir"));

        System.out.println("\n" + "图片合入pdf====================");
        File pdf = new File("C:\\Users\\40484\\Desktop\\do\\file" + File.separator + "签名文件.pdf");
        File img = new File("C:\\Users\\40484\\Desktop\\do\\file" + File.separator + "桥本环奈.jpg");
        System.out.println(pdf.getAbsolutePath());
        String[] path = pdf.getAbsolutePath().split("\\.");
        String dir2 = path[0];
        String suffix = path[1];
        System.out.println(dir2 + "====" + suffix);
        // FileUtil.addImageAbsPosition(dir2,suffix,img.getAbsolutePath());

        System.out.println("\n" + "io流转换File文件====================");
        //File转化byte[]数组，再转File
        /*byte[] buf=FileUtil.file2byte("C:\\Users\\40484\\Desktop\\do\\file\\签名文件_签字件.pdf");
        String outPath1 = "C:\\Users\\40484\\Desktop\\do\\file\\demo";
        String outName1 = "新的已签字文件.pdf";
        FileUtil.byte2File(buf,outPath1,outName1);*/
        // File和InputStream相互转化
        /*File f1 = new File("C:\\Users\\40484\\Desktop\\do\\file\\签名文件_签字件.pdf");
        String outPath2 = "C:\\Users\\40484\\Desktop\\do\\file\\demo";
        String outName2 = "新的已签字文件.pdf";
        File f2 = new File(outPath2 + File.separator + outName2);
        InputStream inStream = null;
        try {
            //File转化InputStream
            inStream = new FileInputStream(f1);
            //InputStream转化File
            FileUtil.inputStreamToFile(inStream,f2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                inStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        // 删除文件
        /*File fileDemo = new File("C:\\Users\\40484\\Desktop\\do\\file\\demo");
        for (File f : fileDemo.listFiles()) {
            if(f.isFile()){ f.delete(); } }*/


        System.out.println("\n" + "====================");


    }
}
