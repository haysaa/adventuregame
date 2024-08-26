public class SafeHouse extends NormalLoc{
   private Player player;

    @Override
    boolean onLocation() {
        System.out.println("You are in the safehouse");
        regenerateHp();
        return true;
    }
    public SafeHouse(Player player) {
        super(player,"SafeHouse");
    }
    public void regenerateHp(){
        if(player.getHp()< player.getMaxhp()){
            player.setHp(player.getMaxhp());
        }
        else{
            System.out.println("You already have a hp of "+player.getMaxhp());
        }
    }
}
