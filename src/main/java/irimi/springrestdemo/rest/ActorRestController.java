package irimi.springrestdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import irimi.springrestdemo.entity.Actor;
import irimi.springrestdemo.entity.IndianActor;
import irimi.springrestdemo.service.ActorService;

@RestController
@RequestMapping("/api")
public class ActorRestController {

    @Autowired
    private ActorService service;

    // Use GET to get all actors or a single one
    // Use POST to add a new actor
    // Use PUT to update an existing actor
    // Use DELETE to remove an existing actor

    @GetMapping("/actors")
    public List<Actor> getAll() {
        List<Actor> actors = service.getAll();
        return actors;
    }

    @GetMapping("/actors/{id}")
    public Actor get(@PathVariable int id)
            throws ActorNotFoundException {
        Actor actor = getIfExists(id);
        return actor;
    }

    @PostMapping("/actors")
    public Actor add(@RequestBody IndianActor actor) {
        actor.setId(0);
        service.addOrUpdate(actor);
        return actor;
    }

    @PutMapping("/actors")
    public Actor update(@RequestBody IndianActor actor)
            throws ActorNotFoundException {
        int id = actor.getId();
        getIfExists(id);
        service.addOrUpdate(actor);
        return actor;
    }

    @DeleteMapping("/actors/{id}")
    public String delete(@PathVariable int id)
            throws ActorNotFoundException {
        getIfExists(id);
        service.delete(id);
        return "Actor with id=" + id + " deleted";
    }

    private Actor getIfExists(int id)
            throws ActorNotFoundException {
        Actor actor = service.get(id);
        if (actor == null)
            throw new ActorNotFoundException("Actor with id=" + id + " not found");
        return actor;
    }
}
