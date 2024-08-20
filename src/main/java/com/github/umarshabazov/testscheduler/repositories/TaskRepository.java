package com.github.umarshabazov.testscheduler.repositories;

import com.github.umarshabazov.testscheduler.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    // Пример метода для поиска задач по автору
    List<TaskEntity> findByAuthorUsername(String username);

    // Пример метода для поиска задач по исполнителю
    List<TaskEntity> findByAssigneeUsername(String username);
}