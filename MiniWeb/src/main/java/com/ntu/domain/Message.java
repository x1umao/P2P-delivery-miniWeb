package com.ntu.domain;

public class Message {
    private Integer mid;
    private String talker;
    private String listener;
    private String message;
    private String postTime;
    private Integer taskId;

    @Override
    public String toString() {
        return "Message{" +
                "mid=" + mid +
                ", talker='" + talker + '\'' +
                ", listener='" + listener + '\'' +
                ", message='" + message + '\'' +
                ", postTime='" + postTime + '\'' +
                ", taskId=" + taskId +
                '}';
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getTalker() {
        return talker;
    }

    public void setTalker(String talker) {
        this.talker = talker;
    }

    public String getListener() {
        return listener;
    }

    public void setListener(String listener) {
        this.listener = listener;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }
}
