public class PatternRobots {
	
	public static void fight(Robot robot1, Robot robot2) {
		int tick1=robot1.getFreq();
		int tick2=robot2.getFreq();
		while(robot2.diffLife(0)>0 && robot1.diffLife(0)>0) {
			int tick=Math.min(tick1, tick2);
			tick1-=tick;
			tick2-=tick;
			if (tick1==0) {// robot 1 feu
				tick1=shoot(robot1,robot2);
			}
			if (tick2==0) {// robot 2 feu
				tick2=shoot(robot2,robot1);
			}
		}
	}
	
	private static int shoot(Robot robot1, Robot robot2) {
		int dmg=Math.max(0,robot1.getCanon()-robot2.getShield());
		int lost=robot2.diffLife(0)-robot2.diffLife(-dmg);
		System.out.println(robot1.getName()+" shoots for "+lost);
		if (robot2.diffLife(0)<=0) {
			System.out.println("Kabooom "+robot2.getName());
		}
		return robot1.getFreq();
	}

	public static void main(String[] args) {
		Robot robot1 = new DoubleCanonDecorator(
				new RobotBuilder()
						.setName("Robot1")
						.setCanon(10)
						.setShield(2)
						.setFreq(100)
						.build()
		);

		Robot robot2 = new HalfDamageDecorator(
				new DoubleShieldDecorator(
						new RobotBuilder()
								.setName("Robot2")
								.setCanon(9)
								.setShield(3)
								.setFreq(90)
								.build()
				)
		);

		fight(robot1, robot2);
	}

}
