package com.example.demo.repo;

import com.example.demo.model.ToDoModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends MongoRepository<ToDoModel,String> {
}
