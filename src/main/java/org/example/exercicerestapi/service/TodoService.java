package org.example.exercicerestapi.service;

import org.example.exercicerestapi.dto.TodoReceiveDto;
import org.example.exercicerestapi.dto.TodoResponseDto;
import org.example.exercicerestapi.entity.Todo;
import org.example.exercicerestapi.exeception.NotFoundException;
import org.example.exercicerestapi.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // crée une todoo
    public TodoResponseDto Create (TodoReceiveDto todoReceiveDto) {
        return todoRepository.save(todoReceiveDto.dtoToEntity()).entityToDto();
    }
    //recupere toute les toodo
    public List<TodoResponseDto> getAll() {
        return todoRepository.findAll().stream().map(Todo::entityToDto).toList();
    }
    //recupere une todoo avec son id
    public TodoResponseDto getById(Long id) {
        return todoRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto();
    }
    //modifie la todoo avec son id
    public TodoResponseDto update(Long id, TodoReceiveDto todoReceiveDto) {
        Todo todoGet = todoReceiveDto.dtoToEntity();
        Todo todoFound = todoRepository.findById(id).orElseThrow(NotFoundException::new);
        todoFound.setTitle(todoGet.getTitle());
        todoFound.setDescription(todoGet.getDescription());
        todoFound.setValidate(todoGet.isValidate());
        todoFound.setDate(todoGet.getDate());

        return todoRepository.save(todoFound).entityToDto();
    }
    //supprime une todoo avec son id
    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
    // tentative de recuperation de list part validation de todoo
    public List<TodoResponseDto> getByStatus(Boolean isValide) {
        return todoRepository.findAllByStatus(isValide);
        //return todoRepository.findAll().stream().filter(todo -> todo.isValidate() == status).map(Todo::entityToDto).toList();
    }
}
