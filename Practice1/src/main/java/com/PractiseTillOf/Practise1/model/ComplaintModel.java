package com.PractiseTillOf.Practise1.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Document(collection = "ComplaintData")
public class ComplaintModel {
    @Id
    private UUID complainId;
    private Date complainRiseDate;
    private String complainStatus;
    private List<OrdersData> itemList;

    public ComplaintModel() {
        this.complainId = UUID.randomUUID();
        this.complainRiseDate= new Date(System.currentTimeMillis());
    }

    public ComplaintModel(UUID complainId, Date complainRiseDate, String complainStatus, List<OrdersData> itemList) {
        this.complainId = complainId;
        this.complainRiseDate = complainRiseDate;
        this.complainStatus = complainStatus;
        this.itemList = itemList;
    }

    public UUID getComplainId() {
        return complainId;
    }
    public void setComplainId(UUID complainId) {
        this.complainId = complainId;
    }
    public Date getComplainRiseDate() {
        return complainRiseDate;
    }
    public void setComplainRiseDate(Date complainRiseDate) {
        this.complainRiseDate = complainRiseDate;
    }
    public String getComplainStatus() {
        return complainStatus;
    }
    public void setComplainStatus(String complainStatus) {
        this.complainStatus = complainStatus;
    }
    public List<OrdersData> getItemList() {
        return itemList;
    }
    public void setItemList(List<OrdersData> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "ComplaintModel{" +
                "complainId=" + complainId +
                ", complainRiseDate=" + complainRiseDate +
                ", complainStatus='" + complainStatus + '\'' +
                ", itemList=" + itemList +
                '}';
    }
}
