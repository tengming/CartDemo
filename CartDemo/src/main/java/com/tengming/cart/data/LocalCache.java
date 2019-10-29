package com.tengming.cart.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalCache {
    private static Map<Long, Product> productMap = new HashMap<>();
    private static Map<Long, Cart> cartMap = new HashMap<>();
    private static Map<Long, Favorite> favoriteMap = new HashMap<>();

    static {
        productMap.put(1l, new Product(1l, "HTML/CSS", "HTML+CSS基础课程",
                "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 200));
        productMap.put(2l, new Product(2l, "HTML/CSS", "HTML+CSS基础课程",
                "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 200));
        productMap.put(3l, new Product(3l, "HTML/CSS", "HTML+CSS基础课程",
                "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 200));
        productMap.put(4l, new Product(4l, "HTML/CSS", "HTML+CSS基础课程",
                "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 200));
        productMap.put(5l, new Product(5l, "HTML/CSS", "HTML+CSS基础课程",
                "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 200));
        productMap.put(6l, new Product(6l, "HTML/CSS", "HTML+CSS基础课程",
                "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 200));
        productMap.put(7l, new Product(7l, "HTML/CSS", "HTML+CSS基础课程",
                "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 200));
        productMap.put(8l, new Product(8l, "HTML/CSS", "HTML+CSS基础课程",
                "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 200));
        productMap.put(9l, new Product(9l, "HTML/CSS", "HTML+CSS基础课程",
                "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 200));
        productMap.put(10l, new Product(10l, "HTML/CSS", "HTML+CSS基础课程",
                "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 200));
        productMap.put(11l, new Product(11l, "HTML/CSS", "HTML+CSS基础课程",
                "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 200));
        productMap.put(12l, new Product(12l, "HTML/CSS", "HTML+CSS基础课程",
                "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 200));
        productMap.put(13l, new Product(13l, "HTML/CSS", "HTML+CSS基础课程",
                "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 200));
        productMap.put(14l, new Product(14l, "HTML/CSS", "HTML+CSS基础课程",
                "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 200));
        productMap.put(15l, new Product(15l, "HTML/CSS", "HTML+CSS基础课程",
                "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 200));
        productMap.put(16l, new Product(16l, "HTML/CSS", "HTML+CSS基础课程",
                "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 200));
    }

    public static List<Product> getProducts() {
        return new ArrayList<>(productMap.values());
    }

    public static Product getProduct(Long id) {
        return productMap.get(id);
    }

    public static void addCart(Product product) {
        if (cartMap.containsKey(product.getId())) {
            LocalCache.addOneCount(LocalCache.getProduct(Long.valueOf(product.getId())));
        } else {
            cartMap.put(product.getId(), new Cart(product.getId(), product.getId(),
                    product.getName(), product.getPrice(), 1));
        }
    }

    public static void delCard(Product product) {
        cartMap.remove(product.getId());
    }

    public static List<Cart> getCarts() {
        return new ArrayList<>(cartMap.values());
    }

    public static void addOneCount(Product product) {
        cartMap.get(product.getId()).incrCount();
    }

    public static void delOneCount(Product product) {
        if (cartMap.get(product.getId()).decrCount())
            cartMap.remove(product.getId());
    }

    public static List<Favorite> getFavoriteProduct() {
        return new ArrayList<>(favoriteMap.values());
    }

    public static void addFavoriteProduct(Product product) {
        favoriteMap.put(product.getId(), new Favorite(product.getName(), product.getId(),
                product.getLevel(), product.getDesc(), product.getPrice()));
    }


    public static void delFavorite(Product product) {
        favoriteMap.remove(product.getId());
    }

    public static void delCart(Long productId) {
        cartMap.remove(productId);
    }

    public static Cart getCart(Long id) {
        return cartMap.get(id);
    }
}
