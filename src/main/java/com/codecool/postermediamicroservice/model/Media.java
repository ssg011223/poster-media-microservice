package com.codecool.postermediamicroservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private long postId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String mediaRoute;

    @Enumerated(EnumType.STRING)
    private MediaTypeEnum mediaType;

}
