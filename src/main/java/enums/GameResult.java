package enums;

import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

public enum GameResult {
    DRAW(Objects::equals),
    MAY_BE_A_WINNER((player1score, player2score) -> player1score >= 4 || player2score >= 4),
    GAME_NOT_FINISHED((player1score, player2score) -> true);

    BiPredicate<Integer, Integer> formula;
    GameResult(BiPredicate<Integer, Integer> law){
        formula = law;
    }

    public static GameResult gameState(int score1, int score2){
        return Stream.of(DRAW, MAY_BE_A_WINNER,GAME_NOT_FINISHED)
                .filter(state -> state.formula.test(score1, score2))
                .findFirst().orElseThrow();
    }
}
