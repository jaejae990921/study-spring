package dto;

import lombok.Getter;
import lombok.Setter;

// @Getter
// @Setter
// 클래스안에 모든 변수에 getter, setter 생성됨. 특정 변수 위에 작성하면 그거만 생성
public class UserDTO {
    // DTO란 프로세스 사이에서 데이터를 전송하는 객체
    private String name;

    // getter와 setter : Generate -> Getter and Setter -> 변수 선택
    // lombok (코드 다이어터)// lombok (코드 다이어터)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // lombok (코드 다이어터)
//    @Getter
//    @Setter
    private String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
