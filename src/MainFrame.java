import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class MainFrame extends JFrame implements ActionListener{            //obsługuje zdarzenia

    enum PLAYER{O, X}

    private List<JButton> buttons;
    private Container container;
    private final static int NUM_OF_BUTTONS = 9;        //tyle bedzie przyciskow (8 indeksów w liście)
    private String player;
    private PLAYER currentPlayer = PLAYER.O;            //zaczyna grę gracz Kółko (O)
    private int turn = 1;

    private void createButtons() {                      //tworzę 9przycisków pętlą for 012345678
        for (int i = 0; i < NUM_OF_BUTTONS; i++) {
            JButton b = new JButton("");
            buttons.add(b);
            container.add(b);
            //dodanie nasluchania przez metode actionPerformed
            b.addActionListener(this);

        }
    }
    public MainFrame(String title) {
        super(title);
        buttons = new ArrayList<>();
        container = getContentPane();
        setLayout(new GridLayout(3, 3));
        createButtons();
        setMinimumSize(new Dimension(300, 300));
        setLocation(100, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    //ActionPerformed - nie wiem czy dobrze, ale dziala
    @Override
    public void actionPerformed(ActionEvent event) {
        JButton button = (JButton) event.getSource();
        if (currentPlayer == PLAYER.O) {    //deklaracja gracza
            button.setText("O");
            currentPlayer = PLAYER.X;
        } else {
            button.setText("X");
            currentPlayer = PLAYER.O;
        }
        turn++;

        button.setEnabled(false);           //okienko z komunikatem i okey'ka
        int q = checkWinner(PLAYER.O);      //ktory gracz wygrywa
        if (q == 1) {           //wygrywa kolko o
            JOptionPane.showMessageDialog(null, "Wygrał gracz Kółko(O).");     //pokazuje wiadomosc
            System.exit(0);
        } else {
            q = checkWinner(PLAYER.X);
            if (q == 1) {       //wygrywa krzyzyk x
                JOptionPane.showMessageDialog(null, "Wygrał gracz Krzyżyk (X).");
                System.exit(0);
            }
            if (q == 2) {       //remis
                JOptionPane.showMessageDialog(null, "Remis - żaden gracz nie wygrał. \n Spróbuj ponownie.");
                System.exit(0);
            }
        }
    }

    private int checkWinner(PLAYER player) {
        String s = player.toString();
        boolean winner = false;

        //sprawdzenie wygranej w kolumnie albo wierszu i diagonalnie
        for (int i = 0; i < 3; i++) {
            if (buttons.get(i).getText().equals(s) &&               //kolumna najpierw x-- x-- x--
                    buttons.get(i + 3).getText().equals(s) &&       //potem kolumna -x- -x- -x-
                    buttons.get(i + 6).getText().equals(s)) {       //ostatnia kolumna --x --x --x
                winner = true;
                break;
            }

            if (buttons.get(i * 3).getText().equals(s) &&           //poziomo wiersz1 xxx --- ---
                    buttons.get(i * 3 + 1).getText().equals(s) &&   //poziomo wiersz2 --- xxx ---
                    buttons.get(i * 3 + 2).getText().equals(s)) {   //poziomo wiersz3 --- --- xxx
                winner = true;
                break;
            }
        }
        if (buttons.get(0).getText().equals(s) &&                   //diagonalnie 1 opcja: x-- -x- --x  (elementy 0,4,8)
                buttons.get(4).getText().equals(s) &&
                buttons.get(8).getText().equals(s)                  //licz od zerowego indeksu!!!!
                ||
                (buttons.get(2).getText().equals(s) &&              //diagonalnie 2 opcja: --x -x- --x (elementy 2,4,6)
                        buttons.get(4).getText().equals(s) &&
                        buttons.get(6).getText().equals(s)))

            winner = true;

        if (winner) {       //ostatnia deklaracje dla wygranego
            return 1;
        } else {
            if (turn == 9) {
                return 2;
            } else {
                return 0;
            }
        }
    }
}
