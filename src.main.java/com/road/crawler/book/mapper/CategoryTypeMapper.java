package com.road.crawler.book.mapper;


import java.util.List;

import com.road.crawler.book.model.CategoryType;

public interface CategoryTypeMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(CategoryType record);

    int insertSelective(CategoryType record);

    CategoryType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CategoryType record);

    int updateByPrimaryKey(CategoryType record);

	List<CategoryType> findAll();
}