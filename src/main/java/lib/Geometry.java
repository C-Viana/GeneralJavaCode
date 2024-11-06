package lib;

import java.util.HashMap;
import java.util.Map;

public class Geometry {
	
	public double coneVolume(double radius, double height) {
		return ((Math.PI*Math.pow(radius, 2d))*height)/3d;
	}
	
	public double elipseArea(double minorRadius, double majorRadius) {
		return majorRadius * minorRadius * Math.PI;
	}
	
	public double heightEquilateralTriangle(double side) {
		double calcA = Math.pow(side, 2);
		double calcB = Math.pow((side/2.0), 2);
		double sum = calcA-calcB;
		return Math.sqrt(sum);
	}
	
	public double areaEquilateralTriangle(double side) {
		return side*heightEquilateralTriangle(side)/2;
	}
	
	public Map<String, Double> heightRightAngledTriangle(double sideA, double sideB, double sideC) {
		double area = areaRightAngledTriangle(sideA, sideB, sideC);
		Map<String, Double> lados = new HashMap<>();
		lados.put("a", area/(0.5d*sideA));
		lados.put("b", area/(0.5d*sideB));
		lados.put("c", area/(0.5d*sideC));
		return lados;
	}
	
	public double areaRightAngledTriangle(double sideA, double sideB, double sideC) {
		double p = (sideA+sideB+sideC)/2;
		double rSum = p*((p-sideA)*(p-sideB)*(p-sideC));
		return Math.sqrt(rSum);
	}
	
	public double areaRectangle(double width, double height) {
		return width * height;
	}
	
	public double areaHexagon(double side) {
		final double raizTres = Math.sqrt(3);
		return (3*Math.pow(side, 2) * raizTres) / 2;
	}
	
	public double areaCircumference(double radius) {
		return Math.PI * (Math.pow(radius, 2));
	}
	
	public double lengthCircumference(double radius) {
		return 2 * Math.PI * radius;
	}
	
	public double diameterCircumference(double length) {
		return length / Math.PI;
	}
	
}
