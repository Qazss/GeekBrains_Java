package Marathon.Competitors;

import Marathon.Competitors.Implementation.Implementation;
import Marathon.Competitors.Interface.Competitor;

public class Human implements Competitor {
    private String name;
    private final String type = " ";

    private int maxRunDistance;
    private int maxJumpHeight;
    private int maxSwimDistance;

    private boolean onDistance;

    private Implementation implementation;

    public Human(String name) {
        this.name = name;
        this.maxRunDistance = 5000;
        this.maxJumpHeight = 30;
        this.maxSwimDistance = 200;

        implementation = new Implementation(type, name);
    }

    @Override
    public boolean isOnDistance() {
        return implementation.implementIsOnDistance();
    }

    @Override
    public void run(int dist) {
        implementation.implementRun(dist, maxRunDistance);
    }

    @Override
    public void jump(int height) {
        implementation.implementJump(height, maxJumpHeight);
    }

    @Override
    public void swim(int dist) {
        implementation.implementSwim(dist, maxSwimDistance);
    }

    @Override
    public void info() {
        implementation.implementInfo();
    }
}
