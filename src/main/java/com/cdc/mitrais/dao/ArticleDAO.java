package com.cdc.mitrais.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cdc.mitrais.database.util.ConnectionPool;
import com.cdc.mitrais.model.Article;

public class ArticleDAO implements IArticleDAO{

	private ConnectionPool connectionPool = null;
	private static final Logger logger = LoggerFactory.getLogger(ArticleDAO.class);
	
	
	public ArticleDAO(){
		try {
			connectionPool = new ConnectionPool();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Article> getAllArticles() {
		List<Article> articleList = new ArrayList<Article>();
		
		try {
			PreparedStatement statement = connectionPool.getPreparedStatement("Select * From Articles");
			ResultSet rs = statement.executeQuery();
						
			while(rs.next()) {
				Article article = new Article();
				article.setArticleId(rs.getInt("article_id"));
				logger.debug(article.getArticleId().toString());
				article.setTitle(rs.getString("title"));
				logger.debug(article.getTitle());
				article.setCategory(rs.getString("category"));
				articleList.add(article);
			}
			
		} catch (SQLException e) {
			logger.debug(e.toString());
			e.printStackTrace();
			return null;
		}
		
		return articleList;
	}

	@Override
	public Article getArticleById(int Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article getArticleByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateArticle(int Id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteArticle(int Id) {
		// TODO Auto-generated method stub
		
	}

}
