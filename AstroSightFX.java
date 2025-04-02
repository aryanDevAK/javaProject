import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.PrintWriter;

public class AstroSightFX extends Application {
    private TextField nameField;
    private TextArea resultArea;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("AstroSight");
        
        // Create components
        Label titleLabel = new Label("AstroSight");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        
        Label nameLabel = new Label("Enter your name:");
        nameField = new TextField();
        nameField.setPrefWidth(200);
        
        Button calculateButton = new Button("Calculate");
        calculateButton.setDefaultButton(true);
        Button clearButton = new Button("Clear");
        Button saveButton = new Button("Save Results");
        
        resultArea = new TextArea();
        resultArea.setEditable(false);
        resultArea.setWrapText(true);
        resultArea.setPrefRowCount(10);
        
        // Set up layout
        VBox root = new VBox(20);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        
        HBox nameBox = new HBox(10);
        nameBox.setAlignment(Pos.CENTER);
        nameBox.getChildren().addAll(nameLabel, nameField);
        
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(calculateButton, clearButton, saveButton);
        
        root.getChildren().addAll(titleLabel, nameBox, buttonBox, resultArea);
        
        // Add event handlers
        calculateButton.setOnAction(e -> calculateAstrology());
        
        clearButton.setOnAction(e -> {
            nameField.clear();
            resultArea.clear();
        });
        
        saveButton.setOnAction(e -> saveResults(primaryStage));
        
        // Create scene
        Scene scene = new Scene(root, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void calculateAstrology() {
        String name = nameField.getText().trim();
        
        if (name.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Please enter a name");
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
    
    private void saveResults(Stage stage) {
        if (resultArea.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "No results to save");
            return;
        }
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Results");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        
        File file = fileChooser.showSaveDialog(stage);
        
        if (file != null) {
            try (PrintWriter writer = new PrintWriter(file)) {
                writer.println(resultArea.getText());
                showAlert(Alert.AlertType.INFORMATION, "Success", "Results saved successfully");
            } catch (Exception ex) {
                showAlert(Alert.AlertType.ERROR, "Error", "Error saving file: " + ex.getMessage());
            }
        }
    }
    
    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

