package com.mybatis.kdt9.repository;

import com.mybatis.kdt9.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    List<UserEntity> findByName(String name);

    Optional<UserEntity> findById(int id);

    // select * from user where name = {name}
//    @Query("select ue from UserEntity ue where ue.name = :name")
//    @Query(nativeQuery = true, value = "select * from user where name=:name")
//    UserEntity findNameByName(String name);

    List<UserEntity> findByNameOrNickname(String name, String nickname);
    // JPA가 제공하는거를 쓰려면 name이랑 nickname 둘 다 보내줘야함

    boolean existsByName(String name);
}
