import java.util.Scanner;


public class NewVersionInConsole {

    private char element[] = new char[10];
    private char player;
    private int measurement;


    public static void main(String args[]) {
        String tmp;
        NewVersionInConsole function = new NewVersionInConsole();
        do {
            function.play();
            System.out.println("Jeśli chcesz zagrać ponownie, wpisz 'chce'");
            Scanner in = new Scanner(System.in);
            tmp = in.nextLine();
            System.out.println("Wpisałeś" +tmp+ "niepoprawny przycisk. Wpisz chce, aby powrócić do gry");
        } while (tmp.equals("chce"));
    }


    public String ticTacToeBoard() {
        System.out.println("________________\n");
        System.out.println("| " + element[1] + "  | " + element[2] + "  | " + element[3] + "  |\n|    |    |    |");
        System.out.println("________________\n");
        System.out.println("| " + element[4] + "  | " + element[5] + "  | " + element[6] + "  |\n|    |    |    |");
        System.out.println("________________\n");
        System.out.println("| " + element[7] + "  | " + element[8] + "  | " + element[9] + "  |\n|    |    |    |");
        System.out.println("________________\n");
        return "ticTacToeBoard";
    }

    public char checkWinnerOfTheGame() {
        char Winner = ' ';

        if (element[1] == 'X' && element[4] == 'X' && element[7] == 'X') Winner = 'X';
        if (element[2] == 'X' && element[5] == 'X' && element[8] == 'X') Winner = 'X';
        if (element[3] == 'X' && element[6] == 'X' && element[9] == 'X') Winner = 'X';
        if (element[1] == 'X' && element[2] == 'X' && element[3] == 'X') Winner = 'X';
        if (element[4] == 'X' && element[5] == 'X' && element[6] == 'X') Winner = 'X';
        if (element[7] == 'X' && element[8] == 'X' && element[9] == 'X') Winner = 'X';
        if (element[1] == 'X' && element[5] == 'X' && element[9] == 'X') Winner = 'X';
        if (element[3] == 'X' && element[5] == 'X' && element[7] == 'X') Winner = 'X';


        // Check if O wins
        if (element[1] == 'O' && element[4] == 'O' && element[7] == 'O') Winner = 'O';
        if (element[2] == 'O' && element[5] == 'O' && element[8] == 'O') Winner = 'O';
        if (element[3] == 'O' && element[6] == 'O' && element[9] == 'O') Winner = 'O';
        if (element[1] == 'O' && element[2] == 'O' && element[3] == 'O') Winner = 'O';
        if (element[4] == 'O' && element[5] == 'O' && element[6] == 'O') Winner = 'O';
        if (element[7] == 'O' && element[8] == 'O' && element[9] == 'O') Winner = 'O';
        if (element[1] == 'O' && element[5] == 'O' && element[9] == 'O') Winner = 'O';
        if (element[3] == 'O' && element[5] == 'O' && element[7] == 'O') Winner = 'O';

        if (Winner == 'X') {
            System.out.println("Gracz Krzyżyk (X) wygrał grę.");
            return Winner;
        }
        if (Winner == 'O') {
            System.out.println("Gracz Kółko (O) wygrał grę.");
            return Winner;
        }

        for (int i = 1; i <= 9; i++) {
            if (element[i] == 'X' || element[i] == 'O') {
                if (i == 9) {
                    char ex = ' ';
                    System.out.println("Remis, żaden gracz nie wygrał. Spróbuj zagrać ponownie.");
                    return ex;
                }
                continue;
            } else
                break;

        }

        return Winner;
    }
    public void additionalBoard() {

        char newElement[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int i;
        measurement = 0;
        player = 'X';
        for (i = 1; i < 10; i++)
            element[i] = newElement[i];
        ticTacToeBoard();


    }
    public void play() {
        int place;
        char empty = ' ';

        System.out.println("Grasz w grę kółko i krzyżyk.\nWygrywa ten, który pierwszy skreśli 3 wartości po wierszu, kolumnie lub diagonali.");

        do {
            ticTacToeBoard();

            System.out.println("Rozpocznij grę przyciskiem numerycznym");

            boolean posTaken = true;
            while (posTaken) {
                // System.out.println( "position is taken, please enter a valid space");
                Scanner in = new Scanner(System.in);
                place = in.nextInt();
                posTaken = busyPlace(place);
                if (posTaken == false)
                    element[place] = getPlayer();
            }
            ticTacToeBoard();
            nextCaseOfPlayer();
        } while (checkWinnerOfTheGame() == empty);

    }



    public boolean busyPlace(int place) {


        if (element[place] == 'X' || element[place] == 'O') {
            System.out.println("To pole jest już zajęte. Wybierz inne.");
            return true;
        } else {
            return false;
        }

        //  measurement++;
        //    return false;
    }


    public void nextCaseOfPlayer() {
        if (player == 'X')
            player = 'O';
        else player = 'X';

    }

    public char getPlayer() {
        return player;
    }
}