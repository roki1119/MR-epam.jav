import java.util.Scanner;


public class NewVersionInConsole {

    private char element[] = new char[9];
    private char player;
    private int measurement;


    public static void main(String args[]) {
        String tmp;
        NewVersionInConsole function = new NewVersionInConsole();
        do {
            function.game();
            System.out.println("Jeśli chcesz zagrać ponownie, wpisz 'chce'");
            Scanner in = new Scanner(System.in);
            tmp = in.nextLine();
            System.out.println("Wpisałeś" +tmp+ "niepoprawny przycisk. Wpisz chce, aby powrócić do gry");
        } while (tmp.equals("chce"));
    }


    public String ticTacToeBackground() {
        System.out.println("________________\n");
        System.out.println("| " + element[0] + "  | " + element[1] + "  | " + element[2] + "  |\n|    |    |    |");
        System.out.println("________________\n");
        System.out.println("| " + element[3] + "  | " + element[4] + "  | " + element[5] + "  |\n|    |    |    |");
        System.out.println("________________\n");
        System.out.println("| " + element[6] + "  | " + element[7] + "  | " + element[8] + "  |\n|    |    |    |");
        System.out.println("________________\n");
        return "ticTacToeBackground";
    }

    public char checkWinnerOfTheGame() {
        char Winner = ' ';

        if (element[0] == 'X' && element[3] == 'X' && element[6] == 'X') Winner = 'X';
        if (element[1] == 'X' && element[4] == 'X' && element[7] == 'X') Winner = 'X';
        if (element[2] == 'X' && element[5] == 'X' && element[8] == 'X') Winner = 'X';
        if (element[0] == 'X' && element[1] == 'X' && element[2] == 'X') Winner = 'X';
        if (element[3] == 'X' && element[4] == 'X' && element[5] == 'X') Winner = 'X';
        if (element[6] == 'X' && element[7] == 'X' && element[8] == 'X') Winner = 'X';
        if (element[0] == 'X' && element[4] == 'X' && element[8] == 'X') Winner = 'X';
        if (element[2] == 'X' && element[4] == 'X' && element[6] == 'X') Winner = 'X';

        if (element[0] == 'O' && element[3] == 'O' && element[6] == 'O') Winner = 'O';
        if (element[1] == 'O' && element[4] == 'O' && element[7] == 'O') Winner = 'O';
        if (element[2] == 'O' && element[5] == 'O' && element[8] == 'O') Winner = 'O';
        if (element[0] == 'O' && element[1] == 'O' && element[2] == 'O') Winner = 'O';
        if (element[3] == 'O' && element[4] == 'O' && element[5] == 'O') Winner = 'O';
        if (element[6] == 'O' && element[7] == 'O' && element[8] == 'O') Winner = 'O';
        if (element[0] == 'O' && element[4] == 'O' && element[8] == 'O') Winner = 'O';
        if (element[2] == 'O' && element[4] == 'O' && element[6] == 'O') Winner = 'O';

        if (Winner == 'X') {
            System.out.println("Gracz Krzyżyk (X) wygrał grę.");
            return Winner;
        }
        if (Winner == 'O') {
            System.out.println("Gracz Kółko (O) wygrał grę.");
            return Winner;
        }

        for (int i = 0; i <= 8; i++) {
            if (element[i] == 'X' || element[i] == 'O') {
                if (i == 8) {
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
        for (i = 0; i < 9; i++)
            element[i] = newElement[i];
        ticTacToeBackground();

    }
    public void game() {
        int place;
        char empty = ' ';

        System.out.println("Grasz w grę kółko i krzyżyk.\nWygrywa ten, który pierwszy skreśli 3 wartości po wierszu, kolumnie lub diagonali.");

        do {
            ticTacToeBackground();

            System.out.println("Rozpocznij grę przyciskiem numerycznym");

            boolean posTaken = true;
            while (posTaken) {
                Scanner in = new Scanner(System.in);
                place = in.nextInt();
                posTaken = busyPlace(place);
                if (posTaken == false)
                    element[place] = getPlayer();
            }
            ticTacToeBackground();
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