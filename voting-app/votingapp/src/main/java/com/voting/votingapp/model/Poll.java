//imports package
package com.voting.votingapp.model;

// imports libraries

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


// marks class as Spring JPA Entity and Lombok Data
@Entity
@Data
@NoArgsConstructor
// creates Poll class
public class Poll {
    // class fields
    // marks field as primary id with identity generation type
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
    private String question;

    @ElementCollection
    private List<OptionVote> options = new ArrayList<>();


}
