// imports packages
package com.voting.votingapp.controllers;


//imports libraries(classes)

import com.voting.votingapp.model.Poll;
import com.voting.votingapp.request.Vote;
import com.voting.votingapp.services.PollService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// marks class as RestController
@RestController
@RequestMapping("/api/polls")
// marks class with cross-origin decorator that lets cross-origin exchange of recourses
@CrossOrigin(origins = "http://localhost:4200/")
// creates PollController class
public class PollController {
    private final PollService pollService;

    // creates PollService constructor
    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    // marks method with GetMapping annotation in order to get one Poll by id
    @GetMapping("/{id}")
    public ResponseEntity<Poll> getPoll(@PathVariable Long id) {
        return pollService.getPollById(id).map(ResponseEntity::ok).orElse(ResponseEntity.noContent().build());
    }

    // marks method with PostMapping annotation in order to make Post Request that creates poll
    @PostMapping
    public Poll createPoll(@RequestBody Poll poll) {
        return pollService.createPoll(poll);
    }

    // marks method with GetMapping annotation in order to get List of All Posts
    @GetMapping
    public List<Poll> getAllPolls() {
        return pollService.getAllPolls();
    }

    // marks method with PostMapping annotation in order to make Post Request to create vote
    @PostMapping("/vote")
    public void vote(@RequestBody Vote vote) {
        pollService.vote(vote.getPollId(), vote.getOptionIndex());
    }
}