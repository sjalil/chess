package org.me.mybackgroundapp;



public class Knight implements ChessPiece,Constants{
    
    Location currentLoc;
    Location initLoc;
    int type;
    boolean alive;
    ChessPiece killer;
    
    public Knight(){
        
    }
    
    public Knight(int type){
        this.type = type;
        currentLoc = new Location();
        initLoc = new Location();
        this.alive = true;
        killer = null;
    }
   
     public void setCurrentLoc(Location loc){
        currentLoc.setValues(loc.x, loc.y);
    }
    
    @Override
    public boolean validateMove(Location destinationPosition){
        
        if(destinationPosition.x == currentLoc.x+1){
            if(destinationPosition.y == currentLoc.y+2 || destinationPosition.y == currentLoc.y-2){
                return true;
            }            
        }
        
        if(destinationPosition.x == currentLoc.x+2){
            if(destinationPosition.y == currentLoc.y+1 || destinationPosition.y == currentLoc.y-1){
                return true;
            }
        }
        
        if(destinationPosition.x == currentLoc.x-1){
            if(destinationPosition.y == currentLoc.y+2 || destinationPosition.y == currentLoc.y-2){
                return true;
            }            
        }
        
        if(destinationPosition.x == currentLoc.x-2){
            if(destinationPosition.y == currentLoc.y+1 || destinationPosition.y == currentLoc.y-1){
                return true;
            }
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
