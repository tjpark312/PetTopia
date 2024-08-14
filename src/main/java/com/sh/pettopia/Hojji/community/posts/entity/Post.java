package com.sh.pettopia.Hojji.community.posts.entity;

import com.sh.pettopia.Hojji.user.member.entity.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;


@Entity
@Table(name = "tbl_community")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {
    private static final Logger log = LoggerFactory.getLogger(Post.class);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    // AUTO_INCREMENT로 관리되는 postId
    private Long postId;

    @Column(nullable = false)
    // 게시글 제목
    private String title;

    @Column(nullable = false)
    // 게시글 내용
    private String content;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    // 게시글 카테고리
    private Category category;

    @Column(name = "created_at", nullable = false)
    // 게시일
    private LocalDate createdAt;

    @Column(name = "updated_at", nullable = false)
    // 게시글 수정일
    private LocalDate updatedAt;

    @Column(name = "like_count")
    // 좋아요 수
    private Integer likeCount;

    @Column(name = "view_count")
    // 좋아요 수
    private Integer viewCount;

    @Column(name = "report_count")
    // 신고 횟수
    private Integer reportCount;

    // Comment 클래스 안에 createAt = 현재 클래스 40번 줄과 컬럼값이 겹침
    @Embedded
    private Comment comment;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;
}
