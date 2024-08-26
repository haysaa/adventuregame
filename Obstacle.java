import java.util.Random;
public class Obstacle {
    private int id;
    private int damage;
    private int hp;
    private int reward,maxNumber;
    private String name;
    public Obstacle(int id,String name, int damage, int hp, int reward,int maxNumber) {
        this.id = id;
        this.damage = damage;
        this.hp = hp;
        this.name=name;
        this.maxNumber=maxNumber;
        this.reward=reward;
    }
    public int count() {
        Random r = new Random();
        return r.nextInt(this.maxNumber) + 1;
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
