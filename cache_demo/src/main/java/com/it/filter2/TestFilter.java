package com.it.filter2;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangchao
 * @description 布隆过滤器
 * @date 2019/11/14 10:15
 */
public class TestFilter {

    private static int size = 1000000;

    private static BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), size, 0.01);

    public static void main(String[] args) {
        for (int i = 0; i < size; i++) {
            bloomFilter.put(i);
        }

        List<Integer> list = new ArrayList<>(10000);
        //故意取10000个不在过滤器中的数据

        for (int i = size + 10000; i < size + 20000; i++) {
            if (bloomFilter.mightContain(i)) {
                list.add(i);
            }
        }

        System.out.println("误判的数量:" + list.size());
    }


}
