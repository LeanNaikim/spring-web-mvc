package org.example.todolistmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoList {
    private Integer id;
    private String task;
    private String description;
    private boolean isDone;
    private LocalDateTime createdAt;

}
