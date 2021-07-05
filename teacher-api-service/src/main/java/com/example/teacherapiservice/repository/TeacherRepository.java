package com.example.teacherapiservice.repository;

import com.example.teacherapiservice.entity.Teacher;
import com.example.teacherapiservice.payload.projection.TeacherProjection;
import com.example.teacherapiservice.payload.projection.UserProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query(value = "SELECT id, first_name, last_name, email, gender, phone, salary_id, start_date, end_date FROM teachers where id = :id " , nativeQuery = true)
    TeacherProjection findTeacherProjectionById(Long id);

    Page<TeacherProjection> findTeacherProjectionBy(Pageable pageable); // with Pagination
}
