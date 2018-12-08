package com.tj.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Practice6 {
    public static void main(String [] args){
        //比较大小
        List<String> list=Arrays.asList("zhang","wang","li","qian");
        //获取最大的
        System.out.println("最大的为"+list.stream().max((a,b)->a.compareTo(b)));
        //获取最小的
        System.out.println("最小的为"+list.stream().min((a, b) -> a.compareTo(b)));
    }
}
