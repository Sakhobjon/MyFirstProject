package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Transactional
public class Service {



    private final MemberRepository memberRepository;

    public Service(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member){
    long start = System.currentTimeMillis();


            // bir hil ismli 회원 bulsa bulmaydi X
            validateDuplicateMember(member);// bir hil bulgan 회원 di olmaydi
            memberRepository.save(member);
            return member.getId();


    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m ->{
            throw new IllegalStateException("Mavjud bulgan 회원");

        });
    }

    /**
     *
     * Barcha 회원 tekshirish
     */
    public List<Member> findMember(){
        return memberRepository.findAll();


    }
    public Optional<Member>findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
