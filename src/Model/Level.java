package Model;

abstract class Level {

    private int l =1; // level

    // return actually level of the game
    public int getLevel(){
        return this.l;
    }

    //increase level
    public int increaseLvl(){
        this.l++;
        return l;
    }
    //decrease level of the game
    public int decreaseLvl(){
        this.l--;
        return l;
    }
}
