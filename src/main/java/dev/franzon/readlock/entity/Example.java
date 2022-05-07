package dev.franzon.readlock.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "example")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Example {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Status status;
}
