package tennis2enums;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiPredicate;

public enum GameState {
    PLAYER1_WITH_HIGHER_SCORE((player1Score, player2Score) -> player1Score > player2Score),
    PLAYER2_WITH_HIGHER_SCORE((player1Score, player2Score) -> player1Score < player2Score),
    PLAYERS_WITH_SAME_SCORE(Objects::equals);

    private BiPredicate<Integer, Integer> formula;

    private GameState(BiPredicate<Integer, Integer> formula) {
        this.formula = formula;
    }

    public static GameState forScores(int inputPlayer1Score, int inputPlayer2Score) {
        return Arrays.stream(values()).filter(state -> state.formula.test(inputPlayer1Score, inputPlayer2Score))
                .findFirst().orElseThrow();
    }
}
