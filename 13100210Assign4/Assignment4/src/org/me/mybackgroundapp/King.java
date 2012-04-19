package org.me.mybackgroundapp;



public class King implements ChessPiece,Constants{
    
    Location currentLoc;
    Location initLoc;
    int type;
    boolean alive;
    ChessPiece killer;
    
    public King(){
        
    }
    
    public King(int type){
        this.type = type;
        currentLoc = new Location();
        initLoc = new Location();
        alive = true;
        killer = null;
    }
    
     public void setCurrentLoc(Location loc){
        currentLoc = new Location();
        currentLoc.setValues(loc.x, loc.y);
    }
        
    @Override
    public boolean validateMove(Location destinationPosition){
        if(destinationPosition.x == currentLoc.x+1){
            if(destinationPosition.y == currentLoc.y)
                return true;
            if(destinationPosition.y == currentLoc.y+1)
                return true;
            if(destinationPosition.y == currentLoc.y-1 )
                return true;
        }
        
        if(destinationPosition.x == currentLoc.x-1){
            if(destinationPosition.y == currentLoc.y)
                return true;
            if(destinationPosition.y == currentLoc.y+1)
                return true;
            if(destinationPosition.y == currentLoc.y-1)
                return true;
        }
        
        if(destinationPosition.x == currentLoc.x){
            if(destinationPosition.y == currentLoc.y+1)
                return true;
            if(destinationPosition.y == currentLoc.y-1)
                return true;
        }
        
        return false;
    }
    
    @Override
    public boolean makeMove(Location newLocation){
        return true;
        
    }
    
    @Override
    public boolean hasCheckOnOpposingKing(Location positionOfOpposingKing){
        return true;
    }
    
    @Override
    public boolean isActive(){
        return alive;
    }
    
    @Override
    public boolean isWhite(){
        if(this.type == WHITE)
            return true;
        else 
            return false;
     
    }
    
    @Override
    public boolean isBlack(){
        if(this.type == BLACK)
            return true;
        else
            return false;
    }
    @Override
    public void kill(ChessPiece a){
        this.killer = a;
    }
    
    @Override
    public void updateCurrentLocation(Location loc){
        this.currentLoc = loc;
        
    }
    
}
