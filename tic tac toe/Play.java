import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import java.util.*;
import java.util.InputMismatchException;
public class Play{
//GET INPUT ON WHERE TO MOVE
public static Scanner xmove = new Scanner(System.in);
//GET INPUT ON WHETHER TO PLAY AGAIN OR NO
public static Scanner again= new Scanner(System.in);
public static Piece piece_o = new Piece('O',0);
public static Piece piece_x = new Piece('X',0);

    public static void chaos(Board gameboard,Player currentplayer, Player nextplayer ) {
        String namecurrentplayer= currentplayer.getFirstname();
        //ask player to choose the piece they are going to put on the board
        System.out.println("Player "+ namecurrentplayer +" Please choose your piece O or X: ");
        String playerpiece = again.next();
   
        while ((playerpiece.equals("o"))==false && (playerpiece.equals("O"))== false && (playerpiece.equals("x"))==false && (playerpiece.equals("X")== false)){
            System.out.println("Invalid Input! Pick a piece O or X : ");
            playerpiece = again.next();
            
        }
        playerpiece= playerpiece.toUpperCase();
        if (playerpiece.equals("O")){
            currentplayer.setPiece(piece_o);
        }
        else{
            currentplayer.setPiece(piece_x);
        }
        //save the piece symbol that the player is currently using 
        char currentsymbol = currentplayer.getSymbol();
        System.out.print("Player "+ namecurrentplayer+ "("+ currentsymbol+ ")"+" Enter Your Move (1-36) : ");
        String x_Move = xmove.nextLine();
            while (gameboard.isEmpty(x_Move)==false){
                System.out.print("Invalid move!");
                System.out.println("Player "+ namecurrentplayer+ "("+ currentsymbol+ ")"+" Enter Your Move (1-36) : ");
                x_Move= xmove.nextLine();
                
            }
            gameboard.placeMove(x_Move,currentsymbol);
            gameboard.printBoard();

            //check if the current playerhas win or there is a tie on the board.If there is, we gotta start a new game or end the game.
            if(gameboard.isFull()|| gameboard.winaltered(5,currentsymbol)){
                if(gameboard.winaltered(5,currentsymbol)){
                System.out.println("Player "+ namecurrentplayer+ "("+ currentsymbol+ ")"+" Wins! ");
                currentplayer.updateWin();
                //loser gets to go first the next turn！
                
                }
                else{
                System.out.println("Its a tie!");
                }
        

                //getting input to continue or not.
                System.out.println("Would you like to start another game? (y/n) : ");
                    again.nextLine();
                    String yesno = again.nextLine();
                    yesno = yesno.toLowerCase();

                while ((yesno.equals("y"))==false && (yesno.equals("n"))== false && (yesno.equals("yes"))==false && (yesno.equals("no")== false)){
                    System.out.println("Invalid Input! Would you like to start another game? (y/n) : ");
                    yesno = again.nextLine();
                    yesno = yesno.toLowerCase();
                }
                //if you restart, clear the game, let the next player start first this time.
                if (yesno.equals("y") || yesno.equals("yes")) {
                    gameboard.clearBoard();
                    gameboard.printBoard();
                    Play.chaos(gameboard,nextplayer,currentplayer);
                }
                //if you end, print out the scores or choose another game
                else if(yesno.equals("n")|| yesno.equals("no")){
                    System.out.println("Would you like switching to tic tac toe? y/n :");
                    yesno = again.nextLine();
                    yesno = yesno.toLowerCase();
                 

                    while ((yesno.equals("y"))==false && (yesno.equals("n"))== false && (yesno.equals("yes"))==false && (yesno.equals("no")== false)){
                       
                        System.out.println("Invalid Input! Would you like to start another game? (y/n) : ");
                        yesno = again.nextLine();
                        yesno = yesno.toLowerCase();
                        
                    }
                   
                //if yes let player play switch to tto let the next player start first this time.
                if (yesno.equals("y") || yesno.equals("yes")) {
                
                    Play.setuptto(nextplayer,currentplayer);
                }
                //if no you end, print out the scores
                else if(yesno.equals("n")|| yesno.equals("no")){
                    System.out.println("Before we exit,here is the summary of the game! :");
                    System.out.println("Player " + namecurrentplayer + " won " + currentplayer.getWin()+ " time(s)!");
                    System.out.println("Player " + nextplayer.getFirstname() + " won " + nextplayer.getWin()+ " time(s)!");
                    System.out.println("Hope you had fun! See You again next time!:)");

                    return ;


                }


            }
        }
            
            else{
            //if current player finish turn without winning or tie, its time for nextplyaer to take a turn. 
                Play.chaos(gameboard,nextplayer,currentplayer);
            }

        
    }


