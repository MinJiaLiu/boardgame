public class Player{

private Piece piece;
private int number_of_win;
private Name name;


//constructor
public Player(Name name, Piece piece){
   
    this.name= name;
    this.piece= piece;
    number_of_win= 0;
    
}
//return the number of win
public int getWin(){
    return number_of_win;
}

//get the piece of the player
public Piece getPiece(){
    return this.piece;
}
//return name of player
public Name getName(){
    return this.name;
}
//getting first name in string 
public String getFirstname(){
    return this.name.getfirstname();
}

//set piece of player
public void setPiece(Piece input){
    this.piece= input;
}

//return the symbol of the piece
public char getSymbol(){
    return this.piece.getSymbol();
}

//increase the win by 1

public void updateWin(){
    number_of_win += 1;
}



    
}