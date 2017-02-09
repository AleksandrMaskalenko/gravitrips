
public class Board {
    private final int column = 7;
    private final int row = 6;
    private final String emtyField = ".";
    private final String xPlayer = "x";
    private final String oPlayer = "o";

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

    public String getxPlayer(){
        return xPlayer;
    }

    public String getoPlayer(){
        return oPlayer;
    }

    public void emtyBord() {
        for (int j = 0; j < row; j++) {
            for (int i = 0; i < column; i++) {
                gameField[i][j] = emtyField;
            }
        }


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
        try {
            while (!gameField[hit][i].equals(emtyField)) {
                i--;
            }
        } catch (Exception e) {

        }

        return i;

    }

    public void addHit (int hit, int freeSlot, String token){

        gameField[hit][freeSlot] = token;
    }

    public boolean checkColum(int slot){
        if (slot == -1 ){

            return false;
        } else {
            return true;
        }
    }

    public boolean checkBord (){
        boolean chec = false;
        int i = 0;
        while (!chec && i < column){
            if (gameField[i][0].equals(emtyField)){
                chec = true;
            }
            i++;
        }

        return chec;
    }


}
