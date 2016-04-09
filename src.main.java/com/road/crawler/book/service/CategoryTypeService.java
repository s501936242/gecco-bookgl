package com.road.crawler.book.service;

import java.util.List;

import com.road.crawler.book.model.CategoryType;

/**
 * @description:
 * @author rook
 * @date 2016-4-9 上午10:47:55
 */
public interface CategoryTypeService {

    void save(CategoryType categoryType);
    
    List<CategoryType> findAll();
    
    CategoryType selectByPrimaryKey(Integer id);
}
