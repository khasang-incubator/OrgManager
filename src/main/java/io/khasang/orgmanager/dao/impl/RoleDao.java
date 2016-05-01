package io.khasang.orgmanager.dao.impl;

import io.khasang.orgmanager.dao.IRoleDao;
import io.khasang.orgmanager.model.Entities.Role;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * @author radiofisik
 */
@Repository
public class RoleDao extends GenericDaoImpl<Role> implements IRoleDao{
    public RoleDao() {
        super(Role.class);}

    @Override
    public Role getRoleByName(String roleName) {
        return (Role) getSession().createCriteria( Role.class ).
                add( Restrictions.eq("name", roleName) ).
                uniqueResult();
    }
}
