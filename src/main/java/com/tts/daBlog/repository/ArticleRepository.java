package com.tts.daBlog.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.daBlog.model.Article;

@Repository
public interface ArticleRepository
    extends CrudRepository<Article, Long> {
  public List<Article> findAll();
  public Optional<Article> findById(Long articleId);
}
