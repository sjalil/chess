package org.me.mybackgroundapp;


public class Bishop implements ChessPiece,Constants{
    
    Location currentLoc;
    Location initLoc;
    int type;
    boolean alive;
    ChessPiece killer;
    
    public Bishop(){
        
    }
    
    public Bishop(int type){
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
         int step =1;
         int val;
        if(this.type == BLACK)
            val = 1;
        else
            val =2;
          ChessBoard board = ChessBoard.getInstance("LUMS Chess");
        if(destinationPosition.x > currentLoc.x){
            if(destinationPosition.y > currentLoc.y){
                for(int i = currentLoc.x; i <=destinationPosition.x; i++){
                    if(board.Isempty[currentLoc.x + step][currentLoc.y +step] == val)return false;
                    if(destinationPosition.y == (currentLoc.y + step) && destinationPosition.x == (currentLoc.x + step)){
                        return true;
                    }
                    step ++;
                }
            }
            
            if(destinationPosition.y < currentLoc.y){
                for(int i = currentLoc.x; i <=destinationPosition.x; i++){
                    if(board.Isempty[currentLoc.x + step][currentLoc.y -step] == val)return false;
                    if(destinationPosition.y == (currentLoc.y - step) && destinationPosition.x == (currentLoc.x + step)){
                        return true;
                    }
                    step ++;
                }
            }
            
            
        }
        if(destinationPosition.x < currentLoc.x){
            if(destinationPosition.y > currentLoc.y){
                for(int i = currentLoc.x; i >=destinationPosition.x; i--){
                    if(board.Isempty[currentLoc.x - step][currentLoc.y +step] == val)return false;
                    if(destinationPosition.y == (currentLoc.y + step) && destinationPosition.x == (currentLoc.x - step)){
                        return true;
                    }
                    step ++;
                }
            }
            
            if(destinationPosition.y < currentLoc.y){
                for(int i = currentLoc.x; i >=destinationPosition.x; i--){
                    if(board.Isempty[currentLoc.x - step][currentLoc.y -step] == val)return false;
                    if(destinationPosition.y == (currentLoc.y - step) && destinationPosition.x == (currentLoc.x - step)){
                        return true;
                    }
                    step ++;
                }  
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
        if (this.type == WHITE)
            return true;
        else 
            return false;
     
    }
    
    @Override
    public boolean isBlack(){
        if (this.type == BLACK)
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
