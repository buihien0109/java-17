package com.example.demojpa.repository;

import com.example.demojpa.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    @Transactional
    @Modifying
    @Query("update Todo t set t.title = ?2, t.status = ?3 where t.id = ?1")
    void updateTodo(Integer id, String title, Boolean status);

    @Transactional
    @Modifying
    @Query("delete Todo t where t.id = ?1")
    int deleteTodo(Integer id);
}