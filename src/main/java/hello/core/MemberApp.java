package hello.core;

// 잘 되는지 테스

import hello.core.member.Grade;
import hello.core.member.MemberService;
import hello.core.member.Member;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MemberApp {

    public static void main(String[] args) {
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService= appConfig.memberService();
        //AppConfig에서 memberService를 달라고 하면 memberService안에 있는 MeeberserviceImpl이 들어있을 것
       // MemberService memberService = new MemberServiceImpl();기존에 MemberServiceImpl를 메인메소드에서 생성을 해줬지 현재는 APPconfig에서 달라해서 가져옴
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);//가입한 회
        memberService.join(member); //회원가입이 되어야함

        //제대로 회원가입이 되었는지 확인
        Member findMember = memberService.findMember(1l);// 가입한 회원과 찾는 회원이 같으 잘 된것
        System.out.println("new member="+member.getName());
        System.out.println("find Member="+findMember.getName());


    }
}
