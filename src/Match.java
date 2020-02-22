import java.util.Random;

public class Match {
    Athlete ath1;
    Athlete ath2;
    String winner;
    Date date;
    Random rnd = new Random();

    public Match(Athlete ath1, Athlete ath2) {
        this.ath1 = ath1;
        this.ath2 = ath2;
    }

    public String getWinner() {
        return winner;
    }

    private String setWinner(String winner) {
        this.winner = winner;
        return this.winner;
    }

    private void incrementCountryPoint(Athlete ath) {
        for (int i = 0; i < Olympiad.COUNTRIES.length; i++) {
            if (ath.getCountry().equals(Olympiad.COUNTRIES[i].country)) {
                Olympiad.COUNTRIES[i].incrementPoint();
                break;
            }
        }
    }

    public String determineWinner() {
        if (ath1.skill > ath2.skill) {
            ath1.incrementPoint();
            incrementCountryPoint(ath1);
            return setWinner(ath1.name);
        } else if (ath2.skill > ath1.skill) {
            ath2.incrementPoint();
            incrementCountryPoint(ath2);
            return setWinner(ath2.name);
        } else {
            double dice = rnd.nextDouble();
            if (dice >= 0.50) {
                ath1.incrementPoint();
                incrementCountryPoint(ath1);
                return setWinner(ath1.name);
            } else {
                ath2.incrementPoint();
                incrementCountryPoint(ath2);
                return setWinner(ath2.name);
            }
        }
    }
}