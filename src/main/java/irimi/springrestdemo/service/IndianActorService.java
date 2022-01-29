package irimi.springrestdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import irimi.springrestdemo.dao.ActorDAO;
import irimi.springrestdemo.entity.Actor;

@Service
public class IndianActorService
        implements ActorService {

    @Autowired
    private ActorDAO dao;

    @Override
    @Transactional
    public Actor get(int id) {
        Actor actor = dao.get(id);
        return actor;
    }

    @Override
    @Transactional
    public List<Actor> getAll() {
        List<Actor> actors = dao.getAll();
        return actors;
    }

    @Override
    @Transactional
    public void addOrUpdate(Actor actor) {
        dao.addOrUpdate(actor);
    }

    @Override
    @Transactional
    public void delete(int id) {
        dao.delete(id);
    }
}
