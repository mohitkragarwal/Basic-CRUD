package com.example.crud.dao;

import com.example.crud.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Dao extends JpaRepository<Tasks,Integer> {

}
