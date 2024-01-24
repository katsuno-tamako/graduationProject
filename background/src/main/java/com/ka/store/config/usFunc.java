package com.ka.store.config;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Component
public class usFunc {

    public String getDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String date_toString = formatter.format(date).toString();
        return date_toString;
    }

    public String getFN(String head){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssS");
        String i = formatter.format(date).toString();
        return head+i;
    }

    public String getRandom(){
       Random r = new Random(1);
       int ran1 = r.nextInt(100);
       System.out.println(ran1);
       return String.valueOf(ran1);

    }

}
