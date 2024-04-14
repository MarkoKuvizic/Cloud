package com.okta.mongodb.mongodbouth.repositories;

import com.okta.mongodb.mongodbouth.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
