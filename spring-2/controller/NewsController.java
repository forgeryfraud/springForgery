package com.examly.springapp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.examly.springapp.model.ApiResponse;
import com.examly.springapp.service.NewsService;
@RestController
@RequestMapping("/news")
public class NewsController 
{
    @Autowired
    private NewsService newsService;
    @GetMapping("/source/{source}")
    public ResponseEntity<ApiResponse> getNewsBySource(@PathVariable String source) {
        ApiResponse apiResponse = newsService.getNewsBySource(source);
        if (apiResponse == null || apiResponse.getArticles() == null || apiResponse.getArticles().length == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(apiResponse);
    }
    @GetMapping("/country/{country}/category/{category}")
    public ResponseEntity<ApiResponse> getNewsByCountryAndCategory(@PathVariable String country, @PathVariable String category) {
        ApiResponse apiResponse = newsService.getNewsByCountryAndCategory(country, category);
        if (apiResponse == null || apiResponse.getArticles() == null || apiResponse.getArticles().length == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(apiResponse);
    }
    @GetMapping("/country/{country}/category/{category}/{pageNumber}/{pageSize}/{sortField}")
    public ResponseEntity<ApiResponse> getNewsByCountryCategoryWithPaginationAndSort(@PathVariable String country, @PathVariable String category, @PathVariable int pageNumber, @PathVariable int pageSize, @PathVariable String sortField) {
        ApiResponse apiResponse = newsService.getNewsByCountryCategoryWithPaginationAndSort(country, category, pageNumber, pageSize, sortField);
        if (apiResponse == null || apiResponse.getArticles() == null || apiResponse.getArticles().length == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(apiResponse);
    }
}