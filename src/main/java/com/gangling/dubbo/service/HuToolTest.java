package com.gangling.dubbo.service;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.ReUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.script.ScriptRuntimeException;
import cn.hutool.script.ScriptUtil;

import javax.script.CompiledScript;
import javax.script.ScriptException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * created by liufeng
 * 2018/7/23
 */
public class HuToolTest {
    public static void main(String[] args) throws ParseException {
      /*  //请求列表页
        String listContent = HttpUtil.get("https://www.oschina.net/action/ajax/get_more_news_list?newsType=&p=2");
//使用正则获取所有标题
        List<String> titles = ReUtil.findAll("<span class=\"text-ellipsis\">(.*?)</span>", listContent, 1);
        for (String title : titles) {
            //打印标题
            Console.log(title);
        }*/

      testScript();

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String today=sdf.format(new Date());
        today=today+" 00:00:00";
        System.out.println(today);
        System.out.println(simpleDateFormat.parse(today));
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(calendar.getTime());
        calendar.add(Calendar.DAY_OF_MONTH,0);
        Date afterTime=calendar.getTime();
        String time=sdf.format(afterTime);
        time=time+" 23:59:59";
        Date endDate=simpleDateFormat.parse(time);
        System.out.println(time);
        System.out.println(endDate);

    }

    public static void testScript(){
        CompiledScript script = ScriptUtil.compile("print('Script test!');");
        try {
            script.eval();
        } catch (ScriptException e) {
            throw new ScriptRuntimeException(e);
        }
    }
}
