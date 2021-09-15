package Influencer.Influencerspring.repository;

import Influencer.Influencerspring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;  //자동 import되지 않음

class MemoryMemberRepositoryTest {  //굳이 public으로 안해도 됨. 딴데 갖다 쓸게 아니니까.
                                    //test 순서는 보장이 안됨. 메소드별로 따로따로 동작함. 그래서 data를 클리어해줘야함.

    MemoryMemberRespository repository = new MemoryMemberRespository();

    //테스트 메소드가 끝날때마다 실행되는 것. callback 메시지같은거라고 보면 된다.
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }
    
    @Test
    public void save(){ //아까 만들었던 save 메소드
        Member member = new Member();
        member.setName("spring");
        repository.save(member);

        Member result = repository.findByMemberno(member.getMemberno()).get();

        //가져온 result랑 member랑 같은가?
        //1 System.out.println("result = "+(result==member));;
        //2 Assertions.assertEquals(member, result);    //result랑 member랑 똑같은지 확인하는 메소드(expected, actual). 아무일없이 초록표시 뜨면 맞는거임.
        //3 org.assertj.core.api.Assertions.assertThat(member).isEqualTo(result);   //assertThat에 option + enter 하면 assertThat으로 단축할 수 있다.
        assertThat(member).isEqualTo(result);   //assertThat으로 단축
    }

    @Test
    public void findBYName(){
        //"spring1" 이라는 회원을 가입시켰다.
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        //"spring2" 라는 회원을 가입시켰다.
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();  //get()을 하면 Optional로 꺼낼 수 있음.

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }
}
