// imports package
package com.voting.votingapp.model;

// imports libraries(classes)

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

// marks class as  Lombok Data and Embeddable Entity
@Embeddable
@Data
@NoArgsConstructor
// creates OptionVote class
public class OptionVote {
    // class fields
    private String optionText;
    private Long voteCount = 0L;
}
