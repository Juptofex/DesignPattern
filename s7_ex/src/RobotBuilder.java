public class RobotBuilder {
    private int life = 100;
    private int canon = 1;
    private int shield = 1;
    private int freq = 100;
    private String name = "Robot";

    public RobotBuilder setLife(int life) {
        this.life = life;
        return this;
    }

    public RobotBuilder setCanon(int canon) {
        this.canon = canon;
        return this;
    }

    public RobotBuilder setShield(int shield) {
        this.shield = shield;
        return this;
    }

    public RobotBuilder setFreq(int freq) {
        this.freq = freq;
        return this;
    }

    public RobotBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public Robot build() {
        return new BasicRobot(life, canon, shield, freq, name);
    }
}
