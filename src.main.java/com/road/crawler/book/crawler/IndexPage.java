package com.road.crawler.book.crawler;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;
import com.road.crawler.book.model.CategoryType;

import java.util.List;

/**
 * @description:
 * @author rook
 * @date 2016-4-9 上午10:50:42
 */
@Gecco(matchUrl = "http://www.aqtxt.com/", pipelines = { "consolePipeline", "saveCategoryPipeline" })
public class IndexPage implements HtmlBean {

	private static final long serialVersionUID = -139677387757121011L;

	@Request
	private HttpRequest request;
	
	@HtmlField(cssPath = ".menu a")
	private List<CategoryType> categoryTypes;

	public List<CategoryType> getCategoryTypes() {
		return categoryTypes;
	}

	public void setCategoryTypes(List<CategoryType> categoryTypes) {
		this.categoryTypes = categoryTypes;
	}

	public HttpRequest getRequest() {
		return request;
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
	}

	public static void main(String[] args) {
		HttpGetRequest start = new HttpGetRequest("http://www.aqtxt.com/");
		start.setCharset("GBK");
		GeccoEngine.create()
				.classpath("com.road.crawler.book")
				.start(start)
				.run();
	}

}
