package com.mostovyi.smartstartup.service;

import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractSoftwareService<M> {

    @Transactional
    public abstract void save(M model);

    public abstract void run(long id);

    public abstract void close(long id);

}
