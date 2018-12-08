package com.tj.homewrok;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {
    public static void main(String[]args){
        //网页字符串
        String html="图片1 <img class=\"样式\" src=\"3.png\"> 图片2 <img class=\"样式\" src=\"4.jpg\">";

        //创建正则对象
        //public static Pattern compile(String regex)   通过该方法传入一个正则表达式，将规则装入一个Pattern对象返回
        Pattern pattern = Pattern.compile("<img.*?src=\"(.*?)\">");
        //开始匹配
        //public Matcher matcher(String input) 传入你需要匹配的字符串，获得一个匹配器对象
        Matcher matcher = pattern.matcher(html);
        //public boolean find()    尝试查找与该模式匹配的输入序列的下一个子序列
        //public String group()    返回有以前匹配操作所匹配的输入子序列
        //group()需要和find()配合使用，不能单独使用
        while(matcher.find()){
            System.out.println(matcher.group(1));
        }
        //在正则表达式中，+和*都属于贪婪匹配模式，尽可能多的去匹配内容;而+?和*?属于非贪婪匹配模式;

    }
}
