package com.zaworov.teamupapp.domain.score;

import com.zaworov.teamupapp.domain.team.TeamInterface;

public interface ScoreInterface {
    ScoreInterface getScore();
    void setScore();
    void IncreaseWinningSets(TeamInterface team);
    void IncreaseWinningPoints(TeamInterface team);
}
