package dev.project.BookMyShow.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
     @Id
     @GeneratedValue (strategy =  GenerationType.AUTO)
     private  int id;
     private LocalDateTime createdAt;
     private LocalDateTime updateAt;
     private String createdBy; //User name
     private String updatedBy; // User name

     public BaseModel() {
          this.createdAt = LocalDateTime.now();
     }
}
