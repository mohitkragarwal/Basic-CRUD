package com.example.crud.service;

import com.example.crud.dao.Dao;
import com.example.crud.model.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private Dao dao;

    public ResponseEntity<String> addTask(Tasks task) {
        dao.save(task);
         return new ResponseEntity< >("Created", HttpStatus.CREATED);

    }

    public ResponseEntity<List<Tasks>> viewTasks() {
        return new ResponseEntity<>(dao.findAll(),HttpStatus.OK);
    }


    public ResponseEntity<String> updateTasks(Tasks task, Integer id){

        Tasks tempTask=dao.findById(id).get();
        tempTask.setTaskID(id);
        tempTask.setName(task.getName());
        tempTask.setStartDate(task.getStartDate());
        tempTask.setEndDate(task.getEndDate());
        tempTask.setStatus(task.getStatus());

        dao.save(tempTask);
        return new ResponseEntity<>("Updated", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteById(Integer id) {
        dao.deleteById(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }
}
