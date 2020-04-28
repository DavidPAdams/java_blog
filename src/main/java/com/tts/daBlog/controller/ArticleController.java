package com.tts.daBlog.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tts.daBlog.model.Article;
import com.tts.daBlog.repository.ArticleRepository;

@Controller
public class ArticleController {
  
  @Autowired
  private ArticleRepository articleRepository;
  
  @GetMapping(value = {"/", "/Articles"})
  public String index(Article article, Model model) {
    List<Article> articles = articleRepository.findAll();
    model.addAttribute("articles", articles);
    return "index";
  }
  
  @GetMapping(value = "/articles/new")
  public String newArticle(Model model) {
    model.addAttribute("article", new Article());
    return "new";
  }
  
  @PostMapping(value = "/articles/new")
  public String create(Article article, Model model) {
    articleRepository.save(article);
    model.addAttribute("title", article.getTitle());
    model.addAttribute("author", article.getAuthor());
    model.addAttribute("entry", article.getEntry());
    return "show";
  }

  @GetMapping("/articles/{articleId}/show")
  public String getArticleById(
      @PathVariable("articleId") Long articleId,
      Model model) {
    Optional<Article> article = articleRepository
        .findById(articleId);
    model.addAttribute("article", article.get());
    return "show";
  }

  @GetMapping(value = "/articles/{articleId}/edit")
  public String editArticle(
      @PathVariable("articleId") Long articleId,
      Model model) {
    Optional<Article> editArticle = articleRepository
        .findById(articleId);
    model.addAttribute("article", editArticle.get());
    return "edit";
  }

  @RequestMapping(value = "/articles/{articleId}/edit", method = RequestMethod.POST)
  public String updateArticle(
      @PathVariable("articleId") Long articleId,
      Article article, Model model) {
    Optional<Article> optionArticle = articleRepository
        .findById(articleId);
    Article updateArticle = optionArticle.get();
    updateArticle.setTitle(article.getTitle());
    updateArticle.setAuthor(article.getAuthor());
    updateArticle.setEntry(article.getEntry());
    articleRepository.save(updateArticle);
    model.addAttribute("article", updateArticle);
    return "show";
  }

  @RequestMapping(value = "/articles/{articleId}/delete", method = RequestMethod.GET)
  public String deleteArticle(
      @PathVariable("articleId") Long articleId,
      Article article) {
    Optional<Article> optionArticle = articleRepository.findById(articleId);
    Article garbageArticle = optionArticle.get();
    articleRepository.delete(garbageArticle);;
    return "redirect:/articles";
  }
}
