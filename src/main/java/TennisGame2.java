import tennis2enums.GameState;

public class TennisGame2 implements TennisGame {
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = "";
        switch (GameState.forScores(P1point, P2point)){
            case PLAYER1_WITH_HIGHER_SCORE -> {
                if (P2point == 0) {
                    P1res = titleByScoreWhenOneScoreIsZero(P1point);
                    P2res = "Love";
                }
                if (P1point < 4) {
                    if (P1point == 2)
                        P1res = "Thirty";
                    if (P1point == 3)
                        P1res = "Forty";
                    if (P2point == 1)
                        P2res = "Fifteen";
                    if (P2point == 2)
                        P2res = "Thirty";
                    score = P1res + "-" + P2res;
                }
                if (P1point >= 4) {
                    score = "Advantage player1";
                    if (P2point >= 0) {
                        if ((P1point - P2point) >= 2) {
                            score = "Win for player1";
                        }
                    }
                }
            }

            case PLAYER2_WITH_HIGHER_SCORE -> {
                if (P1point == 0) {
                    P2res = titleByScoreWhenOneScoreIsZero(P2point);
                    P1res = "Love";
                }
                if (P2point < 4) {
                    if (P2point == 2)
                        P2res = "Thirty";
                    if (P2point == 3)
                        P2res = "Forty";
                    if (P1point == 1)
                        P1res = "Fifteen";
                    if (P1point == 2)
                        P1res = "Thirty";
                    score = P1res + "-" + P2res;
                }
                if (P2point >= 4) {
                    score = "Advantage player2";
                    if (P1point >= 0) {
                        if ((P2point - P1point) >= 2) {
                            score = "Win for player2";
                        }
                    }
                }
            }

            case PLAYERS_WITH_SAME_SCORE -> {
                if (P1point < 4) {
                    if (P1point == 0)
                        score = "Love";
                    if (P1point == 1)
                        score = "Fifteen";
                    if (P1point == 2)
                        score = "Thirty";
                    score += "-All";
                }
                if (P1point >= 3) {
                    score = "Deuce";
                }
            }
        }
        return score;
    }

    private String titleByScoreWhenOneScoreIsZero(int score) {
        return switch (score) {
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
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
        P1point++;
    }

    public void P2Score() {
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}