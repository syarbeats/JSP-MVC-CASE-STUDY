package com.cdc.mitrais.dao;

import java.util.List;

import com.cdc.mitrais.model.Article;

public class Test {

	public static void main(String[] args) {
		
		ArticleDAO dao = new ArticleDAO();
		List<Article> articleList = dao.getAllArticles();
		
		for(Article article : articleList) {
			System.out.println("Title:"+article.getTitle());
		}

	}

}
