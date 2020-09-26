package com.cyoung90.genesis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cyoung90.genesis.repository.MemberRepository;
import com.cyoung90.genesis.service.MemberService;

@Configuration
public class SpringConfig {

	private final MemberRepository memberRepository;
	
	@Autowired
	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
//	private DataSource dataSource;
//	private EntityManager em;
//
//	@Autowired
//	public SpringConfig(DataSource dataSource, EntityManager em) {
//		this.dataSource = dataSource;
//		this.em = em;
//	}
//	@Autowired
//	public SpringConfig(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}

//	@Bean
//	public MemberService memberService() {
//		return new MemberService(memberRepository());
//	}

//	@Bean
//	public MemberRepository memberRepository() {
////		return new MemoryMemberRepository();
////		return new JdbcMemberRepository(dataSource);
////		return new JdbcTemplateMemberRepository(dataSource);
//		return new JpaMemberRepository(em);
//	}
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}
}
