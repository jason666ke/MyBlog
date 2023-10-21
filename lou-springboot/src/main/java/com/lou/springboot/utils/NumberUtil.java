package com.lou.springboot.utils;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberUtil {

    private NumberUtil(){}

    /**
     * judge if is phone number in China
     * @param phone
     * @return
     */
    public static boolean isPhone(String phone) {
        Pattern pattern = Pattern.compile(
                "^((13[0-9]) | (14[5,7]) | (15[^4,\\D]) | (17[0-8]) | (18[0-9])) \\d{8}$");
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    /**
     * generate a random num of specified length
     * @param length
     * @return
     */
    public static int genRandomNum(int length) {
        int num = 1;
        double random = Math.random();
        if (random < 0.1) random += 0.1;
        for (int i = 0; i < length; i++)
            num *= 10;
        return (int) (random * num);
    }

    /**
     * generate order number
     * @return
     */
    public static String genOrderNo() {
        StringBuffer buffer = new StringBuffer(String.valueOf(System.currentTimeMillis()));
        int num = genRandomNum(4);
        buffer.append(num);
        return buffer.toString();
    }

    public static String formatMoney2Str(Double money) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return decimalFormat.format(money);
    }

    public static String formatMoney2Str(float money) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return decimalFormat.format(money);
    }
}
