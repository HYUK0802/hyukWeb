package com.hyuk.hyukweb.study.java_ch2.ch02;

public class OrderTest {
    public static void main(String[] args) {
        Order order1 = new Order();
        order1.orderId = 1234;
        order1.buyerId = "김재혁";
        order1.sellerId = "이현아";
        order1.productId = 443;
        order1.orderDate = "2024-10-28";

        order1.showOrder();
    }
}
