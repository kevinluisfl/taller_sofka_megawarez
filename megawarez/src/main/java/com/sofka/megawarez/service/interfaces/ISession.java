package com.sofka.megawarez.service.interfaces;

import com.sofka.megawarez.domain.Session;

import java.util.List;

public interface ISession {

    public List<Session> getSessions();

    public Session createSession(Session session);

    public Session updateSession(Integer id, Session session);

    public Session deleteSession(Integer id);
}
