package com.cdc.mitrais.test;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cdc.mitrais.dao.ArticleDAO;
import com.cdc.mitrais.model.Article;

public class ArticleDAOTest {
	
	static ArticleDAO dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = new ArticleDAO();
	}

	@Test
	public void testGetAllArticles() {
		
		List<Article> articleList = dao.getAllArticles();
		
		for(Article article : articleList) {
			System.out.println("Title:"+article.getTitle());
			if(article.getArticleId() == 2) {
				assertEquals(article.getTitle().trim(),"Hibernate HQL");
			}
		}
	}

	@Test
	public void testGetArticleById() {
		Article article = dao.getArticleById(2);
		assertEquals(article.getTitle().trim(),"Hibernate HQL");
	}

	@Test
	public void testUpdateArticle() {
		Article article = new Article();
		
		article.setArticleId(10);
		article.setTitle("Enterprise Integration Pattern");
		article.setCategory("Enterprise Application");
		int rs = dao.updateArticle(article);
		
		assertEquals(rs, 1);
		
		Article article2 = dao.getArticleById(10);
		assertEquals(article2.getTitle().trim(),"Enterprise Integration Pattern");
		
	}

	@Test
	public void testDeleteArticle() {
		fail("Not yet implemented");
	}

}
