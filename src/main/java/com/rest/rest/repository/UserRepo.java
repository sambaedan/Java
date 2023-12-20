package com.rest.rest.repository;

import com.rest.rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface UserRepo extends JpaRepository<User,Long> {

    @Query(value = "SELECT a.* FROM users a",nativeQuery = true)
    List<Map<String,Object>> getAllUser();

    @Query(value = "select a.* FROM users a where a.id = ?1",nativeQuery = true)
    Map<String,Object> getUserById(long id);
}
