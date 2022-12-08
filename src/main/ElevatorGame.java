package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ElevatorGame extends Application {

    public static final int TILE_SIZE = 32;
    public static final int WIDTH = TILE_SIZE * 40;
    public static final int HEIGHT = TILE_SIZE * 20;

    private ElevatorPanel elevatorPanel;
    private GamePanel gamePanel;
    private ControlPanel controlPanel;

    private int currentFloor;

    @Override
    public void start(Stage stage) {

        gamePanel = new GamePanel(this);
        elevatorPanel = new ElevatorPanel(this);
        controlPanel = new ControlPanel(this);
        HBox root = new HBox();
        VBox leftPane = new VBox();

        leftPane.setPrefWidth(WIDTH / 4.0);
        leftPane.getChildren().add(controlPanel);
        leftPane.getChildren().add(elevatorPanel);

        root.getChildren().add(leftPane);
        root.getChildren().add(gamePanel);

        Scene scene = new Scene(root, WIDTH, HEIGHT);

        stage.setTitle("Elevator Game!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        gamePanel.paint(currentFloor);
        elevatorPanel.paint();
    }

    public static void main(String[] args) {
        launch();
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
        repaint();
    }

    private void repaint() {
        gamePanel.paint(currentFloor);
        elevatorPanel.paint();
    }
}
