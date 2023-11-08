package com.mybatis.kdt9.service;

import com.mybatis.kdt9.domain.User;
import com.mybatis.kdt9.domain.UserEntity;
import com.mybatis.kdt9.dto.UserDTO;
import com.mybatis.kdt9.dto.UserDTOBuilder;
import com.mybatis.kdt9.mapper.UserMapper;
import com.mybatis.kdt9.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    // mapper를 실행하고 그에 대한 결과값을 dto에 담아서 controller로 return
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRepository userRepository;

    public String searchUser(String name) {
        // repository를 통해 어떤 메소드를 실행하고 그에 대한 결과를 return
        List<UserEntity> result = userRepository.findByName(name);
        // findBy컬럼명
        // findBy컬럼명And컬럼명 findByNameAndNickname;
        for (UserEntity user : result) {
            System.out.println(user.getId());
        }

        return "";
    }

    public String searchId(int id) {
        // UserEntity user = userRepository.findById(id).orElseThrow(() => new RuntimeException("user doesn't exist"));
        Optional<UserEntity> result = userRepository.findById(id);
        // result가 null이면 오류 발생
        // Optional : null일 수도 있는 객체를 감싸는 Wrapper 객체

        if (result.isPresent()) {
            System.out.println(result.get().getName() + " " + result.get().getNickname());
        } else {
            System.out.println("No User");
        }

        // Optional
        // isPresent() 객체의 여부를 boolean 으로 반환
        // isEmpty() : isPresent()의 반대
        // get() : Optional 내부의 객체를 반환

        return "";
    }

    public List<UserDTO> getUserList() {
        // ---------- JPA ----------
        List<UserEntity> result = userRepository.findAll(); // 전체 검색
        List<UserDTO> users = new ArrayList<>();

        for (UserEntity user : result) {
            UserDTO userDTO = UserDTO.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .nickname(user.getNickname())
                    .build();

            users.add(userDTO);
        }

        // ---------- MyBatis ----------
        
        // List<User> result = userMapper.retrieveAll();
        // List<UserDTO> users = new ArrayList<>();
        
        // 검색된 result의 데이터를 UserDTO로 만들어서 user에 추가
//        for (int i = 0; i < result.size(); i++) {
//            User u = result.get(i);
//
//            UserDTO user = UserDTO.builder()
//                    .id(u.getId())
//                    .name(u.getName())
//                    .nickname(u.getNickname())
//                    .no(i+1)
//                    .build();
//
//            users.add(user);

//            User user = result.get(i);
//            UserDTO userDTO = new UserDTO();
//
//            userDTO.setId(user.getId());
//            userDTO.setName(user.getName());
//            userDTO.setNickname(user.getNickname());
//            userDTO.setNo(i + 1);
//
//            users.add(userDTO);
//
//            UserDTOBuilder userDTOBuilder = UserDTOBuilder.builder()
//                    .name(user.getName())
//                    .id(user.getId())
//                    .build();
//        }

        return users;
    }

    public void insertUser(String name, String nickname) {
        User user = new User();
        user.setName(name);
        user.setNickname(nickname);

        userMapper.insertUser(user);
    }

    public String insertUser2(String name, String nickname) {
        UserEntity user = UserEntity.builder()
                .name(name)
                .nickname(nickname)
                .build();

        UserEntity newUser = userRepository.save(user);
        // save를 했을 때 반환되는 객체는 UserEntity 객체
        return newUser.getName();
    }

    public int searchNameOrNickname(String word) {
        List<UserEntity> result = userRepository.findByNameOrNickname(word, word);

        return result.size();
    }

    public boolean checkUser(String name) {
        return userRepository.existsByName(name);
    }
}
