package irimi.springrestdemo.service;

import java.util.List;

import irimi.springrestdemo.entity.Actor;

public interface ActorService {

    public Actor get(int id);

    public List<Actor> getAll();

    public void addOrUpdate(Actor actor);

    public void delete(int id);
}
