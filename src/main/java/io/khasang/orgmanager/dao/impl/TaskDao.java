package io.khasang.orgmanager.dao.impl;

import io.khasang.orgmanager.model.Entities.Task;
import org.springframework.stereotype.Repository;

/**
 * @author radiofisik
 */
@Repository
public class TaskDao extends GenericDaoImpl<Task> {
    public TaskDao() {
        super(Task.class);
    }
}
