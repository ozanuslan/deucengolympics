class Athlete{
    String country;
    String sport;
    String name;
    String birthdate;
    double skill;
    int point;

    public Athlete(String country, String sport, String name, String birthdate, double skill, int point){
        this.country = country;
        this.sport = sport;
        this.name = name;
        this.birthdate = birthdate;
        this.skill = skill;
        this.point = point;
    }

    public String getCountry(){
        return country;
    }

    public String getSport(){
        return sport;
    }

    public String getName(){
        return name;
    }

    public String getBirthDate(){
        return country;
    }

    public double getSkill(){
        return skill;
    }

    public int getPoint(){
        return point;
    }

    public void incrementPoint(){
        point++;
    }
}