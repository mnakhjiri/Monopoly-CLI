import exceptions.NegativeCashException;

public abstract class Invest extends Field {
    private Player owner;
    private double cost;

    public Invest(int id, boolean colored , ColorType color) {
        super(id, colored , color);
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Player getOwner() {
        return this.owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
    public void onFieldActions(Game game , Player player) throws NegativeCashException{
        if(getOwner()!=null){
            if(!getOwner().equals(player)){
                //determine if the owner has properties with same color
                int sameColor = 0;
                for (int i = 0; i < getOwner().getProperties().size(); i++) {
                    if(getColor().equals(getOwner().getField(getOwner().getProperties().get(i)-1).getColor())){
                        sameColor++;
                    }
                }
                if(sameColor == 3){
                    setFine(getFine()*2);
                }
                System.out.printf("Rent price: %5f\n",getFine());
                player.decreaseCash(getFine());
                getOwner().increaseCash(getFine());
                
            }
        }
        
    }

}
