package org.example.todolistmvc.service;

import org.example.todolistmvc.model.TodoList;
import org.example.todolistmvc.repository.TodoRepository;

import java.util.List;

public class TodoServiceImp implements TodoService{
    private TodoRepository todoRepository;

    public void TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<TodoList> getAllTodos() {
        return todoRepository.getAllTodos();
    }

    @Override
    public TodoList getTodoById(Long id) {
        return todoRepository.getTodoById(id);
    }

    @Override
    public void addTodo(TodoList todo) {
        todoRepository.addTodo(todo);
    }

    @Override
    public void updateTodo(TodoList todo) {
        todoRepository.updateTodo(todo);
    }

    @Override
    public void deleteTodoById(Long id) {
        todoRepository.deleteTodoById(id);
    }

    @Override
    public List<TodoList> searchTodos(String task, Boolean isDone) {
        return todoRepository.searchTodos(task, isDone);
    }
}
