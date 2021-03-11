package ua.com.alevel.model;


import java.util.Date;

public class Order {
    public Integer order_id;
    public Integer product_id;
    public Integer user_id;
    public Date order_date;
    public String orderStatus;

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", product_id=" + product_id +
                ", user_id=" + user_id +
                ", order_date=" + order_date +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }


    public Order(Integer order_id, Integer product_id, Integer user_id, Date order_date, String orderStatus) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.user_id = user_id;
        this.order_date = order_date;
        this.orderStatus = orderStatus;
    }

}

