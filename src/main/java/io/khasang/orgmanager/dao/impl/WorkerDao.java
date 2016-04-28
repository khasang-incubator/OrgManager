package io.khasang.orgmanager.dao.impl;

import io.khasang.orgmanager.model.Entities.Worker;
import org.springframework.stereotype.Repository;

/**
 * @author radiofisik
 */
@Repository
public class WorkerDao extends GenericDaoImpl<Worker> {
    public WorkerDao() {
        super(Worker.class);
    }
}
