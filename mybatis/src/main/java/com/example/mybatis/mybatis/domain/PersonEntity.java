package com.example.mybatis.mybatis.domain;

import jakarta.persistence.*;

@Entity // table 생성
@Table(name = "Seoul") // table 이름 명시
public class PersonEntity { // person_entity로 테이블 생성 됨 (카멜케이스 -> 소문자, _(언더바)로 알아서 바뀜)
    @Id // pk 설정
    @GeneratedValue(strategy = GenerationType.AUTO) // auto_increment
    private long id;

    @Column(length = 255, nullable = false) // 컬럼 생성, varchar(255), not null
    private String name;

    @Column(length = 255, nullable = false)
    private String password;

    @Column(length = 255, nullable = false)
    private String user_id;

    private String email; // Column 안써도 되긴 되지만, not null이나 자세한 설정 X

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // 기본생성자
    public PersonEntity() {

    }
}