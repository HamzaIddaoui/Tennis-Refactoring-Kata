package enums;

import java.util.Arrays;
import java.util.function.Predicate;

public enum Winner {
    ADVANTAGE_PLAYER1(score -> score == 1, "Advantage player1"),
    ADVANTAGE_PLAYER2(score -> score == -1, "Advantage player2"),
    PLAYER1_WON(score -> score >= 1, "Win for player1"),
    PLAYER2_WON(score -> true, "Win for player2");

    private Predicate<Integer> formula;
    private String scoreName;
    Winner(Predicate<Integer> formula, String scoreName){
        this.formula = formula;
        this.scoreName = scoreName;
    }

    public static String forScore(int score){
        return Arrays.stream(values())
                .filter(winner -> winner.formula.test(score))
                .findFirst()
                .orElseThrow()
                .scoreName;
    }
}
