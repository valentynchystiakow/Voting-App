// imports package
package com.voting.votingapp.repositories;

//imports classes(libraries)
import com.voting.votingapp.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// marks class as JPA Repository
@Repository
// creates PollRepository interface that extends main JPA Repository
public interface PollRepository extends JpaRepository<Poll,Long> {
}
