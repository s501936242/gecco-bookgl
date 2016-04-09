package com.road.crawler.book.service.impl;

import com.road.crawler.book.mapper.CategoryTypeMapper;
import com.road.crawler.book.model.CategoryType;
import com.road.crawler.book.service.CategoryTypeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author rook
 * @date 2016-4-9 上午10:46:29
 */
@Service
public class CategoryTypeServiceImpl implements CategoryTypeService {

    @Autowired
    private CategoryTypeMapper categoryTypeMapper;

    public void save(CategoryType categoryType) {
        categoryTypeMapper.insert(categoryType);
    }

	public List<CategoryType> findAll() {
		return categoryTypeMapper.findAll();
	}

	public CategoryType selectByPrimaryKey(Integer id) {
		
		return categoryTypeMapper.selectByPrimaryKey(id);
	}
}
