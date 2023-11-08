package com.mybatis.prac.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class PostDTO {
    private int id;
    private String title;
    private String content;
    private String writer;
    private Date registered;
    private String no;
}
