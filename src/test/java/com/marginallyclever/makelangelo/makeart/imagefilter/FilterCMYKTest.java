package com.marginallyclever.makelangelo.makeart.imagefilter;

import com.marginallyclever.makelangelo.makeart.TransformedImage;
import com.marginallyclever.util.PreferencesHelper;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;


public class FilterCMYKTest {
    //@Test
    public void testConversion() throws IOException {
        PreferencesHelper.start();
        final String PATH_NAME = "target/classes/bill-murray";
        final String EXT = "jpg";
        File file = new File(PATH_NAME + "." + EXT);
        assert (file.isFile());
        TransformedImage img = new TransformedImage(ImageIO.read(new FileInputStream(file)));
        FilterCMYK filter = new FilterCMYK(img);
        filter.filter();

        ImageIO.write(filter.getC().getSourceImage(), EXT, new File(PATH_NAME + "C." + EXT));
        ImageIO.write(filter.getM().getSourceImage(), EXT, new File(PATH_NAME + "M." + EXT));
        ImageIO.write(filter.getY().getSourceImage(), EXT, new File(PATH_NAME + "Y." + EXT));
        ImageIO.write(filter.getK().getSourceImage(), EXT, new File(PATH_NAME + "K." + EXT));
    }

    // NEW TEST
    @ParameterizedTest
    @MethodSource("testColors")
    public void testFilter(int colorRGB, int[] expectedCMYK) throws IOException {

        BufferedImage bufferedImage;
        int expectedCyan;
        int expectedMagenta;
        int expectedYellow;
        int expectedBlack;
        int realCyan;
        int realMagenta;
        int realYellow;
        int realBlack;

        expectedCyan    = expectedCMYK[0];
        expectedMagenta = expectedCMYK[1];
        expectedYellow  = expectedCMYK[2];
        expectedBlack   = expectedCMYK[3];

        bufferedImage = new BufferedImage(1,1, BufferedImage.TYPE_INT_RGB);
        bufferedImage.setRGB(0, 0, colorRGB);

        TransformedImage img = new TransformedImage(bufferedImage);
        FilterCMYK filter = new FilterCMYK(img);
        filter.filter();

        TransformedImage channelCyan    = filter.getC();
        TransformedImage channelMagenta = filter.getM();
        TransformedImage channelYellow  = filter.getY();
        TransformedImage channelBlack   = filter.getK();

        realCyan    = channelCyan.sample1x1(0,0);
        realMagenta = channelMagenta.sample1x1(0,0);
        realYellow  = channelYellow.sample1x1(0,0);
        realBlack   = channelBlack.sample1x1(0,0);

        assertEquals(expectedCyan, realCyan);
        assertEquals(expectedMagenta, realMagenta);
        assertEquals(expectedYellow, realYellow);
        assertEquals(expectedBlack, realBlack);
    }

    static Stream<Arguments> testColors() {
        return Stream.of(
                arguments(Color.BLACK.getRGB(), new int[]{255, 255, 255, 0}),
                arguments(Color.WHITE.getRGB(), new int[]{255, 255, 255, 255}),
                arguments(Color.BLUE.getRGB(), new int[]{0, 0, 255, 255}),
                arguments(Color.RED.getRGB(), new int[]{255, 0, 0, 255}),
                arguments(Color.YELLOW.getRGB(), new int[]{255, 255, 0, 255}),
                arguments(Color.GREEN.getRGB(), new int[]{0, 255, 0, 255}),
                arguments(Color.CYAN.getRGB(), new int[]{0, 255, 255, 255}),
                arguments(Color.MAGENTA.getRGB(), new int[]{255, 0, 255, 255})
        );
    }
}
