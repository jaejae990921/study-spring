package com.mybatis.prac.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Post {
    private int id;
    private String title;
    private String content;
    private String writer;
    private Date registered;
}
