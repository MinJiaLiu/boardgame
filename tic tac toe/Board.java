
public class Board{

private Tile[][] board;
private int dimensionr;
private int dimensionc;

//constructor 
public Board(int dimensionr,int dimensionc ){
this.dimensionr= dimensionr;
this.dimensionc= dimensionc;

//make a board of dimension by dimension size
board= new Tile[dimensionr][dimensionc];
int counter = 1;
for (int i = 0; i < dimensionr; i++) {
    for (int k = 0; k < dimensionc; k++) {
        board[i][k]= new Tile(i,k,String.valueOf(counter),' ' );
        counter++;
    }


    }
}

//print the board at current state
public void printBoard(){
    //set the seperator +--

    
    String seperator ="";
    for(int n = 0; n< this.dimensionr; n++){
        seperator += "+--";
        if(n==this.dimensionr-1){
            seperator += "+";
        }
    }
   
    //print the value in the board
    System.out.println(seperator); 
    for (int i = 0; i < this.dimensionr; i++) {
       
        for (int k = 0; k < this.dimensionc; k++) {
        
            Tile current = board[i][k];
            
    
            System.out.print("|" + current.getDisplaytile()+ ' ');
            if(k == this.dimensionc-1){
                System.out.print("|");
                System.out.println();
                System.out.println(seperator);
            }

}
    }
    




}

//print the sample board with the number for plyaer to know where to make move

public void printSampleBoard(){
 //set the seperator +--
 if(this.dimensionc*this.dimensionr < 10){
     String seperator ="";
 for(int n = 0; n< this.dimensionr; n++){
     seperator += "+--";
     if(n==this.dimensionr-1){
         seperator += "+";
     }
 }
 //print the value in the board
 System.out.println(seperator);
 for (int i = 0; i < this.dimensionr; i++) {
     for (int k = 0; k < this.dimensionc; k++) {
         Tile current = board[i][k];
 
         System.out.print("|" + current.getNumtile()+ ' ');
         if(k == this.dimensionc-1){
             System.out.print("|");
             System.out.println();
             System.out.println(seperator);
         }


}
 }
}
else{
    String seperator ="";
    for(int n = 0; n< this.dimensionr; n++){
        seperator += "+---";
        if(n==this.dimensionr-1){
            seperator += "+";
        }
    }
    //print the value in the board
    System.out.println(seperator);
    for (int i = 0; i < this.dimensionr; i++) {
        for (int k = 0; k < this.dimensionc; k++) {
            Tile current = board[i][k];
            if(Integer.parseInt(current.getNumtile())< 10){
            System.out.print("|" + current.getNumtile()+ ' '+ ' ');
            }
            else{
                System.out.print("|" + current.getNumtile()+ ' ');
            }
            if(k == this.dimensionc-1){
                System.out.print("|");
                System.out.println();
                System.out.println(seperator);
            }
        }
    }
}

}
//place a piece at the given tile
public void placeMove(String tile,char symbol){
    for (int i = 0; i < this.dimensionr; i++) {
        for (int k = 0; k < this.dimensionc; k++) {
            Tile current = board[i][k];
            //check if current tile is equal to the given tile
            if(current.getNumtile().equals(tile) ){
            
            //set tile to the piece 
            current.setDisplaytile(symbol);
            }
    


    }
}
}

// //Win condition 
// public boolean Win(char symbol,int winrequirement){
//     Boolean result =false;
//     Boolean rowequal=false;
//     for (int i = 0; i < this.dimensionr; i++) {
//         for (int k = 0; k < this.dimensionc; k++) {
//             //check acrocss the row
            
//             Tile current = board[i][k];
//             int checkrow = i+winrequirement-1;
//             rowequal= (current.getDisplaytile()== symbol);
//             if((checkrow < this.dimension)&& rowequal){
//                 for(int x =i; x < checkrow; x++){
//                     Tile here = board[i][x];
//                     rowequal = (here.getDisplaytile() == current.getDisplaytile())&& rowequal;
//                 }
                
//             }
//         }
//     }
//     return rowequal;

// }

// Win condition
public boolean Win (char symbol){
    return winColumn(symbol) || winDiagonal(symbol)||winRow(symbol);
    

}



//check if there is win in column 
public boolean winColumn(char symbol){
    Boolean result = true ;
    for (int k = 0; k < this.dimensionc; k++) {
        int counter= 0;
        result = true;
        while (counter<this.dimensionr){
            Tile current = board[counter][k];
            result = result&& (symbol == current.getDisplaytile());
            counter++;
            if(counter == this.dimensionr){
                if(result == true){
                    return true;
                }
            }
            
        }
    }
    return false;
}

//check if there is a row win
public boolean winRow(char symbol){
   
    Boolean result = true ;
    for (int k = 0; k < this.dimensionr; k++) {
        int counter= 0;
        result = true;
        while (counter<this.dimensionc){
            Tile current = board[k][counter];
            result = result&& (symbol == current.getDisplaytile());
            counter++;
            if(counter == this.dimensionc){
                if(result == true){
                    return true;
                }
            }
            
        }
    }
    return false;
}
    


// //check if there is a diagonal win
public boolean winDiagonal(char symbol){
    boolean result= true;
    int dimension = 0;
    if (this.dimensionr<= this.dimensionc){
        dimension = this.dimensionr;
    }
    else{;
        dimension= this.dimensionc;
    }
    
    for(int i=0; i<dimension; i++){
        Tile current = board[i][i];
        result = result && (symbol == current.getDisplaytile());
    }
    if(result == true){
        return result;
    }
    result =true; 
    int counter = dimension-1;
    for(int k = 0;k < dimension; k++){
       
        Tile current = board[k][counter];
        result = result && (symbol == current.getDisplaytile());
        counter --;
        
    }
    return result;

    }


