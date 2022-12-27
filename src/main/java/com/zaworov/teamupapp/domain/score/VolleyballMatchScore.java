package com.zaworov.teamupapp.domain.score;

import com.zaworov.teamupapp.domain.team.TeamInterface;

import java.util.List;
import java.util.Map;

public class VolleyballMatchScore implements ScoreInterface {
    private List<VolleyballSetScore> score;
    
    public ScoreInterface getScore() {
        return null;
    }

    
    public void setScore() {
        //is it score to end the game?
    }

    
    public void IncreaseWinningSets(TeamInterface team) {

    }

    
    public void IncreaseWinningPoints(TeamInterface team) {

    }

    public void setScore(VolleyballSetScore setScore) {
        score.put(set, points);
    }

    toString();
}
