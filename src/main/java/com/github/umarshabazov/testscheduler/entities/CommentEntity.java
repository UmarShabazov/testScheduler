package com.github.umarshabazov.testscheduler.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class CommentEntity extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String content;

    // Связь с задачей
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", nullable = false)
    private TaskEntity task;

    // Связь с автором комментария
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private UserEntity author;

    // Getters и Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;

    }

    public TaskEntity getTask() {
        return task;
    }

    public void setTask(TaskEntity task) {
        this.task = task;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }
}