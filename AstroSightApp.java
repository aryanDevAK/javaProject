import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AstroSightApp extends JFrame {
    private JTextField nameField;
    private JTextArea resultArea;
    private JButton calculateButton;
    private JButton clearButton;
    private JButton saveButton;
    
    public AstroSightApp() {
        // Set up the frame
        super("AstroSight");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        
        // Create components
        JLabel titleLabel = new JLabel("AstroSight", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        
        JLabel nameLabel = new JLabel("Enter your name:");
        nameField = new JTextField(20);
        
        calculateButton = new JButton("Calculate");
        clearButton = new JButton("Clear");
        saveButton = new JButton("Save Results");
        
        resultArea = new JTextArea(10, 40);
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        
        // Set up layout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.add(titleLabel, BorderLayout.CENTER);
        
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(calculateButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(saveButton);
        
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(titlePanel, BorderLayout.NORTH);
        topPanel.add(inputPanel, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        
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
        
        // Add components to frame
        add(mainPanel);
        
        // Make the enter key work for calculation
        nameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    calculateAstrology();
                }
            }
        });
        
        // Display the frame
        setVisible(true);
    }
    
    private void calculateAstrology() {
        String name = nameField.getText().trim();
        
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a name", "Error", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(this, "No results to save", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save Results");
        
        int userSelection = fileChooser.showSaveDialog(this);
        
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            
            // Add .txt extension if not present
            if (!fileToSave.getName().toLowerCase().endsWith(".txt")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".txt");
            }
            
            try (PrintWriter writer = new PrintWriter(fileToSave)) {
                writer.println(resultArea.getText());
                JOptionPane.showMessageDialog(this, "Results saved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public static void main(String[] args) {
        // Set look and feel to system default
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Start the application
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AstroSightApp();
            }
        });
    }
}

