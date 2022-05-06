package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;
    //MemberService memberService = new MemberServiceImpl();

    //테스트 실행전에 무조건 실행되는 것
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();//실행 전 AppConfig를 만들
        memberService = appConfig.memberService(); // 해당memberService를 할당해준다.(위에) 그 뒤 아래 테스트가 돌아간다.
    }

    @Test
    void join(){
        //given 이러한 것이 주어졌을 때
        Member member = new Member(1L,"memberA",Grade.VIP); //VIP를 만들었을 때


        //when 이렇게 했을 때
        memberService.join(member);//memberservice에 join했을때
        Member findMember = memberService.findMember(1L); //찾아서 검증한다. join한거랑 찾은게 같은
        //then 해당 결과가 이렇게 나온다.
        //검증하기
        Assertions.assertThat(member).isEqualTo(findMember);//member가 findmemeber와 같은지 검

    }
}
