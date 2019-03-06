package com.javaee.utility;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午1:35 2019/3/6
 */
public class TimeUtils {

    public static Timestamp getCurrentTime(){
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr=dateFormat.format(new Date());
        Timestamp ts=Timestamp.valueOf(dateStr);
        return ts;
    }

}
