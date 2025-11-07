public class HalfDamageDecorator extends RobotDecorator {
    public HalfDamageDecorator(Robot robot) {
        super(robot);
    }

    @Override
    public int diffLife(int i) {
        if (i < 0) {
            return robot.diffLife(i / 2);
        }
        return robot.diffLife(i);
    }
}
