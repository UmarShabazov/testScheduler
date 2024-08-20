package com.github.umarshabazov.testscheduler.repositories;

import com.github.umarshabazov.testscheduler.entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    List<CommentEntity> findByTaskId(Long taskId);
}
