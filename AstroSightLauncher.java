import javax.swing.*;

public class AstroSightLauncher {
    public static void main(String[] args) {
        // Ask user which version to run
        Object[] options = {"Swing (Basic)", "JavaFX (Modern)"};
        int choice = JOptionPane.showOptionDialog(null,
                "Which version of AstroSight would you like to run?",
                "AstroSight Launcher",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
        
        if (choice == 0) {
            // Run Swing version
            AstroSightApp.main(args);
        } else {
            // Run JavaFX version
            AstroSightFX.main(args);
        }
    }
}

