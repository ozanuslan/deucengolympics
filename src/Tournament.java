public class Tournament {
    Sport sport;
    Match[] MATCHES;

    public Tournament(Sport sport) {
        this.sport = sport;
        int matchCount = (this.sport.ATHLETES_BY_SPORT.length * (this.sport.ATHLETES_BY_SPORT.length - 1)) / 2;
        MATCHES = new Match[matchCount];
    }

    public Match[] generateMatches() {
        int hour = 11;
        int day = 24;
        int month = 7;
        int year = 2020;
        int matchIndex = 0;
        int x = 0;
        // VV this refers to 2020 having 29 days in february
        int[] daysPerMonth = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        for (int i = 0; i < sport.ATHLETES_BY_SPORT.length; i++) {
            x++;
            for (int j = 0; j < sport.ATHLETES_BY_SPORT.length; j++) {
                if (x + j <= sport.ATHLETES_BY_SPORT.length-1) {
                    MATCHES[matchIndex] = new Match(sport.ATHLETES_BY_SPORT[j], sport.ATHLETES_BY_SPORT[j + x]);
                    MATCHES[matchIndex].date = new Date(day, month, year, hour);
                    MATCHES[matchIndex].determineWinner();
                    matchIndex++;
                    hour += 2;
                }
                if (hour > 15) {
                    hour = 11;
                    day++;
                    if (day > daysPerMonth[month - 1]) {
                        day = 1;
                        month++;
                        if (month > 12) {
                            month = 1;
                            year++;
                            if (year % 4 == 0) {
                                daysPerMonth[1] = 29;
                            } else {
                                daysPerMonth[1] = 28;
                            }
                        }
                    }
                }
            }
        }
        return MATCHES;
    }
}