package Marathon.Competitors.Implementation;

public class Implementation {
    private boolean onDistance = true;
    private String type;
    private String name;

    public Implementation(String type, String name){
        this.type =  type;
        this.name = name;
    }

    public boolean implementIsOnDistance() {
        return onDistance;
    }

    public void implementRun(int dist, int maxRunDistance) {
        if (dist <= maxRunDistance) {
            System.out.println(type + " " + name + " хорошо справился с кроссом");
        } else {
            System.out.println(type + " " + name + " не справился с кроссом");
            onDistance = false;
        }
    }

    public void implementJump(int height, int maxJumpHeight) {
        if (height <= maxJumpHeight) {
            System.out.println(type + " " + name + " удачно перепрыгнул через стену");
        } else {
            System.out.println(type + " " + name + " не смог перепрыгнуть стену");
            onDistance = false;
        }
    }

    public void implementSwim(int dist, int maxSwimDistance) {
        if (maxSwimDistance == 0) {
            System.out.println(type + " " + name + " не умеет плавать");
            onDistance = false;
            return;
        }
        if (dist <= maxSwimDistance) {
            System.out.println(type + " " + name + " отлично проплыл");
        } else {
            System.out.println(type + " " + name + " не смог проплыть");
            onDistance = false;
        }
    }
    public void implementInfo() {
        System.out.println(type + " " + name + " - " + onDistance);
    }
}
