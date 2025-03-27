package com.example.demo.dto;

import com.example.demo.model.ToDoModel;
import lombok.NonNull;

public record ToDoRequest(@NonNull String text) {
    public ToDoModel toModel(){
        return ToDoModel.builder()
                .text(text)
                .build();
    }
}