package com.example.hrms.models.employment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "postingBranchName")
public class PostingBranchName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postingBranchId;

    private String postingBranchName;

//    @ManyToOne
//    @JoinColumn(referencedColumnName = "placeOfPostingId", name = "placeOfPostingId")
//    private PlaceOfPosting placeOfPosting;
}
