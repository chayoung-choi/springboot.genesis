package com.cyoung90.genesis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cyoung90.genesis.repository.MemberRepository;
import com.cyoung90.genesis.repository.MemoryMemberRepository;
import com.cyoung90.genesis.service.MemberService;

@Configuration
public class SpringConfig {
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}
	
	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
}
