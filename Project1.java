import javax.swing.*; 
import java.io.*;
import java.awt.event.*;

public class Project1 extends PuzzleGUI{

    public static String validLetters(TextFileInput inFile){
        return inFile.readLine();
    }

    public static boolean threePoints(String guess, String validLetters, int validLength){
        for(int i = 0; i < validLength; i++){
            if(!(guess.contains(Character.toString(validLetters.charAt(i))))) return false;
        }
        return true;
    }
    
    public static void setTextArea(WordList list, JTextArea textArea){
        WordNode temp = list.first.next;
        textArea.setText("");
        while(temp != null){ 
                textArea.append(temp.data + " ");
            temp = temp.next;
        }
    }

    public static boolean Test1(String guess, String validLetters){
        for(int i = 0; i < guess.length(); i++){
            if(validLetters.contains(Character.toString(guess.charAt(i)))) continue;
            else return false;
            }
        return true;
    }

    public static boolean Test2(String guess){
        if(guess.length() < 5){
            return false;
        }

        return true;
     }

    public static boolean Test3(String guess, WordList list){
        if(list.contains(list, guess)) return true;

        return false;  
    }

    public static boolean Test4(String guess, String arr[]){
        for(int i = 0; i < arr.length; i++){
            if(guess.equals(arr[i])) return false;
        }

        return true;
    }

    public static boolean Test5(String guess, String validLetters){
            if(guess.contains(Character.toString(validLetters.charAt(0)))) return true;
            return false;  
    }

    public static void main(String args[]){
        puzzleGUI();

        FileMenuHandler fileMenuHandler = new FileMenuHandler(frame);
        fileMenuHandler.actionPerformed(new ActionEvent(frame, ActionEvent.ACTION_PERFORMED, "Open"));
        File openedFile = FileMenuHandler.file;
        TextFileInput inFile = new TextFileInput(openedFile.getAbsolutePath());

        String validLetters = validLetters(inFile);

        letters.append(validLetters);

        SortedWordList sortedList = new SortedWordList();
        WordList unsortedList = new WordList();

        int score = 0;
        int count = 0;
        int length = 0;

        String line = inFile.readLine();
        while (line != null){
            try{
            unsortedList.append(line);
            }
            catch (IllegalWordException exception){
                JOptionPane.showMessageDialog(null, "Caught IllegalWordException: " + exception.getMessage());
                System.out.println("The erroneous word is: " + line);
                length--;
            }
            length++;
            line = inFile.readLine();
        }
        String previousGuesses[] = new String[length + 1];  

        while(true){
            String guess = JOptionPane.showInputDialog(null, "Guess a word using at least 5 of the letters provided");

            if(guess.equalsIgnoreCase("STOP")) System.exit(0);

            // Test 1 
            if(Test1(guess, validLetters) != true){
                JOptionPane.showMessageDialog(null, "You used a letter that is not one of the seven letters provided.");
            }

            if(Test2(guess) != true){
                JOptionPane.showMessageDialog(null, "You need to use at least 5 letters");
            }
            else if(Test3(guess, unsortedList)!= true){
                JOptionPane.showMessageDialog(null, "This word is not a solution.");
            }
            else if(Test4(guess, previousGuesses) != true){
                JOptionPane.showMessageDialog(null, "You guessed this word before");
            }
            else if (Test5(guess, validLetters) != true){
                JOptionPane.showMessageDialog(null, "You need to use the first letter of the subject letters in your guess.");
            }

            else{
                sortedList.add(guess, sortedList);
                setTextArea(sortedList, guesses);
                count++;
                previousGuesses[count] = guess;
                if(threePoints(guess, validLetters, validLetters.length())) score += 3;
                else score++;
                scoreLabel.setText("Score: " + score);
                frame.setVisible(true);
                }

            if(score == length + 2) break;
        }
        JOptionPane.showMessageDialog(null, "You won the game!");
 
    }
}
