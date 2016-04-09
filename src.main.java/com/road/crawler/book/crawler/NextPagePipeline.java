package com.road.crawler.book.crawler;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;
import com.road.crawler.book.model.BookInfo;
import com.road.crawler.book.service.BookInfoService;
import com.road.crawler.book.service.CategoryTypeService;
 

/**
 * @description:
 * @author rook
 * @date 2016-4-8 下午10:18:11
 */

@Service
public class NextPagePipeline implements Pipeline<SecondPage> {

	@Resource(name="bookInfoServiceImpl")
	private BookInfoService bookInfoService;
	
	@Resource(name="categoryTypeServiceImpl")
	private CategoryTypeService categoryServiceImpl;

	public void process(SecondPage bean) {
		// 保存当前页爬取的书籍信息
		List<Book> books = bean.getBooks();
		for (Book book : books) {
			BookInfo bookInfo = new BookInfo();
			bookInfo.setTag(bean.getTag());
			bookInfo.setAlt(book.getAlt());
			bookInfo.setHref(book.getHref());
			bookInfo.setThumbnail(book.getThumbnail());
			bookInfo.setCreateDate(new Date());
			bookInfoService.save(bookInfo);
			//继续抓取详情页
			HttpRequest sub = bean.getRequest().subRequest(book.getHref());
			sub.addParameter("txtinfoId", ""+bookInfo.getId());
			sub.addParameter("type", categoryServiceImpl.selectByPrimaryKey(Integer.parseInt(bookInfoService.selectByPrimaryKey(bookInfo.getId()).getTag())).getTag());
			SchedulerContext.into(sub);
		}
		//继续抓取下一页构造下一页
		int currPage = bean.getCurrPage();
		int totalPage = getTotalPage(bean.getLastPageUrl());
		String tagCode = bean.getTagCode();
		if (currPage < totalPage) {
			int nextPage = currPage + 1;
			String nextUrl = "http://www.aqtxt.com/" + tagCode +"/"+nextPage+".htm";
			HttpRequest request = bean.getRequest();
			SchedulerContext.into(request.subRequest(nextUrl));
		}
	}
	
	private int getTotalPage(String lastPageUrl) {
		if(StringUtils.isEmpty(lastPageUrl)) {
			return 1;
		}
		//http://www.meizitu.com/tag/ suxiong_17_ 9 .html
		lastPageUrl = StringUtils.substringAfterLast(lastPageUrl, "/");
		lastPageUrl = StringUtils.substringBefore(lastPageUrl, ".");
		return NumberUtils.toInt(lastPageUrl, 1);
	}
}
