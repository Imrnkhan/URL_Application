package com.example.url_application.service;

import com.example.url_application.Model.Url;
import com.example.url_application.dto.UrlLongRequest;
import com.example.url_application.repository.UrlRepostory;
import lombok.var;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;

@Service
public class UrlService {

    private final   UrlRepostory urlRepostory;

    private final BaseConversion baseConversion;

    public UrlService(UrlRepostory urlRepostory, BaseConversion baseConversion) {
        this.urlRepostory = urlRepostory;
        this.baseConversion = baseConversion;
    }



    public String convertTOShortUrl(UrlLongRequest urlRequest){
        var url = new Url();
url.setFull_url(urlRequest.getLong_url());
url.setExpiryDate(urlRequest.getExpireDate());
url.setCreatedDate(new Date());
var entity = urlRepostory.save(url);
return baseConversion.encode(entity.getId());
    }
    public String getOrigionalUrl(String shortUrl){
        var id = baseConversion.decode(shortUrl);
        var entity = urlRepostory.findById(id).orElseThrow(()-> new EntityNotFoundException("There is no entity " +shortUrl));
        if(entity.getExpiryDate()!=null && entity.getExpiryDate().before(new Date())){
            urlRepostory.delete(entity);
            throw new EntityNotFoundException("url link expire");
        }
        return entity.getFull_url();
    }
}
