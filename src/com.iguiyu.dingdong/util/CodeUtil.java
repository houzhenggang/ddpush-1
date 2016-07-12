//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.util;

public class CodeUtil {
    public CodeUtil() {
    }

    public static String genCode() {
        String result = "";
        int temp = (int)(Math.random() * 9999.0D);
        if(temp < 1000) {
            result = result + "0";
        }

        if(temp < 100) {
            result = result + "0";
        }

        if(temp < 10) {
            result = result + "0";
        }

        result = result + temp;
        temp = (int)(Math.random() * 9999.0D);
        if(temp < 1000) {
            result = result + "0";
        }

        if(temp < 100) {
            result = result + "0";
        }

        if(temp < 10) {
            result = result + "0";
        }

        result = result + temp;
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        genCode();
    }
}
