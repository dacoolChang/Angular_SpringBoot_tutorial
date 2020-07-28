package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;



public class ApplicationEventListener implements ApplicationListener {
	private static final Logger log = LoggerFactory.getLogger(ApplicationEventListener.class);
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		// 監聽spring boot的生命週期
//		System.out.println("ApplicationEvent: "+event);
		if (event instanceof ApplicationEnvironmentPreparedEvent) { // 初始化環境變數
			System.out.println("ApplicationEnvironmentPreparedEvent");
		} else if (event instanceof ApplicationPreparedEvent) { // 初始化完成
			System.out.println("ApplicationPreparedEvent");
		} else if (event instanceof ContextRefreshedEvent) { // 應用更新
			System.out.println("ContextRefreshedEvent");
		} else if (event instanceof ApplicationReadyEvent) {// 應用已啟動完成
			System.out.println("ApplicationReadyEvent");
		} else if (event instanceof ContextStartedEvent) { // 應用啟動，需要在代碼動態添加監聽器才可捕獲
			System.out.println("ContextStartedEvent");
		} else if (event instanceof ContextStoppedEvent) { // 應用停止
			System.out.println("ContextStoppedEvent");
		} else if (event instanceof ContextClosedEvent) { // 應用關閉
			System.out.println("ContextClosedEvent");
			//Service.instance().stop();
		} else {
//			System.out.println("OtherEvent:" + event.toString());
		}

	}

}
