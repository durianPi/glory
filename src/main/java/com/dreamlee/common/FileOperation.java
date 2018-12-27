package com.dreamlee.common;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author: DreamLee copied from other
 * @date: Created on 23:12 2018/12/5
 * @description: 文件相关操作
 * @modified:
 */
public class FileOperation {

    /**
     * 读取文件名称为filename中的内容，并将其中包含的所有词语放进words中
     * @param filename
     * @param words
     * @return
     */
    public static boolean readFile(String filename, ArrayList<String> words) {
        if (null == filename || null == words) {
            System.out.println("filename is null or words is null");
            return false;
        }

        //文件读取
        Scanner scanner = null;
        try {
            File file = new File(filename);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            }
            else
                return false;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //简单分词
        //这个分词方式相对简陋，没有考虑很多文本处理中的特殊问题
        //在这里只做demo展示用
        if (scanner.hasNextLine()) {
            String contents = scanner.useDelimiter("\\A").next();
            int start = firstCharacterIndex(contents, 0);
            for (int i = start + 1; i <= contents.length();)
                if (i == contents.length() || !Character.isLetter(contents.charAt(i))) {
                    String word = contents.substring(start, i).toLowerCase();
                    words.add(word);
                    start = firstCharacterIndex(contents, i);
                }
                else
                    i++;
        }
        return true;
    }

    private static int firstCharacterIndex(String s, int start) {
        for (int i = start; i < s.length(); i++)
            if (Character.isLetter(s.charAt(i)))
                return i;
        return s.length();
    }

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile("pride and prejudice.txt", words);
        System.out.println(words.size());
    }

}
