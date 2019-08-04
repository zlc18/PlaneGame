package game;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.awt.Image;
/**
 * @author zengluchuan
 * @date 2019/7/17 - 10:01
 */

//指定路径文件的图片对象


public class GameUtil {

    private GameUtil() {// 工具类一般构造器私有。

    };

    public static Image getImage(String path) {
        URL u = GameUtil.class.getClassLoader().getResource(path);
        BufferedImage img = null;
        try {
            img = ImageIO.read(u);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return img;
    }

}