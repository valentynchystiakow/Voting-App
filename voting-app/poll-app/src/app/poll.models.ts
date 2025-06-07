//exports the Vote inteface
export interface OptionVote {
    // interface fields
    optionText: string;
    voteCount: number;
}

// exports the Poll interface
export interface Poll {
    // inteface fields
    id: any;
    question: string;
    options: OptionVote[];
}
