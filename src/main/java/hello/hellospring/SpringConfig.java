package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.Service;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.SpringVersion;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

@Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public Service memberService(){
        return new Service(memberRepository);
    }
    //@Bean
   //  public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        // return new JdbcMemberRepository(dataSource);
        //return new JpaMemberRepository(em);
         // return new JdbcTemplateMemberRepository(dataSource);
   // }
    }


