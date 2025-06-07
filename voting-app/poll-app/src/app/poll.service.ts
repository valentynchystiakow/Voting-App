// imports classes(libraries)
import { Poll } from './poll.models';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

// marks class as injectable
@Injectable({
  providedIn: 'root'
})

// exports Poll class
export class PollService {
  // sets base url of the api
  private baseUrl = 'http://localhost:5454/api/polls';
  // class constructor - injects HttpClient
  constructor(private http: HttpClient) { 
  }
  // creates method that creates a poll, Observable of type Poll
  createPoll(poll: Poll): Observable<Poll> {
    return this.http.post<Poll>(this.baseUrl, poll);
  }

  // creates method that gets all polls, Observable of type Poll[]
  getPolls(): Observable<Poll[]> {
    return this.http.get<Poll[]>(this.baseUrl);
  }

  //creates method vote on a poll, Observable of type Poll
  vote(pollId: number, optionIndex: number) : Observable<void> {
    const url = `${this.baseUrl}/vote`;
    return this.http.post<void>(url, { pollId, optionIndex });
  }
}


