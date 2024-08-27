package shop.mtcoding.blog.board;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@NoArgsConstructor // 빈 생성자 (하이버네이트가 om 할때 필요)
@Getter
@Setter
@Table(name = "post_tb")
//@Table(name = "board_tb") //바꾸기 연습
@Entity // DB에서 조회하면 자동 매핑이됨
public class Board {
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_incremnt 설정, 시퀸스 설정
    @Id // PK 설정

    private Integer id;
    //@Column(nullable = false)
    private String subtitle;


    private String postContent;

    private Timestamp createdAt;

    // builder 패턴 활용하기
    @Builder
    public Board(Integer id, String subtitle, String postContent, Timestamp createdAt) {
        this.id = id;
        this.subtitle = subtitle;

        this.postContent = postContent;

        this.createdAt = createdAt;
    }

}
