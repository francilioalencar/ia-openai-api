package com.francilio.api.model;

public class CompletionTokensDetails {
    private int reasoningTokens;
    private int acceptedPredictionTokens;
    private int rejectedPredictionTokens;

    public CompletionTokensDetails() {}

    public CompletionTokensDetails(int reasoningTokens, int acceptedPredictionTokens, int rejectedPredictionTokens) {
        this.reasoningTokens = reasoningTokens;
        this.acceptedPredictionTokens = acceptedPredictionTokens;
        this.rejectedPredictionTokens = rejectedPredictionTokens;
    }

    public int getReasoningTokens() {
        return reasoningTokens;
    }

    public void setReasoningTokens(int reasoningTokens) {
        this.reasoningTokens = reasoningTokens;
    }

    public int getAcceptedPredictionTokens() {
        return acceptedPredictionTokens;
    }

    public void setAcceptedPredictionTokens(int acceptedPredictionTokens) {
        this.acceptedPredictionTokens = acceptedPredictionTokens;
    }

    public int getRejectedPredictionTokens() {
        return rejectedPredictionTokens;
    }

    public void setRejectedPredictionTokens(int rejectedPredictionTokens) {
        this.rejectedPredictionTokens = rejectedPredictionTokens;
    }
}