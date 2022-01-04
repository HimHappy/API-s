package com.example.crudoperation.module;

import com.mongodb.internal.connection.Time;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Document(collection = "eventDB")
public class EventModule {
    @Id
    private UUID eventId;
    private String eventName;
    private Date eventDate;
    private String eventDescription;
    private Boolean status;
    private List<String> city;
    private List<String> locality;
    private List<String> properties;
    private Date createdTimeStamp;
    private Date updatedTimeStamp;

    //constructor
    public EventModule(){
        this.eventId = UUID.randomUUID();
        this.createdTimeStamp = new Date();
    }

    //getters nd setters
    public UUID getEventId() {
        return eventId;
    }
    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }
    public String getEventName() {
        return eventName;
    }
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    public Date getEventDate() {
        return eventDate;
    }
    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
    public String getEventDescription() {
        return eventDescription;
    }
    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public List<String> getCity() {
        return city;
    }
    public void setCity(List<String> city) {
        this.city = city;
    }
    public List<String> getLocality() {
        return locality;
    }
    public void setLocality(List<String> locality) {
        this.locality = locality;
    }
    public List<String> getProperties() {
        return properties;
    }
    public void setProperties(List<String> properties) {
        this.properties = properties;
    }
    public Date getCreatedTimeStamp() {
        return createdTimeStamp;
    }
    public void setCreatedTimeStamp(Date createdTimeStamp) {
        this.createdTimeStamp = createdTimeStamp;
    }
    public Date getUpdatedTimeStamp() {
        return updatedTimeStamp;
    }
    public void setUpdatedTimeStamp(Date updatedTimeStamp) {
        this.updatedTimeStamp = updatedTimeStamp;
    }

    @Override
    public String toString() {
        return "EventModule{" +
                "eventId=" + eventId +
                ", eventName='" + eventName + '\'' +
                ", eventDate=" + eventDate +
                ", eventDescription='" + eventDescription + '\'' +
                ", status=" + status +
                ", city=" + city +
                ", locality=" + locality +
                ", properties=" + properties +
                ", createdTimeStamp=" + createdTimeStamp +
                ", updatedTimeStamp=" + updatedTimeStamp +
                '}';
    }
}
