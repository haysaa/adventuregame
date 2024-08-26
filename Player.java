import java.util.Scanner;

public class Player {
    private int damage,hp,money,id,maxhp;
    private String name,charName;
    private Inventory inv;
   public Player(String name) {
       this.name = name;
       this.inv = new Inventory();
   }

    public void selectChar() {

            System.out.println("please select a character id:");
            System.out.println("Characters:");
            System.out.println("---------------------------------------------");
            System.out.println("Samurai\tid:1 \t damage:5 \t hp:21\t money:15 ");
            System.out.println("Archer \tid:2 \t damage:7 \t hp:18\t money:20 ");
            System.out.println("Knight \tid:3 \t damage:8 \t hp:24\t money:5 ");
            System.out.println("-----------------------------------------------");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            switch (id) {
                case 1:
                    charName = "Samurai";
                    damage = 5;
                    hp = 21;
                    money = 15;
                    maxhp = 21;
                    break;
                case 2:
                    charName = "Archer";
                    damage = 7;
                    hp = 18;
                    money = 20;
                    maxhp = 18;
                    break;
                case 3:
                    charName = "Knight";
                    damage = 8;
                    hp = 24;
                    money = 5;
                    maxhp = 24;
                    break;
                default:
                    charName = "Knight";
                    damage = 7;
                    hp = 18;
                    money = 5;
                    break;
            }

        }

    public void selectLoc() {
        while (true) {
            Location location = null;
            System.out.println("----------------");
            System.out.println("ID=1\tsafehouse => hp generating");
            System.out.println("ID=2\ttoolstore => for buying items");
            System.out.println("ID=3\tcave: monster => zombie count(1-3) ");
            System.out.println("ID=4\tforest: monster -> vampire(1-3) ");
            System.out.println("ID=5\triver: monster -> bear (1-3) ");
            System.out.println("------------------>");
            System.out.println("Please select a location ID:");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            switch (id) {
                case 1:
                    location = new SafeHouse(this);
                    break;
                case 2:
                    location = new ToolStore(this);
                    break;
                case 3:
                    location = new Cave(this);
                    break;
                case 4:
                    location = new River(this);
                    break;
                default:
                    location = new SafeHouse(this);
            }

            System.out.println("--------------->");
            if (!location.onLocation()) {
                System.out.println("Game Over!");
                break;
            }
            if (this.getInv().isWater() && this.getInv().isFirewood() && this.getInv().isFood()) {
                System.out.println("Congratulations! You've collected all the items and won the game!");
                break;
            }
            }
        }


    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxhp() {
        return maxhp;
    }

    public void setMaxhp(int maxhp) {
        this.maxhp = maxhp;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }
}
