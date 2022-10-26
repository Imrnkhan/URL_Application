package com.example.url_application.controller;


import com.example.url_application.dto.UrlLongRequest;
import com.example.url_application.service.UrlService;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1")
public class UrlController {


    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }


    @ApiOperation(value = "convert in url",notes = "converts long url to short url")
    @PostMapping("create_short")

    public  String convertToShortUrl(@RequestBody UrlLongRequest urlLongRequest){
        return urlService.convertTOShortUrl(urlLongRequest);
    }

    @ApiOperation(value = "redirect", notes = "find the origional url and redirect")

    @GetMapping(value = "{shortUrl}")
    @Cacheable(value = "url",key = "#shortUrl",sync = true)

    public ResponseEntity<Void> getAndRedirect(@PathVariable String shortUrl){
        var url =urlService.getOrigionalUrl(shortUrl);
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(url)).build();
    }
}













/*
What is the use of @RequestMapping?
One of the most important annotations in spring is the @RequestMapping Annotation which is used to map HTTP requests to handler methods of MVC and REST controllers.
 In Spring MVC applications, the DispatcherServlet (Front Controller) is responsible for routing incoming HTTP requests to handler methods of controllers.
 */