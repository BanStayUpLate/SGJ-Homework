package com.tj.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Practice1 {
    public static void main(String []args){

        List<String []> list= new ArrayList<>();

        list.add(new String[]{"张三","李四"});
        list.add(new String[]{"王五","赵六"});
        list.add(new String[]{"钱七","周八"});

        List<String> list2=new ArrayList<>();
        for (String[] strings : list) {
            for (String s : strings) {
                list2.add(s);
            }
        }
        System.out.println(list2);
        System.out.println("========================================================");
        List<String> list3 = list.stream().flatMap(strings -> stream(strings)).collect(Collectors.toList());
        System.out.println(list3);
    }
}
