package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    public void findBeanByName(){

       MemberService memberService = ac.getBean("memberService", MemberService.class);
       //System.out.println("memberService ="+memberService);
       //System.out.println("memberService.getClass() ="+ memberService.getClass());
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }
    @Test
    @DisplayName("이름없이 타입으로만조회")
    public void findBeanByType(){

       MemberService memberService = ac.getBean( MemberService.class);
       assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }
    @Test
    @DisplayName("구체타입으로만조회") // 하지만 이는 유연성이 떨어진다.
    public void findBeanByName2(){

       MemberServiceImpl memberService = ac.getBean("memberService" ,MemberServiceImpl.class);
       assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    public void findBeanByNameX(){

        MemberService xxxxx = ac.getBean("xxxxx",MemberService.class);
        //해당 오류가 떠야지 테스트가 제대로 실행되는
        assertThrows(NoSuchBeanDefinitionException.class,
                ()-> ac.getBean("xxxxx",MemberService.class));//오른쪽 로직을 실행하면 왼쪽이 터져야한다.


    }

}
