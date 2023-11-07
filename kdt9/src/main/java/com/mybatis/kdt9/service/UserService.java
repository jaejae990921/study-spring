package com.mybatis.kdt9.service;

import com.mybatis.kdt9.domain.User;
import com.mybatis.kdt9.dto.UserDTO;
import com.mybatis.kdt9.dto.UserDTOBuilder;
import com.mybatis.kdt9.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    // mapper를 실행하고 그에 대한 결과값을 dto에 담아서 controller로 return
    @Autowired
    UserMapper userMapper;

    public List<UserDTO> getUserList() {
        List<User> result = userMapper.retrieveAll();
        List<UserDTO> users = new ArrayList<>();

        // 검색된 result의 데이터를 UserDTO로 만들어서 user에 추가
        for (int i = 0; i < result.size(); i++) {
            User u = result.get(i);

            UserDTO user = UserDTO.builder()
                    .id(u.getId())
                    .name(u.getName())
                    .nickname(u.getNickname())
                    .no(i+1)
                    .build();

            users.add(user);

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
        }

        return users;
    }

    public void insertUser(String name, String nickname) {
        User user = new User();
        user.setName(name);
        user.setNickname(nickname);

        userMapper.insertUser(user);
    }
}
