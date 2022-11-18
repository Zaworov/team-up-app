package com.zaworov.teamupapp.domain.player;

import java.util.ArrayList;
import java.util.Arrays;

public class PlayerTestDataHelper {

    private PlayerTestDataHelper(){}
    public static ArrayList<Player> createFullSquadForVolleyballGame() {
        return new ArrayList<>(Arrays.asList(
                PlayerBuilder.aVolleyballPlayer("Piotr", "Zawodniak"),
                PlayerBuilder.aVolleyballPlayer("Krzysio", "Badzik"),
                PlayerBuilder.aVolleyballPlayer("Marcin", "Froncik"),
                PlayerBuilder.aVolleyballPlayer("Ewa", "Froncik"),
                PlayerBuilder.aVolleyballPlayer("Justyna", "Dziabadziuba"),
                PlayerBuilder.aVolleyballPlayer("Marek", "Tyszko"),
                PlayerBuilder.aVolleyballPlayer("Marek", "Klawesyn"),
                PlayerBuilder.aVolleyballPlayer("Kuba", "Piweczko"),
                PlayerBuilder.aVolleyballPlayer("Franciszek", "Wiecha"),
                PlayerBuilder.aVolleyballPlayer("Jan", "Janeczko"),
                PlayerBuilder.aVolleyballPlayer("Bartosz", "Kluska"),
                PlayerBuilder.aVolleyballPlayer("Jan", "Nadzieja")));
    }
}
