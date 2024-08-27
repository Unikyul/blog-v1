package shop.mtcoding.blog.board;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

//@SpringBootTest // C R e h2 -> 모든 레이어 메모리에 다 올리고 테스트 할 때 사용하는 어노테이션

// insert 테스트 하기
@DataJpaTest // h2 , em 을 띄우고 테스트
@Import(BoardRepository.class) // br
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    //테스트 메소드에서는 매개변수를 사용 할 수 없다.
    // 메소드명_test : 컨센션

    @Test
    public void save_test() {
        //given(매개변수를 강제로 만들기)
        String subtitle = "제목1";
        String PostContent = "내용1";

        //when (Test)
        boardRepository.save(subtitle, PostContent);

        //eye (눈으로 확인)


    }


}
