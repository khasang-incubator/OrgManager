package io.khasang.orgmanager.dao.impl;

import io.khasang.orgmanager.dao.ITaskDao;
import io.khasang.orgmanager.model.Entities.Task;
import io.khasang.orgmanager.model.Entities.User;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author radiofisik
 */
@Repository
public class TaskDao extends GenericDaoImpl<Task>  implements ITaskDao{
    public TaskDao() {
        super(Task.class);
    }

    @Override
    public List<Task> getRelatedToUser(User user) {
        return getSession().createCriteria(Task.class)
                .add(Restrictions.or(
                        Restrictions.eq("creator",user),
                        Restrictions.eq("executor",user)
                ))
                .list();
    }
}
