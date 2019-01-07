package com.cqupt.bear.blockchain.test;

import java.io.*;

/**
 * @author Y.bear
 * @version 创建时间：2018年11月29日 上午10:44:20 类说明
 */
public class Wenku {
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\Y.bear\\Desktop\\test.txt";
        readFile(fileName);

    }

    /**
     * 读入TXT文件
     *
     * @throws IOException
     */
    public static void readFile(String fileName) throws IOException {
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gb2312"));
        String line = null;
        while ((line = br.readLine()) != null) {
            String info = line.replaceAll("[^\u4E00-\u9FA5]", "");
            System.out.println(info);
        }
        br.close();
    }
}