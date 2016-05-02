package io.khasang.orgmanager.dao;

import io.khasang.orgmanager.model.Entities.Task;
import io.khasang.orgmanager.model.Entities.User;

import java.util.List;

public interface ITaskDao extends GenericDao<Task> {
    List<Task> getRelatedToUser(User user);
}
