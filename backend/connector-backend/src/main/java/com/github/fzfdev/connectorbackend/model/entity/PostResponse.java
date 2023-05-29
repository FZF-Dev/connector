package com.github.fzfdev.connectorbackend.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class PostResponse {
    public PostResponse(Post post, User poster, String postResponseContent) {
        this.post = post;
        this.poster = poster;
        this.postResponseContent = postResponseContent;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID postResponseId;

    @JoinColumn
    @ManyToOne
    private Post post;

    @JoinColumn
    @ManyToOne
    private User poster;

    @Column
    @CreationTimestamp
    private Timestamp dateOfPosting;

    @Column
    private String postResponseContent;

    @Column
    @UpdateTimestamp
    private Timestamp timeOfEdit;
}
