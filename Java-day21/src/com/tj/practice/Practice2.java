package com.tj.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Practice2 {
    public static void main(String[]args){

        List<String[]> list=new ArrayList<>();

        list.add(new String[]{"张","李"});
        list.add(new String[]{"王","赵"});
        list.add(new String[]{"钱","周"});

        List<String> list2 = list.stream().flatMap(strings -> stream(strings)).collect(Collectors.toList());

        //俩种不同的遍历
        list2.stream().forEach(strings->{
            System.out.println(strings);
        });
        System.out.println("====================================");
        System.out.println(list2);
    }
}
