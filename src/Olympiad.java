public class Olympiad {
    static Tournament[] TOURNAMENTS;
    static Sport[] SPORTS;
    static int tournamentCount;
    public Olympiad(Sport[] SPORTS_ARR){
        SPORTS = SPORTS_ARR;
        tournamentCount = SPORTS.length;
        TOURNAMENTS = new Tournament[tournamentCount];
    }
    public static Tournament[] generateFixture() {
        for(int i = 0; i < tournamentCount; i++){
            int startingDay = 24;
            int startingMonth = 7;
            int startingYear = 2020;
            TOURNAMENTS[i] = new Tournament(SPORTS[i]);
        }
        
        return TOURNAMENTS;
    }

    public static void performTournament() {

    }
}