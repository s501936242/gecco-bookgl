package com.road.crawler.book.crawler;

import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Image;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * @description:
 * @author rook
 * @date 2016-4-9 上午10:50:55
 */
public class Book implements HtmlBean {

	private static final long serialVersionUID = 1L;

	@Text
	@HtmlField(cssPath = "ul > li.title > a")
	private String alt;

	@Href
	@HtmlField(cssPath = "ul > li.title > a")
	private String href;

	@HtmlField(cssPath = "ul > li.tj > label[1] > font")
	private String thumbnail;

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

}
