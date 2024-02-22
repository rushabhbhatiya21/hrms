package com.example.hrms.models.employment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "placeOfPosting")
public class PlaceOfPosting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long placeOfPostingId;

    private String placeOfPostingName;

    @ManyToOne
    @JoinColumn(referencedColumnName = "postingBranchId", name = "postingBranchId")
    private PostingBranchName postingBranchName;
}
