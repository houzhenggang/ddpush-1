//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
    public RegexUtil() {
    }

    public static boolean isPhoneNO(String mobiles) {
        Pattern p = Pattern.compile("^((13[0-9])|(15[0-9])|(18[0-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        System.out.println(m.matches() + "---");
        return m.matches();
    }
}
