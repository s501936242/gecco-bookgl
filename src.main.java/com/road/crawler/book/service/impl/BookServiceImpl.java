package com.road.crawler.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.road.crawler.book.mapper.BookMapper;
import com.road.crawler.book.model.Book;
import com.road.crawler.book.service.BookService;

/**
 * @description:
 * @author rook
 * @date 2016-4-9 上午10:46:20
 */
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookMapper bookMapper;

	public int save(Book book) {
		return bookMapper.insert(book);
	}

}
