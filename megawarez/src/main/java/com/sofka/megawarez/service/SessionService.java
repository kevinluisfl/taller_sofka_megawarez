package com.sofka.megawarez.service;

import com.sofka.megawarez.domain.Session;
import com.sofka.megawarez.repository.SessionRepository;
import com.sofka.megawarez.service.interfaces.ISession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
public class SessionService implements ISession {

    @Autowired
    private SessionRepository sessionRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Session> getSessions() {
        return (List<Session>) sessionRepository.findAll();
    }

    @Override
    @Transactional
    public Session createSession(Session session) {
        session.setCreatedAt(Instant.now());
        return sessionRepository.save(session);
    }

    @Override
    @Transactional
    public Session updateSession(Integer id, Session session) {
        session.setId(id);
        return sessionRepository.save(session);
    }

    @Override
    @Transactional
    public Session deleteSession(Integer id) {
        var session = sessionRepository.findById(id);
        if (session.isPresent()) {
            sessionRepository.delete(session.get());
            return session.get();
        } else {
            return null;
        }
    }
}
