package dev.project.BookMyShow.controller;

import dev.project.BookMyShow.entity.Actor;
import dev.project.BookMyShow.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actor")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @PostMapping("/")
    ResponseEntity createActor(@RequestBody Actor actor){
        Actor responseActor = actorService.createActor(actor);
        return  ResponseEntity.ok(responseActor);
    }
}
