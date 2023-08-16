package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional

class ServiceIntegrationTest {
    @Autowired Service memberService;
    @Autowired MemberRepository memberRepository;





    @Test

    void join() {
        //given
        Member member = new Member();
        member.setName("spring");

        // when
        Long saveId =memberService.join(member);


        //the
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }
    @Test
    public void Mavjun_bulgan_회원(){
        //given
         Member member1 = new Member();
        member1.setName("spring2");
        Member member2 = new Member();
        member2.setName("spring2");

        // when
        memberService.join(member2);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("Mavjud bulgan 회원");

    }
}