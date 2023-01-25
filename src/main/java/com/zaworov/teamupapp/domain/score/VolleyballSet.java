package com.zaworov.teamupapp.domain.score;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VolleyballSet {
    private static final int MAX_DIFFERENCE = 2;
    private static final int LAST_SET_NUMBER = 5;
    int setNumber;
    int teamAScore;
    int teamBScore;

    boolean isFinished = false;

    boolean isTieBreak = false;

    public VolleyballSet(){

    }
    public VolleyballSet(int setNumber, int teamAScore, int teamBScore) {
        try {
            checkIfValid(teamAScore, teamBScore);
        } catch (InvalidScoreException exception) {
            return; //todo I could probably handle it better
        }
        if (setNumber == LAST_SET_NUMBER) isTieBreak = true;
        checkIfFinished(teamAScore, teamBScore, isTieBreak);
        this.setNumber = setNumber;
        this.teamAScore = teamAScore;
        this.teamBScore = teamBScore;
    }

    private void checkIfFinished(int teamAScore, int teamBScore, boolean isTieBreak) {
        int pointsToWin = isTieBreak ? 15 : 25;
        if (teamAScore >= pointsToWin || teamBScore >= pointsToWin) {
            isFinished = true;
        }
    }

    protected void checkIfValid(int teamAScore, int teamBScore) throws InvalidScoreException {
        boolean isValid = true;
        List<Integer> scores = Arrays.asList(teamAScore, teamBScore);
        if (areNegative(teamAScore, teamBScore)) isValid = false;
        if (isTieBreak){
            if (anyScoreExceeds(teamAScore, teamBScore, 15)){
                isValid = !isScoreDifferenceTooBig(scores);
            }
        }
        if (anyScoreExceeds(teamAScore, teamBScore, 25)){
            isValid = !isScoreDifferenceTooBig(scores);
        }
        if (!isValid) throw new InvalidScoreException();
    }

    protected boolean isSetFinished(VolleyballSet set){
        return isFinished;
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

    public int getTeamBScore() {
        return teamBScore;
    }

    public int getSetNumber() {
        return setNumber;
    }

    public void setSetNumber(int setNumber) {
        this.setNumber = setNumber;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public boolean isTieBreak() {
        return isTieBreak;
    }

    public void setTieBreak(boolean tieBreak) {
        isTieBreak = tieBreak;
    }

    public void setTeamAScore(int teamAScore) {
        this.teamAScore = teamAScore;
    }
}
