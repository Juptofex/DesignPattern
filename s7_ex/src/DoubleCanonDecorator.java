public class DoubleCanonDecorator extends RobotDecorator {
    public DoubleCanonDecorator(Robot robot) {
        super(robot);
    }

    @Override
    public int getCanon() {
        return robot.getCanon() * 2;
    }
}
