package com.backend.simpleweb.dao;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	Logger logger = LogManager.getLogger(BoardDao.class);

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;

	/**
	 * 커뮤니티글 전체, 카테고리 조회 + 조건검색 search(작성자|제목|내용)
	 * 
	 * @param pMap
	 * 
	 * @return
	 */
	public List<Map<String, Object>> boardList(Map<String, Object> pMap) {
		logger.info("boardList 호출");
		List<Map<String, Object>> bList = null;
		bList = sqlSessionTemplate.selectList("boardList", pMap);
		return bList;
	}

	/**
	 * 커뮤니티글 상세조회
	 */
	public List<Map<String, Object>> boardDetail(Map<String, Object> pMap) {
		logger.info("boardDetail 호출");
		List<Map<String, Object>> bList = null;
		bList = sqlSessionTemplate.selectList("boardDetail", pMap);
		return bList;
	}

	/**
	 * 커뮤니티 글쓰기
	 */
	public int boardInsert(Map<String, Object> pMap) {
		logger.info("boardInsert 호출");
		int result = 0;
		int board_no = 0; // insert 시에 시퀀스로 채번된 속성을 담을 변수 - board_no의 값
		// insert는 반환값이 object
		result = sqlSessionTemplate.insert("boardInsert", pMap);
		if (result == 1) {
			if (pMap.get("board_no") != null) {
				board_no = Integer.parseInt(pMap.get("board_no").toString());
			}
		}
		logger.info("result => " + result);
		logger.info("userGeneratedKeys 프로퍼티 속성값 => " + board_no);
		return board_no;
	}

	/**
	 * Quill image 목록 조회
	 */
	public List<Map<String, Object>> imageList(Map<String, Object> pMap) {
		logger.info("imageList 호출");
		List<Map<String, Object>> iList = null;
		iList = sqlSessionTemplate.selectList("imageList", pMap);
		return iList;
	}

	/**
	 * Quill image 추가 - 이미지 선택할때마다 인서트
	 */
	public int imageInsert(Map<String, Object> pMap) {
		logger.info("imageInsert 호출");
		int result = 0;
		result = sqlSessionTemplate.update("imageInsert", pMap);
		return result;
	}

	/**
	 * Quill image 수정 - board_no 추가
	 */
	public int imageUpdate(List<Map<String, Object>> pList) {
		logger.info("imageUpdate 호출");
		logger.info(pList);
		int result = 0;
		result = sqlSessionTemplate.update("imageUpdate", pList);
		return result;
	}

	/**
	 * quill image 삭제
	 */
	public int imageDelete(Map<String, Object> pMap) {
		logger.info("imageDelete 호출");
		int result = 0;
		result = sqlSessionTemplate.update("imageDelete", pMap);
		return result;
	}

	/**
	 * 커뮤니티 글 수정(조회수 갱신, board_hit)
	 */
	public int boardUpdate(Map<String, Object> pMap) {
		logger.info("boardUpdate 호출");
		int result = 0;
		result = sqlSessionTemplate.update("boardDelete", pMap);
		return result;
	}

	/**
	 * 커뮤니티 글 삭제
	 */
	public int boardDelete(Map<String, Object> pMap) {
		logger.info("boardDelete 호출");
		int result = 0;
		result = sqlSessionTemplate.update("boardDelete", pMap);
		return result;
	}

	/**
	 * 댓글 전체 조회
	 */
	public List<Map<String, Object>> replyList(Map<String, Object> pMap) {
		logger.info("replyList 호출");
		logger.info(pMap);
		List<Map<String, Object>> bList = null;
		bList = sqlSessionTemplate.selectList("replyList", pMap);
		return bList;
	}

	/**
	 * 댓글/답글 쓰기
	 */
	public int replyInsert(Map<String, Object> pMap) {
		logger.info("replyInsert 호출");
		int result = 0;
		result = sqlSessionTemplate.update("replyInsert", pMap);
		return result;
	}

	/**
	 * 댓글/답글 수정
	 */
	public int replyUpdate(Map<String, Object> pMap) {
		logger.info("replyUpdate 호출");
		int result = 0;
		result = sqlSessionTemplate.update("replyUpdate", pMap);
		return result;
	}

	/**
	 * 댓글 삭제
	 */
	public int replyDelete(Map<String, Object> pMap) {
		logger.info("replyDelete 호출");
		int result = 0;
		result = sqlSessionTemplate.update("replyDelete", pMap);
		return result;
	}
	
	/**
	 * 신고 - 글:0 / 댓글:1 /
	 * 
	 * @param pMap
	 * @return
	 */
	public int report(Map<String, Object> pMap) {
		logger.info("report 호출");
		int result = 0;
		result = sqlSessionTemplate.update("report", pMap);
		return result;
	}
	
	/**
	 * User가 좋아요 누른 글, 댓글 조회 - 판별용
	 * 글 : 0
	 * 댓글 or 대댓글 : 1
	 */
	public List<Map<String, Object>> likedList(Map<String, Object> pMap){
		logger.info("likedList 호출");
		logger.info(pMap);
		List<Map<String, Object>> lList = null;
		lList = sqlSessionTemplate.selectList("likedList", pMap);
		return lList;
	}

	/**
	 * 좋아요 기능
	 * 글 : 0
	 * 댓글 or 대댓글 : 1
	 */
	public int likeClicked(Map<String, Object> pMap) {
		logger.info("likeClicked 호출");
		int result = 0;
		result = sqlSessionTemplate.update("likeClicked", pMap);
		return result;
	}

	/**
	 * 좋아요 취소 !
	 * 글 : 0
	 * 댓글 or 대댓글 : 1
	 */
	public int likeUnclicked(Map<String, Object> pMap) {
		logger.info("likeUnclicked 호출");
		int result = 0;
		result = sqlSessionTemplate.update("likeUnclicked", pMap);
		return result;
	}
	
}
