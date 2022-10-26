package com.example.url_application.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(description = "Request for POST Method")
public class UrlLongRequest {

    @ApiModelProperty(required = true,notes = "url converts sort")
    private String long_url;



    @ApiModelProperty(notes = "url expire date time")
    private Date expireDate;

    public void setLong_url(String long_url) {
        this.long_url = long_url;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public String getLong_url() {
        return long_url;


    }


}
