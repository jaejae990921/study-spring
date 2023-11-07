package com.mybatis.prac.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class PostDTO {
    private int id;
    private String title;
    private String content;
    private String writer;
    private Date registered;
}
