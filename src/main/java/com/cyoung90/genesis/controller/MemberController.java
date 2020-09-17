package com.cyoung90.genesis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cyoung90.genesis.service.MemberService;

@Controller
public class MemberController {
	
	
	private final MemberService memeberSerive;

	@Autowired
	public MemberController(MemberService memeberSerive) {
		this.memeberSerive = memeberSerive;
	}
	
	
}
