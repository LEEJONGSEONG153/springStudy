package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("ljs1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("ljs2");
        repository.save(member2);


        Member result1 = repository.findByName(member1.getName()).get();
        Member result2 = repository.findByName(member2.getName()).get();

        assertThat(member1).isEqualTo(result1);
        assertThat(member2).isEqualTo(result2);

    }

    @Test
    public void findALl(){
        Member member1 = new Member();
        member1.setName("ljs1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("ljs2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
