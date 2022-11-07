package com.sungsu.JavaCore;

import com.sungsu.JavaCore.member.Grade;
import com.sungsu.JavaCore.member.Member;
import com.sungsu.JavaCore.member.MemberService;
import com.sungsu.JavaCore.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();

        Member member = new Member(1L, "memberA", Grade.VIP);

        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("new Member : " + member.getName());
        System.out.println("find Member : " + findMember.getName());
    }
}
