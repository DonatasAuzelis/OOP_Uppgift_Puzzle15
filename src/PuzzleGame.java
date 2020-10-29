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

    JPanel panel = new JPanel();
    JPanel gamePanel = new JPanel();
    JPanel optionsPanel = new JPanel();

    JButton newGameButton = new JButton("Nytt Spel");
    JButton sortTilesButton = new JButton("Sortera rätt");

    ArrayList<JButton> gameTiles;

    public PuzzleGame() {

        add(panel);
        panel.setLayout(new BorderLayout());

        panel.add("Center", gamePanel);
        gamePanel.setLayout(new GridLayout(4, 4));

        panel.add("West", optionsPanel);
        optionsPanel.setLayout(new GridLayout(2, 1));

        newGameButton.addActionListener(this);
        optionsPanel.add(newGameButton);

        sortTilesButton.addActionListener(this);
        optionsPanel.add(sortTilesButton);
        sortTilesButton.setVisible(false);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newGameButton)
            startNewGame();
        else if (e.getSource() == sortTilesButton){}
        else {}

    }
}
