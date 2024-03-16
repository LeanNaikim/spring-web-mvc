package org.example.todolistmvc.controller;

import org.example.todolistmvc.model.TodoList;
import org.example.todolistmvc.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Controller
//@RequestMapping("/todoList")
public class TodoController {

    private final List<TodoList> todoList = new ArrayList<>();

    // Constructor to initialize dummy data
    public TodoController() {
        todoList.add(new TodoList(1, "Task 1", "Description 1", false, LocalDateTime.now()));
        todoList.add(new TodoList(2, "Task 1", "Description 1", false, LocalDateTime.now()));
        todoList.add(new TodoList(3, "Task 1", "Description 1", false, LocalDateTime.now()));
    }
//    private final List<TodoList> todoList;
//
//    public TodoController(List<TodoList> todoList) {
//        this.todoList = todoList;
//    }

    @GetMapping("/todoList")
    public String viewTodoList(Model model) {
        model.addAttribute("todos", todoList);
        return "/todo-list";
    }

    @GetMapping("/{id}")
    public String viewTodoDetails(@PathVariable("id") Long id, Model model) {
        TodoList todo = findTodoById(id);
        model.addAttribute("todo", todo);
        return "/todo-details";
    }

    @GetMapping("/new")
    public String showAddTodoForm() {
        // Show the form to add a new todo item
        return "/add-todo";
    }

    @PostMapping("/new")
    public String addTodo(@ModelAttribute TodoList todo) {
        // Add the new todo item to the list
        todoList.add(todo);
        return "redirect:/todo";
    }

//    @GetMapping("/add-todo")
//    public String addPersonPage() {
//        return "add-todo";
//    }
//
//    @PostMapping("/add")
//    public String addPerson(TodoList todoList) {
//        TodoService.addTodo(todoList);
//        return "redirect:/";
//    }

    @GetMapping("/edit/{id}")
    public String showEditTodoForm(@PathVariable("id") Long id, Model model) {
        TodoList todo = findTodoById(id);
        model.addAttribute("todo", todo);
        return "edit-todo";
    }

    @PostMapping("/edit/{id}")
    public String editTodo(@PathVariable("id") Long id, @ModelAttribute TodoList updatedTodo) {
        TodoList todo = findTodoById(id);
        if (todo != null) {
            // Update the existing todo item with the updated values
            todo.setTask(updatedTodo.getTask());
            todo.setDescription(updatedTodo.getDescription());
            todo.setDone(updatedTodo.isDone());
        }
        return "redirect:/todo";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable("id") Long id) {
        TodoList todo = findTodoById(id);
        if (todo != null) {
            // Remove the todo item from the list
            todoList.remove(todo);
        }
        return "redirect:/todo";
    }

    @GetMapping("/search")
    public String searchTodoList(@RequestParam(value = "task", required = false) String task,
                                 @RequestParam(value = "isDone", required = false) Boolean isDone,
                                 Model model) {
        List<TodoList> searchResults = new ArrayList<>();
        // Perform the search based on the provided parameters (task and isDone)
        // Add matching todo items to the searchResults list
        // You can customize the search logic based on your requirements
        if (task != null) {
            // Search by task
            for (TodoList todo : todoList) {
                if (todo.getTask().equalsIgnoreCase(task)) {
                    searchResults.add(todo);
                }
            }
        }
        if (isDone != null) {
            // Search by isDone
            for (TodoList todo : todoList) {
                if (todo.isDone() == isDone) {
                    searchResults.add(todo);
                }
            }
        }
        model.addAttribute("todos", searchResults);
        return "/todo-list";
    }

    private TodoList findTodoById(Long id) {
        // Find the todo item in the list based on the ID
        return todoList.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}