    public static void setupchaos(Player player1, Player player2){
        Board gameboard = new Board(6,6);
        System.out.println("Lets play a game of order and chaos!");
        System.out.println("Here is how the tiles are structured! Please input number based on where you would want to put your marks!");
        gameboard.printSampleBoard();
        System.out.println();
        System.out.println("Now here is an empty board.Lets place your move and let the game begin!");
        System.out.println();
        gameboard.printBoard();
        chaos(gameboard,player1,player2);

    }

    
//turns for tic tac toe
    public static void turn (Board gameboard, Player currentplayer, Player nextplayer){
    
        //current symbol of the current player
        char currentsymbol = currentplayer.getSymbol();
        String namecurrentplayer= currentplayer.getFirstname();
             
        //get valid input to move the piece and print the boars
        System.out.print("Player "+ namecurrentplayer+ "("+ currentsymbol+ ")"+" Enter Your Move (1-9) : ");
        String x_Move = xmove.nextLine();
            while (gameboard.isEmpty(x_Move)==false){
                System.out.print("Invalid move!");
                System.out.println("Player "+ namecurrentplayer+ "("+ currentsymbol+ ")"+" Enter Your Move (1-9) : ");
                x_Move= xmove.nextLine();
                
            }
            gameboard.placeMove(x_Move,currentsymbol);
            gameboard.printBoard();

            //check if the current playerhas win or there is a tie on the board.If there is, we gotta start a new game or end the game.
            if(gameboard.isFull()|| gameboard.Win(currentsymbol)){
                if(gameboard.Win(currentsymbol)){
                System.out.println("Player "+ namecurrentplayer+ "("+ currentsymbol+ ")"+" Wins! ");
                currentplayer.updateWin();
                //loser gets to go first the next turn！
                
                }
                else{
                System.out.println("Its a tie!");
                }
                //getting input to continue or not.
                System.out.print("Would you like to start another game? (y/n) : ");
                String yesno = again.nextLine();
                yesno = yesno.toLowerCase();
                while ((yesno.equals("y"))==false && (yesno.equals("n"))== false && (yesno.equals("yes"))==false && (yesno.equals("no")== false)){
                    System.out.println("Invalid Input! Would you like to start another game? (y/n) : ");
                    yesno = again.nextLine();
                    yesno = yesno.toLowerCase();
                }
                //if you restart, clear the game, let the next player start first this time.
                if (yesno.equals("y") || yesno.equals("yes")) {
                    gameboard.clearBoard();
                    gameboard.printBoard();
                    Play.turn(gameboard,nextplayer,currentplayer);
                }
                //if you end, print out the scores or choose another game
                else if(yesno.equals("n")|| yesno.equals("no")){
                    System.out.println("Would you like switching to Order and Chaos? y/n :");
                    yesno = again.nextLine();
                    yesno = yesno.toLowerCase();
                    while ((yesno.equals("y"))==false && (yesno.equals("n"))== false && (yesno.equals("yes"))==false && (yesno.equals("no")== false)){
                        System.out.println("Invalid Input! Would you like to start another game? (y/n) : ");
                        yesno = again.nextLine();
                        yesno = yesno.toLowerCase();
                        
                    }
                    if (yesno.equals("y") || yesno.equals("yes")) {
                        Play.setupchaos(nextplayer,currentplayer);
                    }
                    //if you end, print out the scores
                    else if(yesno.equals("n")|| yesno.equals("no")){

                    
                     System.out.println("Before we exit,here is the summary of the game! :");
                     System.out.println("Player " + namecurrentplayer + " won " + currentplayer.getWin()+ " time(s)!");
                     System.out.println("Player " + nextplayer.getFirstname() + " won " + nextplayer.getWin()+ " time(s)!");
                     System.out.println("Hope you had fun! See You again next time!:)");

                    return ;


                }


            }
        }
            else{
            //if current player finish turn without winning or tie, its time for nextplyaer to take a turn. 
                Play.turn(gameboard,nextplayer,currentplayer);
            }

            
        }

