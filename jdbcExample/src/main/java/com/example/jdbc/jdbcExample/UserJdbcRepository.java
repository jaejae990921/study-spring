package com.example.jdbc.jdbcExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserJdbcRepository {
    @Autowired // 의존성 주입할 때 autowired를 써줌. new jdbc 어쩌고 할필요 없음
    private JdbcTemplate jdbc; // 필드 주입

    private static String INSERT_USER = // 쿼리문 작성
            """
                INSERT INTO users (id, name, address) VALUES (?, ?, ?);
            """;

    private static String DELETE_USER =
            """
                DELETE FROM users WHERE id = ?;        
            """;

    private static String SELECT_USER =
            """
                SELECT * FROM users WHERE id = ?;    
            """;

    public void insert(Users user) { // 쿼리문을 실행(?) 하는 함수
        jdbc.update(INSERT_USER, user.getId(), user.getName(), user.getAddress());
    }

    public void deleteId(long id) {
        jdbc.update(DELETE_USER, id);
    }

    public Users findId(long id) {
        // queryForObject : 주어진 쿼리에 따라 데이터베이스에서 한 행만 반활될 때 사용
        // Users 클래스의 인스턴스로 매핑하기 위해서 new BeanPropertyRowMapper<>(Users.class)
        // BeanPropertyRowMapper : 데이터베이스 테이블의 칼럼 이름과 Java Bean의 프로퍼티 이름을 자동으로 매칭
        return jdbc.queryForObject(SELECT_USER, new BeanPropertyRowMapper<>(Users.class), id);
    }

    /** JDBC 주요 메서드
     *  update() : INSERT, UPDATE, DELETE와 같은 SQL문 실행
     *  query() : 여러행을 반환하는 쿼리 결과 처리할 때 사용
     *  execute() : 반환값이 없는 SQL 명령을 실행
     *  queryForMap() : 단 하나의 행만 반환, 해당 데이터를 Map 형태로 반환
     *  queryForInt() : 단일 값 반환. 반환 값으로 int 형태 데이터(select count(*) from ___)
     */
}