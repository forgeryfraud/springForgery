
package com.examly.springapp.model;
public class ApiResponse 
{
    private Article[] articles;
    public ApiResponse() {}
    public ApiResponse(Article[] articles) {
        this.articles = articles;
    }
    public Article[] getArticles() {
        return articles;
    }
    public void setArticles(Article[] articles) {
        this.articles = articles;
    }
}
