import exceptions.NegativeCashException;

public class Cinema extends Invest{
    public Cinema(int id, boolean colored , ColorType color) {
        super(id, colored , color);
        setCost(200);
    }
    @Override
    public void onFieldActions(Game game, Player player) throws NegativeCashException{
        if(!player.checkIsOwner(super.getId())){
            Player owner = super.getOwner();
            //setting fine
            if(owner != null){
                int countCinema = 0;
                if(owner.checkIsOwner(14)){
                    countCinema++;
                }
                if(owner.checkIsOwner(7)){
                    countCinema++;
                }
                if(owner.checkIsOwner(3)){
                    countCinema++;
                }
                if(countCinema == 1){
                    setFine(25);
                }
                if(countCinema == 2){
                    setFine(50);
                }
                if(countCinema == 3){
                    setFine(100);
                }
                super.onFieldActions(game, player);
            }
        }
    }
}
