package de.hype.bbsentials.profileidfromlogs;

import javax.swing.*;
import java.awt.*;

public class SimplePopup {
    private JFrame frame;
    private JTextArea textArea;

    // Constructor
    public SimplePopup(String initialText) {
        // Create the frame
        frame = new JFrame("Profile ID Extracter Info");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // Create the label with initial text
        System.out.println(initialText);
        textArea = new JTextArea(initialText);
        textArea.setMargin(new Insets(0, 10, 0, 0));
        textArea.setColumns(50);
        textArea.setRows(50);

        // Add label to frame
        frame.getContentPane().add(textArea);
        frame.add(textArea);
        // Set frame size and visibility
        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }

    public void setText(String newText){
        setText(newText,true);
    }
    // Method to change the text shown in the popup
    public void setText(String newText,boolean dontReset) {
        System.out.println(newText);
        if (dontReset)textArea.append("\n" + newText); // Append the new text
        else textArea.setText(newText);
    }

    public void setClosable(boolean closable){
        if (closable) frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            else frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }
}
