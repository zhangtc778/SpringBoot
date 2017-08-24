package com.kevin.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.kevin.bean.User;

@Service
public class UserService {

	@Cacheable(value = "usercache", keyGenerator = "wiselyKeyGenerator")
	public User findUser(String id, String name) {
		System.out.println("无缓存的时候调用这里");
		return new User();
	}
}
