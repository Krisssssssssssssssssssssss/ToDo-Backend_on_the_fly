package com.example.demo.dto;

import com.example.demo.model.ToDoModel;
import lombok.Builder;

@Builder
public record ToDoResponse(String id, String text, boolean isDone) {
    public static ToDoResponse from (ToDoModel dataModel){
        return ToDoResponse.builder()
                .id(dataModel.getId())
                .text(dataModel.getText())
                .isDone(true)
                .build();
    }
}

