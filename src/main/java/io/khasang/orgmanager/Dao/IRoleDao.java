package io.khasang.orgmanager.dao;

import io.khasang.orgmanager.model.Entities.Role;

public interface IRoleDao extends GenericDao<Role>  {
    Role getRoleByName(String roleName);
}
