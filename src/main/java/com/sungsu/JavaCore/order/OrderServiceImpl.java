package com.sungsu.JavaCore.order;

import com.sungsu.JavaCore.discount.DiscountPolicy;
import com.sungsu.JavaCore.discount.FixDiscountPolicy;
import com.sungsu.JavaCore.member.Member;
import com.sungsu.JavaCore.member.MemberRepository;
import com.sungsu.JavaCore.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice){
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
