package com.github.umarshabazov.testscheduler.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tasks")
public class TaskEntity extends AbstractAuditingEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    private String status; // "в ожидании", "в процессе", "завершено"

    @Column(nullable = false)
    private String priority; // "высокий", "средний", "низкий"

    // Связь с автором задачи
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private UserEntity author;

    // Связь с исполнителем задачи
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignee_id")
    private UserEntity assignee;

    // Связь с комментариями
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CommentEntity> comments;

    // Getters и Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public UserEntity getAssignee() {
        return assignee;
    }

    public void setAssignee(UserEntity assignee) {
        this.assignee = assignee;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }
}


