package com.backend.simpleweb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.simpleweb.dao.MainDao;

@Service
public class MainService {
	Logger logger = LogManager.getLogger(MainService.class);

	@Autowired
	private MainDao mainDao = null;

	/*
	 * 메인 페이지 Free, Humor, Forum 신규 / 인기 포스트 출력
	 * 
	 * @param pMap
	 * 
	 * @return
	 */

	public List<Map<String, Object>> mainList(Map<String, Object> pMap) {
		logger.info("mainList called");
		List<Map<String, Object>> mList = new ArrayList<>();
		// Humor 신규글
		List<Map<String, Object>> mainHumorNew = mainDao.mainHumorNew(pMap);
		if(mainHumorNew != null && mainHumorNew.size()>0) {
			mList.addAll(mainHumorNew);
		}
		
		// Free 신규글
		List<Map<String, Object>> mainFreeNew = mainDao.mainFreeNew(pMap);
		if(mainFreeNew != null && mainFreeNew.size()>0) {
			mList.addAll(mainFreeNew);
		}
		
		// Forum 신규글
		List<Map<String, Object>> mainForumNew = mainDao.mainForumNew(pMap);
		if(mainForumNew != null && mainForumNew.size()>0) {
			mList.addAll(mainForumNew);
		}
		

		// 인기글 조건 : 좋아요 5개 이상, 혹은 조회수 30이상 && 일주일 내의 작성글
		// Humor 인기글
		List<Map<String, Object>> mainHumorHot = mainDao.mainHumorHot(pMap);
		if(mainHumorHot != null && mainHumorHot.size()>0) {
			mList.addAll(mainHumorHot);
		}
		
		// Free 인기글
		List<Map<String, Object>> mainFreeHot = mainDao.mainFreeHot(pMap);
		if(mainFreeHot != null && mainFreeHot.size()>0) {
			mList.addAll(mainFreeHot);
		}
		
		// Forum 인기글
		List<Map<String, Object>> mainForumHot = mainDao.mainForumHot(pMap);
		if(mainForumHot != null && mainForumHot.size()>0) {
			mList.addAll(mainForumHot);
		}

		return mList;
	}

}
