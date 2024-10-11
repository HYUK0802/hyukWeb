package com.hyuk.hyukweb.study.java_ch2.ch02;

public class Order {

    // 멤버변수
    int orderId;
    String buyerId;
    String sellerId;
    int productId;
    String orderDate;

    public void showOrder() {
        System.out.println("주문 아이디 = " + orderId
                            + "구매자 아이디 = " + buyerId
                            + "판매자 아이디 = " + sellerId
                            + "상품 아이디 = "  + productId
                            + "주문 날짜 = " + orderDate);
    }
}