    //public wincondtion for chaos by splitting board into 4 corners and feeding it into win()
    public boolean winaltered(int d,char symbol){
        // Tile [][] upperleft= new Tile[d][d];
        // Tile [][] upperright= new Tile[d][d];
        // Tile [][] lowerleft= new Tile[d][d];
        // Tile [][] lowerright = new Tile [d][d];

        Board upperleft= new Board(d,d);
        Board upperright= new Board(d,d);
        Board lowerleft= new Board(d,d);
        Board lowerright= new Board(d,d);

        //upperleft corner
        for(int i = 0; i< d; i++){
            for (int k = 0; k<d;k++){
                Tile original= board[i][k];
                
                upperleft.board[i][k] = new Tile(i,k,original.getNumtile(),original.getDisplaytile());
            }

        }
        //upperright corner
        for(int i =0; i< d; i++){
            for (int k = 1; k<d+1;k++){
                // System.out.println(i+ " " + k);
                Tile original= board[i][k];
               
                upperright.board[i][k-1] = new Tile(i,k,original.getNumtile(),original.getDisplaytile());
                

                // upperright.printBoard();
            }

        }

        //lowerleft
        for(int i =1; i< d+1; i++){
            for (int k = 0; k<d;k++){
                Tile original= board[i][k];
                lowerleft.board[i-1][k]= new Tile(i,k,original.getNumtile(),original.getDisplaytile());
            }

        }
        //lowerright
        for(int i =1; i< d+1; i++){
            for (int k = 1; k<d+1;k++){
                Tile original= board[i][k];
                lowerright.board[i-1][k-1] = new Tile(i,k,original.getNumtile(),original.getDisplaytile());
            }

        }

        // upperright.printBoard();
        
        return lowerleft.Win(symbol) || upperleft.Win(symbol)|| upperright.Win(symbol) || lowerright.Win(symbol);



    }
   
   
    

//check if the current tile is empty
public boolean isEmpty (String tile){
    
    for (int i = 0; i < this.dimensionr; i++) {
        for (int k = 0; k < this.dimensionc; k++) {
            Tile current = board[i][k];
            //check if current tile is equal to the given tile
            if(current.getNumtile().equals(tile) ){
                // System.out.println("gere");
            //set tile to the piece 
                return (current.getDisplaytile() == ' ');
            }
    

        }
    }
    return false;
    }

// //check if board is full

public boolean isFull (){

    for (int i = 0; i < this.dimensionr; i++) {
        for (int k = 0; k < this.dimensionc; k++) {
            Tile current = board[i][k];
            if (current.getDisplaytile()==' '){
               return false;
           }
        }
    }
    return true ;
}

//clears the whole board
public void clearBoard (){

    for (int i = 0; i < this.dimensionr; i++) {
        for (int k = 0; k < this.dimensionc; k++) {
            Tile current = board[i][k];
            current.setDisplaytile(' ');
        }
    }
      
}


public static void main(String[] args){
    Board Boardboard1 = new Board(3,3);
    // Boardboard1.placeMove("3",'x');
    // Boardboard1.placeMove("5",'O');
    // Boardboard1.placeMove("7",'x');
    // Boardboard1.placeMove("1",'x');
    // Boardboard1.placeMove("2",'O');
    // Boardboard1.placeMove("8",'O');
    // Boardboard1.placeMove("9",'O');
    // Boardboard1.placeMove("4",'O');
    // Boardboard1.placeMove("6",'O');
    // Boardboard1.printBoard();
    // System.out.println( Boardboard1.isEmpty("9"));
    // System.out.println(Boardboard1.Win('O'));
    // System.out.println(Boardboard1.isFull());
    // Boardboard1.clearBoard();
    Boardboard1.printSampleBoard();
}



    
}