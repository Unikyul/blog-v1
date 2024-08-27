package shop.mtcoding.blog.board;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository // 1. @Repository를 붙이면 스프링이 new를 해서 IoC(컬렉션 List자료형 같은거) 에 저장한다.
public class BoardRepository {

    @Autowired // 2. IoC 에 있는 객체를 찾아온다.
    private EntityManager em;

    public BoardRepository() {
        System.out.println("BoardRepository 생성자");

    }

    //insert 하기
    @Transactional // 1. 일의 최소 단위 2. 고립성이 시작된다.(데이터가 민감해진다.)
    //ex) 홍길동이 만원을 들고 있어서 만원의 고립성을 시작 된다. 동시에 같은 행을 건드릴 수 없다.
    //유효성 검사가 중요하다. 불피요한 트렌젝션을 줄어준다.
    public void save(String title, String content) {
        Query query = em.createNativeQuery("insert into post_tb(subtitle,post_content,created_at) values(?,?,now())");
        query.setParameter(1, title); // postion = ?의 순서
        query.setParameter(2, content);

        query.executeUpdate();
    }
}
