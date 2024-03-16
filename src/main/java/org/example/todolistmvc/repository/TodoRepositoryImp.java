package org.example.todolistmvc.repository;

import org.example.todolistmvc.model.TodoList;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TodoRepositoryImp implements TodoRepository {

    private List<TodoList> todoList;

    public void TodoRepositoryImpl() {
        todoList = new ArrayList<>();
    }
    @Override
    public List<TodoList> getAllTodos() {

        return todoList;
    }

    @Override
    public TodoList getTodoById(Long id) {
        return todoList.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addTodo(TodoList todo) {
        todoList.add(todo);
    }

    @Override
    public void updateTodo(TodoList todo) {

    }

    @Override
    public void deleteTodoById(Long id) {
        TodoList todo = getTodoById(id);
        if (todo != null) {
            todoList.remove(todo);
        }
    }

    @Override
    public List<TodoList> searchTodos(String task, Boolean isDone) {
        return todoList.stream()
                .filter(todo -> todo.getTask().contains(task))
                .filter(todo -> isDone == null || todo.isDone() == isDone)
                .collect(Collectors.toList());
    }
}
