package org.example.testsecurity.repository;

import org.example.testsecurity.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

//JpaRepository<User, Long> 에서의 User = Entity, Long = id의 데이터 타입
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    // 중복 아이디 2
    boolean existsByUsername(String username);
}
