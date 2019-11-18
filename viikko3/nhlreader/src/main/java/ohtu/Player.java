
package ohtu;

public class Player {
    private String name;
    private String nationality;
    private int goals;
    private int assists;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNationality(String  nationality) {
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getGoals() {
        return goals;
    }

    public void setAssists(int assists) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }


    public int getPoints() {return goals+assists;}


    @Override
    public String toString() {
        return name +" "+ goals + " + " + assists + " = " + getPoints();
    }
      
}
