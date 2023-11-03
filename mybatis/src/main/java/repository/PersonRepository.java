package repository;

import com.example.mybatis.mybatis.domain.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonRepository, Long> {
    // name 매개변수를 받은 PersonEntity의 name필드와 비교
    // 일치하는 레코드가 DB에 있을 때, 해당 엔티티를 Java의 Optional 객체로 반환
    // => Select * from PersonEntity WHERE name = :name
    Optional<PersonRepository> findByName(String name);
}

// Optional 클래스의 메서드
/**
 * 1. orElse()
 * 저장된 값이 있으면 해당 값을 반환, 없으면 인자로 넘겨진 값 반환
 * ex) .orElse("저장된 값이 없습니다.") => 값이 없으면 안내 문구 반환
 *
 * 2. orElseThrow( () => {} )
 * 저장된 값이 있으면 해당 값을 반환, 없으면 예외 처리
 *
 * 3. isPresent() ( == isEmpty() java11버전 이상부터 사용)
 * 값이 존재하면 true, 없으면 false
 *
 * 4. filter()
 * 값이 존재하고 주어진 조건을 만족하면 그 값을 포함하는 Optional을 반환
 * 값이 없으면 빈 Optional 반환
 */
