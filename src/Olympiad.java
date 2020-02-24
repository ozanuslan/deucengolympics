public class Olympiad {
    public Tournament[] TOURNAMENTS;
    public Sport[] SPORTS;
    public Country[] COUNTRIES;
    public static int tournamentCount;


    public Olympiad(Sport[] SPORTS_ARR, Country[] COUNTRIES_ARR) {
        this.SPORTS = SPORTS_ARR;
        COUNTRIES = COUNTRIES_ARR;
        tournamentCount = SPORTS.length;
        TOURNAMENTS = new Tournament[tournamentCount];
    }

    public Tournament[] generateTourments() {
        for (int i = 0; i < tournamentCount; i++) {
            TOURNAMENTS[i] = new Tournament(SPORTS[i]);
            TOURNAMENTS[i].generateMatches();
        }

        return TOURNAMENTS;
    }
}