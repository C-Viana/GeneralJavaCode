package lib;

import java.awt.image.BufferedImage;
import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@Execution(ExecutionMode.CONCURRENT)
class ImageHandlerTest {
	
	@Test
	void getImageFileTest() {
		BufferedImage imgA = null;
		try {
			imgA = new ImageHandler().getImageFile("src/test/resources/ComparableImages/icon_128x128.png");
		}
		catch (IOException e) {
			Assertions.fail("Something went wrong and test could not be performed!");
		}
		Assertions.assertNotNull( imgA, "BufferedImage should not be NULL!" );
	}
	
	@Test
	void getImageFileFileNotFoundExceptionTest() {
		String error = "";
		
		error = Assertions.assertThrows(IOException.class, () -> {
			new ImageHandler().getImageFile("C://Wrong_Path.jpg");
		}).getMessage();
		
		Assertions.assertEquals("Can't read input file!", error);
	}
	
	@Test
	void getImageNullPathExceptionTest() {
		ImageHandler ih = new ImageHandler();
		Assertions.assertThrows(NullPointerException.class, () -> {
			ih.getImageFile(null);
		});
	}
	
	@ParameterizedTest
	@CsvSource({
		"100.0d, icon_128x128.png, icon_256x256.png",
        "100.0d, icon_128x128.png, icon_200x128.png",
        "100.0d, icon_128x128.png, icon_128x200.png",
        "50.0d, Imagem3.png, Imagem4.png",
        "0.0d, Imagem1.png, Imagem2.png"
        })
	void compareImagesTest(double expectedResult, String imageA, String imageB) {
		ImageHandler ih = new ImageHandler();
		BufferedImage imgA = null;
		BufferedImage imgB = null;
		try {
			imgA = ih.getImageFile("src/test/resources/ComparableImages/"+imageA);
			imgB = ih.getImageFile("src/test/resources/ComparableImages/"+imageB);
		}
		catch (IOException e) {
			Assertions.fail("Something went wrong and test could not be performed!");
		}
		Assertions.assertEquals( expectedResult, ih.compareImages(imgA, imgB) );
	}
	
}
