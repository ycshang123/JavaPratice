package com.dev;/*@ClassName CopyFile
 *@Description:使用缓冲流，实现文件的拷贝，根据不同的文件类型使用不同的流来处理
 *@author yc_shang
 *@Date2020/1/14
 *@Version 1.0
 **/

import java.io.*;

public class CopyFile {
    public static void main(String[] args)  {

        //被复制的文件
        File fromFile = new File("D:/1.txt");
        //复制出来的文件
        File toFile = new File("D:/2.txt");

        File fromImage = new File("D:/images/4.png");
        File toImage =  new File("D:/images/5.png");

        InputStream inputStream =null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;


        FileReader fileReader = null;
        FileWriter fileWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileReader = new FileReader(fromFile);
            fileWriter = new FileWriter(toFile);
            bufferedReader = new BufferedReader(fileReader);
            bufferedWriter = new BufferedWriter(fileWriter);
            inputStream = new FileInputStream(fromImage);
            outputStream = new FileOutputStream(toImage);
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
//            inputStream = new FileInputStream(fromImage);
//            bufferedInputStream = new BufferedInputStream(fileReader);
//            outputStream = new FileOutputStream(toFile);
//            bufferedOutputStream = new BufferedOutputStream(outputStream);
//            fileReader = new FileReader(fromImage);
//            bufferedReader = new BufferedReader(fileReader);
//            fileWriter = new FileWriter(toImage);
//            bufferedWriter = new BufferedWriter(fileWriter);
            //一次最多读取1kb的内容
            byte[] b = new byte[1024];
            char[] buf = new char[1024];
            //实际读取的字节数
            int length =0;

            while (bufferedReader.read(buf)!= -1){
               bufferedWriter.write(buf);
                System.out.println("文件复制成功");
            }
            bufferedWriter.flush();

            while ( bufferedInputStream.read(b)!= -1){
               bufferedOutputStream.write(b);
            }
            bufferedOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    finally {
            try {
                bufferedOutputStream.close();
                bufferedInputStream.close();
                outputStream.close();
                inputStream.close();
                bufferedWriter.close();
               bufferedReader.close();
                fileWriter.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
