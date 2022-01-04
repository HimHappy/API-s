package Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document("RatingsAndReviews")
public class RatingsAndReviews {
    @Id
    private Integer orderId;
    private Integer userId;
    private List<String> itemNames;
    private List<Float> discount;
    private List<Float> price;
    private Date time;
    private Date updatedtime;
    private boolean status;

    //default constructer
    RatingsAndReviews(){
        this.time=new Date();
    }
    //parameterized constructer
    public RatingsAndReviews(Integer orderId, Integer userId, List<String> itemNames, List<Float> discount, List<Float> price, Date time, Date updatedtime, boolean status) {
        this.orderId = orderId;
        this.userId = userId;
        this.itemNames = itemNames;
        this.discount = discount;
        this.price = price;
        this.time = time;
        this.updatedtime = updatedtime;
        this.status = status;
    }

    //getters and setters
    public Integer getOrderId() {
        return orderId;
    }
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public List<String> getItemNames() {
        return itemNames;
    }
    public void setItemNames(List<String> itemNames) {
        this.itemNames = itemNames;
    }
    public List<Float> getDiscount() {
        return discount;
    }
    public void setDiscount(List<Float> discount) {
        this.discount = discount;
    }
    public List<Float> getPrice() {
        return price;
    }
    public void setPrice(List<Float> price) {
        this.price = price;
    }
    public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
        this.time = time;
    }
    public Date getUpdatedtime() {
        return updatedtime;
    }
    public void setUpdatedtime(Date updatedtime) {
        this.updatedtime = updatedtime;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RatingsAndReviews{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", itemNames=" + itemNames +
                ", discount=" + discount +
                ", price=" + price +
                ", time=" + time +
                ", updatedtime=" + updatedtime +
                ", status=" + status +
                '}';
    }

}
