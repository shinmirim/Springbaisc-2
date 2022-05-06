package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
//구성영역 구체적인 부분이 작성
public class AppConfig {

    @Bean//스프컨테이너라는 곳에 모두 등록된다.
    //memberService역할
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());//생성자 연
    }

    @Bean
    //memberRepository역할
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    //orderService역할
    public OrderService OrderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());//생성자 연결
    }

    @Bean
    public DiscountPolicy discountPolicy(){

        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();

    }
}

//의존성 주입 - 다른 곳에서 주입 클라이언트 코드에 주입