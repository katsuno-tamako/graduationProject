package com.ka.store;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class test {

    public static void main(String[] args) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HHmmss");
        Date date = new Date();
        System.out.println(formatter.format(date));
        String nowDate = date.toString();
        System.out.println(nowDate);

    }

}
