package com.example.demo.controller;

import com.example.demo.dto.ToDoRequest;
import com.example.demo.dto.ToDoResponse;
import com.example.demo.model.ToDoModel;
import com.example.demo.service.ToDoService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ToDoController {
    private final ToDoService toDoService;
    private final KafkaTemplate<String,String> kafkaTemplate;
    public ToDoController (ToDoService toDoService, KafkaTemplate<String, String> kafkaTemplate) {
        this.toDoService = toDoService;
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/get_all")
    public List<ToDoModel> getAllNotes() {
        return toDoService.getAllNotes();
    }
    @GetMapping("find_by_id/{id}")
    public ToDoModel getNoteById(@PathVariable String id) {
        return toDoService.getNoteById(id);
    }
    @PostMapping
    public ToDoResponse addNote(@RequestBody ToDoRequest request) throws Exception {
        ToDoModel model = request.toModel();
        return ToDoResponse.from(toDoService.addNote(model));
    }
    @PutMapping("/{id}")
    public ToDoResponse editNote(@PathVariable String id, @RequestBody ToDoRequest request) throws Exception {
        ToDoModel model = request.toModel();
        model.setId(id);
        return ToDoResponse.from(toDoService.editNote(model));
    }
    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable String id) throws Exception {
        toDoService.deleteById(id);
    }
}
