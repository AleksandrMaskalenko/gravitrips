
public class Board {

    private static final int COLUMNS = 7;
    private static final int ROWS = 6;

    public Board() {

        for (int j = 0; j < ROWS; j++) {
            for (int i = 0; i < COLUMNS; i++) {
                gameField[i][j] = Token.EMPTY;
            }
        }

    }

    private Token[][] gameField = new Token[COLUMNS][ROWS];

    public Token getGameField(int column, int row) {
        return gameField[column][row];
    }
    public int getColumn() {
        return COLUMNS;
    }
    public int getRow() {
        return ROWS;
    }

    public void printField(){
        System.out.println(1 +"\t"+ 2 +"\t"+ 3 +"\t"+ 4 +"\t"+ 5 +"\t"+ 6 +"\t"+ 7);

        for (int j = 0; j < ROWS; j++) {
            for (int i = 0; i < COLUMNS; i++) {
                System.out.print(gameField[i][j].getToken() + "\t");
            }
            System.out.println();
        }
    }

    public int checkHit(int hit) {
        int i = 5;

            while ((i >= 0) && (!gameField[hit][i].equals(Token.EMPTY))) {
                i--;
            }

        return i;

    }

    public void addHit (int hit, int freeSlot, Token token){

        gameField[hit][freeSlot] = token;
    }

    public boolean checkColum(int slot){

        return (slot != -1);
    }

    public boolean checkBord (){
        boolean chec = false;
        int i = 0;
        while (!chec && i < COLUMNS){
            if (gameField[i][0].equals(Token.EMPTY)){
                chec = true;
            }
            i++;
        }

        return chec;
    }


}
