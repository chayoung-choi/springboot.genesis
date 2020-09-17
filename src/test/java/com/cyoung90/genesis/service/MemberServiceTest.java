package com.cyoung90.genesis.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cyoung90.genesis.domain.Member;
import com.cyoung90.genesis.repository.MemoryMemberRepository;

public class MemberServiceTest {

	MemberService memberService;
	MemoryMemberRepository memberRepository;
	
	@BeforeEach
	public void beforeEach() {
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memberRepository);
	}
	
	@AfterEach
	public void afterEach(){
		memberRepository.clearStore();
	}
	
	@Test
	public void 중복_회원_예외() {
		Member member1 = new Member();
		member1.setName("spring");
		
		Member member2 = new Member();
		member2.setName("spring");
		
		memberService.join(member1);
		assertThrows(IllegalStateException.class, () -> memberService.join(member2));
//		try {
//			memberService.join(member2);
//			fail();
//		} catch (IllegalStateException e) {
//			assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//		}
	}
}
