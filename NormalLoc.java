abstract class NormalLoc extends Location{
    NormalLoc(Player player,String location){
       super(player,location);
    }

    @Override
    boolean onLocation() {
        return true;
    }

}
