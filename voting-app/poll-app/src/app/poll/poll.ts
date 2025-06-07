//imports classes(libraries)
import { Component, OnInit } from '@angular/core';
import { PollService } from '../poll.service';
import { Poll } from '../poll.models';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
// marks class as component decorator
@Component({
  selector: 'app-poll',
  imports: [CommonModule, FormsModule],
  templateUrl: './poll.html',
  styleUrl: './poll.css'
})
// exports the Poll class component that implements the OnInit interface
export class PollComponent implements OnInit {
  
  // creates newPoll model of type Poll for storing new created Poll
  newPoll: Poll = {id: null,question: '', options: [{optionText: '', voteCount: 0}, {optionText: '', voteCount: 0}]};
  
  // creates variable polls of type Poll[]
  polls: Poll[] = [];
  
  // class constructor - initjects PollService
  constructor(private pollService: PollService) {

  }

  // creates method that is called when the component is initialized
  ngOnInit(): void {
    this.loadPolls();
  }

   // creates method that loads the polls component from the server
   loadPolls() {
    // calls method that gets all polls and subscribes to it in order to get the data, in case of error, logs the error
    this.pollService.getPolls().subscribe({
        next: (data) => {this.polls = data;},
        error: (error) => {console.error("Error while fetching polls: ", error);}
        
    });
  }

 

  // creates method that creates new Poll by clicking the button and pushes it to the backend
  createPoll() {
    // calls method that creates a poll and subscribes to it in order to get the data, in case of error, logs the error, resets poll after it creating
    this.pollService.createPoll(this.newPoll).subscribe({
        next: (createdPoll) => {this.polls.push(createdPoll); this.resetPoll();}, 
        error: (error) => {console.error("Error while fetching polls: ", error);}
    });
  }

  // creates method that ads new Option for Pole and pushes it to the back end
  addOption() {
    this.newPoll.options.push({optionText: '', voteCount: 0});
  }

  // creates method that resets Poll after creating it
  resetPoll() {
    this.newPoll = {id: 
      null,question: '', options: [{optionText: '', voteCount: 0}, {optionText: '', voteCount: 0}]};
  }

  // creates method that makes vote by clicking on option
  vote(pollId: number,optionIndex:number) {
      this.pollService.vote(pollId,optionIndex).subscribe({
        next:() => {
          const poll = this.polls.find(p=>p.id === pollId);
          if (poll) { 
            poll.options[optionIndex].voteCount++;
          }
        },
        error: (error) => {
          console.error("Error while making vote on a pole",error);
        }
      });
  }

  // creates method that tracks the index of each poll
  trackByIndex(index: number) : number {
    return index;
  }    
}
