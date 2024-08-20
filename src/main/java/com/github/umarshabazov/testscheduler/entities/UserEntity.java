package com.github.umarshabazov.testscheduler.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role; // Например, ROLE_USER, ROLE_ADMIN и т.д.

    // Связь с созданными задачами
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TaskEntity> tasksCreated;

    // Связь с назначенными задачами
    @OneToMany(mappedBy = "assignee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TaskEntity> tasksAssigned;

    // Связь с комментариями
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CommentEntity> comments;

    // Getters и Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername (String username) {
        this.username=username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<TaskEntity> getTasksCreated() {
        return tasksCreated;
    }

    public void setTasksCreated(List<TaskEntity> tasksCreated) {
        this.tasksCreated = tasksCreated;
    }

    public List<TaskEntity> getTasksAssigned() {
        return tasksAssigned;
    }

    public void setTasksAssigned(List<TaskEntity> tasksAssigned) {
        this.tasksAssigned = tasksAssigned;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }
}

