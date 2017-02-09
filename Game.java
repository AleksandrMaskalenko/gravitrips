import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Game {

    private static int number;

    public static void main(String[] agrs) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Player player1 = new Player();
        Player player2 = new Player();
        InputNumber inputNumber = new InputNumber();
        Board board = new Board();
        CheckWinner game = new CheckWinner();

        System.out.println("Gravitrips game!");
        System.out.println("Select game mode:");
        System.out.println("Player to Computer - press 1 and ENTER ");
        System.out.println("Player to Player - press 2 and ENTER ");
        number = Integer.parseInt(reader.readLine());

        if (number == 2) {

            System.out.println("Enter the name of first player:");
            player1.setPlayerName(reader.readLine());
            player1.setToken(board.getxPlayer());

            System.out.println("Enter the name of second player:");
            player2.setPlayerName(reader.readLine());
            player2.setToken(board.getoPlayer());


        } else if (number == 1){

            System.out.println("Enter the name of player:");
            player1.setPlayerName(reader.readLine());
            player1.setToken(board.getxPlayer());

            System.out.println("Against you playing Computer");
            player2.setPlayerName("MEGAMIND");
            player2.setToken(board.getoPlayer());
        } else {
            System.out.println("Wrong!!! Please enter valid move! Valid number range 1 or 2");
        }

        System.out.println("Player " +player1.getPlayerName() + " plays token - " + player1.getToken());
        System.out.println("Player " +player2.getPlayerName() + " plays token - " + player2.getToken());
        System.out.println("Let's Start!");
        System.out.println();


        board.emtyBord();
        board.printField();

        String token;
        int count = 0;
        boolean exit = false;

        while (!exit) {
            count++;
            if (count%2 != 0){
                System.out.println("Player " + player1.getPlayerName() + " makes a move (token " +player1.getToken()+")" + "!");
                token = player1.getToken();
            } else {
                System.out.println("Player " + player2.getPlayerName() + " makes a move (token " +player2.getToken()+" )" + "!");
                token = player2.getToken();
            }
            boolean checkBord = false;
            int hit = 0;
            int freeSlot = 0;

            while (!checkBord) {

                if ((count%2 == 0) && (number == 1)) {
                    Random r = new Random();
                    hit = r.nextInt(8);
                } else {
                    hit = inputNumber.getHit();
                }


                    freeSlot = board.checkHit(hit);
                    boolean checkC = board.checkColum(freeSlot);
                    boolean checkB = board.checkBord();
                    if (!checkC && !checkB) {
                        checkBord = true;
                    } else if (checkC && checkB ) {
                        checkBord = true;
                    } else if (!checkC && checkB) {
                        System.out.println("Column is already full, try another column!");
                    }
            }



            board.addHit(hit, freeSlot, token);
            board.printField();

            if (!board.checkBord()) {
                System.out.println("Game over, no more free slots!!");
                exit = true;
            }

            if (game.checkVertical(board,token) || game.checkHorizontal(board,token) || game.checkDiagonal(board,token)) {
                String winner;
                if (count%2 != 0) {
                    winner = player1.getPlayerName();
                } else {
                    winner = player2.getPlayerName();
                }
                System.out.println();
                System.out.println("We have a winner!!!" + "\n " + "Winner is - " + winner);
                exit = true;
            }
            System.out.println();
            System.out.println("------------------------------");

        }

    }
}
