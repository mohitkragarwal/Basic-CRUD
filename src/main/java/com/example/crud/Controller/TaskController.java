package com.example.crud.Controller;

import com.example.crud.model.Tasks;
import com.example.crud.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/home")
    public String home()
    {
        return "Basic CRUD Application";
    }

    @PostMapping("create")
    public ResponseEntity<String> addTask(@RequestBody Tasks task)
    {

        return taskService.addTask(task);
    }
    @GetMapping("view")
    public ResponseEntity<List<Tasks>> viewTasks()
    {
        return taskService.viewTasks();
    }
    @PutMapping("update/{id}")
    public ResponseEntity<String> updateTasks(@RequestBody Tasks task, @PathVariable Integer id)
    {
        return taskService.updateTasks(task,id);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id)
    {
        return taskService.deleteById(id);
    }


}
