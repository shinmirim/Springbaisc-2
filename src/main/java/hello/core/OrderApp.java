package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();
        //OrderService orderService = appConfig.OrderService();



        //MemberService memberService = new MemberServiceImpl();
        //OrderService orderService = new OrderServiceImpl(memberRepository, discountPolicy);


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        //member 저장 모르겠음
        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        //메모리 객체에 넣음 주문해서 찾아 쓸 수 있도록
        memberService.join(member);
        //order 생성
        Order order = orderService.createOrder(memberId,"itemA",10000);

        System.out.println("order ="+order); //tostring()으로 호출되어 출력
        System.out.println("order.calculatePrice ="+order.calculatePrice());

    }
}
