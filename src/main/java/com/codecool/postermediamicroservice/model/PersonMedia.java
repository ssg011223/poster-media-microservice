package com.codecool.postermediamicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long personId;

    private String mediaRoute;

    @Enumerated(EnumType.STRING)
    private MediaTypeEnum mediaType;

}
