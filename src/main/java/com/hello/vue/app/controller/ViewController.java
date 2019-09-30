package com.hello.vue.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class ViewController {

	@GetMapping("/hv")
    public String userIndex() {
        return "index";
    }
	
	@GetMapping("/hv/list/{cnt}")
    public ResponseEntity<?> getList(@PathVariable("cnt") int cnt) {
		List<Map<String, String>> testList = new ArrayList<>(); 
		for (int i = 0; i < cnt; i++) {
			Map<String, String> tempMap = new HashMap<>();
			tempMap.put("key", String.valueOf(i));
			tempMap.put("val", "테스트" + i);
			
			testList.add(tempMap);
		}
		
		Map<String, Object> rsObject = new HashMap<String, Object>();
		rsObject.put("list", testList);
		
		return ResponseEntity.ok(rsObject);
    }
}
