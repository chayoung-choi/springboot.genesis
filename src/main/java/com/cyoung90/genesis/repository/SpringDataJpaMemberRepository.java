package com.cyoung90.genesis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cyoung90.genesis.domain.Member;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
	
	@Override
	Optional<Member> findByName(String name);
}
