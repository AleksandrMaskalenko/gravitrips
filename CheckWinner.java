
public class CheckWinner {




    public boolean checkVertical(Board board, String token) {
        int count = 0;
        for (int j = 0; j < board.getColumn(); j++) {
            for (int i = 0; i < board.getRow(); i++) {
                if (board.getGameField(j, i).equals(token)) {
                    count++;
                } else {
                    count = 0;
                }

                if(count == 4){
                    return true;
                }

            }
        }
        return false;
    }

    public boolean checkHorizontal(Board board, String token) {
        int count = 0;
        for (int j = 0; j < board.getRow(); j++) {
            for (int i = 0; i < board.getColumn(); i++) {
                if (board.getGameField(i, j).equals(token)) {
                    count++;
                } else {
                    count = 0;
                }

                if(count == 4){
                    return true;
                }

            }
        }
        return false;
    }

    public boolean checkDiagonal(Board board, String token) {
        int count = 0;
        for (int i = 0; i < board.getRow()*2; i++) {
            for (int j = 0; j <= i; j++) {
                int k = i - j;
                if ( (k < board.getColumn()) && (j < board.getRow()) && (board.getGameField(k, j).equals(token))) {
                    count++;
                } else {
                    count = 0;
                }

                if(count == 4) {
                    return true;
                }
            }
        }
        return false;
    }

}
