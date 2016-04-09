package com.road.crawler.book;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.pipeline.PipelineFactory;
import com.geccocrawler.gecco.request.HttpGetRequest;

/**
 * @description:
 * @author rook
 * @date 2016-4-8 下午10:48:33
 */
@Service
public class CrawlerMain implements ApplicationContextAware,InitializingBean {

	private ApplicationContext context;

	public void afterPropertiesSet() throws Exception {
		PipelineFactory springPipelineFactory = (PipelineFactory)context.getBean("springPipelineFactory");
		HttpGetRequest start = new HttpGetRequest("http://www.aqtxt.com/");
		start.setCharset("GBK");
		GeccoEngine.create()
			.classpath("com.road.crawler.book.crawler")
			.pipelineFactory(springPipelineFactory)
			.interval(3000)
			.start(start)
			.run();
	}

	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.in.read();
		context.close();
	}
}
