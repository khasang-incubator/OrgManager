package io.khasang.orgmanager.dao.impl;

import io.khasang.orgmanager.model.Entities.Requisite;
import org.springframework.stereotype.Repository;

/**
 * @author radiofisik
 */
@Repository
public class RequisiteDao extends GenericDaoImpl<Requisite> {
    public RequisiteDao() {
        super(Requisite.class);
    }
}
