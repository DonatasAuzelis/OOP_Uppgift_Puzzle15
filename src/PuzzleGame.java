import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Donatas Auzelis
 * Date: 2020-10-29
 * Time: 10:37
 * Project: OOP_Sprint3_Inlämning
 * Copyright: MIT
 */
public class PuzzleGame extends JFrame implements ActionListener {

    //Panels
    JPanel panel = new JPanel();
    JPanel gamePanel = new JPanel();
    JPanel optionsPanel = new JPanel();

    //Move counter
    int clicks = 0;

    //Buttons
    JButton newGameButton = new JButton("Nytt Spel");
    JButton sortTilesButton = new JButton("Sortera rätt");

    ArrayList<JButton> gameTiles;

    public PuzzleGame() {

        //Main panel
        add(panel);
        panel.setLayout(new BorderLayout());

        //Game panel
        panel.add("Center", gamePanel);
        gamePanel.setLayout(new GridLayout(4, 4));

        //Options Panel
        panel.add("West", optionsPanel);
        optionsPanel.setLayout(new GridLayout(2, 1));

        newGameButton.addActionListener(this);
        optionsPanel.add(newGameButton);

        sortTilesButton.addActionListener(this);
        optionsPanel.add(sortTilesButton);
        sortTilesButton.setVisible(false);

        //Frame settings
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void addAndShuffleTiles() {
        gameTiles = new ArrayList<>();
        for (int i = 1; i < 16; i++) {
            gameTiles.add(new JButton(i + ""));
        }
        gameTiles.add(new JButton());
        Collections.shuffle(gameTiles);
    }

    public void addButtonListeners() {
        for (JButton button: gameTiles) {
            gamePanel.add(button);
            button.addActionListener(this);
        }
    }

    public void startNewGame() {
        //Cleanup
        gamePanel.removeAll();
        gamePanel.revalidate();
        gamePanel.repaint();

        //Add methods
        addAndShuffleTiles();
        addButtonListeners();

        //Frame settings
        sortTilesButton.setVisible(true);
        setSize(400, 350);
    }

    public void isEmpty(int index, JButton clicked) {
        JButton testButton = gameTiles.get(index);
        if (testButton.getText().equals("")) {
            testButton.setText(clicked.getText());
            clicked.setText("");
        }
    }

    public void tryToSwapTiles(JButton button) {

        int index = gameTiles.indexOf(button);

        try {
            isEmpty(index - 1, button); //Ett steg vänster
        } catch (IndexOutOfBoundsException e) {
            System.out.println();
        }
        try {
            isEmpty(index - 4, button); //Ett steg upp
        } catch (IndexOutOfBoundsException e) {
            System.out.println();
        }try {
            isEmpty(index +1 , button); //Ett steg höger
        } catch (IndexOutOfBoundsException e) {
            System.out.println();
        }try {
            isEmpty(index +4, button); //Ett steg ner
        } catch (IndexOutOfBoundsException e) {
            System.out.println();
        }
    }

    private void checkGameCondition() {
        for (int i = 0; i < gameTiles.size() - 1; i++) {
            JButton button = gameTiles.get(i);
            if (button.getText().equals("")) return;
            else if (Integer.parseInt(button.getText()) != (i + 1)) return;
        }
        JOptionPane.showMessageDialog(null, "Grattis, du vann!\n" + "Antal drag: " + clicks);
        System.exit(0);
    }

    public void sortTilesInOrder() {
        for (int i = 0; i < gameTiles.size() - 1; i++) {
            gameTiles.get(i).setText(i + 1 + "");
        }
        gameTiles.get(15).setVisible(false);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newGameButton)
            startNewGame();
        else if (e.getSource() == sortTilesButton){}
        else {}

    }
}
