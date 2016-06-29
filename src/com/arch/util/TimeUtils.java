package com.arch.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhou on 2016/6/30.
 * @author zhou
 */
public class TimeUtils {
    public static String getTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(new Date());
    }

    public static void main(String[] args) {
        long t = 153971;
        double a = t;
        System.out.println(t/1024/1024);
        a = a / 1024 / 1024;
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(a));
    }
}
