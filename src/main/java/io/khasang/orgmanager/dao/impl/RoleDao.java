package io.khasang.orgmanager.dao.impl;

import io.khasang.orgmanager.model.Entities.Role;
import org.springframework.stereotype.Repository;

/**
 * @author radiofisik
 */
@Repository
public class RoleDao extends GenericDaoImpl<Role> {
    public RoleDao() {
        super(Role.class);
    }
}
