package com.example.todo_api.repository.task;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface TaskRepository {

    @Select("SELECT id, title FROM tasks ORDER BY id LIMIT 1")
    Optional<TaskRecord> select();

}
