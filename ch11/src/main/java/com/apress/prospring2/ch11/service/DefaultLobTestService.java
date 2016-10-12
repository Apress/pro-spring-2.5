package com.apress.prospring2.ch11.service;

import com.apress.prospring2.ch11.dataaccess.LobTestDao;
import com.apress.prospring2.ch11.domain.LobTest;

/**
 * @author janm
 */
public class DefaultLobTestService implements LobTestService {
    private LobTestDao lobTestDao;

    public void save(LobTest lobTest) {
        this.lobTestDao.save(lobTest);
    }

    public LobTest findById(Long id) {
        return this.lobTestDao.getById(id);
    }

    public void setLobTestDao(LobTestDao lobTestDao) {
        this.lobTestDao = lobTestDao;
    }
}
