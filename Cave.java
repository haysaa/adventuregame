public class Cave extends BattleLoc{

   private Player player;
   public Cave(Player player) {
       super(player,"cave",new Zombie(),"food");
   }
}
