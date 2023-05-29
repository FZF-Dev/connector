package com.github.fzfdev.connectorbackend.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    @JoinColumn
    @ManyToOne
    private User poster;

    @Column
    @CreationTimestamp
    private Timestamp dateOfPosting;

    @Column
    private String bitContent;

    @JoinColumn
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<PostResponse> bitResponses;

    @JoinColumn
    @ManyToMany
    private Collection<User> likedBy;
}
