package com.chenfei.cfgo.math.service.add;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 464498258@qq.com
 * @version 1.0.0
 * @descriptions 加法相关的操作
 * @create 2023/12/4 21:15
 */
public class AddAlg {

    public static void main(String[] args) {
        numberAdd();
    }

    /**
     *@description 30以内的加法：1+1、 2+1、 3+1。。。
     *
     *@return void
     *@throw
     *@author 464498258@qq.com
     *@version 1.0.0
     *@create 2023/12/5 14:35
     */
    private static void numberAdd() {
        int fixedNumber = 1;
        int changeNumber = 1;
        for (; fixedNumber <= 30; fixedNumber++) {
            List<String> numberList = new ArrayList();
            int num = 0;
            for (; changeNumber <= 30; changeNumber++) {
                String formattedStr = String.format("%1d\t+\t%d\t= \t\t\t", changeNumber, fixedNumber);
                numberList.add(formattedStr);
            }
            Collections.shuffle(numberList);

            for (int i = 0; i < numberList.size(); i++) {
                num ++;
                System.out.print(numberList.get(i));
                if (num % 3 == 0 ) {
                    System.out.println();
                }
            }
            System.out.println("================================================================");
            changeNumber = 1;
        }
    }
}