        public static void setupplayers(){
             //gets player1's name
             Scanner scannername = new Scanner (System.in); 
             System.out.println("Player 1 Please enter your first name:");
             String firstname1 = scannername.next();
             System.out.println("Player 1 Please enter your last name:");
             String lastname1 = scannername.next();
             Name player1name = new Name(firstname1,lastname1);
             //get player2's name
             System.out.println("Player 2 Please enter your first name:");
             String firstname2 = scannername.next();
             System.out.println("Player 2 Please enter your last name:");
             String lastname2 = scannername.next();
             Name player2name= new Name(firstname2,lastname2);
             //CHOOSE THE GAME
             System.out.println("Please choose a game(1-2): (1) tic-tac-toe , (2) order and chaos");
             String game = scannername.next();
             while(game.equals("1")== false && game.equals("2")== false){
                System.out.println("Invalid input!Please choose a game(1-2): (1) tic-tac-toe , (2) order and chaos");
                game = scannername.next();
             
             }
             Piece temp1= new Piece(' ',0);
             Piece temp2= new Piece(' ',0);
             Player player1= new Player(player1name,temp1);
             Player player2= new Player(player2name,temp2);
             if(game.equals("1")){
                 setuptto(player1,player2);
             }
             else{
                 setupchaos(player1, player2);
             }
             scannername.close();
        }

        public static void setuptto(Player player1, Player player2){
            Board gameboard= new Board(3,3);

            Scanner scannername = new Scanner (System.in); 
            String player1name = player1.getFirstname();
            System.out.println("Player " +player1name+ " Choose a piece O or X:");
            String player1piece = scannername.next();
       
            while ((player1piece.equals("o"))==false && (player1piece.equals("O"))== false && (player1piece.equals("x"))==false && (player1piece.equals("X")== false)){
                System.out.println("Invalid Input! Pick a piece O or X : ");
                player1piece = scannername.next();
                
            }
            player1piece = player1piece.toUpperCase();
            
            if(player1piece.equals("O")){
                System.out.print("here");
                player1.setPiece(piece_o);
                player2.setPiece(piece_x);
                System.out.println("Lets play a game of Tic tac toe!");
                System.out.println("Here is how the tiles are structured! Please input number based on where you would want to put your marks!");
                gameboard.printSampleBoard();
                System.out.println();
                System.out.println("Now here is an empty board.Lets place your move and let the game begin!");
                System.out.println();
                gameboard.printBoard();
                turn(gameboard,player1,player2);
            }
            else{
                player1.setPiece(piece_x);
                player2.setPiece(piece_o);
                System.out.println("Lets play a game of Tic tac toe!");
                System.out.println("Here is how the tiles are structured! Please input number based on where you would want to put your marks!");
                gameboard.printSampleBoard();
                System.out.println();
                System.out.println("Now here is an empty board.Lets place your move and let the game begin!");
                System.out.println();
                gameboard.printBoard();
                turn(gameboard,player1,player2);
                
            }
            
            


            
            // System.out.println("Lets play a game of Tic tac toe!");
            // System.out.println("Here is how the tiles are structured! Please input number based on where you would want to put your marks!");
            // gameboard.printSampleBoard();
            // System.out.println();
            // System.out.println("Now here is an empty board.Lets place your move and let the game begin!");
            // System.out.println();
            // gameboard.printBoard();
            // turn(gameboard,playerx,playero);
            scannername.close();
            return;
            

        }

        public static void main (String[] args){
            setupplayers();
        }
    


    // public static void main(String[] args){
    //     //Intro with all the intructions and initiate the calass
    //     // Board gameboard= new Board(3);
    //     // Player playero = new Player('O');
    //     // Player playerx = new Player('X');
    //     // System.out.println("Lets play a game of Tic tac toe!");
    //     // System.out.println("Here is how the tiles are structured! Please input number based on where you would want to put your marks!");
    //     // gameboard.printSampleBoard();
    //     // System.out.println();
    //     // System.out.println("Now here is an empty board.Lets place your move and let the game begin!");
    //     // System.out.println();
    //     // gameboard.printBoard();
    //     // turn(gameboard,playerx,playero);
    //     // return;
    // }
   
}

// public static void main(String[] args){
//     //Intro with all the intructions
//     Board gameboard= new Board();
//     Player playero = new Player('O');
//     Player playerx = new Player('X');
//     char turn = playerx.getSymbol();
//     System.out.println("Lets play a game of Tic tac toe!");
//     System.out.println("Here is how the tiles are structured! Please input number based on where you would want to put your marks!");
//     gameboard.printSampleBoard();
//     System.out.println();
//     System.out.println("Now here is an empty board.Lets place your move and let the game begin!");
//     System.out.println();
//     gameboard.printBoard();
//     //two scanners one for getting where to move to and one for whether to continue the game or not. 
//     Scanner xmove = new Scanner(System.in);
//     Scanner again= new Scanner(System.in);
//     char xcurrentsymbol = playerx.getSymbol();
//     char ocurrentsymbol = playero.getSymbol();
//     //while the gameboard is not full!We can keep taking turns!
//     while (!gameboard.isFull()){
//     //X's turn.
//         while ((turn == playerx.getSymbol())){
             
//             //get valid input to move the piece and print the board
           
