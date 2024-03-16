package org.example.todolistmvc.repository;

import org.example.todolistmvc.model.TodoList;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public interface TodoRepository {

//    static List<TodoList> todoList() {
//        List<TodoList> todoList = new ArrayList<>();
//        // Add some initial todo items to the list
//        // You can replace this with your own implementation to fetch data from a database or another data source
//        todoList.add(new TodoList(1, "Task 1", "Description 1", false, LocalDateTime.now()));
//        todoList.add(new TodoList(2, "Task 2", "Description 2", true, LocalDateTime.now()));
//        return todoList;
//    }
    List<TodoList> getAllTodos();
    TodoList getTodoById(Long id);
    void addTodo(TodoList todo);
    void updateTodo(TodoList    todo);
    void deleteTodoById(Long id);
    List<TodoList> searchTodos(String task, Boolean isDone);
}
