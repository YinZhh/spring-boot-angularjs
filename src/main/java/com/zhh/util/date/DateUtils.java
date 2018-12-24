package com.zhh.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author zhh.yin
 * @version v.1.0.0
 * @description This's date of related tool classes
 * @date 2018/12/22 17:37
 */
public class DateUtils {
    private DateUtils() {
    }

    /**
     * @param dateToString new Date().toString();  ---> Sat Dec 15 10:12:54 CST 2018
     * @return java.util.Date
     * @throws ParseException 转换异常
     */
    public static Date parseENToDate(String dateToString) throws ParseException {
        if (dateToString == null) {
            return null;
        }
        return new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH).parse(dateToString);
    }
}
