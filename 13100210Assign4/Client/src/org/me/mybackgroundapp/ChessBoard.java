package org.me.mybackgroundapp;

public class ChessBoard implements Constants{
    
    static ChessBoard board;
    static String ChessName;
    boolean empty;
    int[][] Isempty;
    int [][] attackAble;
    Pawn pawnBlack1,pawnBlack2, pawnBlack3,pawnBlack4,pawnBlack5,pawnBlack6,pawnBlack7,pawnBlack8,
         pawnWhite1,pawnWhite2, pawnWhite3,pawnWhite4,pawnWhite5,pawnWhite6,pawnWhite7,pawnWhite8;
    Bishop bishopBlack1,bishopBlack2,bishopWhite1,bishopWhite2;
    King blackKing,whiteKing;
    Queen blackQueen,whiteQueen;
    Rook rookBlack1,rookBlack2,rookWhite1,rookWhite2;
    Knight knightBlack1,knightBlack2,knightWhite1,knightWhite2;
    
    Location pnb1Loc,pnb2Loc,pnb3Loc,pnb4Loc,pnb5Loc,pnb6Loc,pnb7Loc,pnb8Loc,pnw1Loc,pnw2Loc,
             pnw3Loc,pnw4Loc,pnw5Loc,pnw6Loc,pnw7Loc,pnw8Loc;
    Location rkb1,rkb2,rkw1,rkw2;
    Location kb,kw;
    Location qb,qw;
    Location bb1,bb2,bw1,bw2;
    Location nb1,nb2,nw1,nw2;
    
    public ChessBoard(String name){
        
        ChessName = name;
        Isempty = new int[9][9];
        attackAble = new int [9][9];
        for(int i = 1; i<9; i++){
            for (int j = 1;j<9;j++){
                Isempty[i][j]=0;
                attackAble[i][j]=0;
            }
        }
        
        this.InitLocation();
        this.initPos();
        
        pawnBlack1 = new Pawn(BLACK);pawnBlack1.setCurrentLoc(pnb1Loc);
        pawnBlack2 = new Pawn(BLACK);pawnBlack2.setCurrentLoc(pnb2Loc);
        pawnBlack3 = new Pawn(BLACK);pawnBlack3.setCurrentLoc(pnb3Loc);
        pawnBlack4 = new Pawn(BLACK);pawnBlack4.setCurrentLoc(pnb4Loc);
        pawnBlack5 = new Pawn(BLACK);pawnBlack5.setCurrentLoc(pnb5Loc);
        pawnBlack6 = new Pawn(BLACK);pawnBlack6.setCurrentLoc(pnb6Loc);
        pawnBlack7 = new Pawn(BLACK);pawnBlack7.setCurrentLoc(pnb7Loc);
        pawnBlack8 = new Pawn(BLACK);pawnBlack8.setCurrentLoc(pnb8Loc);
        
        pawnWhite1 = new Pawn(WHITE);pawnWhite1.setCurrentLoc(pnw1Loc);
        pawnWhite2 = new Pawn(WHITE);pawnWhite2.setCurrentLoc(pnw2Loc);
        pawnWhite3 = new Pawn(WHITE);pawnWhite3.setCurrentLoc(pnw3Loc);
        pawnWhite4 = new Pawn(WHITE);pawnWhite4.setCurrentLoc(pnw4Loc);
        pawnWhite5 = new Pawn(WHITE);pawnWhite5.setCurrentLoc(pnw5Loc);
        pawnWhite6 = new Pawn(WHITE);pawnWhite6.setCurrentLoc(pnw6Loc);
        pawnWhite7 = new Pawn(WHITE);pawnWhite7.setCurrentLoc(pnw7Loc);
        pawnWhite8 = new Pawn(WHITE);pawnWhite8.setCurrentLoc(pnw8Loc);
        
        bishopBlack1 = new Bishop(BLACK);bishopBlack1.setCurrentLoc(bb1);
        bishopBlack2 = new Bishop(BLACK);bishopBlack2.setCurrentLoc(bb2);
        bishopWhite1 = new Bishop(WHITE);bishopWhite1.setCurrentLoc(bw1);
        bishopWhite2 = new Bishop(WHITE);bishopWhite2.setCurrentLoc(bw2);
        
        rookBlack1 = new Rook(BLACK);rookBlack1.setCurrentLoc(rkb1);
        rookBlack2 = new Rook(BLACK);rookBlack2.setCurrentLoc(rkb2);
        rookWhite1 = new Rook(WHITE);rookWhite1.setCurrentLoc(rkw1);
        rookWhite2 = new Rook(WHITE);rookWhite2.setCurrentLoc(rkw2);
        
        blackKing = new King(BLACK);blackKing.setCurrentLoc(kb);
        whiteKing = new King(WHITE);whiteKing.setCurrentLoc(kw);
        
        blackQueen = new Queen(BLACK);blackQueen.setCurrentLoc(qb);
        whiteQueen = new Queen(WHITE);whiteQueen.setCurrentLoc(qw);
        
        knightWhite1 = new Knight(WHITE);knightWhite1.setCurrentLoc(nw1);
        knightWhite2 = new Knight(WHITE);knightWhite2.setCurrentLoc(nw2);
        knightBlack1 = new Knight(BLACK);knightBlack1.setCurrentLoc(nb1);
        knightBlack2 = new Knight(BLACK);knightBlack2.setCurrentLoc(nb2);  
    }
    
