package com.ace.ojt.bean;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.DonutChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

@Named
@ApplicationScoped
public class ChartBean {
	private String name="JSF";
	private PieChartModel pieModel;
	private LineChartModel lineModel;
	private DonutChartModel donutModel;
	private BarChartModel barModel;
	
	
	

	public BarChartModel getBarModel() {
		return barModel;
	}

	public DonutChartModel getDonutModel() {
		return donutModel;
	}

	public LineChartModel getLineModel() {
		return lineModel;
	}

	public PieChartModel getPieModel() {
		return pieModel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@PostConstruct
	public void init() {
		createPieChartModel();
		createCustomLineChartModel();
		createDonutChartModel();
		createBarChartModel();
	}

	private void createBarChartModel() {
		barModel = new BarChartModel();
		ChartSeries series1 = new ChartSeries();
		series1.setLabel("Boys");
		series1.set("Brand 1", 100);
		series1.set("Brand 2", 200);
		series1.set("Brand 3", 150);
		
		ChartSeries series2 = new ChartSeries();
		series2.setLabel("Girls");
		series2.set("Brand 1", 200);
		series2.set("Brand 2", 50);
		series2.set("Brand 3", 60);
		
		barModel.addSeries(series1);
		barModel.addSeries(series2);
		barModel.setTitle("Bar Chart");
		barModel.setLegendPosition("e");
		barModel.setStacked(true);
		
		Axis xAxis= barModel.getAxis(AxisType.X);
		xAxis.setLabel("Gender");
		
		Axis yAxis= barModel.getAxis(AxisType.Y);
		yAxis.setLabel("Birth");
		yAxis.setMin(0);
		yAxis.setMax(300);
		
		
		
	}

	private void createPieChartModel() {
		pieModel = new PieChartModel();
		pieModel.set("Brand 1", 400);
		pieModel.set("Brand 2", 100);
		pieModel.set("Brand 3", 50);
		pieModel.setLegendPosition("w");
		pieModel.setTitle("PieChart");
		pieModel.setShowDataLabels(true);
		pieModel.setDiameter(150);
		
	}
	public void itemSelect(ItemSelectEvent e) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Item selected ","Item Index: "+e.getItemIndex()+
				", Series Index "+e.getSeriesIndex());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println(e.getItemIndex());
	}
	public void createLineChartModel() {
		lineModel= new LineChartModel();
		LineChartSeries series1 = new LineChartSeries();
		series1.setLabel("Sereis 1");
		series1.set(1, 2);
		series1.set(2, 1);
		series1.set(3, 3);
		series1.set(4, 6);
		series1.set(5, 8);
		
		LineChartSeries series2 = new LineChartSeries();
		series2.setLabel("Series 2");
		series2.set(1, 6);
		series2.set(2, 3);
		series2.set(3, 2);
		series2.set(4, 7);
		series2.set(5, 9);
		
		lineModel.addSeries(series1);
		lineModel.addSeries(series2);
		lineModel.setTitle("Line Chart");
		lineModel.setLegendPosition("e");
		Axis yAxis= lineModel.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(10);
	}
	public void createCustomLineChartModel() {
		lineModel = new LineChartModel();
		ChartSeries boys = new ChartSeries();
		boys.setLabel("Boys");
		boys.set("2004", 120);
		boys.set("2005", 100);
		boys.set("2006", 44);
		boys.set("2007", 150);
		boys.set("2008", 25);
		
		ChartSeries girls = new ChartSeries();
		girls.setLabel("Girls");
		girls.set("2004", 52);
		girls.set("2005", 60);
		girls.set("2006", 110);
		girls.set("2007", 90);
		girls.set("2008", 120);
		
		lineModel.addSeries(boys);
		lineModel.addSeries(girls);
		lineModel.setTitle("Custome Model");
		lineModel.setLegendPosition("e");
		lineModel.setShowPointLabels(true);
		lineModel.getAxes().put(AxisType.X, new CategoryAxis("Years"));
		Axis yAxis = lineModel.getAxis(AxisType.Y);
		yAxis.setLabel("Births");
		yAxis.setMin(0);
		yAxis.setMax(200);
		
	}
	public void createDonutChartModel() {
		donutModel = new DonutChartModel();
		Map<String,Number> circle1= new LinkedHashMap<>();
		circle1.put("Brand 1",400);
		circle1.put("Brand 2", 300);
		circle1.put("Brand 3", 200);
		circle1.put("Brand 4", 100);
		donutModel.addCircle(circle1);
		
		Map<String,Number> circle2 = new LinkedHashMap<>();
		circle2.put("Brand 1", 450);
		circle2.put("Brand 2", 350);
		circle2.put("Brand 3", 26);
		circle2.put("Brand 4", 150);
		donutModel.addCircle(circle2);
		
		Map<String,Number> circle3 = new LinkedHashMap<>();
		circle3.put("Brand 1", 360);
		circle3.put("Brand 2", 220);
		circle3.put("Brand 3", 110);
		circle3.put("Brand 3", 50);
		donutModel.addCircle(circle3);
		
		donutModel.setTitle("Donut Model");
		donutModel.setLegendPosition("e");
		donutModel.setSliceMargin(5);
		donutModel.setShowDataLabels(true);
		donutModel.setDataFormat("value");
		donutModel.setShadow(true);
		
	}
	

}
