package com.livestudy.week4.github;

import org.kohsuke.github.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

class GithubDashBoard {

    private static final String MY_TOKEN = "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 ";

    static void main(String[] args) throws IOException {
        GithubDashBoard githubDashBoard = new GithubDashBoard();
        githubDashBoard.printBoard();
    }

    private void printBoard() throws IOException {
        GitHub gitHub =  new GitHubBuilder().withOAuthToken(MY_TOKEN).build();
        GHRepository repository = gitHub.getRepository("whiteship/live-study"); // Repository 연결

        // IssueState ALL, OPEN, CLOSED
        List<GHIssue> issues = repository.getIssues(GHIssueState.ALL);
        List<Participant> participants = new ArrayList<>();

        for (GHIssue issue : issues) {
            List<GHIssueComment> comments = issue.getComments();
            for(GHIssueComment comment : comments) {
                Participant participant = findParticipant(participants, comment.getUser().getLogin());
                participant.hasParticipated(issue.getNumber());
            }
        }
        participants.forEach(p -> {
            System.out.println( p.userName+" : "+ p.getRate(issues.size()));
        });
    }

    private Participant findParticipant(List<Participant> participants, String userName) {
        if (isNewUser(participants, userName)) {
            Participant participant = new Participant(userName);
            participants.add(participant);
            return participant;
        } else {
            Optional<Participant> first = participants.stream().filter(p -> p.userName.equals(userName)).findFirst();
            return first.orElseThrow();
        }
    }

    private boolean isNewUser(List<Participant> participants, String userName) {
        return participants.stream().noneMatch(p -> p.userName.equals(userName));
    }

    private void test(){
        LinkedList list = new LinkedList();
    }

}