//             System.out.print("Player " + xcurrentsymbol+" Enter Your Move (1-9) : ");
//             String x_Move = xmove.nextLine();
//             while (gameboard.isEmpty(x_Move)==false){
//                 System.out.print("Invalid move!");
//                 System.out.print("Player " + xcurrentsymbol + " Enter Your Move (1-9) : ");
//                 x_Move= xmove.nextLine();
                
//             }
//             gameboard.placeMove(x_Move,xcurrentsymbol);
//             gameboard.printBoard();

//             //check if the x has win or there is a tie on the board.If there is, we gotta start a new game or end the game.
//             if(gameboard.isFull()|| gameboard.Win(xcurrentsymbol)){
//                 if(gameboard.Win(xcurrentsymbol)){
//                 System.out.println("Player " + xcurrentsymbol + " wins!");
//                 playerx.updateWin();
//                 //loser gets to go first the next turn！
//                 turn =ocurrentsymbol;
//                 }
//                 else{
//                 System.out.println("Its a tie!");
//                 }
//                 //getting input to continue or not.
//                 System.out.print("Would you like to start another game? (y/n) : ");
//                 String yesno = again.nextLine();
//                 yesno = yesno.toLowerCase();
//                 while ((yesno.equals("y"))==false && (yesno.equals("n"))== false && (yesno.equals("yes"))==false && (yesno.equals("no")== false)){
//                     System.out.print("Invalid Input! Would you like to start another game? (y/n) : ");
//                     yesno = again.nextLine();
//                     yesno = yesno.toLowerCase();
//                 }
//                 if (yesno.equals("y") || yesno.equals("yes")) {
//                     gameboard.clearBoard();
//                     gameboard.printBoard();
//                 }
//                 else if(yesno.equals("n")|| yesno.equals("no")){
//                     System.out.println("Before we exit,here is the summary of the game! :");
//                     System.out.println("Player " + xcurrentsymbol + " won " + playerx.getWin()+ " time(s)!");
//                     System.out.println("Player " + ocurrentsymbol + " won " + playero.getWin()+ " time(s)!");
//                     System.out.println("Hope you had fun! See You again next time!:)");
//                     return;


//                 }


//             }
//             else{
//             //if x finish turn without winning or tie, its time for o to take a turn. 
//                 turn = ocurrentsymbol;
//             }

            
//         }

        
//         //O's turn
//         while ((turn == 'O')){
//             //get valid input to move the piece and print the board
//             System.out.print("Player "+ ocurrentsymbol+ " Enter Your Move (1-9) : ");
//             String x_Move = xmove.nextLine();
//             while (gameboard.isEmpty(x_Move)==false){
//                 System.out.print("Invalid move!");
//                 System.out.print("Player " + ocurrentsymbol + " Enter Your Move (1-9) : ");
//                 x_Move= xmove.nextLine();
//             }
//             gameboard.placeMove(x_Move,'O');
//             gameboard.printBoard();
//             //check if the o has win or there is a tie
//             if(gameboard.isFull()|| gameboard.Win(ocurrentsymbol)){
//                 if(gameboard.Win(ocurrentsymbol)){
//                 System.out.println("Player "+ ocurrentsymbol +" wins!");
//                 playero.updateWin();
//                 //loser gets first next round
//                 turn=xcurrentsymbol;
//                 }
//                 else{
//                 System.out.println("Its a tie!");
//                 }
//                 //getting input to continue or end the game
//                 System.out.print("Would you like to start another game? (y/n) : ");
//                 String yesno = again.nextLine();
//                 yesno = yesno.toLowerCase();
                
//                 while ((yesno.equals("y"))==false && (yesno.equals("n"))== false && (yesno.equals("yes"))==false && (yesno.equals("no")== false)){
//                     System.out.print("Invalid Input! Would you like to start another game? (y/n) : ");
//                     yesno = again.nextLine();
//                     yesno = yesno.toLowerCase();
//                 }
//                 if (yesno.equals("y") || yesno.equals("yes")) {
//                     gameboard.clearBoard();
//                     gameboard.printBoard();
//                 }
//                 else if(yesno.equals("n")|| yesno.equals("no")){
//                     System.out.println("Before we exit,here is the summary of the game! :");
//                     System.out.println("Player "+ xcurrentsymbol+ " won " + playerx.getWin()+ " time(s)!");
//                     System.out.println("Player " + ocurrentsymbol +" won " + playero.getWin() + " time(s)!");
//                     System.out.println("Hope you had fun! See You again next time!:)");
//                     return;


//                 }


//             }
//             else{
//                 //if no one wins nor if there is no tie, then its the other players turn. 
//                 turn = xcurrentsymbol;
//             }

            
//         }
// }
// }

// }