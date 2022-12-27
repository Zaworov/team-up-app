package com.zaworov.teamupapp.domain.score;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VolleyballSetScore {
    int teamAScore;
    int teamBScore;

    boolean isTieBreak = false;
    public VolleyballSetScore(int setNumber, int teamAScore, int teamBScore) {
        isScoreValid(teamAScore, teamBScore);
    }

    private void isScoreValid(int teamAScore, int teamBScore) {
        if (areNegative(teamAScore, teamBScore)) throw new RuntimeException();
        if (isTieBreak){
            if (anyScoreExceeds(teamAScore, teamBScore, 15)){
                List<Integer> scores = Arrays.asList(teamAScore, teamBScore);
                if (isDifferenceBiggerThen(scores, 2)) throw new RuntimeException("Bigger score number exceedes..." );
            }
        }
        if (anyScoreExceeds(teamAScore, teamBScore, 25)){
            
        }
    }

    private boolean isDifferenceBiggerThen(List<Integer> scores, int maxDifference) {
        Collections.sort(scores);
        return ((teamAScore - teamBScore) > maxDifference);
    }

    private boolean anyScoreExceeds(int teamAScore, int teamBScore, int maxSetPoints) {
        return (teamAScore > maxSetPoints || teamBScore > maxSetPoints);
    }

    private boolean areNegative(int teamAScore, int teamBScore) {
        return (teamAScore < 0 || teamBScore < 0);
    }

    public int getTeamAScore() {
        return teamAScore;
    }

    public void setTeamAScore(int teamAScore) {
        this.teamAScore = teamAScore;
    }
}
