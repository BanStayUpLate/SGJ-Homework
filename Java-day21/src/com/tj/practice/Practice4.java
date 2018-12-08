package com.tj.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Practice4 {
    public static void main(String[]args){
        //判断个数
        List<String[]> list=new ArrayList<>();
        list.add(new String[]{"吕布","赵云"});
        list.add(new String[]{"张飞","关羽"});
        list.add(new String[]{"刘备","曹操"});
        List<String> list1 = list.stream().flatMap(strings -> stream(strings)).collect(Collectors.toList());
        System.out.println(list1.stream().count());
    }
}
