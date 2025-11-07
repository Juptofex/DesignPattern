public class BasicRobot implements Robot {
    private int life;
    private final int canon;
    private final int shield;
    private final int freq;
    private final String name;

    public BasicRobot(int life, int canon, int shield, int freq, String name) {
        this.life = life;
        this.canon = canon;
        this.shield = shield;
        this.freq = freq;
        this.name = name;
    }

    @Override
    public int getCanon() {
        return canon;
    }

    @Override
    public int getShield() {
        return shield;
    }

    @Override
    public int getFreq() {
        return freq;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int diffLife(int i) {
        life += i;
        return life;
    }
}
