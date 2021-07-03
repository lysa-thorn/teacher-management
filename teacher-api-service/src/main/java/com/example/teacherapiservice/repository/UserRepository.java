package com.example.teacherapiservice.repository;

import com.example.teacherapiservice.entity.User;
import com.example.teacherapiservice.payload.projection.UserCountProjection;
import com.example.teacherapiservice.payload.projection.UserProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    User findByUsernameIgnoreCase(String username);
    List<User> findByEmailContainingIgnoreCaseOrderByIdDesc(String email);

    //TODO: Spring Data JPA Project
    //List<UserProjection> findUserProjectionBy();
    Page<UserProjection> findUserProjectionBy(Pageable pageable); // with Pagination

    UserProjection findUserProjectionByUsername(String username);

    // TODO : Native Query
    @Query(value = "SELECT * FROM tu_user where id = :id" , nativeQuery = true)
    User findUserById(Long id);

    @Query(value = "SELECT id, username, email, gender FROM tu_user where id = :id " , nativeQuery = true)
    UserProjection findUserProjectionById(Long id);

    // TODO: Calling Store Procedure or Function from Database
    @Query(value = "SELECT * FROM count_user()" , nativeQuery = true)
    UserCountProjection countUser();

}
