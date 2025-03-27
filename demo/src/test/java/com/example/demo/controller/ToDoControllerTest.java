package com.example.demo.controller;

import com.example.demo.model.ToDoModel;
import com.example.demo.repo.ToDoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class ToDoControllerTest {
    private static final String URL_BASE = "/api";
    private static final String TEXT_FIELD_ONE = "test1";
    private static final String TEXT_FIELD_TWO = "test1";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ToDoRepository toDoRepository;

    @Test
    @DirtiesContext
    void addNote() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(URL_BASE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                """
                                                {
                                                    "text": "%s"
                                                }
                                        """.formatted(TEXT_FIELD_ONE)
                        ))
                .andExpect(MockMvcResultMatchers.status().isOk());
        List<ToDoModel> data = toDoRepository.findAll();
        assertEquals(1, data.size());
    }
    @Test
    @DirtiesContext
    void addNoteFail() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(URL_BASE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                """
                                                {
                                                }
                                        """
                        ))
                .andExpect(MockMvcResultMatchers.status().is5xxServerError());
    }

    @Test
    @DirtiesContext
    void getAllNotes() throws Exception {
        ToDoModel toDoOne = ToDoModel.builder().id("1").text(TEXT_FIELD_ONE).isFinished(true).build();
        ToDoModel toDoTwo = ToDoModel.builder().id("2").text(TEXT_FIELD_TWO).isFinished(true).build();
        toDoRepository.saveAll(List.of(toDoOne, toDoTwo));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/get_all"));
    }

    @Test
    void getNoteById() {
    }

    @Test
    void editNote() {
    }

    @Test
    void deleteNote() {
    }
}