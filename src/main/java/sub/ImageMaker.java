package sub;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageMaker {

    //bad cord
    public static void main(String[] args) throws Exception {

        BufferedImage image = new BufferedImage(1000, 1000,
                BufferedImage.TYPE_INT_RGB); //임시 이미지. 진짜 이미지X

        File bgFile = new File("C:\\zzz\\album\\bg.jpg");
        BufferedImage bgImage = ImageIO.read(bgFile);

        Graphics graphics = image.getGraphics();
        graphics.drawImage(bgImage, 0, 0, null);

        graphics.setColor(Color.pink);
//        graphics.fillRect(0, 0, 200, 500);


        graphics.setFont(new Font("TimeRoman", Font.ITALIC, 100));
        graphics.drawString("GOGOGO", 150, 150);


        ImageIO.write(image, "jpg.", new File("C:\\zzz\\album\\test.jpg"));


    }


}
