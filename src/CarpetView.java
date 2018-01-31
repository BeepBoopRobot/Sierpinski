import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CarpetView {
    static double pow;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter num pls: ");
        pow = Math.pow(3,sc.nextInt());
        System.out.println(pow);
        new JFXPanel();
        Platform.runLater(CarpetView::launch);
    }

    private static void launch() {
        Stage stage = new Stage();
        stage.setTitle("Sierpinski");
        stage.setWidth(800);
        stage.setHeight(800);
        stage.setResizable(false);
        stage.show();

        Group group = new Group();
        Scene scene = new Scene(group);
        stage.setScene(scene);

        WritableImage wIm = new WritableImage((int) pow, (int) pow);
        PixelWriter pw = wIm.getPixelWriter();
        for(int i = 0; i< pow; i++) {
            for(int j = 0; j< pow; j++) {
                pw.setColor(i,j,inCarpet(i,j) ? Color.BLACK : Color.WHITE);
            }
        }

        VBox vb = new VBox();
        vb.setPrefWidth(800);
        vb.setPrefHeight(800);
        vb.setAlignment(Pos.CENTER);
        ImageView im = new ImageView(wIm);
        vb.getChildren().add(im);
        group.getChildren().add(vb);

        try {
            BufferedImage bi = new BufferedImage((int) wIm.getWidth(), (int)wIm.getHeight(), 2);
            SwingFXUtils.fromFXImage(wIm, bi);
            File out = new File("out.png");
            ImageIO.write(bi, "png", out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean inCarpet(long x, long y) {
        while (x != 0 && y != 0) {
            if (x % 3 == 1 && y % 3 == 1) return false;
            x /= 3;
            y /= 3;
        }
        return true;
    }
}
