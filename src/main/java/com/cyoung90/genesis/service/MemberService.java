package com.cyoung90.genesis.service;

import java.util.List;
import java.util.Optional;

import com.cyoung90.genesis.domain.Member;
import com.cyoung90.genesis.repository.MemberRepository;
import com.cyoung90.genesis.repository.MemoryMemberRepository;

public class MemberService {
	private final MemberRepository memberReopsitory = new MemoryMemberRepository();

	/**
	 * 회원 가입 
	 */
	public Long join(Member member) {
//		Optional<Member> result = memberReopsitory.findByName(member.getName());
//		result.ifPresent(m -> {
//			throw new IllegalStateException("이미 존재하는 회원입니다.");
//		});
		
		validateDuplicateMember(member);
		memberReopsitory.save(member);
		return member.getId();

	}

	private void validateDuplicateMember(Member member) {
		memberReopsitory.findByName(member.getName())
			.ifPresent(m -> {
				throw new IllegalStateException("이미 존재하는 회원입니다.");
			});
	}
	
	/**
	 * 전체 회원 조회
	 */
	public List<Member> findMembers(){
		return memberReopsitory.findAll();
	}
	
	
	/**
	 * 회원 조회
	 */
	public Optional<Member> findOne(Long memberId){
		return memberReopsitory.findById(memberId);
	}
}
