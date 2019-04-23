package com.gangling;

import java.math.BigDecimal;

/**
 * created by liufeng
 * 2018/9/6
 */
public class FloatPrice {
    public static void main(String[] args) {
        //下调
        BigDecimal channelPrice = new BigDecimal("100.00");
        BigDecimal a = channelPrice.multiply(new BigDecimal(1).subtract(new BigDecimal(30).divide(new BigDecimal(100))));
        System.out.println(a);
        BigDecimal b = channelPrice.multiply(new BigDecimal(1).subtract(new BigDecimal(Double.parseDouble("30")).divide(new BigDecimal(100))));
        System.out.println(b);


        //上调
        BigDecimal c = channelPrice.multiply(new BigDecimal(1).add(new BigDecimal(Double.parseDouble("30")).divide(new BigDecimal(100))));
        System.out.println(c);
        BigDecimal d = channelPrice.multiply(new BigDecimal(1).add(new BigDecimal(30).divide(new BigDecimal(100))));
        System.out.println(d);
    }
}
