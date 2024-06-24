package com.backend.simpleweb.controller;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.backend.simpleweb.service.BoardService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/board/")
public class BoardController {
	Logger logger = LogManager.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService = null;
	
	/*
	 * 커뮤니티 글 전체, 카테고리 조회 + 조건검색 (작성자|제목|내용)
	 */
	@GetMapping("boardList")
	public String boardList(@RequestParam Map<String, Object> pMap) {
		logger.info("boardList 호출");
		logger.info(pMap);
		String temp = null;
		List<Map<String, Object>> bList = null;
		bList = boardService.boardList(pMap);
		logger.info(bList);
		Gson g = new Gson();
		temp = g.toJson(bList);
		return temp;
	}
	
	/*
	 * 커뮤니티 글 상세조회
	 */
	@GetMapping("boardDetail")
	public String boardDetail(@RequestParam Map<String, Object> pMap) {
		logger.info("boardDetail 호출");
		logger.info(pMap);
		String temp = null;
		List<Map<String, Object>> bList = null;
		bList = boardService.boardDetail(pMap);
		logger.info(bList);
		Gson g = new Gson();
		temp = g.toJson(bList);
		return temp;
	}
	
	/*
	 * 커뮤니티 글쓰기
	 */
	@PostMapping("boardInsert")
	public String boardInsert(@RequestBody Map<String, Object> pMap) {
		logger.info("boardInsert 호출");
		logger.info(pMap);
		if(pMap.get("board_no") != null) {
			// NumberFormatException 방어코드( 값에 null이 들어가면 큰일남)
			int board_no = Integer.parseInt(pMap.get("board_no").toString());
			pMap.put("board_no", board_no);
		}
		int result = 0;
		result = boardService.boardInsert(pMap);
		logger.info(result);
		return String.valueOf(result);
	}

	/*
	 * 커뮤니티 글 수정(조회수 갱신 board_hit : 1)
	 */
	@PostMapping("boardUpdate")
	public String boardUpdate(@RequestBody Map<String, Object> pMap) {
		logger.info("boardUpdate 호출");
		logger.info(pMap);
		if(pMap.get("board_no") != null) {
			int board_no = Integer.parseInt(pMap.get("board_no").toString());
			pMap.put("board_no", board_no);
		}
		int result = 0;
		result = boardService.boardUpdate(pMap);
		logger.info(result);
		return String.valueOf(result);
	}
	
	/*
	 * 커뮤니티 글 삭제
	 */
	@PostMapping("boardDelete")
	public String boardDelete(@RequestBody Map<String, Object> pMap) {
		logger.info("boardDelete 호출");
		logger.info(pMap);
		if(pMap.get("board_no") != null) {
			int board_no = Integer.parseInt(pMap.get("board_no").toString());
			pMap.put("board_no", board_no);
		}
		int result = 0;
		result = boardService.boardDelete(pMap);
		logger.info(result);
		return String.valueOf(result);
	}
	
	/**
	 * 댓글 전체 조회
	 * 
	 * @param pMap
	 * @return
	 */
	@GetMapping("replyList")
	public String replyList(@RequestParam Map<String, Object> pMap) {
		logger.info("replyList 호출");
		logger.info(pMap);
		String temp = null;
		List<Map<String, Object>> bList = null;
		bList = boardService.replyList(pMap);
		logger.info(bList);
		Gson g = new Gson();
		temp = g.toJson(bList);
		return temp;
	}

	/**
	 * 댓글, 대댓글 쓰기 - 댓글step: 0 / 대댓글step: 1
	 * 
	 * @param pMap
	 * @return
	 */
	@PostMapping("replyInsert")
	public String replyInsert(@RequestBody Map<String, Object> pMap) {
		logger.info("replyInsert 호출");
		logger.info(pMap);
		int result = 0;
		result = boardService.replyInsert(pMap);
		logger.info(result);
		return String.valueOf(result);
	}

	/**
	 * 댓글, 대댓글 수정
	 * 
	 * @param pMap
	 * @return
	 */
	@PostMapping("replyUpdate")
	public String replyUpdate(@RequestBody Map<String, Object> pMap) {
		logger.info("replyUpdate 호출");
		logger.info(pMap);
		int result = 0;
		result = boardService.replyUpdate(pMap);
		logger.info(result);
		return String.valueOf(result);
	}

	/**
	 * 댓글, 대댓글 삭제
	 * 
	 * @param pMap
	 * @return
	 */
	@PostMapping("replyDelete")
	public String replyDelete(@RequestBody Map<String, Object> pMap) {
		logger.info("replyDelete 호출");
		logger.info(pMap);
		int result = 0;
		result = boardService.replyDelete(pMap);
		logger.info(result);
		return String.valueOf(result);
	}

	/**
	 * 신고 - 글:0 / 댓글:1 / 마켓글:2 / 리뷰:3(마켓에서 처리)
	 * 
	 * @param pMap
	 * @return
	 */
	@PostMapping("report")
	public String report(@RequestBody Map<String, Object> pMap) {
		logger.info("report 호출");
		logger.info(pMap);
		int result = 0;
		result = boardService.report(pMap);
		logger.info(result);
		return String.valueOf(result);
	}

	/**
	 * 좋아요 - 글:0 / 댓글:1(대댓step까지 가져올것) / 리뷰:2(마켓에서 처리)
	 * 
	 * @param pMap
	 * @return
	 */
	@PostMapping("likeClicked")
	public String likeClicked(@RequestBody Map<String, Object> pMap) {
		logger.info("likeClicked 호출");
		logger.info(pMap);
		int result = 0;
		result = boardService.likeClicked(pMap);
		logger.info(result);
		return String.valueOf(result);
	}

	/**
	 * 좋아요 취소 - 글:0 / 댓글:1 / 리뷰:2(마켓에서 처리)
	 * 
	 * @param pMap
	 * @return
	 */
	@PostMapping("likeUnclicked")
	public String likeUnclicked(@RequestBody Map<String, Object> pMap) {
		logger.info("likeUnclicked 호출");
		logger.info(pMap);
		int result = 0;
		result = boardService.likeUnclicked(pMap);
		logger.info(result);
		return String.valueOf(result);
	}

	/**
	 * Quill image 추가 - 이미지 선택할때마다 인서트
	 * 
	 * @param mRequest
	 * @param image
	 * @return
	 */
	@PostMapping("uploadImage")
	public String uploadImage(@RequestParam(value = "image", required = false) MultipartFile image) {
		logger.info("imageUpload 호출");
		String filename = boardService.imageInsert(image);
		return filename;
	}
}
