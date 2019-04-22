package com.mrhu.amazed.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Transcripts {
	//储存成绩单的数据结构
	
	//userId 就是 User 的 Password
	private Map<String, Double> map;
	private String userId;
	private String transcript;

	public Transcripts() {
		map = new HashMap<String, Double>();
	}
	
	/**
	 * 获取到的是一个String类型的成绩单，以json方式储存
	 * @return the transcript
	 */
	public String getTranscript() {
		return transcript;
	}
	/**
	 * @param transcript the transcript to set
	 */
	public void setTranscript(String transcript) {
		this.transcript = transcript;
	}
	/**
	 * @return the userId
	 */
	@Id
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @param  the Map to set Map 
	 */
	public void setMap(Map<String, Double> map) {
		this.map = map;
	}

	/**
	 * 获取成绩列表
	 * @return  类型的成绩单
	 */
	@Transient
	public Map<String, Double> getMap() {
		return map;
	}
	
}
