import java.awt.*;
import javax.swing.*;
import java.io.*;

public class PuzzleGUI {

    public static JTextArea letters;
    public static JTextArea guesses;
    public static JFrame frame;
    public static JLabel guessesLabel;
    public static JLabel scoreLabel;

    public static void puzzleGUI() {
        // Create frame
        frame = new JFrame("Word Game");
        Container pane = frame.getContentPane();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 500);
        frame.setLocation(200, 200);
        frame.setLayout(new GridLayout(2, 1));

        // Set up content
        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new BorderLayout()); 

        letters = new JTextArea();
        letters.setEditable(false);
        letters.setFont(letters.getFont().deriveFont(16f));

        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setFont(scoreLabel.getFont().deriveFont(17f));

        guesses = new JTextArea();
        guesses.setEditable(false);
        guesses.setFont(guesses.getFont().deriveFont(16f));
        JScrollPane guessesScrollPane = new JScrollPane(guesses);
        guessesScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        JLabel lettersLabel = new JLabel("Letters");
        lettersLabel.setFont(lettersLabel.getFont().deriveFont(18f));

        guessesLabel = new JLabel("Guesses:");
        guessesLabel.setFont(guessesLabel.getFont().deriveFont(18f));

        // Add letters label and text area to panel1
        panel1.add(lettersLabel, BorderLayout.NORTH);
        panel1.add(letters, BorderLayout.CENTER);
        panel1.setBackground(Color.WHITE);

        // Add guesses label and text area to panel2
        panel2.add(guessesLabel, BorderLayout.NORTH);
        panel2.add(guessesScrollPane, BorderLayout.CENTER);
        panel2.add(scoreLabel, BorderLayout.SOUTH);
        panel2.setBackground(Color.WHITE);

        pane.add(panel1);
        pane.add(panel2);

        //create file menu
        JMenuBar menuBar = new JMenuBar();
        JMenuItem   item;
        JMenu       fileMenu = new JMenu("File");
        FileMenuHandler fmh  = new FileMenuHandler(frame);
  
        item = new JMenuItem("Open");    //Open...
        item.addActionListener(fmh);
        fileMenu.add(item);
  
        fileMenu.addSeparator();           //add a horizontal separator line
      
        item = new JMenuItem("Quit");       //Quit
        item.addActionListener(fmh);
        fileMenu.add(item);
  
        menuBar.add(fileMenu);  
        frame.setJMenuBar(menuBar);

        frame.setVisible(true);
    }

    public static String processFile(File file){
        if (file != null){
            return file.getAbsolutePath();
        }
        return null;
    }
}

