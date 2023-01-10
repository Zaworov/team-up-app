package com.zaworov.teamupapp.domain.score;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VolleyballSetScore {
    private static final int MAX_DIFFERENCE = 2;
    int teamAScore;
    int teamBScore;

    boolean isTieBreak = false;

    public VolleyballSetScore(){

    }
    public VolleyballSetScore(int setNumber, int teamAScore, int teamBScore) {
        if (!isScoreValid(teamAScore, teamBScore)) throw new RuntimeException("Score is not valid");
    }

    protected boolean isScoreValid(int teamAScore, int teamBScore) {
        List<Integer> scores = Arrays.asList(teamAScore, teamBScore);
        if (areNegative(teamAScore, teamBScore)) return false;
        if (isTieBreak){
            if (anyScoreExceeds(teamAScore, teamBScore, 15)){
                return !isScoreDifferenceTooBig(scores);
            }
        }
        if (anyScoreExceeds(teamAScore, teamBScore, 25)){
            return !isScoreDifferenceTooBig(scores);
        }
        return true;
    }

    private boolean isScoreDifferenceTooBig(List<Integer> scores) {
        int scoresDifference = getScoresDifference(scores);
        return scoresDifference > MAX_DIFFERENCE;
    }

    private int getScoresDifference(List<Integer> scores) {
        Collections.sort(scores);
        return scores.get(1) - scores.get(0);
    }

    protected boolean isDifferenceEnoughToWin(List<Integer> scores) {
        //it checks only difference, not whether reached 25/15 points
        if (scores.size() != 2) return false;
        return (getScoresDifference(scores) >= MAX_DIFFERENCE);
    }

    protected boolean anyScoreExceeds(int teamAScore, int teamBScore, int maxSetPoints) {
        return (teamAScore > maxSetPoints || teamBScore > maxSetPoints);
    }

    protected boolean areNegative(int teamAScore, int teamBScore) {
        return (teamAScore < 0 || teamBScore < 0);
    }

    public int getTeamAScore() {
        return teamAScore;
    }

    public void setTeamAScore(int teamAScore) {
        this.teamAScore = teamAScore;
    }
}
