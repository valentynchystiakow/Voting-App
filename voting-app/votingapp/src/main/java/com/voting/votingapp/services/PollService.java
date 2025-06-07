// imports package
package com.voting.votingapp.services;

// imports libraries(packages)

import com.voting.votingapp.model.OptionVote;
import com.voting.votingapp.model.Poll;
import com.voting.votingapp.repositories.PollRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// marks class as Service
@Service
// creates pollService class
public class PollService {
    //  class fields
    private final PollRepository pollRepository;

    // creates PollService constructor
    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }


    // creates method that makes post request to create poll in database
    public Poll createPoll(Poll poll) {
        return pollRepository.save(poll);
    }

    // creates method that makes get request to get list of all polls
    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }

    // creates method that makes get request to get current post by id
    public Optional<Poll> getPollById(Long id) {
        return pollRepository.findById(id);
    }

    // creates method that makes post request to make vote for chosen option
    public void vote(Long pollId, int optionIndex) {
        // Get poll by id from database, in case it doesn't exist throw exception
        Poll poll = pollRepository.findById(pollId).orElseThrow(() -> new RuntimeException("Poll not found"));
        // Get all options
        List<OptionVote> options = poll.getOptions();
        // validates option index
        if (optionIndex < 0 || optionIndex >= options.size()) {
            throw new RuntimeException("Invalid option index");
        }
        // Get option by index
        OptionVote selectedOption = options.get(optionIndex);
        // Increment option by 1
        selectedOption.setVoteCount(selectedOption.getVoteCount() + 1);
        // Save poll in database
        pollRepository.save(poll);
    }
}
