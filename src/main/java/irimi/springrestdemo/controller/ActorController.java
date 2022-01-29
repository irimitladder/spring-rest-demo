package irimi.springrestdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import irimi.springrestdemo.entity.Actor;
import irimi.springrestdemo.entity.IndianActor;
import irimi.springrestdemo.service.ActorService;

@Controller
@RequestMapping("/actors")
public class ActorController {

    // Check code files for line separators
    // c: and form:

    @Autowired
    private ActorService service;

    @GetMapping("")
    public String showListingPage(Model model) {
        List<Actor> actors = service.getAll();
        model.addAttribute("actors", actors);
        return "listing-actors";
    }

    @GetMapping("/addActor")
    public String showAddingPage(Model model) {
        Actor actor = new IndianActor();
        model.addAttribute("actor", actor);
        return "adding-or-updating-actor";
    }

    @PostMapping("/saveActor")
    public String executeAddingOrUpdatingRequest(@ModelAttribute("actor") IndianActor actor) {
        service.addOrUpdate(actor);
        return "redirect:/actors";
    }

    @GetMapping("/updateActor")
    public String showUpdatingPage(@RequestParam("actorId") int id, Model model) {
        Actor actor = service.get(id);
        model.addAttribute("actor", actor);
        return "adding-or-updating-actor";
    }

    @GetMapping("/deleteActor")
    public String executeDeletingRequest(@RequestParam("actorId") int id, Model model) {
        service.delete(id);
        return "redirect:/actors";
    }
}
