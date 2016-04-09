package com.road.crawler.book.crawler;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;
import com.road.crawler.book.model.CategoryType;
import com.road.crawler.book.service.CategoryTypeService;

/**
 * @description:
 * @author rook
 * @date 2016-4-9 上午10:50:29
 */
@Service
public class SaveCategoryPipeline implements Pipeline<IndexPage> {

	@Resource(name="categoryTypeServiceImpl")
	private CategoryTypeService categoryTypeService;

	public void process(IndexPage bean) {
		List<CategoryType> categoryTypes = bean.getCategoryTypes();
		for (CategoryType categoryType : categoryTypes) {
			categoryType.setCreateDate(new Date());
			categoryTypeService.save(categoryType);
			HttpRequest sub = bean.getRequest().subRequest(categoryType.getUrl()+"1.htm");
			sub.addParameter("tag", ""+categoryType.getId());
			SchedulerContext.into(sub);
		}
	}
}
