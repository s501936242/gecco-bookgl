package com.road.crawler.book.service;

import com.road.crawler.book.model.BookInfo;

/**
 * @description:
 * @author rook
 * @date 2016-4-9 上午10:46:51
 */
public interface BookInfoService {

	int save(BookInfo bookInfo);
	
	BookInfo selectByPrimaryKey(Integer id);

}