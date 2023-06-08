package com.example.demojpa.controller;

import com.example.demojpa.entity.Todo;
import com.example.demojpa.repository.TodoRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/")
    public String getIndex(Model model) {
        List<Todo> todos = todoRepository.findAll();
        model.addAttribute("todos", todos);
        return "index";
    }

    @GetMapping("/todos")
    public String getTodos(Model model) {
        List<Todo> todos = todoRepository.findAll();
        model.addAttribute("todos", todos);
        return "todos";
    }

    @PostMapping("api/todos")
    public ResponseEntity<?> createTodo(@RequestBody Todo todo) {
        Todo newTodo = new Todo(null, todo.getTitle(), false);
        todoRepository.save(newTodo);
        return new ResponseEntity<>(newTodo, HttpStatus.CREATED); // 201
    }

    @PutMapping("api/todos/{id}")
    public ResponseEntity<?> updateTodo(@PathVariable Integer id, @RequestBody Todo todo) {
        // Kiểm tra id
        Todo updatedTodo = todoRepository.findById(id)
                .orElseThrow(() -> {
                    throw new RuntimeException("Not found");
                });
        // Cập nhật
        updatedTodo.setTitle(todo.getTitle());
        updatedTodo.setStatus(todo.getStatus());
        todoRepository.save(updatedTodo);

        return ResponseEntity.ok(updatedTodo); // 200
    }

    @DeleteMapping("api/todos/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable Integer id) {
        // Kiểm tra id
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> {
                    throw new RuntimeException("Not found");
                });
        todoRepository.delete(todo);
        return ResponseEntity.noContent().build(); // 204
    }

    @PutMapping("api/todos/{id}/toggle")
    public ResponseEntity<?> toggleTodoStatus(@PathVariable Integer id) {
        // Kiểm tra id
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> {
                    throw new RuntimeException("Not found");
                });

        // Thay đổi trạng thái công việc
        Boolean status = todo.getStatus();
        if (status != null) {
            boolean newStatus = !status;
            todo.setStatus(newStatus);
            todoRepository.save(todo);
        }

        return ResponseEntity.ok(todo); // 200
    }

    @GetMapping("/api/todos/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        return ResponseEntity.ok(todoRepository.findById(id));
    }
}
