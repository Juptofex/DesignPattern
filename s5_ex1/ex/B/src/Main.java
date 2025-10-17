public class Main {

  public static void main(String[] args) {
    DwarvenGoldmine jjGoldmine = new DwarvenGoldmine();
    jjGoldmine.startNewDay();
    jjGoldmine.digOutGold();
    jjGoldmine.endDay();
  }
}

//Pattern 1: Template Method (state ...)
//Pattern 2: Command (action ...)