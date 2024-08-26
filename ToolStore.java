import java.util.Scanner;

public class ToolStore extends NormalLoc{
  private Player player;
    public ToolStore(Player player) {
        super(player,"toolstore");
        this.player = player;
    }

    @Override
    boolean onLocation() {
        System.out.println("your current location is toolstore ");
        menu();
        return true;
    }



    public void menu() {
        System.out.println("Menu");
        System.out.println("please press w for weapon menu s for shield menu");
        Scanner sc = new Scanner(System.in);
        String w = sc.nextLine();
        if (w.equals("w")) {
            System.out.println("Weapon ID Dmg Money");
            System.out.println("Gun    1   2  25");
            System.out.println("Sword  2   3  35");
            System.out.println("Rifle  3   7  45");
        } else if (w.equals("s")) {
            System.out.println("Shield ID Def Money");
            System.out.println("Light   4   1  15");
            System.out.println("Medium  5   3  25");
            System.out.println("Heavy   6   5  40");
        }
        System.out.println("Press b for buying menu");
        String a = sc.nextLine();
        if (a.equals("b")) {
            System.out.println("Please enter the ID for the item");
            int id = sc.nextInt();
            buy(id);
        }
    }
    public void buy(int id) {
        if (id == 1) {  // Gun
            if (player.getMoney() >= 25) {
                player.setDamage(player.getDamage() + 2);
                player.setMoney(player.getMoney() - 25);
                System.out.println("You bought a Gun! Damage increased by 2.");
            } else {
                System.out.println("Not enough money!");
            }
        } else if (id == 2) {  // Sword
            if (player.getMoney() >= 35) {
                player.setDamage(player.getDamage() + 3);
                player.setMoney(player.getMoney() - 35);
                System.out.println("You bought a Sword! Damage increased by 3.");
            } else {
                System.out.println("Not enough money!");
            }
        } else if (id == 3) {  // Rifle
            if (player.getMoney() >= 45) {
                player.setDamage(player.getDamage() + 7);
                player.setMoney(player.getMoney() - 45);
                System.out.println("You bought a Rifle! Damage increased by 7.");
            } else {
                System.out.println("Not enough money!");
            }
        } else if (id == 4) {  // Light Shield
            if (player.getMoney() >= 15) {
                player.setMoney(player.getMoney()-15);
                player.setHp(player.getHp()+1);
                System.out.println("You bought a Light Shield! HP increased by 1.");
            } else {
                System.out.println("Not enough money!");
            }
        } else if (id == 5) {  // Medium Shield
            if (player.getMoney() >= 25) {
                player.setMoney(player.getMoney()-25);
                player.setHp(player.getHp()+3);
                System.out.println("You bought a Medium Shield! HP increased by 3.");
            } else {
                System.out.println("Not enough money!");
            }
        } else if (id == 6) {  // Heavy Shield
            if (player.getMoney() >= 40) {
                player.setMoney(player.getMoney()-40);
                player.setHp(player.getHp()+5);
                System.out.println("You bought a Heavy Shield! HP increased by 5.");
            } else {
                System.out.println("Not enough money!");
            }
        } else {
            System.out.println("Invalid item ID!");
        }

        System.out.println("Current stats:");
        System.out.println("Money: " + player.getMoney());
        System.out.println("HP: " + player.getHp());
        System.out.println("Damage: " + player.getDamage());
    }

}
