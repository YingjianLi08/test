package com.zmyjn.test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class ArraySort implements  Runnable{

    private String num;

    public ArraySort(int num){
        this.num = num + "";
    }
    public static void main(String[] args){
        // 把这个数据升序输出
        Integer[] nums = {11,3,98,5455,1,152,990};

        for(int i =0; i <nums.length;i++){
            new Thread(new ArraySort(nums[i])).start();
        }
    }
    @Override
    public void run() {
        try{
            Thread.sleep(1000);
            Thread.sleep(Integer.parseInt(num));
            System.out.println(num);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
