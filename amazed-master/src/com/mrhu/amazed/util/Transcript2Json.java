package com.mrhu.amazed.util;

import com.alibaba.fastjson.JSON;
import com.mrhu.amazed.model.Transcripts;

public class Transcript2Json {
	
	private Transcripts transcript;
	private String jsonUser;
	
	Transcript2Json(Transcripts transcript) {
		this.transcript = transcript;
	}
	
	public String getJsonUser() {
		jsonUser = JSON.toJSONString(transcript);
		return jsonUser;
	}
	
}
