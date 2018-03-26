package com.cdc.mitrais.dao;

import java.util.List;

import com.cdc.mitrais.model.Article;

public interface IArticleDAO {
	public List<Article> getAllArticles();
	public Article getArticleById(int Id);
	public Article getArticleByTitle(String title);
	public void updateArticle(int Id);
	public void deleteArticle(int Id);
}
