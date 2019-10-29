package com.tengming.cart.test;


import com.tengming.cart.data.Product;

import java.util.*;

public class Maptest {
    //定义一个商品的数量
    static final int max = 100;
//    static int a;
    static long b;
    private static Map<Integer,Product> productMap = new HashMap<>();
    static {
        for (int i=1; i<max+1; i++){
            b++;
//            a++;
//          Integer integer = new Integer(a);
            productMap.put(i,new Product(b,"发的","等等","电放费","法发广告",500));
        }
    }



    public static List<Product> getProduct(){
        return new ArrayList<>(productMap.values());
    }



    public static Set<Integer> getid(){
        return new HashSet<>(productMap.keySet());
    }

    public static void main(String[] args) {
        for(Product productlist:Maptest.getProduct()){
            System.out.println(productlist);
        }

        for (Integer id: Maptest.getid()){
            System.out.print(id+"\t");
        }

        Iterator<Integer> iterable =Maptest.getid().iterator();
        while (iterable.hasNext()){
            System.out.print(iterable.next()+"\t");
        }


    }
}
