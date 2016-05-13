package io.khasang.orgmanager.model.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Boolean done;

    @ManyToOne
    @JoinColumn(name = "executorID")
    private User executor;

    @ManyToOne
    @JoinColumn(name = "creatorID")
    private User creator;

    @ManyToOne
    @JoinColumn(name = "parentTaskId")
    private Task parentTask;

    @JsonIgnore
    @OneToMany(mappedBy = "parentTask")
    public Set<Task> childTasks= new HashSet<>();

    @Column
    @Type(type="timestamp")
    private Date createDate;

    @Column
    @Type(type="timestamp")
    private Date deadLine;

    @Column(name = "name", unique = false, nullable = false, length = 1000)
    private String name;

    @Column
    @Type(type="text")
    private String description;

    @Column
    private Integer priority;

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public Set<Task> getChildTasks() {
        return childTasks;
    }

    public void setChildTasks(Set<Task> childTasks) {
        this.childTasks = childTasks;
    }

    public Integer getId() {
        return id;
    }

    public User getExecutor() {
        return executor;
    }

    public void setExecutor(User executor) {
        this.executor = executor;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Task getParentTask() {
        return parentTask;
    }

    public void setParentTask(Task parentTask) {
        this.parentTask = parentTask;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
