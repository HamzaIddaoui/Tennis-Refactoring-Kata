package enums;

import java.util.Arrays;

public enum Equality {
    LOVE_ALL(0, "Love-All"),
    FIFTEEN_ALL(1, "Fifteen-All"),
    THIRTY_ALL(2, "Thirty-All"),
    DEUCE(-1, "Deuce");

    private int score;
    private String scoreName;
    Equality(int score, String scoreName) {
        this.score = score;
        this.scoreName = scoreName;
    }

    public static String forScore(int score){
        return Arrays.stream(values()).filter(element -> element.score == score)
                .findFirst().orElse(Equality.DEUCE).scoreName;
    }
}
