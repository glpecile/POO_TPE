package frontend;

import backend.CanvasState;
import backend.model.Circle;
import backend.model.Figure;
import backend.model.Point;
import backend.model.Rectangle;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PaintPane extends BorderPane {

	// BackEnd
	private CanvasState canvasState;

	// Canvas y relacionados
	private Canvas canvas = new Canvas(800, 600);
	private GraphicsContext gc = canvas.getGraphicsContext2D();
	private Color lineColor = Color.BLACK;
	private Color fillColor = Color.YELLOW;

	// Botones Barra Izquierda
	private ToggleButton selectionButton = new ToggleButton("Seleccionar");
	private ToggleButton deleteButton = new ToggleButton("Borrar");
	private ToggleButton bringForwardButton = new ToggleButton("Al fondo");
	private ToggleButton sendBackButton = new ToggleButton("Al frente");
	private Slider strokeSlider = new Slider(1,50,0);
	private ColorPicker strokeColorPicker = new ColorPicker(Color.BLACK);
	private final Label	strokeText = new Label("Borde");
	private ColorPicker fillColorPicker = new ColorPicker(Color.YELLOW);
	private final Label	fillText = new Label("Relleno");

	// Dibujar una figura
	private Point startPoint;

	// Seleccionar una figura
	private Figure selectedFigure;

	// StatusBar
	private StatusPane statusPane;

	public PaintPane(CanvasState canvasState, StatusPane statusPane) {
		this.canvasState = canvasState;
		this.statusPane = statusPane;
		List<ToggleButton> toolsList = new ArrayList<>();
		ToggleGroup tools = new ToggleGroup();
		toolsList.add(selectionButton);
		toolsList.addAll(Arrays.stream(FigureButtons.values()).map(FigureButtons::getButton).collect(Collectors.toList()));
		toolsList.add(deleteButton);
		toolsList.add(bringForwardButton);
		toolsList.add(sendBackButton);
		toolsList.forEach(tool -> { tool.setMinWidth(90); tool.setToggleGroup(tools); tool.setCursor(Cursor.HAND); });
		VBox buttonsBox = new VBox(10);
		buttonsBox.getChildren().addAll(toolsList);
		strokeSlider.setShowTickMarks(true);
		strokeSlider.setShowTickLabels(true);
		buttonsBox.getChildren().add(strokeText);
		buttonsBox.getChildren().add(strokeSlider);
		buttonsBox.getChildren().add(strokeColorPicker);
		buttonsBox.getChildren().add(fillText);
		buttonsBox.getChildren().add(fillColorPicker);
		buttonsBox.setPadding(new Insets(5));
		buttonsBox.setStyle("-fx-background-color: #999999");
		buttonsBox.setPrefWidth(100);
		gc.setLineWidth(1);

		canvas.setOnMousePressed(event -> startPoint = new Point(event.getX(), event.getY()));

		canvas.setOnMouseReleased(event -> {
			Point endPoint = new Point(event.getX(), event.getY());
			try {
				Figure newFigure = FigureButtons.fetchFigure(startPoint,endPoint);
				if (newFigure != null)
					canvasState.addFigure(newFigure);
			}catch (Exception e){
				System.out.println(e.getClass());
			}
			redrawCanvas();
		});

		canvas.setOnMouseMoved(event -> {
			Point eventPoint = new Point(event.getX(), event.getY());
			boolean found = false;
			StringBuilder label = new StringBuilder();
			for(Figure figure : canvasState.figures()) {
				if(figure.contains(eventPoint)) {
					found = true;
					label.append(figure.toString());
				}
			}
			if(found) {
				statusPane.updateStatus(label.toString());
			} else {
				statusPane.updateStatus(eventPoint.toString());
			}
		});

		canvas.setOnMouseClicked(event -> {
			if(selectionButton.isSelected()) {
				Point eventPoint = new Point(event.getX(), event.getY());
				boolean found = false;
				StringBuilder label = new StringBuilder("Se seleccionó: ");
				for (Figure figure : canvasState.figures()) {
					if(figure.contains(eventPoint)) {
						found = true;
						selectedFigure = figure;
						label.append(figure.toString());
					}
				}
				if (found) {
					statusPane.updateStatus(label.toString());
				} else {
					selectedFigure = null;
					statusPane.updateStatus("Ninguna figura encontrada");
				}
				redrawCanvas();
			}
		});

		canvas.setOnMouseDragged(event -> {
			if(selectionButton.isSelected()) {
				Point eventPoint = new Point(event.getX(), event.getY());
				double diffX = (eventPoint.getX() - startPoint.getX());
				double diffY = (eventPoint.getY() - startPoint.getY());
				if (selectedFigure != null) {
					selectedFigure.move(diffX / 100, diffY / 100);
					redrawCanvas();
				}
			}
		});

		setLeft(buttonsBox);
		setRight(canvas);
	}

	void redrawCanvas() {
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		for(Figure figure : canvasState.figures()) {
			if(figure == selectedFigure) {
				gc.setStroke(Color.RED);
			} else {
				gc.setStroke(strokeColorPicker.getValue());
			}
			gc.setFill(fillColorPicker.getValue());
			figure.draw(gc);
		}
	}
}
