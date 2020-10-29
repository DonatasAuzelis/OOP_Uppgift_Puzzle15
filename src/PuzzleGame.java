import javax.swing.*;
import java.awt.*;

/**
 * Created by Donatas Auzelis
 * Date: 2020-10-29
 * Time: 10:37
 * Project: OOP_Sprint3_Inlämning
 * Copyright: MIT
 */
public class PuzzleGame extends JFrame{

    JPanel panel = new JPanel();
    JPanel gamePanel = new JPanel();
    JPanel optionsPanel = new JPanel();

    JButton newGameButton = new JButton("Nytt Spel");
    JButton sortTilesButton = new JButton("Sortera rätt");

    public PuzzleGame() {

        add(panel);
        panel.setLayout(new BorderLayout());

        panel.add("Center", gamePanel);
        gamePanel.setLayout(new GridLayout(4, 4));

        panel.add("West", optionsPanel);
        optionsPanel.setLayout(new GridLayout(2, 1));

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
