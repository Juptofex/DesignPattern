public class DoubleShieldDecorator extends RobotDecorator {
    public DoubleShieldDecorator(Robot robot) {
        super(robot);
    }

    @Override
    public int getShield() {
        return robot.getShield() * 2;
    }
}
