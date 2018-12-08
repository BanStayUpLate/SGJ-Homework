package com.tj.practice;

import java.util.HashMap;
import java.util.Map;

public class Practice3 {
    public static void main(String[]args){
        //Map的遍历
        Map<String,String> map=new HashMap<>();
        map.put("a","张");
        map.put("b","李");
        map.forEach((key,value)->{
            System.out.println("key:"+key+"       value:"+value);
        });
    }
}
