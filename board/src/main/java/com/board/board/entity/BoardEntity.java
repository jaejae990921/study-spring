package com.board.board.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
public class BoardEntity {
    @Id // PK 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private int id;

    @Column(length = 127, nullable = false) // varchar(127) not null
    private String title;

    @Column(length = 1000, nullable = false) // varchar(1000) not null
    private String content;

    @Column(length = 31, nullable = false) // varchar(31) not null
    private String author;

    @CreationTimestamp
    private LocalDateTime createAt; // 직접 핸들링 X 알아서 해줌

    @UpdateTimestamp
    private LocalDateTime updateAt; // 직접 핸들링 X 알아서 해줌

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public BoardEntity() {

    }
}