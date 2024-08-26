public class SafeHouse extends NormalLoc{
   private Player player;
 public SafeHouse(Player player) {
        super(player,"SafeHouse");
    this.player=player;
    }
    @Override
    boolean onLocation() {
        System.out.println("You are in the safehouse");
        regenerateHp();
        return true;
    }
   
    public void regenerateHp(){
        if(player.getHp()< player.getMaxhp()){
            player.setHp(player.getMaxhp());
            System.out.println("HP regenerated");
        }
        else{
            System.out.println("You already have a hp of "+player.getMaxhp());
        }
    }
}
