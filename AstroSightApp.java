import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AstroSightApp extends Frame {
    private TextField nameField;
    private TextArea resultArea;
    private Button calculateButton;
    private Button clearButton;
    private Button saveButton;

    public AstroSightApp() {
        // Set up the frame
        super("AstroSight");
        setSize(600, 500);
        setLayout(new BorderLayout(10, 10));
        setLocationRelativeTo(null);

        // Create components
        Label titleLabel = new Label("AstroSight", Label.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        Label nameLabel = new Label("Enter your name:");
        nameField = new TextField(20);

        calculateButton = new Button("Calculate");
        clearButton = new Button("Clear");
        saveButton = new Button("Save Results");

        resultArea = new TextArea(10, 40);
        resultArea.setEditable(false);

        // Set up layout
        Panel titlePanel = new Panel(new BorderLayout());
        titlePanel.add(titleLabel, BorderLayout.CENTER);

        Panel inputPanel = new Panel(new FlowLayout(FlowLayout.CENTER));
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);

        Panel buttonPanel = new Panel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(calculateButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(saveButton);

        Panel topPanel = new Panel(new BorderLayout());
        topPanel.add(titlePanel, BorderLayout.NORTH);
        topPanel.add(inputPanel, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);
        add(resultArea, BorderLayout.CENTER);

        // Add action listeners
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateAstrology();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameField.setText("");
                resultArea.setText("");
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveResults();
            }
        });

        // Add window listener for closing
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        // Display the frame
        setVisible(true);
    }

    private void calculateAstrology() {
        String name = nameField.getText().trim();

        if (name.isEmpty()) {
            showMessageDialog("Please enter a name", "Error");
            return;
        }

        AstrologyInfo info = AstroDataManager.getInfoByName(name);

        StringBuilder result = new StringBuilder();
        result.append("Results for: ").append(name).append("\n\n");
        result.append("Rashi: ").append(info.getRashi()).append("\n");
        result.append("Ratan: ").append(info.getRatan()).append("\n");
        result.append("Day: ").append(info.getDay()).append("\n");
        result.append("Dhatu: ").append(info.getDhatu()).append("\n");
        result.append("Quantity: ").append(info.getQuantity()).append("\n");

        resultArea.setText(result.toString());
    }

    private void saveResults() {
        if (resultArea.getText().isEmpty()) {
            showMessageDialog("No results to save", "Error");
            return;
        }

        FileDialog fileDialog = new FileDialog(this, "Save Results", FileDialog.SAVE);
        fileDialog.setVisible(true);

        String directory = fileDialog.getDirectory();
        String fileName = fileDialog.getFile();

        if (directory != null && fileName != null) {
            File fileToSave = new File(directory, fileName);

            // Add .txt extension if not present
            if (!fileToSave.getName().toLowerCase().endsWith(".txt")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".txt");
            }

            try (PrintWriter writer = new PrintWriter(fileToSave)) {
                writer.println(resultArea.getText());
                showMessageDialog("Results saved successfully", "Success");
            } catch (Exception ex) {
                showMessageDialog("Error saving file: " + ex.getMessage(), "Error");
            }
        }
    }

    private void showMessageDialog(String message, String title) {
        Dialog dialog = new Dialog(this, title, true);
        dialog.setLayout(new FlowLayout());
        dialog.setSize(300, 150);

        Label messageLabel = new Label(message, Label.CENTER);
        Button okButton = new Button("OK");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

        dialog.add(messageLabel);
        dialog.add(okButton);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        new AstroSightApp();
    }
}
