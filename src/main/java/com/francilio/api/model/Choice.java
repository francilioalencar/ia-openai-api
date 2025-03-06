package com.francilio.api.model;

import java.util.List;

public class Choice {
    private int index;
    private Message message;
    private Object logprobs;
    private String finishReason;

    public Choice() {}

    public Choice(int index, Message message, Object logprobs, String finishReason) {
        this.index = index;
        this.message = message;
        this.logprobs = logprobs;
        this.finishReason = finishReason;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Object getLogprobs() {
        return logprobs;
    }

    public void setLogprobs(Object logprobs) {
        this.logprobs = logprobs;
    }

    public String getFinishReason() {
        return finishReason;
    }

    public void setFinishReason(String finishReason) {
        this.finishReason = finishReason;
    }
}

