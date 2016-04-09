package com.road.crawler.book.crawler;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Attr;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Image;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

/**
 * @description:
 * @author rook
 * @date 2016-4-8 下午10:49:15
 */
@Gecco(matchUrl = "http://www.aqtxt.com/xiazai/txt/{code}.htm", pipelines = { "consolePipeline", "txtPipeline" })
public class Txt implements HtmlBean {

	private static final long serialVersionUID = 1L;

	@RequestParameter
	private int txtinfoId;
	
	@RequestParameter
	private String type;
	
	@Href
	@HtmlField(cssPath="#txtdown .bd a")
	private String url;
	
	@Attr("title")
	@HtmlField(cssPath="#txtdown .bd a")
	private String title;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTxtinfoId() {
		return txtinfoId;
	}

	public void setTxtinfoId(int txtinfoId) {
		this.txtinfoId = txtinfoId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static void main(String[] args) {
		HttpGetRequest start = new HttpGetRequest("http://www.aqtxt.com/xiazai/txt/1.htm");
		start.setCharset("GBK");
		GeccoEngine.create().classpath("com.road.crawler.book").start(start).interval(3000).run();
	}

}
