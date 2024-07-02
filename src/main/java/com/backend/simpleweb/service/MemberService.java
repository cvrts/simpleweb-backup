package com.backend.simpleweb.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.backend.simpleweb.dao.MemberDao;

public class MemberService {
	Logger logger = LogManager.getLogger(MemberService.class);

	@Autowired
	private MemberDao memberDao = null;

	@Autowired
	private PasswordEncoder passwordEncoder;

	// 회원 정보 조회 - 상세보기 페이지
	public List<Map<String, Object>> memberList(Map<String, Object> pMap) {
		logger.info("memberList called");
		String password = (String) pMap.get("user_pw");
		Map<String, Object> result = new HashMap<String, Object>();

		List<Map<String, Object>> mList = memberDao.memberList(pMap);
		logger.info(mList);

		try {
			if (mList.size() > 0) {
				logger.info("PW Certificating");
				Map<String, Object> rMap = mList.get(0);
				String user_pw = (String) rMap.get("USER_PW");
				logger.info(password);
				logger.info(user_pw);
				boolean isTrue = passwordEncoder.matches(password, user_pw);
				if (isTrue) {
					// 로그인 성공시
					return mList;
				} else {
					// 비밀번호 틀렸을 때
					mList.clear();
					result.put("result", 1);
					mList.add(result);
					return mList;
				}
			} else {
				// 일치하는 아이디가 존재하지 않을 때
				mList.clear();
				result.put("result", 0);
				mList.add(result);
				return mList;
			}
		} catch (NullPointerException e) {
			mList.clear();
			result.put("result", 0);
			mList.add(result);
			return mList;
		}
	}

	// 아이디 / 닉네임 / 이메일 중복체크 + 이메일(아이디) 조회
	public List<Map<String, Object>> checkInfo(Map<String, Object> pMap) {
		logger.info("checkInfo called");
		List<Map<String, Object>> mList = new ArrayList<>();
		mList = memberDao.checkInfo(pMap);
		return mList;
	}

	// 세션 정보
	public List<Map<String, Object>> sessionList(Map<String, Object> pMap) {
		logger.info("sessionList called");
		List<Map<String, Object>> mList = new ArrayList<>();
		mList = memberDao.sessionList(pMap);
		return mList;
	}

	// 이메일 조회
	public List<Map<String, Object>> findUser(Map<String, Object> pMap) {
		logger.info("findUser called");
		List<Map<String, Object>> mList = new ArrayList<>();
		mList = memberDao.referrer(pMap);
		return mList;
	}

	// 회원가입
	public int memberInsert(Map<String, Object> pMap) {
		logger.info("memberInsert called");
		logger.info(pMap.toString());
		
		String password = (String)pMap.get("user_pw");
		String encodedPassword = passwordEncoder.encode(password);
		pMap.put("user_pw", encodedPassword);
		
		int result = 0;
		result = memberDao.memberInsert(pMap);
		return result;
	}

	// 회원정보 수정
	public int memberUpdate(Map<String, Object> pMap) {
		logger.info("memberUpdate called");
		logger.info(pMap.toString());
		
		String password = (String)pMap.get("user_pw");
		String encodedPassword = passwordEncoder.encode(password);
		pMap.put("user_pw", encodedPassword);
		
		int result = 0;
		result = memberDao.memberUpdate(pMap);
		return result;
	}
	
	//임시 비밀번호 발급
	public int resetPassword(Map<String, Object> pMap) {
		logger.info("resetPassword called");
		logger.info(pMap.toString());
		
		String password = (String)pMap.get("user_pw");
		String encodedPassword = passwordEncoder.encode(password);
		pMap.put("user_pw", encodedPassword);
		
		int result = 0;
		result = memberDao.resetPassword(pMap);
		return result;
	}
	
	// 회원 탈퇴
	public int memberDelete(Map<String, Object> pMap) {
		logger.info("memberDelete called");
		logger.info(pMap.toString());
		int result = 0;
		result = memberDao.memberDelete(pMap);
		return result;
		
	}
}
