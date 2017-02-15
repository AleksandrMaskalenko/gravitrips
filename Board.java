
public class Board {

    private final int column = 7;
    private final int row = 6;

    public Board() {

        for (int j = 0; j < row; j++) {
            for (int i = 0; i < column; i++) {
                gameField[i][j] = Token.EMPTY.getToken();
            }
        }

    }

    private String[][] gameField = new String[column][row];

    public String getGameField(int column, int row) {
        return gameField[column][row];
    }
    public int getColumn() {
        return column;
    }
    public int getRow() {
        return row;
    }

    public void printField(){
        System.out.println(1 +"\t"+ 2 +"\t"+ 3 +"\t"+ 4 +"\t"+ 5 +"\t"+ 6 +"\t"+ 7);

        for (int j = 0; j < row; j++) {
            for (int i = 0; i < column; i++) {
                System.out.print(gameField[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public int checkHit(int hit) {
        int i = 5;

            while ((i >= 0) && (!gameField[hit][i].equals(Token.EMPTY.getToken()))) {
                i--;
            }

        return i;

    }

    public void addHit (int hit, int freeSlot, String token){

        gameField[hit][freeSlot] = token;
    }

    public boolean checkColum(int slot){

        return (slot != -1);
    }

    public boolean checkBord (){
        boolean chec = false;
        int i = 0;
        while (!chec && i < column){
            if (gameField[i][0].equals(Token.EMPTY.getToken())){
                chec = true;
            }
            i++;
        }

        return chec;
    }


}
