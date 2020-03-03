public class Sport {
    String sport;
    Athlete[] ATHLETES_BY_SPORT;
    int index; // Index of the athlete being put in the athletes_by_sport array
    int playerCount;

    public Sport(String sport) {
        this.sport = sport;
        this.playerCount = 0;
        this.index = 0;
    }

    public String getSport() {
        return sport;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void initAthleteArrElems() {
        for (int i = 0; i < ATHLETES_BY_SPORT.length; i++) {
            ATHLETES_BY_SPORT[i] = new Athlete();
        }
    }

    public void initAthleteArr() {
        ATHLETES_BY_SPORT = new Athlete[playerCount];
        initAthleteArrElems();
    }

    public void incrementIndex() {
        index++;
    }

    public void incrementPlayerCount() {
        playerCount++;
    }
}