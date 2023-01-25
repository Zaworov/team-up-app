package com.zaworov.teamupapp.domain.score;

import com.zaworov.teamupapp.domain.team.TeamInterface;

public interface ScoreInterface {
    ScoreInterface getGameScore();
    void setScore();
    void IncreaseWinningSets(TeamInterface team);
    void IncreaseWinningPoints(TeamInterface team);
}
