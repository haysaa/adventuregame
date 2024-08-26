import java.util.Random;
import java.util.Scanner;

abstract public class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int obstacleCount;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.obstacleCount = randomObstacle();
    }

    @Override
    boolean onLocation() {
        System.out.println("You are now at " + this.getLocation());
        System.out.println("Be careful! There are " + this.obstacleCount + " " + this.getObstacle().getName() + "s living here");
        System.out.println("<R>un or <F>ight? ");
        Scanner in = new Scanner(System.in);
        String selectCase = in.nextLine().toUpperCase();

        if (selectCase.equals("F")) {
            if (combat(this.obstacleCount)) {
                System.out.println("You cleared all the enemies in " + this.getLocation() + "!");
                // Award logic
                if (this.award.equals("Food") && !getPlayer().getInv().isFood()) {
                    System.out.println("You won " + this.award + "!");
                    getPlayer().getInv().setFood(true);
                } else if (this.award.equals("Water") && !getPlayer().getInv().isWater()) {
                    System.out.println("You won " + this.award + "!");
                    getPlayer().getInv().setWater(true);
                } else if (this.award.equals("Firewood") && !getPlayer().getInv().isFirewood()) {
                    System.out.println("You won " + this.award + "!");
                    getPlayer().getInv().setFirewood(true);
                }
                return true;
            }

            if (getPlayer().getHp() <= 0) {
                System.out.println("You died!");
                return false;
            }
        } else if (selectCase.equals("R")) {
            System.out.println("You fled from the battle!");
            return true;
        }

        return true;
    }


    public int randomObstacle() {
        Random rand = new Random();
        return rand.nextInt(3) + 1;
    }

    public boolean combat(int obsCount) {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < obsCount; i++) {
            int defObsHp = obstacle.getHp();
            playerStats();
            enemyStats();
            while (getPlayer().getHp() > 0 && obstacle.getHp() > 0) {
                System.out.print("<A>ttack or <R>un: ");
                String selCase = scan.nextLine().toUpperCase();
                if (selCase.equals("A")) {
                    System.out.println("You hit the enemy!");
                    obstacle.setHp(obstacle.getHp() - getPlayer().getDamage());
                    afterHit();
                    if (obstacle.getHp() > 0) {
                        System.out.println();
                        System.out.println("The enemy hit you!");
                        getPlayer().setHp(getPlayer().getHp() - (obstacle.getDamage() - getPlayer().getInv().getArmor()));
                        afterHit();
                    }
                } else {
                    return false;
                }
            }

            if (obstacle.getHp() <= 0) {
                System.out.println("You defeated the enemy!");
                getPlayer().setMoney(getPlayer().getMoney() + obstacle.getReward());
                System.out.println("Your current money: " + getPlayer().getMoney());
                obstacle.setHp(defObsHp);
            } else {
                return false;
            }
            System.out.println("-------------------");
        }
        return true;
    }

    public void playerStats() {
        System.out.println("Player Stats\n--------------");
        System.out.println("Health: " + getPlayer().getHp());
        System.out.println("Damage: " + getPlayer().getDamage());
        System.out.println("Money: " + getPlayer().getMoney());
        if (getPlayer().getInv().getDamage() > 0) {
            System.out.println("Weapon: " + getPlayer().getInv().getwName());
        }
        if (getPlayer().getInv().getArmor() > 0) {
            System.out.println("Armor: " + getPlayer().getInv().getaName());
        }
    }

    public void enemyStats() {
        System.out.println("\n" + obstacle.getName() + " Stats\n--------------");
        System.out.println("Health: " + obstacle.getHp());
        System.out.println("Damage: " + obstacle.getDamage());
        System.out.println("Reward: " + obstacle.getReward());
    }

    public void afterHit() {
        System.out.println("Player Health: " + getPlayer().getHp());
        System.out.println(obstacle.getName() + " Health: " + obstacle.getHp());
        System.out.println();
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public int getObstacleCount() {
        return obstacleCount;
    }

    public void setObstacleCount(int obstacleCount) {
        this.obstacleCount = obstacleCount;
    }
}


