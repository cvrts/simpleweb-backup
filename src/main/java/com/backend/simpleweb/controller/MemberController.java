package com.backend.simpleweb.controller;

import java.util.ArrayList;
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

import com.backend.simpleweb.service.MemberService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/member/*")
public class MemberController {
	Logger logger = LogManager.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService = null;

	/**
	 * 회원 정보 조회, 로그인
	 * 
	 * @param pMap
	 * @return
	 */
	@GetMapping("memberList")
	public String memberList(@RequestParam Map<String, Object> pMap) {
		logger.info("memberList 호출");
		logger.info(pMap);
		String temp = null;
		List<Map<String, Object>> mList = new ArrayList<>();
		mList = memberService.memberList(pMap);
		logger.info(mList);

		if (mList.size() > 0) {
			Gson g = new Gson();
			temp = g.toJson(mList);
		} else {
			temp = "0";
		}
		return temp;
	}

	/**
	 * 세션 저장
	 * @param pMap
	 * @return
	 */
	@GetMapping("sessionList")
	public String sessionList(@RequestParam Map<String, Object> pMap) {
		logger.info("sessionList 호출");
		logger.info(pMap);
		String temp = null;
		List<Map<String, Object>> mList = new ArrayList<>();
		mList = memberService.sessionList(pMap);
		logger.info(mList);
		if(mList.size()>0) {
			Gson g = new Gson();
			temp = g.toJson(mList);
		}
		else {
			temp = "0";
		}
		return temp;
	}

	/**
	 * 이메일 찾기
	 * 
	 * @param pMap
	 * @return
	 */
	@GetMapping("findUser")
	public String findUser(@RequestParam Map<String, Object> pMap) {
		logger.info("findUser 호출");
		logger.info(pMap);
		String temp = null;
		List<Map<String, Object>> mList = new ArrayList<>();
		mList = memberService.findUser(pMap);
		logger.info(mList);
		if (mList.size() > 0) {
			Gson g = new Gson();
			temp = g.toJson(mList);
		} else {
			temp = "0";
		}
		return temp;
	}

	/**
	 * 중복 검사
	 * 
	 * @param pMap
	 * @return
	 */
	@GetMapping("checkInfo")
	public String userInfo(@RequestParam Map<String, Object> pMap) {
		logger.info("userInfo 호출");
		logger.info(pMap);
		String temp = null;
		List<Map<String, Object>> mList = new ArrayList<>();
		mList = memberService.checkInfo(pMap);
		logger.info(mList);

		if (mList.size() > 0) {
			Gson g = new Gson();
			temp = g.toJson(mList);
		} else {
			temp = "0";
		}
		return temp;
	}
	
	/**
	 * 회원 등록
	 * 
	 * @param pMap
	 * @return
	 */
	@GetMapping("memberinsert")
	public String memberInsert(@RequestBody Map<String, Object>pMap) {
		logger.info("memberInsert 호출");
		logger.info(pMap);
		int result = 0;
		result = memberService.memberInsert(pMap);
		return String.valueOf(result);
	}
	
	/**
	 * 회원 정보 수정
	 * 
	 * @param pMap
	 * @return
	 */
	@PostMapping("memberUpdate")
	public String memberUpdate(@RequestBody Map<String, Object>pMap) {
		logger.info("memberUpdate 호출");
		logger.info(pMap);
		int result = 0;
		result = memberService.memberUpdate(pMap);
		return String.valueOf(result);
	}
	
	/**
	 * 임시 비밀번호 발급
	 * 
	 * @param pMap
	 * @return
	 */
	@PostMapping("resetPassword")
	public String resultPassword(@RequestBody Map<String, Object> pMap) {
		logger.info("resetPassword 호출");
		logger.info(pMap);
		int result = 0;
		result = memberService.resetPassword(pMap);
		return String.valueOf(result);
	}
	
	/**
	 * 회원 탈퇴
	 * 
	 * @param pMap
	 * @return
	 */
	@PostMapping("memberDelete")
	public String memberDelete(@RequestBody Map<String, Object> pMap) {
		logger.info("memberDelete Called");
		logger.info(pMap);
		int result = 0;
		result = memberService.memberDelete(pMap);
		return String.valueOf(result);
	}
}
