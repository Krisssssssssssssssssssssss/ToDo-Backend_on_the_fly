package com.example.demo.controller;

import com.example.demo.dto.ToDoRequest;
import com.example.demo.dto.ToDoResponse;
import com.example.demo.model.ToDoModel;
import com.example.demo.service.ToDoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ToDoController {
    private final ToDoService toDoService;
    public ToDoController (ToDoService toDoService) {
        this.toDoService = toDoService;
    }
    @GetMapping("/get_all")
    public List<ToDoModel> getAllData () {
        return toDoService.getAllNotes();
    }
    @GetMapping("find_by_id/{id}")
    public ToDoModel getDataById (@PathVariable String id) {
        return toDoService.getNoteById(id);
    }
    @PostMapping
    public ToDoResponse addData(@RequestBody ToDoRequest request) throws Exception {
        ToDoModel model = request.toModel();
        return ToDoResponse.from(toDoService.addNote(model));
    }
    @PutMapping("/{id}")
    public ToDoResponse editData(@PathVariable String id, @RequestBody ToDoRequest request) throws Exception {
        ToDoModel model = request.toModel();
        model.setId(id);
        return ToDoResponse.from(toDoService.editNote(model));
    }
    @DeleteMapping("/{id}")
    public void deleteData(@PathVariable String id) throws Exception {
        toDoService.deleteById(id);
    }
}
