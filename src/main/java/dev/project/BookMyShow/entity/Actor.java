package dev.project.BookMyShow.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "actor")
public class Actor extends  BaseModel{
    private String name;
    private int age;

}
