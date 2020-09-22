package com.cyoung90.genesis;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cyoung90.genesis.repository.JdbcMemberRepository;
import com.cyoung90.genesis.repository.MemberRepository;
import com.cyoung90.genesis.service.MemberService;

@Configuration
public class SpringConfig {
	
	private DataSource dataSource;
	@Autowired
	public SpringConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}
	
	@Bean
	public MemberRepository memberRepository() {
//		return new MemoryMemberRepository();
		return new JdbcMemberRepository(dataSource);
	}
}
