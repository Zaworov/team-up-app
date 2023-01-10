package com.zaworov.teamupapp.domain.score;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VolleyballSetScoreUnitTest {

    @Test
    void isScoreValid(){
        //todo add parametrized test for below
        VolleyballSetScore volleyballSetScore = new VolleyballSetScore();

        boolean isScoreValid = volleyballSetScore.isScoreValid(24, 26);

        assertTrue(isScoreValid);
    }

    @Test
    void isNegativeScoreInvalid(){
        VolleyballSetScore volleyballSetScore = new VolleyballSetScore();

        boolean isScoreValid = volleyballSetScore.isScoreValid(-24, 26);

        assertFalse(isScoreValid);
    }

    @Test
    void isTooBigDifferenceInvalidWhenBiggerAlreadyWinning(){
        VolleyballSetScore volleyballSetScore = new VolleyballSetScore();

        boolean isScoreValid = volleyballSetScore.isScoreValid(30, 26);

        assertFalse(isScoreValid);
    }

    @Test
    void isScoresDifferenceEnoughToWinWhenAdvantage(){
        VolleyballSetScore volleyballSetScore = new VolleyballSetScore();
        List<Integer> scores = Arrays.asList(24, 26);

        boolean isDifferenceEnoughToWin = volleyballSetScore.isDifferenceEnoughToWin(scores);

        assertTrue(isDifferenceEnoughToWin);
    }

    @Test
    void isScoresDifferenceEnoughWhenStandardWinAndMinDifference(){
        VolleyballSetScore volleyballSetScore = new VolleyballSetScore();
        List<Integer> scores = Arrays.asList(25, 23);

        boolean isDifferenceEnoughToWin = volleyballSetScore.isDifferenceEnoughToWin(scores);

        assertTrue(isDifferenceEnoughToWin);
    }

    @Test
    void isScoresDifferenceEnoughToWinWhenStandardWinWithBigAdvantage(){
        VolleyballSetScore volleyballSetScore = new VolleyballSetScore();
        List<Integer> scores = Arrays.asList(10, 25);

        boolean isDifferenceEnoughToWin = volleyballSetScore.isDifferenceEnoughToWin(scores);

        assertTrue(isDifferenceEnoughToWin);
    }

    @Test
    void isScoresDifferenceEnoughWhenNotEnough(){
        VolleyballSetScore volleyballSetScore = new VolleyballSetScore();
        List<Integer> scores = Arrays.asList(24, 25);

        boolean isDifferenceEnoughToWin = volleyballSetScore.isDifferenceEnoughToWin(scores);

        assertFalse(isDifferenceEnoughToWin);
    }

    @Test
    void anyScoreExceedsWhenVolleyballMatch(){
        VolleyballSetScore volleyballSetScore = new VolleyballSetScore(1, 20, 25);

        boolean isExceeded = volleyballSetScore.anyScoreExceeds(25, 20, 25);

        assertFalse(isExceeded);
    }

    @Test
    void areNegative(){
        VolleyballSetScore volleyballSetScore = new VolleyballSetScore(1, 20, 25);

        boolean isNegative = volleyballSetScore.areNegative(-1, 5);

        assertTrue(isNegative);
    }
}