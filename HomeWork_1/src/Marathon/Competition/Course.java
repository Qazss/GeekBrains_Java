package Marathon.Competition;

import Marathon.Competitors.Interface.Competitor;
import Marathon.Obstacles.Obstacle;

public class Course {
    private Obstacle[] obstacles;

    public Course(Obstacle[] obstacles){
        this.obstacles = obstacles;
    }

    public void doIt(Team team){
        for (Competitor c : team.competitors) {
            for (Obstacle o : obstacles) {
                o.doIt(c);
                if (!c.isOnDistance()) break;
            }
        }
    }
}
