package com.road.crawler.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.road.crawler.book.mapper.BookInfoMapper;
import com.road.crawler.book.model.BookInfo;
import com.road.crawler.book.service.BookInfoService;

/**
 * @description:
 * @author rook
 * @date 2016-4-9 上午10:46:08
 */
@Service
public class BookInfoServiceImpl implements BookInfoService {

	@Autowired
	private BookInfoMapper bookInfoMapper;

	public int save(BookInfo bookInfo) {

		return bookInfoMapper.insert(bookInfo);
	}

	public BookInfo selectByPrimaryKey(Integer id) {
		
		return bookInfoMapper.selectByPrimaryKey(id);
	}

}
