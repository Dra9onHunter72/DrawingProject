package art.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.Hashtable;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import art.controller.Controller;

public class ArtPanel extends JPanel
{
	private final int MINIMUM_EDGE = 5;
	private final int MAXIMUM_EDGE = 20;
	private final int MINIMUM_SCALE = 20;
	private final int MAXIMUM_SCALE = 100;
	
	private Controller app;
	
	private SpringLayout appLayout;
	private DrawingCanvas canvas;
	private JPanel buttonPanel;
	private JPanel sliderPanel;
	private JSlider scaleSlider;
	private JSlider edgeSlider;
	private JButton triangleButton;
	private JButton rectangleButton;
	private JButton ellipseButton;
	private JButton polygonButton;
	private JButton clearButton;
	private JButton saveButton;
	private JButton colorButton;
	
	private int currentEdgeCount;
	private int currentScale;
	
	public ArtPanel(Controller app)
	{
		super();
		this.app = app;
		appLayout = new SpringLayout();
		
		currentScale = MINIMUM_SCALE;
		currentEdgeCount = MINIMUM_EDGE;
		scaleSlider = new JSlider(MINIMUM_SCALE, MAXIMUM_SCALE);
		edgeSlider = new JSlider(MINIMUM_EDGE, MAXIMUM_EDGE);
		
		canvas = new DrawingCanvas(app);
		sliderPanel = new JPanel();
		buttonPanel = new JPanel(new GridLayout(0, 1));
		
		triangleButton = new JButton("add triangle");
		rectangleButton = new JButton("add rectangle");
		ellipseButton = new JButton("add ellipse");
		polygonButton = new JButton("add polygon");
		clearButton = new JButton("clear image");
		saveButton = new JButton("save image");
		colorButton = new JButton("change color");
		
		setupSliders();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupSliders()
	{
		Hashtable<Integer, JLabel> scaleLabels = new Hashtable<Integer, JLabel>();
		Hashtable<Integer, JLabel> edgeLabels = new Hashtable<Integer, JLabel>();
		
		scaleLabels.put(MINIMUM_SCALE,  new JLabel("<HTML>Small<BR>Shape</HTML>"));
		scaleLabels.put((MAXIMUM_SCALE + MINIMUM_SCALE) / 2, new JLabel("<HTML>Medium<BR>Shape</HTML>"));
		scaleLabels.put(MAXIMUM_SCALE, new JLabel("<HTML>Large<BR>Shape</HTML>"));
		
		edgeLabels.put(MINIMUM_EDGE, new JLabel("Edge: " + MINIMUM_EDGE));
		edgeLabels.put(MAXIMUM_EDGE, new JLabel("Edge: " + MAXIMUM_EDGE));
		
		scaleSlider.setLabelTable(scaleLabels);
		scaleSlider.setOrientation(JSlider.VERTICAL);
		scaleSlider.setSnapToTicks(true);
		scaleSlider.setMajorTickSpacing(10);
		scaleSlider.setPaintTicks(true);
		scaleSlider.setPaintLabels(true);
		
		scaleSlider.setLabelTable(scaleLabels);
		scaleSlider.setOrientation(JSlider.VERTICAL);
		scaleSlider.setSnapToTicks(true);
		scaleSlider.setMajorTickSpacing(3);
		scaleSlider.setMinorTickSpacing(1);
		scaleSlider.setPaintTicks(true);
		scaleSlider.setPaintLabels(true);
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.setBackground(Color.DARK_GRAY);
		this.setPreferredSize(new Dimension(1024, 768));
		this.add(canvas);
		
		buttonPanel.setPreferredSize(new Dimension(200, 540));
		buttonPanel.add(triangleButton);
		buttonPanel.add(rectangleButton);
		buttonPanel.add(ellipseButton);
		buttonPanel.add(polygonButton);
		buttonPanel.add(clearButton);
		buttonPanel.add(saveButton);
		buttonPanel.add(colorButton);
		
		sliderPanel.setPreferredSize(new Dimension(250, 450));
		sliderPanel.add(scaleSlider);
		sliderPanel.add(edgeSlider);
		
		this.add(buttonPanel);
		this.add(sliderPanel);
	}
	
	private void setupLayout()
	{
		
	}
	
}