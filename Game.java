import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {

    public void createPlayer() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Player player1;
        Player player2 = null;

        System.out.println("Gravitrips game!");
        System.out.println("Select game mode:");
        System.out.println("Computer to Player - press 1 and ENTER ");
        System.out.println("Player to Player - press 2 and ENTER ");

        boolean exit = false;

        while (!exit) {
            try {
                int number = Integer.parseInt(reader.readLine());
                if (number == 2) {
                    player2 = new HumanPlayer(2);
                    exit = true;

                } else if (number == 1) {
                    player2 = new ComputerPlayer();
                    exit = true;
                } else {
                    System.out.println("Wrong!!! Please enter valid number! Valid number range 1 or 2");
                }
            } catch (Exception e) {
                System.out.println("Wrong!!! Please enter valid number! Valid number range 1 or 2");
            }

        }

        player1 = new HumanPlayer(1);

        printPlayers(player1);
        printPlayers(player2);

        System.out.println("Let's Start! \n");

        runGame(player1, player2);
    }

    public void printPlayers(Player player) {
        System.out.println("Player " + player.getPlayerName() + " set token - " + player.getToken());
    }

    public void runGame(Player player1, Player player2) {
        Board board = new Board();
        board.printField();
        Player currentPlayer = player1;

        while ((checkGame(board, currentPlayer)) && (chechWinner(board, currentPlayer))) {

            if (currentPlayer == player1) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
            System.out.println("\n------------------------------");
        }
    }

    public boolean checkGame (Board board, Player player) {

        if (!board.checkBord()) {
            System.out.println("Game over, no more free slots!!");
            return false;

        } else {
            int hit = player.getHit();
            int freeSlot = board.checkHit(hit);

            while (!board.checkColum(freeSlot)) {
                System.out.println("Column is already full, try another column!");
                hit = player.getHit();
                freeSlot = board.checkHit(hit);
            }
            board.addHit(hit, freeSlot, player.getToken());
            board.printField();
            return true;
        }
    }

    public boolean chechWinner(Board board, Player player) {
        CheckWinner game = new CheckWinner();
        if (game.checkVertical(board, player.getToken()) || game.checkHorizontal(board, player.getToken()) || game.checkDiagonal(board, player.getToken())) {

            System.out.println(" \n We have a winner!!! \n Winner is - " + player.getPlayerName());
            return false;
        }
        return true;
    }
}