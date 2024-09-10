import tennis2enums.GameState;

import java.util.HashMap;
import java.util.Map;

public class TennisGame2 implements TennisGame {
    public static final String LOVE = "Love";
    public static final String FIFTEEN = "Fifteen";
    public static final String THIRTY = "Thirty";
    public static final String FORTY = "Forty";
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;
    private Map<String, Integer> playersScore = new HashMap<>();

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        playersScore.putAll(Map.of(player1Name, 0, player2Name, 0));
    }

    public String getScore() {
        String score = "";
        switch (GameState.forScores(playersScore.get(player1Name), playersScore.get(player2Name))) {
            case PLAYER1_WITH_HIGHER_SCORE -> score = buildScoreWhenPlayer1HasHigherScore();
            case PLAYER2_WITH_HIGHER_SCORE -> score = buildScoreWhenPlayer2HasHigherScore();
            case PLAYERS_WITH_SAME_SCORE -> score = buildDrawScore();
        }
        return score;
    }

    private String buildScoreWhenPlayer2HasHigherScore() {
        P2res = titleByScore(playersScore.get(player2Name));
        P1res = titleByScore(playersScore.get(player1Name));
        String result = "";
        if (playersScore.get(player2Name) < 4) {
            result = P1res + "-" + P2res;
        }
        if (playersScore.get(player2Name) >= 4) {
            result = (playersScore.get(player2Name) - playersScore.get(player1Name)) >= 2 ? "Win for player2" : "Advantage player2";
        }
        return result;
    }

    private String buildScoreWhenPlayer1HasHigherScore() {
        P1res = titleByScore(playersScore.get(player1Name));
        P2res = titleByScore(playersScore.get(player2Name));
        String result = "";
        if (playersScore.get(player1Name) < 4) {
            result = P1res + "-" + P2res;
        }
        if (playersScore.get(player1Name) >= 4) {
            result = (playersScore.get(player1Name) - playersScore.get(player2Name)) >= 2 ? "Win for player1" : "Advantage player1";
        }
        return result;
    }

    private String buildDrawScore() {
        String result;
        result = titleByScore(playersScore.get(player1Name));
        if (playersScore.get(player1Name) < 4) {
            result += "-All";
        }
        if (playersScore.get(player1Name) >= 3) {
            result = "Deuce";
        }
        return result;
    }

    private String titleByScore(int score) {
        return switch (score) {
            case 0 -> LOVE;
            case 1 -> FIFTEEN;
            case 2 -> THIRTY;
            case 3 -> FORTY;
            default -> "";
        };
    }

    public void SetP1Score(int number) {

        for (int i = 0; i < number; i++) {
            P1Score();
        }

    }

    public void SetP2Score(int number) {

        for (int i = 0; i < number; i++) {
            P2Score();
        }

    }

    public void P1Score() {
        playersScore.put(player1Name,playersScore.get(player1Name) + 1);
    }

    public void P2Score() {
        playersScore.put(player2Name,playersScore.get(player2Name) + 1);
    }

    public void wonPoint(String player) {
        playersScore.put(player, playersScore.get(player) + 1);
    }
}