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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
