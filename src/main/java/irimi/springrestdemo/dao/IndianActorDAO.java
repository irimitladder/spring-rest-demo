package irimi.springrestdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import irimi.springrestdemo.entity.Actor;
import irimi.springrestdemo.entity.IndianActor;

@Repository
public class IndianActorDAO
        implements ActorDAO {

    @Autowired
    private SessionFactory dbSessionFactory;

    @Override
    public Actor get(int id) {
        Session dbSession = dbSessionFactory.getCurrentSession();
        Actor actor = dbSession.get(IndianActor.class, id);
        return actor;
    }

    @Override
    public List<Actor> getAll() {
        Session dbSession = dbSessionFactory.getCurrentSession();
        Query<Actor> dbSessionQuery = dbSession.createQuery("FROM IndianActor ORDER BY lastName", Actor.class);
        List<Actor> actors = dbSessionQuery.getResultList();
        return actors;
    }

    @Override
    public void addOrUpdate(Actor actor) {
        Session dbSession = dbSessionFactory.getCurrentSession();
        dbSession.saveOrUpdate(actor);
    }

    @Override
    public void delete(int id) {
        Session dbSession = dbSessionFactory.getCurrentSession();
        Query<?> dbSessionQuery = dbSession.createQuery("DELETE FROM IndianActor WHERE id=:id");
        dbSessionQuery.setParameter("id", id);
        dbSessionQuery.executeUpdate();
    }
}
