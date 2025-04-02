import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.PrintWriter;
import javax.swing.*;

public class AstroSightAWT extends Frame {
    private TextField nameField;
    private TextArea resultArea;

    public AstroSightAWT() {
        setTitle("AstroSight");
        setSize(600, 500);
        setLayout(new BorderLayout());

        // Create components
        Label titleLabel = new Label("AstroSight", Label.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        Panel inputPanel = new Panel(new FlowLayout());
        Label nameLabel = new Label("Enter your name:");
        nameField = new TextField(20);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);

        Panel buttonPanel = new Panel(new FlowLayout());
        Button calculateButton = new Button("Calculate");
        Button clearButton = new Button("Clear");
        Button saveButton = new Button("Save Results");
        buttonPanel.add(calculateButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(saveButton);

        resultArea = new TextArea(10, 50);
        resultArea.setEditable(false);

        // Add components to the frame
        add(titleLabel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(resultArea, BorderLayout.EAST);

        // Add event handlers
        calculateButton.addActionListener(e -> calculateAstrology());
        clearButton.addActionListener(e -> {
            nameField.setText("");
            resultArea.setText("");
        });
        saveButton.addActionListener(e -> saveResults());

        // Add window closing event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void calculateAstrology() {
        String name = nameField.getText().trim();

        if (name.isEmpty()) {
            showAlert("Error", "Please enter a name");
            return;
        }

        // Dummy data for demonstration
        String rashi = "Aries";
        String ratan = "Ruby";
        String day = "Tuesday";
        String dhatu = "Gold";
        String quantity = "5";

        StringBuilder result = new StringBuilder();
        result.append("Results for: ").append(name).append("\n\n");
        result.append("Rashi: ").append(rashi).append("\n");
        result.append("Ratan: ").append(ratan).append("\n");
        result.append("Day: ").append(day).append("\n");
        result.append("Dhatu: ").append(dhatu).append("\n");
        result.append("Quantity: ").append(quantity).append("\n");

        resultArea.setText(result.toString());
    }

    private void saveResults() {
        if (resultArea.getText().isEmpty()) {
            showAlert("Error", "No results to save");
            return;
        }

        FileDialog fileDialog = new FileDialog(this, "Save Results", FileDialog.SAVE);
        fileDialog.setFile("*.txt");
        fileDialog.setVisible(true);

        String directory = fileDialog.getDirectory();
        String fileName = fileDialog.getFile();

        if (directory != null && fileName != null) {
            File file = new File(directory, fileName);
            try (PrintWriter writer = new PrintWriter(file)) {
                writer.println(resultArea.getText());
                showAlert("Success", "Results saved successfully");
            } catch (Exception ex) {
                showAlert("Error", "Error saving file: " + ex.getMessage());
            }
        }
    }

    private void showAlert(String title, String message) {
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new AstroSightAWT();
    }
}
