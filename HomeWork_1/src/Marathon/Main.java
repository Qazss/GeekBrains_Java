package Marathon;

import Marathon.Competition.*;
import Marathon.Competitors.*;
import Marathon.Obstacles.*;
import Marathon.Competitors.Interface.Competitor;

public class Main {
    public static void main(String[] args) {
        Team team = new Team("Команда_1", new Competitor[]{new Human("Иван"), new Dog("Джек"), new Cat("Роб")});
        Course course = new Course(new Obstacle[]{new Cross(80), new Wall(2), new Water(20), new Cross(300)});
        course.doIt(team);
        team.showResults();
    }
}
