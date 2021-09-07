package com.pureInt.demo.service;

import org.springframework.stereotype.Repository;

@Repository
public interface ParsingService {
	Object parse(String url);
}
