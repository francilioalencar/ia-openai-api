package com.francilio.api.model;

public class Usage {
    private int promptTokens;
    private int completionTokens;
    private int totalTokens;
    private CompletionTokensDetails completionTokensDetails;

    public Usage() {}

    public Usage(int promptTokens, int completionTokens, int totalTokens, CompletionTokensDetails completionTokensDetails) {
        this.promptTokens = promptTokens;
        this.completionTokens = completionTokens;
        this.totalTokens = totalTokens;
        this.completionTokensDetails = completionTokensDetails;
    }

    public int getPromptTokens() {
        return promptTokens;
    }

    public void setPromptTokens(int promptTokens) {
        this.promptTokens = promptTokens;
    }

    public int getCompletionTokens() {
        return completionTokens;
    }

    public void setCompletionTokens(int completionTokens) {
        this.completionTokens = completionTokens;
    }

    public int getTotalTokens() {
        return totalTokens;
    }

    public void setTotalTokens(int totalTokens) {
        this.totalTokens = totalTokens;
    }

    public CompletionTokensDetails getCompletionTokensDetails() {
        return completionTokensDetails;
    }

    public void setCompletionTokensDetails(CompletionTokensDetails completionTokensDetails) {
        this.completionTokensDetails = completionTokensDetails;
    }
}
