package de.hype.bbsentials.profileidfromlogs;

public class Main {
    public static void main(String[] args) {
        // Create and show the Swing GUI
        MainGui gui = new MainGui();
        gui.setVisible(true);
        while (true) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ignored) {
                //ignored
            }
        }
    }
}

