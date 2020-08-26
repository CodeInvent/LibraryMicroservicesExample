package com.library.book.config;

import org.springframework.cloud.stream.annotation.EnableBinding;

import com.library.book.stream.GreetingsStream;

public class StreamConfig {
	
	@EnableBinding(GreetingsStream.class)
	public class StreamsConfig {
	}

}
