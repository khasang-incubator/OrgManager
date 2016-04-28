package io.khasang.orgmanager.dao.impl;

import io.khasang.orgmanager.model.Entities.Phone;
import org.springframework.stereotype.Repository;

/**
 * @author radiofisik
 */
@Repository
public class PhoneDao extends GenericDaoImpl<Phone> {
    public PhoneDao() {
        super(Phone.class);
    }
}
