package com.gangling.dubbo.service;

import java.math.BigDecimal;

/**
 * created by liufeng
 * 2018/8/2
 */
public class Test {
    public static void main(String[] args) {
        int n=2;
        Double sum= Double.valueOf(1);
        Double num= Double.valueOf(1);
        while(n<=20){
            for(int t=2;t<=20;t++){
                num=num*t;
                sum=sum+1/num;
            }
            n++;
        }
        System.out.println(sum);

        BigDecimal bigDecimal=new BigDecimal("23");
        System.out.println(bigDecimal);
    }
}
