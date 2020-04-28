package com.tts.daBlog.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

@Entity
public class Article {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="article_id")
  private Long id;
  
  @NotEmpty(message = "An article must have a title")
  @Length(max = 75, message = "An article title can't be longer than 75 characters")
  private String title;
  
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "user_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private User author;
  
  @NotEmpty(message = "An article must have content")
  @Length(max = 10000, message = "An article can have at most 10,000 characters")
  private String entry;
  
  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;
  
  public Article() {}

  public Article(Long id, String title, User author,
      String entry, LocalDateTime createdAt,
      LocalDateTime updatedAt) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.entry = entry;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public Long getArticleId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public User getAuthor() {
    return author;
  }

  public String getEntry() {
    return entry;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setAuthor(User author) {
    this.author = author;
  }

  public void setEntry(String entry) {
    this.entry = entry;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public String toString() {
    return "Article [id=" + id + ", title=" + title
        + ", author=" + author + ", entry=" + entry
        + ", createdAt=" + createdAt + ", updatedAt="
        + updatedAt + "]";
  }
  
}


