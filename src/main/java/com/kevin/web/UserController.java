package com.kevin.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kevin.bean.User;
import com.kevin.dao.UserMapper;
import com.kevin.service.UserService;

@RestController
@EnableAutoConfiguration
@RequestMapping({ "/user" })
public class UserController {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserService userService;

	@RequestMapping("/getUser")
	@ResponseBody
	public String getUser() {
		User findUserByName = userMapper.findUserByName("乐银珠");
		userService.findUser("2", "2");
		userService.findUser("2", "2");
		return "hello world2222222222222222222" + findUserByName.getId();
	}

	@RequestMapping(value = "/sessions")
	public Object sessions(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		String id = request.getSession().getId();
		map.put("sessionId", id);
		System.out.println(id);
		map.put("message", request.getSession().getAttribute("map"));
		return map;
	}

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/first")
	@ResponseBody
	public String first(HttpServletRequest request) {
		String body = restTemplate.getForEntity("http://compute-service/first",
				String.class).getBody();
		HttpSession session = request.getSession();
		System.out.println(session.getId());
		return "22222222222222222222222";
	}

}
