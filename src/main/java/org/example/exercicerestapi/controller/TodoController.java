package org.example.exercicerestapi.controller;

import org.example.exercicerestapi.dto.TodoReceiveDto;
import org.example.exercicerestapi.dto.TodoResponseDto;
import org.example.exercicerestapi.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todo")
public class TodoController {
    private final TodoService todoService;
    public TodoController(TodoService todoService) {
        this.todoService = todoService;

    }

    @GetMapping
    public ResponseEntity<List<TodoResponseDto>> getAll() {
        return ResponseEntity.ok(todoService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<TodoResponseDto> get (@PathVariable long id){
        return ResponseEntity.ok(todoService.getById(id));
    }

    @PostMapping
    public ResponseEntity<TodoResponseDto> create (@RequestBody TodoReceiveDto todoReceiveDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.Create(todoReceiveDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponseDto> update (@PathVariable long id , @RequestBody TodoReceiveDto todoReceiveDto){
        return ResponseEntity.ok(todoService.update(id,todoReceiveDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        todoService.delete(id);
        return ResponseEntity.ok(String.format("todo at id : %s is deleted",id));
    }
    @GetMapping("/status/{status}")
    public ResponseEntity<List<TodoResponseDto>> getByStatus(@PathVariable boolean status) {
        return ResponseEntity.ok(todoService.getByStatus(status));
    }

}
