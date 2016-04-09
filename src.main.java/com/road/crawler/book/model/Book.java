package com.road.crawler.book.model;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {
    private Integer id;

    private Integer txtinfoId;

    private String url;

    private String path;

    private Date createDate;

    private Date updateDate;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTxtinfoId() {
		return txtinfoId;
	}

	public void setTxtinfoId(Integer txtinfoId) {
		this.txtinfoId = txtinfoId;
	}

	public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", txtinfoId=" + txtinfoId +
                ", url='" + url + '\'' +
                ", path='" + path + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}