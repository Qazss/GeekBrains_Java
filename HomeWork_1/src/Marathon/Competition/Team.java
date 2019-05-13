package Marathon.Competition;

import Marathon.Competitors.Interface.Competitor;

public class Team {
    private String name;
    protected Competitor[] competitors;

    public Team(String name, Competitor[] competitors){
        this.competitors = competitors;
        this.name = name;
    }

    public void showResults() {
        System.out.println();
        for (Competitor a : competitors) {
                a.info();
        }
    }
}