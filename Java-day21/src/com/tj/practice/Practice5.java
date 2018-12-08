package com.tj.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Practice5 {
    public static void main(String[]args){
        //去掉重复的
        List<String[]> list=new ArrayList<>();
        list.add(new String[]{"苹果","华为"});
        list.add(new String[]{"华为","锤子"});
        list.add(new String[]{"vivo","苹果"});
        List<String> list2=new ArrayList<>();
        for (String[] strings : list) {
            for (String s : strings) {
                list2.add(s);
            }
        }
        List<String> list3 = list2.stream().distinct().collect(Collectors.toList());
        System.out.println(list3);
    }
}
