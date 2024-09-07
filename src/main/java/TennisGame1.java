import enums.Equality;
import enums.GameResult;
import enums.Winner;

import java.util.HashMap;
import java.util.Map;

public class TennisGame1 implements TennisGame {
    private final String player1Name;
    private final String player2Name;
    private final Map<String, Integer> players;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        players = new HashMap<>(Map.of(player1Name, 0, player2Name, 0));
    }

    public void wonPoint(String playerName) {
        players.put(playerName, players.get(playerName) + 1);
    }

    public String getScore() {
        String score = "";
        switch (GameResult.gameState(players.get(player1Name), players.get(player2Name))) {
            case DRAW -> score = Equality.forScore(players.get(player1Name));
            case MAY_BE_A_WINNER -> score = Winner.forScore(players.get(player1Name) - players.get(player2Name));
            case GAME_NOT_FINISHED -> score = buildScoreTitle();
        }
        return score;
    }

    private String buildScoreTitle() {
        int tempScore;
        String result;
        tempScore = players.get(player1Name);
        result = titleFromScore(tempScore);
        result += "-";
        tempScore = players.get(player2Name);
        result += titleFromScore(tempScore);
        return result;
    }

    private String titleFromScore(int tempScore) {
        return switch (tempScore) {
            case 0 ->  "Love";
            case 1 ->  "Fifteen";
            case 2 ->  "Thirty";
            case 3 ->  "Forty";
            default -> "";
        };
    }
}
