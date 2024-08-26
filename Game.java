import java.util.Scanner;

public class Game {
    private Scanner sc = new Scanner(System.in);
    public void start(){
        System.out.println("Welcome to the adventure game!");
        System.out.println("||||||||||||||||||||||||||||||");
        System.out.println("Please enter your name:");
        String name = sc.nextLine();
        Player player = new Player(name);
        System.out.println("Welcome "+player.getName());
       player.selectChar();
        System.out.println("Character is "+player.getCharName()+" damage: "+player.getDamage()+" hp: "+player.getHp()+" money: "+player.getMoney());
        player.selectLoc();

    }
}
