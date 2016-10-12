package com.apress.prospring2.ch11.dataaccess;

import com.apress.prospring2.ch11.domain.LobTest;

/**
 * @author janm
 */
public interface LobTestDao {

    void save(LobTest lobTest);

    LobTest getById(Long id);

}
