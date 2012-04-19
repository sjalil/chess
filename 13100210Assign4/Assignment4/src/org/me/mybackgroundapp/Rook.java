package org.me.mybackgroundapp;



public class Rook implements ChessPiece,Constants{
    
    Location currentLoc;
    Location initLoc;
    int type;
    boolean alive;
    ChessPiece killer;
    
    public Rook(){
        
    }
    
    public Rook(int type){
        this.type = type;
        currentLoc = new Location();
        initLoc = new Location();
        this.alive = true;
        killer = null;
    }
    
     public void setCurrentLoc(Location loc){
        currentLoc = new Location();
        currentLoc.setValues(loc.x, loc.y);
    }
    
    @Override
    public boolean validateMove(Location destinationPosition){
        
        ChessBoard board = ChessBoard.getInstance("LUMS Chess");
        int val;
        if(this.type == BLACK)
            val = 1;
        else
            val =2;
        
        if(destinationPosition.x > currentLoc.x && destinationPosition.y == currentLoc.y){
            
            for(int i = currentLoc.x;i<destinationPosition.x;i++){
                if(board.Isempty[i+1][currentLoc.y] == val)return false;}
            
            for(int i = currentLoc.x;i<=destinationPosition.x;i++){
                if(destinationPosition.y == currentLoc.y && destinationPosition.x == i)
                    return true;
            }    
        }
        
        if(destinationPosition.y > currentLoc.y && destinationPosition.x == currentLoc.x){
            for(int i = currentLoc.y;i<destinationPosition.y;i++){
                if(board.Isempty[currentLoc.x][i+1] == val)return false;
            }
            for(int i = currentLoc.y;i<=destinationPosition.y;i++){
                if(destinationPosition.x == currentLoc.x && destinationPosition.y == i)
                    return true;
            } 
        }
        
        if(destinationPosition.y < currentLoc.y && destinationPosition.x == currentLoc.x){
            
            for(int i = currentLoc.y;i>destinationPosition.y;i--){
                if(board.Isempty[currentLoc.x][i-1] == val)return false;
            }
            
            for(int i = currentLoc.y;i>=destinationPosition.y;i--){
                if(destinationPosition.x == currentLoc.x && destinationPosition.y == i)
                    return true;
            }   
        }
        
        if(destinationPosition.x < currentLoc.x && destinationPosition.y == currentLoc.y){
            
            for(int i = currentLoc.x;i>destinationPosition.x;i--){
                if(board.Isempty[i-1][currentLoc.y] == val)return false;}
            
            for(int i = currentLoc.x;i>destinationPosition.x;i--){
                if(destinationPosition.y == currentLoc.y && destinationPosition.x == i)
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
