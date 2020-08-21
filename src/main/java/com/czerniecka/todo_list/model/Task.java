package com.czerniecka.todo_list.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Task {

    private Integer id;
    private String title;
    private String description;

    private LocalDateTime creationTime;
    private LocalDateTime completionTime;

}
