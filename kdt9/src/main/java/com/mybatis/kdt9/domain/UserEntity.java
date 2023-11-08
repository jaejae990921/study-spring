package com.mybatis.kdt9.domain;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@Builder // 빌더
@NoArgsConstructor // 빌더 쓰려면 써야함 1
@AllArgsConstructor // 빌더 쓰려면 써야함 2
public class UserEntity {
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment로 설정
    private int id;
    @Column(name = "name", nullable = false, length = 20)
    private String name;

    private String nickname; // 255

    // Enum 타입
//    @Column
//    @Enumerated(EnumType.STRING)
//    private UserType type;
//
//    public enum UserType {
//        STUDENT, TEACHER
//    }
}
