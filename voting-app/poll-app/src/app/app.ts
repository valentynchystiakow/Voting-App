// imports classes(libraries)
import { Component } from '@angular/core';
import { PollComponent } from './poll/poll';

//marks class as component decorator - main app component
@Component({
  selector: 'app-root',
  imports: [PollComponent],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected title = 'poll-app';
}
