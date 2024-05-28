
package com.examly.springapp.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.examly.springapp.model.ApiResponse;
@Service
public class NewsService 
{
    @Value("${newsapi.apikey}")
    private String apiKey;
    private final RestTemplate restTemplate;
    public NewsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public ApiResponse getNewsBySource(String source) {
        String url = String.format("https://newsapi.org/v2/top-headlines?sources=%s&apiKey=%s", source, apiKey);
        ResponseEntity<ApiResponse> response = restTemplate.getForEntity(url, ApiResponse.class);
        return response.getBody();
    }
    public ApiResponse getNewsByCountryAndCategory(String country, String category) {
        String url = String.format("https://newsapi.org/v2/top-headlines?country=%s&category=%s&apiKey=%s", country, category, apiKey);
        ResponseEntity<ApiResponse> response = restTemplate.getForEntity(url, ApiResponse.class);
        return response.getBody();
    }
    public ApiResponse getNewsByCountryCategoryWithPaginationAndSort(String country, String category, int pageNumber, int pageSize, String sortField) {
        String url = String.format("https://newsapi.org/v2/top-headlines?country=%s&category=%s&apiKey=%s", country, category, apiKey);
        ResponseEntity<ApiResponse> response = restTemplate.getForEntity(url, ApiResponse.class);
        return response.getBody(); 
    }
}