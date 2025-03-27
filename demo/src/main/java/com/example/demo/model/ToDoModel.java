package com.example.demo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@With
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Document("ToDoNotes")
public class ToDoModel {
    @Id
    private String  id;
    private String text;
    private boolean isFinished;
}