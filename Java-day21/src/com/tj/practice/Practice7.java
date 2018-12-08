package com.tj.practice;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Practice7 {
    public static void main(String[]args){
        //数字流的相关操作
        //获取最大值
        IntStream intStream1=IntStream.of(1,2,3,4,5,6,7,8,9);
        OptionalInt max = intStream1.max();
        System.out.println("最大值为"+max);
        //获取最小值
        IntStream intStream2=IntStream.of(2,3,4,5,6,7,8,9);
        OptionalInt min = intStream2.min();
        System.out.println("最小值为"+min);
        //获取数量
        IntStream intStream3=IntStream.of(3,4,5,6,7,8,9);
        long count = intStream3.count();
        System.out.println("个数为"+count);
        //获取平均值
        IntStream intStream4=IntStream.of(1,2,3,4,5,6,7,8,9);
        OptionalDouble average = intStream4.average();
        System.out.println("平均值为"+average);
        //求总和
        IntStream intStream5=IntStream.of(1,2,3,4,5,6,7,8,9);
        int sum = intStream5.sum();
        System.out.println("总和为"+sum);

    }
}
