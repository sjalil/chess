package org.me.mybackgroundapp;

public interface ChessPiece {
    
    /*Before the player’s move is committed, it needs to validate
    if its correct per the rule of the game*/
    boolean validateMove(Location destinationPosition); 
    
    /*move the chess piece to the destination location, 
    * return false if an error occurs and the move is not made*/
    boolean makeMove(Location newLocation); 
    
    /*Before the opposing player can complete his move, we need to check for 
     * this on all active chess pieces*/
    boolean hasCheckOnOpposingKing(Location positionOfOpposingKing);
    
    boolean isActive(); //to see if the piece has been killed
    
    boolean isWhite(); // to see if the player belongs to the white team
    
    boolean isBlack(); //to see if the player belongs to the black team
    
    
    /*The current object is being killed by
    ChessPiece a. Each piece should maintain who killed it and when it was 
     * killed. Use this function when converting a pawn to a queen when it 
     * reaches the other side by passing it itself. Only in this latter case
     * should a non-null value be returned, the reference to the Queen chesspiece.*/
    void kill(ChessPiece a);
    
    void updateCurrentLocation(Location loc);
    
}
