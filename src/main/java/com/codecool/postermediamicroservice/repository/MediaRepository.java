package com.codecool.postermediamicroservice.repository;


import com.codecool.postermediamicroservice.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {
    Collection<Media> findAllByPostIdIn(Collection<Long> id);
}
