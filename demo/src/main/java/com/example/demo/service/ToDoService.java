package com.example.demo.service;

import com.example.demo.model.ToDoModel;
import com.example.demo.repo.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public String returnTest() {
        return "Hello World";
    }

    public ToDoModel addNote(ToDoModel product) {
        return toDoRepository.save(product);
    }

    public ToDoModel getNoteById(String id) {
        return toDoRepository.findById(id).orElseThrow();
    }

    public List<ToDoModel> getAllNotes() {
        return toDoRepository.findAll();
    }

    public ToDoModel editNote(ToDoModel dataModel) throws Exception {
        ToDoModel model = toDoRepository.findById(dataModel.getId()).orElseThrow();
        return toDoRepository.save((model));
    }

    public void deleteById(String id) {
        toDoRepository.deleteById(id);
    }
}
