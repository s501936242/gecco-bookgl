package com.road.crawler.book.model;

import java.util.Date;

import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;

public class CategoryType implements HtmlBean {

    private Integer id;

    @Text
    @HtmlField(cssPath = "a")
    private String tag;

    @Href
    @HtmlField(cssPath = "a")
    private String url;
    
    private Date createDate;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
    public String toString() {
        return "CategoryType{" +
                "id=" + id +
                ", tag='" + tag + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}