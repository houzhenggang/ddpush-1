//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.util;

import com.iguiyu.dingdong.weixin.pojo.DZPStatic;
import java.util.Random;

public class DZPUtil {
    public DZPUtil() {
    }

    public static long getPrize() {
        long result = 5L;
        boolean number = false;
        int number1;
        if(DZPStatic.prize1Count < DZPStatic.prize1MaxCount) {
            number1 = (new Random()).nextInt(DZPStatic.prize1) + 1;
            if(number1 == DZPStatic.prize1 - 1) {
                result = 1L;
                ++DZPStatic.prize1Count;
                return result;
            }
        }

        if(DZPStatic.prize2Count < DZPStatic.prize2MaxCount) {
            number1 = (new Random()).nextInt(DZPStatic.prize2) + 1;
            if(number1 == DZPStatic.prize2 - 1) {
                result = 2L;
                ++DZPStatic.prize2Count;
                return result;
            }
        }

        if(DZPStatic.prize3Count < DZPStatic.prize3MaxCount) {
            number1 = (new Random()).nextInt(DZPStatic.prize3) + 1;
            if(number1 == DZPStatic.prize3 - 1) {
                result = 3L;
                ++DZPStatic.prize3Count;
                return result;
            }
        }

        if(DZPStatic.prize4Count < DZPStatic.prize4MaxCount) {
            number1 = (new Random()).nextInt(DZPStatic.prize4) + 1;
            if(number1 == DZPStatic.prize4 - 1) {
                result = 4L;
                ++DZPStatic.prize4Count;
                return result;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 10000; ++i) {
            long prize = getPrize();
            if(prize < 2L) {
                System.out.println("[" + prize + "]");
            }
        }

    }
}
