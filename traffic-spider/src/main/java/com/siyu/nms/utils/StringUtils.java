package com.siyu.nms.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * String工具类
 */
public class StringUtils {

    /**
     * 过滤字符串中的数字字符串（除-号）
     *
     * @param ptCasinoMsg
     * @return
     */
    public static String Finds(String ptCasinoMsg) {
        String returnAmounts = new String();
        if (!ptCasinoMsg.equals("")) {
            String msgAmount = ptCasinoMsg;
            String numFlag = "";
            if (msgAmount.contains("-")) {
                numFlag = "-";
            }
            Pattern p = Pattern.compile("(\\d+\\.\\d+)");
            Matcher m = p.matcher(ptCasinoMsg);
            if (m.find()) {
                returnAmounts = m.group(1) == null ? "" : numFlag + m.group(1);
            } else {
                p = Pattern.compile("(\\d+)");
                m = p.matcher(ptCasinoMsg);
                if (m.find()) {
                    returnAmounts = m.group(1) == null ? "" : numFlag + m.group(1);
                }
            }
        } else {
            returnAmounts = "0d";
        }

        return returnAmounts;
    }

    /**
     * 实现切割字符串，取出特定的字符串
     *
     * @param Data
     * @param start
     * @param end
     * @return
     */
    public static String splitString(String Data, String start, String end) {
        int startIndex = Data.indexOf(start) + start.length();
        int index = Data.substring(startIndex).indexOf(end);
        String result = Data.substring(startIndex).substring(0, index);
        return result;
    }
}
