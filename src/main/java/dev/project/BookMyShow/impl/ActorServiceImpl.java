package dev.project.BookMyShow.impl;

import dev.project.BookMyShow.dto.ActorDTO;
import dev.project.BookMyShow.entity.Actor;
import dev.project.BookMyShow.repository.ActorRepository;
import dev.project.BookMyShow.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorServiceImpl implements ActorService{
    @Autowired
    private  ActorRepository actorRepo;

    @Override
    public Actor createActor(Actor actor) {
        return  actorRepo.save(actor);
    }
}
