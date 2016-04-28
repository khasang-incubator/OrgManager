package io.khasang.orgmanager.dao.impl;

import io.khasang.orgmanager.model.Entities.ContrAgent;
import org.springframework.stereotype.Repository;

/**
 * @author  radiofisik
 */
@Repository
public class ContrAgentDao extends GenericDaoImpl<ContrAgent> {
    public ContrAgentDao() {
        super(ContrAgent.class);
    }
}
