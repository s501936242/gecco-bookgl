package com.road.crawler.book.crawler;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

/**
 * @description:
 * @author rook
 * @date 2016-4-9 上午10:50:16
 */
@Gecco(matchUrl = "http://www.aqtxt.com/{tagCode}/{currPage}.htm", pipelines = {"consolePipeline", "nextPagePipeline"})
public class SecondPage implements HtmlBean {

	private static final long serialVersionUID = 1L;

	@RequestParameter
	private String tag;
	
	@RequestParameter
	private String tagCode;
	

	@Request
	private HttpRequest request;

	@RequestParameter
	private int currPage;
	

	@Href
	@HtmlField(cssPath = "#newbook > .pager > a:last-child")
	private String lastPageUrl;

	@HtmlField(cssPath = "#newbook > .list")
	private List<Book> books;
	

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public HttpRequest getRequest() {
		return request;
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getLastPageUrl() {
		return lastPageUrl;
	}

	public void setLastPageUrl(String lastPageUrl) {
		this.lastPageUrl = lastPageUrl;
	}

	public String getTagCode() {
		return tagCode;
	}

	public void setTagCode(String tagCode) {
		this.tagCode = tagCode;
	}

	public static void main(String[] args) {
		HttpRequest request = new HttpGetRequest("http://www.aqtxt.com/finished/20.htm");
		request.setCharset("GBK");
		GeccoEngine.create().classpath("com.road.crawler.book").start(request).interval(3000).run();
	}

}
