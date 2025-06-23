package org.example.exercicerestapi.repository;

import org.example.exercicerestapi.dto.TodoResponseDto;
import org.example.exercicerestapi.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {
    @Query("SELECT t FROM Todo t WHERE t.isValidate = ?1")
    List<Todo> findAllByStatus(Boolean isValide);
}
