package com.mrhu.amazed.util;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import com.mrhu.amazed.model.Transcripts;

public class Transcript2JsonTest {

	@Test
	public void test() {
		HashMap map = new HashMap();
		map.put("语文", 99.7);
		map.put("数学", 99.8);
		map.put("英语", 99.9);
		map.put("Physics", 99.8);
		map.put("Java Programing", 99.9);
		Transcripts t = new Transcripts();
		t.setUserId("7489123");
		t.setMap(map);
		Transcript2Json t2j = new Transcript2Json(t);
		System.out.println(t2j.getJsonUser());
	}

}
