package dev.project.BookMyShow.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class BaseModel {
     @Id
     @GeneratedValue (strategy =  GenerationType.AUTO)
     private  int id;
     private LocalDateTime createdAt;
     private LocalDateTime updateAt;
     private String createdBy; //User name
     private String updatedBy; // User name



}
