package com.backend.simpleweb.controller;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.simpleweb.service.MainService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/main/*")
public class MainController {
	Logger logger = LogManager.getLogger(MainController.class);
	
	@Autowired
	private MainService mainService= null;
	
	/*
	 * 메인페이지 ad, curated, [카테고리별 신규 / 인기 / 글] 출력
	 * 
	 * @param pMap
	 * @return
	 */
	@GetMapping("mainList")
	public String mainList(@RequestParam Map<String, Object> pMap) {
		logger.info("mainList 호출");
		logger.info(pMap);
		String temp = null;
		List<Map<String, Object>> mList = null;
		mList = mainService.mainList(pMap);
		logger.info(mList);
		Gson g = new Gson();
		temp = g.toJson(mList);
		return temp;
	}

}
