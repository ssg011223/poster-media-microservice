package com.codecool.postermediamicroservice.repository;

import com.codecool.postermediamicroservice.model.PersonMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonMediaRepository extends JpaRepository<PersonMedia, Long> {
}
