# boardgame
Tic tac toe and Order and Chaos

--HOW TO EXCEUCTE FILE 

1.Compile the play class and run the main function. (java Play)

2.Fill in the input for name and select game(1,2). 

3. If tic tac toe is choosen player 1 gets to choose their piece and same for order and chaos.(however, afterward, losers of previous game will get to start first. Player can only rechoose pieces for tic tac toe if they just went from order and chaos back to tic tac toe).

4.Sample board will be given to show where postion is. Each player takes turn to play game.

5. End of the game, player will be ask if they want to play again, if they choose no, they can choose to choose another game or return the result of total wins from both games.

--Class Implemented

1. Tile - this is what each board is compose of. Holds info like col, row, position(num tile) and the displayvalue.

2. Board - creates a board of class tile and perform operations on them

3. Name- Holds the players firstname and last name.
 (middle name is emitted since I feel its unnecessary to make user input 3 things for name)

4. Piece- Pieces on the board with symbol being how they are displayed, and values.
 (for these two games , value are set to 0 since they dont matter.)

5. Player- holds info about player through Name class and Piece class (the piece they choosen) and their socre.

6.Play- Where the game is executed and setup. 
