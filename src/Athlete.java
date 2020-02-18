public class Athlete {
    String country;
    String sport;
    String name;
    String birthdate;
    String gender;
    double skill;
    int point;
    
    public Athlete(String country, String sport, 
    String name, String birthdate,String gender, 
    Double skill){
        this.country = country;
        this.sport = sport;
        this.name = name;
        this.birthdate = birthdate;
        this.gender = gender;
        this.skill = skill;
        point = 0;
    }

    public String getCountry() {
        return country;
    }

    public String getSport() {
        return sport;
    }

    public String getName() {
        return name;
    }

    
    public String getGender() {
        return gender;
    }

    public String getBirthDate() {
        return birthdate;
    }

    public double getSkill() {
        return skill;
    }

    public int getPoint() {
        return point;
    }

    public void incrementPoint() {
        point++;
    }
}