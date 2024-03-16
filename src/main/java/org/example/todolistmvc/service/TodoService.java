package org.example.todolistmvc.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.todolistmvc.model.TodoList;

import java.util.List;

public interface TodoService {
    List<TodoList> getAllTodos();
    TodoList getTodoById(Long id);

    void addTodo(TodoList todo);

    void updateTodo(TodoList todo);
    void deleteTodoById(Long id);
    List<TodoList> searchTodos(String task, Boolean isDone);
}
