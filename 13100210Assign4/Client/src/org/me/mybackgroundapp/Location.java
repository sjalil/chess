package org.me.mybackgroundapp;


public class Location {
    static final int ROWS  = 9;
    int[] boxes=null;
    int x;
    int y;
    int init = 0;
    ChessPiece currPiece;
    
    
    
    public Location(){
        boxes= new int[ROWS];
        x= 0;
        y= 0;
        currPiece = null;
        
    }
    public Location(int x, int y,ChessPiece pc){
        this.x = x;
        this.y = y;
        this.currPiece = pc;
    }
    
    public Location(int x,int y){
        this.x = x;
        this.y = y;
    }
    
    public void findLocation(float x,float y){
        boxes[0]=0;
        for (int i = 1;i<ROWS;i++){
            boxes[i]= boxes[i-1] + 75;
        }
        for(int i= 0;i<boxes.length;i++){
            if (boxes[i]>x){
                this.x = i;
                break;
            }
        }
        
        for(int i= 0;i<boxes.length;i++){
            if (boxes[i]>y){
                this.y = i;
                break;
            }
        }
        System.out.println("x: "+ this.x + "\n"+ "y: "+this.y);
        
    }
    
    public void setValues(int x,int y){
        this.x = x;
        this.y = y;
    }
    
    public Location getLocation(){
        return this;
    }
        
    
}
