package lib;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GeometryTest {
	
	@Test
	void diameterCircumferenceTest() {
		Assertions.assertEquals( 4.7746482927568605, new Geometry().diameterCircumference(15) );
	}
	
	@Test
	void lengthCircumferenceTest() {
		Assertions.assertEquals( 94.24777960769379, new Geometry().lengthCircumference(15) );
	}
	
	@Test
	void areaCircumferenceTest() {
		Assertions.assertEquals( 706.8583470577034, new Geometry().areaCircumference(15) );
	}
	
	@Test
	void areaHexagonTest() {
		Assertions.assertEquals( 127.30573435631247, new Geometry().areaHexagon(7) );
	}
	
	@Test
	void areaRectangleTest() {
		Assertions.assertEquals( 25.947499999999998, new Geometry().areaRectangle(5.35, 4.85) );
	}
	
	@Test
	void areaRightAngledTriangleTest() {
		Assertions.assertEquals( 16.119999999999113, new Geometry().areaRightAngledTriangle(5.2, 6.2, 8.09197) );
	}
	
	@Test
	void heightRightAngledTriangleTest() {
		Map<String, Double> heights = new Geometry().heightRightAngledTriangle(5.2, 6.2, 8.09197);
		Assertions.assertAll("Right triangle heights", 
				() -> Assertions.assertEquals( 6.199999999999658, heights.get("a") ),
				() -> Assertions.assertEquals( 5.199999999999713, heights.get("b") ),
				() -> Assertions.assertEquals( 3.9841966789296333, heights.get("c") )
				);
	}
	
	@Test
	void areaEquilateralTriangleTest() {
		Assertions.assertEquals( 18.182376557535047, new Geometry().areaEquilateralTriangle(6.48) );
	}
	
	@Test
	void heightEquilateralTriangleTest() {
		Assertions.assertEquals( 5.611844616523163, new Geometry().heightEquilateralTriangle(6.48) );
	}
	
	@Test
	void elipseAreaTest() {
		Assertions.assertEquals( 136.40302071840267, new Geometry().elipseArea(4.43, 9.801) );
	}
	
	@Test
	void coneVolumeTest() {
		Assertions.assertEquals( 475.1897659816882, new Geometry().coneVolume(7.012, 9.229) );
	}
	
	
	
}
