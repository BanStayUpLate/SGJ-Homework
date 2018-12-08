package com.tj.homework;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class HeroTest {

    public static void main(String[]args)throws IOException {
        // 1. 找到武将中武力前三的hero对象, 提示流也可以排序
        // 2. 按出生地分组
        // 3. 找出寿命前三的武将
        // 4. 女性寿命最高的
        // 5. 找出武力排名前三  100, 99, 97 97 ==> 4个人 吕布", "张飞", "关羽", "马超
        // 6. 按各个年龄段分组： 0~20, 2140, 41~60, 60以上
        // 7. 按武力段分组： >=90， 80~89, 70~79, <70
        // 8. 按出生地分组后，统计各组人数
        Stream<String> lines=Files.lines(Paths.get("F:\\沈老师的JAVA\\MyJava\\SGJ-Homework\\Java-day21\\Heroes.txt"),Charset.forName("utf-8"));
        Stream<Hero> stream = lines.map(str -> str.split("\t")).map(array -> new Hero(
                Integer.parseInt(array[0]),
                array[1], array[2], array[3],
                Integer.parseInt(array[4]),
                Integer.parseInt(array[5]),
                Integer.parseInt(array[6])
        ));
        List<Hero> list = stream.collect(Collectors.toList());
        // 1. 找到武将中武力前三的hero对象, 提示流也可以排序
        Stream<Hero> limit = list.stream().sorted((a, b) -> a.getPower() - b.getPower()).limit(3);
        limit.forEach(a -> System.out.println(a.getName()));
        System.out.println("-----------------------------------");
        //2.按出生地分组
        Map<String, List<Hero>> map1 = list.stream().collect(Collectors.groupingBy((hero) -> hero.getCity()));
        System.out.println(map1);
        System.out.println("-----------------------------------");
        // 3. 找出寿命前三的武将
        Stream<Hero> limit1 = list.stream().sorted((a, b) -> (a.getDeath() - a.getBir()) - (b.getDeath() - b.getBir())).limit(3);
        limit1.forEach(a -> System.out.println(a.getName()));
        System.out.println("-----------------------------------");
        // 4. 女性寿命最高的
        Stream<Hero> nv = list.stream().filter(a -> a.getSex().equals("女"));
        Stream<Hero> limit2 = nv.sorted((a, b) -> (a.getDeath() - a.getBir()) - (b.getDeath() - b.getBir())).limit(3);
        limit2.forEach(a -> System.out.println(a.getName()));

        // 5. 找出武力排名前三  100, 99, 97 97 ==> 4个人 吕布", "张飞", "关羽", "马超
        Set<Integer> topP=list.stream().map(a -> a.getPower()).sorted((a,b)->b-a).limit(3).collect(Collectors.toSet());
        Stream<Hero> limit3 = list.stream().filter((a) -> topP.contains(a.getPower()));
        limit3.forEach(a-> System.out.println(a.getName()));
        System.out.println("-----------------------------------");
//        // 6. 按各个年龄段分组： 0~20, 2140, 41~60, 60以上
//
//        Map<Object, List<Hero>> map2 = list.stream().collect(Collectors.groupingBy((a) -> ageRange(a.getDeath() - a.getBir())));
//        System.out.println(map2);
//        System.out.println("-----------------------------------");
//        // 7. 按武力段分组： >=90， 80~89, 70~79, <70
//        Map<String, List<Hero>> map3 = list.stream().collect(Collectors.groupingBy(h -> powerRange(h.getPower())));
//        map3.forEach((k, v) -> {
//            System.out.println(k + ":" + v.stream().map(h -> h.getName()).collect(Collectors.toList()));
//        });
//        System.out.println("-----------------------------------");
//        // 8. 按出生地分组后，统计各组人数
//        Map<String, Long> group4 = list.stream().collect(Collectors.groupingBy((h) -> h.getCity(), Collectors.counting()));
//        group4.forEach((k, v) -> {
//            System.out.println(k + ":" + v);
//        });
//        public static String powerRange(int power) {
//            if (power >= 90) {
//                return "90以上";
//            } else if (power >= 80 && power <= 89) {
//                return "80~89";
//            } else if (power >= 70 && power <= 79) {
//                return "70~79";
//            } else {
//                return "70之下";
//            }
//        }
//
//        public static String ageRange(int age) {
//            if (age >= 0 && age <= 20) {
//                return "0~20";
//            } else if (age >= 21 && age <= 40) {
//                return "21~40";
//            } else if (age >= 41 && age <= 60) {
//                return "41~60";
//            } else {
//                return "60以上";
//            }
//        }
    }
}
