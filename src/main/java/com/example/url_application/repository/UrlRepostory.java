package com.example.url_application.repository;

import com.example.url_application.Model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepostory extends JpaRepository<Url,Long> {
}