    public static ChessBoard getInstance(String name){
		if (board == null){
			board = new ChessBoard(name);
			ChessName= name;
		}
		return board;
	}
    
    
    private void InitLocation(){
        pnb1Loc= new Location(1,2);pnb2Loc= new Location(2,2);pnb3Loc= new Location(4,2);
        pnb4Loc= new Location(3,2);pnb5Loc= new Location(6,2);pnb6Loc= new Location(5,2);
        pnb7Loc= new Location(7,2);pnb8Loc= new Location(8,2);pnw1Loc= new Location(2,7);
        pnw2Loc= new Location(1,7);pnw3Loc= new Location(4,7);pnw4Loc= new Location(5,7);
        pnw5Loc= new Location(6,7);pnw6Loc= new Location(3,7);pnw7Loc= new Location(7,7);
        pnw8Loc= new Location(8,7);rkb1= new Location(8,1);rkb2= new Location(1,1);
        rkw1= new Location(8,8);rkw2= new Location(1,8);kb= new Location(4,1);
        kw= new Location(4,8);qb= new Location(5,1);qw= new Location(5,8);
        bb1= new Location(6,1);bb2= new Location(3,1);bw1= new Location(3,8);
        bw2= new Location(6,8);nb1= new Location(2,1);nb2= new Location(7,1);
        nw1= new Location(2,8);nw2= new Location(7,8);
        
    }
    /*
    public Location findBox(Location a){
        for(int i = 0; i<locations.size();i++){
            if (a == locations.get(i)){
                System.out.println("location matched: " + locations.get(i).x + "," + locations.get(i).y);
                return locations.get(i);}
            }
        return null;
        }  */
    
    public void initPos(){
        Isempty[1][1] = 1;Isempty[2][1] = 1;Isempty[3][1] = 1;Isempty[4][1] = 1;Isempty[5][1] = 1;
        Isempty[6][1] = 1;Isempty[7][1] = 1;Isempty[8][1] = 1;Isempty[1][2] = 1;Isempty[2][2] = 1;
        Isempty[3][2] = 1;Isempty[4][2] = 1;Isempty[5][2] = 1;Isempty[6][2] = 1;Isempty[7][2] = 1;
        Isempty[8][2] = 1;Isempty[1][7] = 2;Isempty[2][7] = 2;Isempty[3][7] = 2;Isempty[4][7] = 2;
        Isempty[5][7] = 2;Isempty[6][7] = 2;Isempty[7][7] = 2;Isempty[8][7] = 2;Isempty[1][8] = 2;
        Isempty[2][8] = 2;Isempty[3][8] = 2;Isempty[4][8] = 2;Isempty[5][8] = 2;
        Isempty[6][8] = 2;Isempty[7][8] = 2;Isempty[8][8] = 2;
    }
}
