package com.okta.mongodb.mongodbouth.model;



import javax.persistence.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String name;
    public Integer year;
    public String genre;


}
