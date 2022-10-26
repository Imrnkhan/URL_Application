package com.example.url_application.Model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "url")

public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)  // it applies the not null constraint to the particular database column.
                              // (used mainly in the DDL schema metadata generation)
                               // because hibernate generate automatically database schema .
    private String sort_url;


    private String full_url;

    @Column(nullable = false)    // it applies the not null constraint to the particular database column.
    private Date createdDate;

    public Url() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSort_url() {
        return sort_url;
    }

    public void setSort_url(String sort_url) {
        this.sort_url = sort_url;
    }

    public String getFull_url() {
        return full_url;
    }

    public void setFull_url(String full_url) {
        this.full_url = full_url;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    private Date expiryDate;

    public Url(Long id, String sort_url, String full_url, Date createdDate, Date expiryDate) {
        this.id = id;
        this.sort_url = sort_url;
        this.full_url = full_url;
        this.createdDate = createdDate;
        this.expiryDate = expiryDate;
    }
}
