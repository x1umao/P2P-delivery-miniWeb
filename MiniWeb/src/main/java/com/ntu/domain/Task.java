package com.ntu.domain;

public class Task {

    private Integer tid;
    private String customerId;
    private String driverId;
    private String pickupTime;
    private String deliverTime;
    private String pickupAddress;
    private String deliverAddress;
    private String remarks;
    private int status;
    private String postTime;
    private String username;

    @Override
    public String toString() {
        return "Task{" +
                "tid=" + tid +
                ", customerId='" + customerId + '\'' +
                ", driverId='" + driverId + '\'' +
                ", pickupTime='" + pickupTime + '\'' +
                ", deliverTime='" + deliverTime + '\'' +
                ", pickupAddress='" + pickupAddress + '\'' +
                ", deliverAddress='" + deliverAddress + '\'' +
                ", remarks='" + remarks + '\'' +
                ", status=" + status +
                ", postTime='" + postTime + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(String deliverTime) {
        this.deliverTime = deliverTime;
    }

    public String getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    public String getDeliverAddress() {
        return deliverAddress;
    }

    public void setDeliverAddress(String deliverAddress) {
        this.deliverAddress = deliverAddress;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
