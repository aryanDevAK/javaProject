import java.awt.*;
import java.awt.event.*;

public class AstroSightLauncher {
    public static void main(String[] args) {
        Frame frame = new Frame("AstroSight Launcher");
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());
        frame.setResizable(false);

        Label label = new Label("Which version of AstroSight would you like to run?");
        Button swingButton = new Button("Swing (Basic)");
        Button javafxButton = new Button("JavaFX (Modern)");

        swingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                AstroSightApp.main(args);
            }
        });

        javafxButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                AstroSightFX.main(args);
            }
        });

        frame.add(label);
        frame.add(swingButton);
        frame.add(javafxButton);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }
}
