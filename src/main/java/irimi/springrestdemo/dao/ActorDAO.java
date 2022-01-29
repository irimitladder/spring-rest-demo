package irimi.springrestdemo.dao;

import java.util.List;

import irimi.springrestdemo.entity.Actor;

public interface ActorDAO {

    public Actor get(int id);

    public List<Actor> getAll();

    public void addOrUpdate(Actor actor);

    public void delete(int id);
}
