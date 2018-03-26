package com.cdc.mitrais.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cdc.mitrais.dao.ArticleDAO;
import com.cdc.mitrais.model.Article;

/**
 * Servlet implementation class Article
 */


public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ArticleServlet.class);   
	private ArticleDAO articleDAO;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		logger.debug("Action-"+action);
		articleDAO = new ArticleDAO();
		
		try {
			switch(action) {
			
			case "/addArticle":
				addArticle(request, response);
				break;
			case "/editArticle":
				editArticle(request, response);
				break;
			case "/deleteArticle":
				deleteArticle(request, response);
				break;
			case "/searchArticleById":
				searchArticleById(request, response);
				break;
			case "/displayArticles":
				showAllArticle(request, response);
				break;

			
			}
			
		}catch(Exception ex) {
			
		}
		
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/test.jsp");
		//dispatcher.forward(request, response);
	}

	private void home(HttpServletRequest request, HttpServletResponse response) {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/test.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			logger.debug(e.toString());
			e.printStackTrace();
		}
		
	}

	private void showAllArticle(HttpServletRequest request, HttpServletResponse response) {
		logger.debug("URL-/displayArticles");
		List<Article> articleList = articleDAO.getAllArticles();
		
		for(Article article : articleList) {
			logger.debug("Title:"+article.getTitle()+" "+"Category:"+article.getCategory());
		}
		
		request.setAttribute("articles", articleList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/display-articles.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			logger.debug(e.toString());
			e.printStackTrace();
		}
		
	}

	private void searchArticleById(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void deleteArticle(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void editArticle(HttpServletRequest request, HttpServletResponse response) {
		Article article = new Article();
		article.setArticleId(Integer.valueOf(request.getParameter("articleId")));
		article.setTitle(request.getParameter("title"));
		article.setCategory(request.getParameter("category"));
		request.setAttribute("article", article);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/edit-article.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			logger.debug(e.toString());
			e.printStackTrace();
		}
		
		
	}

	private void addArticle(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
