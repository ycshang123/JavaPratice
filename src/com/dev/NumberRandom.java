package com.dev;/*@ClassName NumberRandom
 *@Description:todo
 *@author yc_shang
 *@Date2020/1/13
 *@Version 1.0
 **/

import java.io.*;
import java.util.Random;

public class NumberRandom {
    public static void main(String[] args) throws IOException {
    int[] number = new int[100];
        Random random = new Random();
        for (int i =0;i<number.length;i++){
            number[i]  = random.nextInt(100);
            System.out.print(number[i] + " ");
        }
        File file = new File("d:\\numberRandom.txt");//存入数组的文件
        FileWriter out =new FileWriter(file);//文件写入流
        for(int j = 0; j<number.length;j++){
         out.write(number[j]+"\t");
        }
        out.close();

    }
}


