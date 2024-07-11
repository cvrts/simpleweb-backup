package com.backend.simpleweb.dao;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MainDao {
	Logger logger = LogManager.getLogger(MainDao.class);
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;
	
	/*
	 * Humor 신규글
	 * 
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> mainHumorNew(Map<String, Object> pMap){
		logger.info("mHumorNew called");
		logger.info(pMap);
		List<Map<String, Object>> mList = null;
		mList = sqlSessionTemplate.selectList("mainHumorNew", pMap);
		return mList;
	}

	/*
	 * free 신규글
	 * 
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> mainFreeNew(Map<String, Object> pMap){
		logger.info("mFreeNew called");
		logger.info(pMap);
		List<Map<String, Object>> mList = null;
		mList = sqlSessionTemplate.selectList("mainFreeNew", pMap);
		return mList;
	}
	
	/*
	 * forum 신규글
	 * 
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> mainForumNew(Map<String, Object> pMap){
		logger.info("mForumNew called");
		logger.info(pMap);
		List<Map<String, Object>> mList = null;
		mList = sqlSessionTemplate.selectList("mainForumNew", pMap);
		return mList;
	}
	
	/*
	 * Humor 인기글(좋아요 5개 이상, 좋아요 높은 순으로 최대 10개까지)
	 * 
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> mainHumorHot(Map<String, Object> pMap){
		logger.info("mHumorHot called");
		logger.info(pMap);
		List<Map<String, Object>> mList = null;
		mList = sqlSessionTemplate.selectList("mainHumorNew", pMap);
		return mList;
	}
	
	/*
	 * free 인기글(좋아요 5개 이상, 좋아요 높은 순으로 최대 10개까지)
	 * 
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> mainFreeHot(Map<String, Object> pMap){
		logger.info("mFreeHot called");
		logger.info(pMap);
		List<Map<String, Object>> mList = null;
		mList = sqlSessionTemplate.selectList("mainFreeHot", pMap);
		return mList;
	}
	
	/*
	 * forum 인기글(좋아요 5개 이상, 좋아요 높은 순으로 최대 10개까지)
	 * 
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> mainForumHot(Map<String, Object> pMap){
		logger.info("mForumHot called");
		logger.info(pMap);
		List<Map<String, Object>> mList = null;
		mList = sqlSessionTemplate.selectList("mainForumHot", pMap);
		return mList;
	}

}
