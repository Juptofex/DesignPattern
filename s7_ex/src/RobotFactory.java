public class RobotFactory {
    
    public static Robot createPicVert() {
        return new RobotBuilder()
            .setName("Pic-Vert")
            .setLife(100)
            .setCanon(3)
            .setShield(2)
            .setFreq(30)
            .build();
    }
    
    public static Robot createGrosseBerta() {
        return new RobotBuilder()
            .setName("Grosse Berta")
            .setLife(100)
            .setCanon(25)
            .setShield(5)
            .setFreq(200)
            .build();
    }
    
    public static Robot createTank() {
        return new RobotBuilder()
            .setName("Tank")
            .setLife(250)
            .setCanon(5)
            .setShield(10)
            .setFreq(150)
            .build();
    }
}
