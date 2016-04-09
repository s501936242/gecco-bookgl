package com.road.crawler.book.crawler;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.geccocrawler.gecco.pipeline.Pipeline;
import com.road.crawler.book.exec.DownloadAction;
import com.road.crawler.book.exec.Executors;
import com.road.crawler.book.model.Book;
import com.road.crawler.book.service.BookService;

/**
 * @description:
 * @author rook
 * @date 2016-4-9 上午10:50:21
 */
@Service
public class TxtPipeline implements Pipeline<Txt> {

	@Resource(name = "bookServiceImpl")
	private BookService bookService;

	@Value("${local.path}")
	private String fileSavePath;

	private Executors executors = Executors.create();

	public void process(Txt bean) {
		Book book = new Book();
		book.setCreateDate(new Date());
		book.setUpdateDate(new Date());
		book.setTxtinfoId(bean.getTxtinfoId());
		String url = bean.getUrl();
		String title = bean.getTitle();
		String type = bean.getType();
		book.setUrl(url);
		String localPath = fileSavePath + type+ "1/" + title  +"_"+System.currentTimeMillis() + ".rar";
		book.setPath(localPath);
		bookService.save(book);
		executors.getDefaultActionQueue().enqueue(
				new DownloadAction(executors.getDefaultActionQueue(), url, localPath));
	}
}
