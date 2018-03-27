
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
		
		article.setArticleId(1);
		article.setTitle("Java Concurrency & Paralel Programming");
		article.setCategory("Java SE");
		int rs = dao.updateArticle(article);
		
		assertEquals(rs, 1);
		
		Article article2 = dao.getArticleById(1);
		assertEquals(article2.getTitle().trim(),"Java Concurrency & Paralel Programming");
		
	}
	
	@Test
	public void testInsertArticle() {
		Article article = new Article();

		article.setTitle("Apache Camel");
		article.setCategory("Enterprise Application");
	
		assertEquals(dao.addArticle(article),1);			
	}
	
	@Test
	public void testDeleteTheLatestData() {
		Article article = new Article();
		article = dao.getTheLatestId();
		dao.deleteArticle(article.getArticleId());
	}
	
	@Test
	public void testGetTheLatestDataInserted() {
		Article article = new Article();
		article = dao.getTheLatestId();
		
		//assertEquals(Integer.valueOf(12), article.getArticleId());
	}
	

}
