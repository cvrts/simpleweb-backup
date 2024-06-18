package com.backend.simpleweb.dao;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	Logger logger = LogManager.getLogger(BoardDao.class);
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;
	
	/*
	 * 커뮤니티글 전체, 카테고리 조회 + 조건검색 search(작성자|제목|내용)
	 * 
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> boardList(Map<String, Object> pMap){
		logger.info("boardList 호출");
		List<Map<String, Object>> bList = null;
		bList = sqlSessionTemplate.selectList("boardList", pMap);
		return bList;
	}
}
