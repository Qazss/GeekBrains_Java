package Marathon.Competitors;
import Marathon.Competitors.Implementation.Implementation;
import Marathon.Competitors.Interface.Competitor;

public class Animal implements Competitor {
    private String type;
    private String name;

    private int maxRunDistance;
    private int maxJumpHeight;
    private int maxSwimDistance;

    private boolean onDistance;

    private Implementation implementation;

    public Animal(String type, String name, int maxRunDistance, int maxJumpHeight, int maxSwimDistance) {
        this.type = type;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.maxSwimDistance = maxSwimDistance;
        this.onDistance = true;

        implementation = new Implementation(type, name);
    }

    @Override
    public boolean isOnDistance() {
        onDistance = implementation.implementIsOnDistance();
        return onDistance;
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

    public void setOnDistance(boolean onDistance){
        this.onDistance = onDistance;
    }
}
