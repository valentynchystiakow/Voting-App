//imports package
package com.voting.votingapp.request;

//imports libraries(classes)

import lombok.Data;
import lombok.NoArgsConstructor;

//marks class as Lombok Data
@Data
@NoArgsConstructor
// creates Vote class
public class Vote {
    //class fields
    private Long pollId;
    private int optionIndex;
}
