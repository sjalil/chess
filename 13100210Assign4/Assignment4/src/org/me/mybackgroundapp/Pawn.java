package org.me.mybackgroundapp;


public class Pawn implements ChessPiece,Constants{
    
    int type;
    Location currentLoc;
    Location initLoc;
    boolean alive;
    int pos;
    ChessPiece killer;
    
    public Pawn(){
        
    }
    
    public Pawn(int type){
        this.type = type;
        currentLoc = new Location();
        initLoc = new Location();
        alive = true;
        pos = 0;
        killer = null;
    }
    
    public Pawn(int x, int y){
        this.currentLoc.x = x;
        this.currentLoc.y = y;
        this.initLoc.x = x;
        this.initLoc.y= y;
    }
    
    public void setCurrentLoc(Location loc){
        //currentLoc = new Location();
        currentLoc.setValues(loc.x, loc.y);
        initLoc.setValues(loc.x, loc.y);
    }
    
    public void setInitLoc(Location loc){
        initLoc = new Location();
        initLoc.setValues(loc.x, loc.y);
    }
    
    @Override
    public boolean validateMove(Location destinationPosition){
        ChessBoard board = ChessBoard.getInstance("LUMS Chess");
        int val;
        if(this.type == BLACK){
            val =1;
            if(pos == 0){
                if(destinationPosition.x == currentLoc.x && (destinationPosition.y == currentLoc.y+2 ||
                     destinationPosition.y == currentLoc.y+1)){
                    if(board.Isempty[destinationPosition.x][destinationPosition.y] == val)return false;
                    pos++;
                    return true;
                }
            
                if(destinationPosition.x == currentLoc.x+1 && destinationPosition.y == currentLoc.y+1){
                    if(board.Isempty[destinationPosition.x][destinationPosition.y] == val)return false;
                    pos++;
                    return true;
                }
                if(destinationPosition.x == currentLoc.x-1 && destinationPosition.y == currentLoc.y+1){
                    if(board.Isempty[destinationPosition.x][destinationPosition.y] == val)return false;
                    pos++;
                    return true;
                }
            
            }
            else if(this.currentLoc.y == 8){
                return updatedValidate(destinationPosition);
            }
            else{
                
                if(destinationPosition.x == currentLoc.x && destinationPosition.y == currentLoc.y+1){
                    if(board.Isempty[destinationPosition.x][destinationPosition.y] == 1)return false;
                    return true;
                }
            
                if(destinationPosition.x == currentLoc.x+1 && destinationPosition.y == currentLoc.y+1){
                    if(board.Isempty[destinationPosition.x][destinationPosition.y] == 1)return false;
                    return true;
                }
                    
                if(destinationPosition.x == currentLoc.x-1 && destinationPosition.y == currentLoc.y+1){
                    if(board.Isempty[destinationPosition.x][destinationPosition.y] == 1)return false;
                    return true;
                }
            }
            
        }
        else if (this.type == WHITE){
            val =2;
            if(pos == 0){
                if(destinationPosition.x == currentLoc.x && (destinationPosition.y == currentLoc.y-2 ||
                    destinationPosition.y == currentLoc.y-1)){
                    if(board.Isempty[destinationPosition.x][destinationPosition.y] == val)return false;
                    pos++;
                    return true;
                }
                if(destinationPosition.x == currentLoc.x+1 && destinationPosition.y == currentLoc.y-1){
                    if(board.Isempty[destinationPosition.x][destinationPosition.y] == val)return false;
                    pos++;
                    return true;
                }
                if(destinationPosition.x == currentLoc.x-1 && destinationPosition.y == currentLoc.y-1){
                    if(board.Isempty[destinationPosition.x][destinationPosition.y] == val)return false;
                    pos++;
                    return true;
                }
            }
            else if(this.currentLoc.y == 8){
                return updatedValidate(destinationPosition);
            }
            else{
                if(destinationPosition.x == currentLoc.x && destinationPosition.y == currentLoc.y-1){
                    if(board.Isempty[destinationPosition.x][destinationPosition.y] == 1)return false;
                    return true;
                }
                if(destinationPosition.x == currentLoc.x-1 && destinationPosition.y == currentLoc.y-1){
                    if(board.Isempty[destinationPosition.x][destinationPosition.y] == 1)return false;
                    return true;
                }
                if(destinationPosition.x == currentLoc.x+1 && destinationPosition.y == currentLoc.y-1){
                    if(board.Isempty[destinationPosition.x][destinationPosition.y] == 1)return false;
                    return true;}
            }
        }
        return false;
    }
    
    public boolean updatedValidate(Location destinationPosition){
        
         ChessBoard board = ChessBoard.getInstance("LUMS Chess");
        int val;
        if(this.type == BLACK)
            val = 1;
        else
            val =2;
        //**********************************************//
        ////////////// FOR STRAIGHT MOVES////////////////
        //********************************************//
        if(destinationPosition.x > currentLoc.x && destinationPosition.y == currentLoc.y ){
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
            for(int i = currentLoc.x;i>=destinationPosition.x;i--){
                if(destinationPosition.y == currentLoc.y && destinationPosition.x == i)
                    return true;
            }  
        }
        
        //*******************************************************************//
        ////////////// FOR Diagonal MOVES/////////////////////////////////////
        //*****************************************************************//
        int step =1;
        if(destinationPosition.x > currentLoc.x){
            if(destinationPosition.y > currentLoc.y){
                for(int i = currentLoc.x; i <= destinationPosition.x; i++){
                    if(board.Isempty[currentLoc.x + step][currentLoc.y +step] == val)return false;
                    if(destinationPosition.y == (currentLoc.y + step) && destinationPosition.x == (currentLoc.x + step)){
                        step =1;
                        return true;
                    }
                    step ++;
                }
            }
            
            if(destinationPosition.y < currentLoc.y){
                for(int i = currentLoc.x; i <destinationPosition.x; i++){
                    if(board.Isempty[currentLoc.x + step][currentLoc.y -step] == val)return false;
                    if(destinationPosition.y == (currentLoc.y - step) && destinationPosition.x == (currentLoc.x + step)){
                        step =1;
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
                        step =1;
                        return true;
                    }
                    step ++;
                }
            }
            
            if(destinationPosition.y < currentLoc.y){
                
                for(int i = currentLoc.x; i >destinationPosition.x; i--){
                    if(board.Isempty[currentLoc.x - step][currentLoc.y -step] == val)return false;
                    if(destinationPosition.y == (currentLoc.y - step) && destinationPosition.x == (currentLoc.x - step)){
                        step =1;
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
