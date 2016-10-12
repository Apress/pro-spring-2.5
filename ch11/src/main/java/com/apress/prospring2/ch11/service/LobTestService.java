package com.apress.prospring2.ch11.service;

import com.apress.prospring2.ch11.domain.LobTest;

/**
 * @author janm
 */
public interface LobTestService {

    void save(LobTest lobTest);

    LobTest findById(Long id);

}
