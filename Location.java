abstract class Location {
    private String location;
    private Player player;
    public Location(Player player, String location) {
        this.player = player;
        this.location = location;
    }
    abstract boolean onLocation();

     public Player getPlayer() {
         return player;
     }

     public void setPlayer(Player player) {
         this.player = player;
     }

     public String getLocation() {
         return location;
     }

     public void setLocation(String location) {
         this.location = location;
     }
 }
