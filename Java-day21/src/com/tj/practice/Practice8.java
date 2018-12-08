package com.tj.practice;

import java.util.*;
import java.util.stream.Collectors;

public class Practice8 {
    public static void main(String[]args){
        //测试学生集合，并将其分组
        List<Student> list=Arrays.asList(
                new Student("张三","男","西安"),
                new Student("李四","女","西安"),
                new Student("王五","女","上海"),
                new Student("赵六","男","新疆"),
                new Student("钱七","男","上海")
        );
        //分组
        Map<String,List<Student>> map=new HashMap<>();
        for (Student student : list) {
            if(student.getSex().equals("男")){
                List<Student> nan=map.get("男");
                if(nan==null) {
                    nan = new ArrayList<>();
                    map.put("男", nan);
                }
                nan.add(student);
            }else{
                List<Student> nv=map.get("女");
                if(nv==null){
                    nv=new ArrayList<>();
                    map.put("女",nv);
                }
                nv.add(student);
            }
        }
        System.out.println(map);
        System.out.println("====================================================");
        Map<String, List<Student>> map2 = list.stream().collect(Collectors.groupingBy((student) -> student.getSex()));
        System.out.println(map2);
        System.out.println("----------------------------------------------------");
        Map<Object, List<Student>> map4 = list.stream().collect(Collectors.groupingBy((student) -> student.getCity()));
        System.out.println(map4);
    }
}
