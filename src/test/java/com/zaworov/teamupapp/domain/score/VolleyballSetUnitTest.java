package com.zaworov.teamupapp.domain.score;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VolleyballSetUnitTest {

    private static final String EXPECTED_INVALID_MESSAGE = "Score is not valid";
    VolleyballSet volleyballSet = new VolleyballSet();

    @Test
    void isScoreValid(){
        //todo add parametrized test for below and special exception class for invalid score InvalidScoreException
        VolleyballSet volleyballSet = new VolleyballSet();

        assertDoesNotThrow(() -> volleyballSet.checkIfValid(24, 26));
    }

    @Test
    void isNegativeScoreInvalid(){
        VolleyballSet volleyballSet = new VolleyballSet();

        Exception exception = assertThrows(InvalidScoreException.class, () -> volleyballSet.checkIfValid(-24, 26));
        String actualMessage = exception.getMessage();

        assertEquals(EXPECTED_INVALID_MESSAGE, actualMessage);
    }

    @Test
    void isTooBigDifferenceInvalidWhenBiggerAlreadyWinning(){
        VolleyballSet volleyballSet = new VolleyballSet();

        Exception exception = assertThrows(InvalidScoreException.class, () -> volleyballSet.checkIfValid(30, 26));
        String actualMessage = exception.getMessage();

        assertEquals(EXPECTED_INVALID_MESSAGE, actualMessage);
    }

    @Test
    void isScoresDifferenceEnoughToWinWhenAdvantage(){
        VolleyballSet volleyballSet = new VolleyballSet();
        List<Integer> scores = Arrays.asList(24, 26);

        boolean isDifferenceEnoughToWin = volleyballSet.isDifferenceEnoughToWin(scores);

        assertTrue(isDifferenceEnoughToWin);
    }

    @Test
    void isScoresDifferenceEnoughWhenStandardWinAndMinDifference(){
        VolleyballSet volleyballSet = new VolleyballSet();
        List<Integer> scores = Arrays.asList(25, 23);

        boolean isDifferenceEnoughToWin = volleyballSet.isDifferenceEnoughToWin(scores);

        assertTrue(isDifferenceEnoughToWin);
    }

    @Test
    void isScoresDifferenceEnoughToWinWhenStandardWinWithBigAdvantage(){
        VolleyballSet volleyballSet = new VolleyballSet();
        List<Integer> scores = Arrays.asList(10, 25);

        boolean isDifferenceEnoughToWin = volleyballSet.isDifferenceEnoughToWin(scores);

        assertTrue(isDifferenceEnoughToWin);
    }

    @Test
    void isScoresDifferenceEnoughWhenNotEnough(){
        VolleyballSet volleyballSet = new VolleyballSet();
        List<Integer> scores = Arrays.asList(24, 25);

        boolean isDifferenceEnoughToWin = volleyballSet.isDifferenceEnoughToWin(scores);

        assertFalse(isDifferenceEnoughToWin);
    }

    @Test
    void anyScoreExceedsWhenVolleyballMatch(){
        VolleyballSet volleyballSet = new VolleyballSet(1, 20, 25);

        boolean isExceeded = volleyballSet.anyScoreExceeds(25, 20, 25);

        assertFalse(isExceeded);
    }

    @Test
    void areNegative(){
        VolleyballSet volleyballSet = new VolleyballSet(1, 20, 25);

        boolean isNegative = volleyballSet.areNegative(-1, 5);

        assertTrue(isNegative);
    }

    @Test
    void shouldThrowExceptionScoreIsNotValid() {
        Exception exception = assertThrows(InvalidScoreException.class, () -> volleyballSet.checkIfValid(30, 10));
        String actualMessage = exception.getMessage();

        assertEquals(EXPECTED_INVALID_MESSAGE, actualMessage);
    }
}