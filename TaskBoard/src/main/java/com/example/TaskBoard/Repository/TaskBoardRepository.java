package com.example.TaskBoard.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.TaskBoard.Model.TaskBoard;

@Repository
public interface TaskBoardRepository extends MongoRepository<TaskBoard, String> {

}
