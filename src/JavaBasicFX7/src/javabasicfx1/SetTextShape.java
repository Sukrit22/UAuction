/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabasicfx1;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Sitth
 */
public class SetTextShape {

    private static Rectangle rectangle;
    static private StackPane stackPane;
    private static double widht = 10;
    static private double higth = 10;

    static public StackPane setTextShape(Rectangle rectangle, String text, int fontSize) {
        stackPane = new StackPane();
        Text textText = new Text(text);
        Font font = new Font(fontSize);
        textText.setFont(font);
        stackPane.getChildren().addAll(rectangle, textText);
        return stackPane;
    }

    static public StackPane setTextShape(Circle circle, String text, int fontSize) {
        stackPane = new StackPane();
        Text textText = new Text(text);
        Font font = new Font(fontSize);
        textText.setFont(font);
        stackPane.getChildren().addAll(circle, textText);
        return stackPane;
    }
    
    static public StackPane setTextShape( String text, int fontSize) {
        stackPane = new StackPane();
        Text textText = new Text(text);
        Font font = new Font(fontSize);
        textText.setFont(font);        
        name(text, fontSize);
        stackPane.getChildren().addAll(rectangle, textText);
        return stackPane;
    }
    
    static public StackPane setTextShape( String text, int fontSize, double w, double h) {
        widht = w;
        higth = h;
        stackPane = new StackPane();
        Text textText = new Text(text);
        Font font = new Font(fontSize);
        textText.setFont(font);        
        name(text, fontSize);
        stackPane.getChildren().addAll(rectangle, textText);        
        stackPane.setMaxSize(w, h);
        return stackPane;
    }


    static private void name(String text, int fontSize){
        MyButton textShape = new MyButton(text, fontSize, widht, higth);
        rectangle = new Rectangle();
        rectangle = textShape.getButtonShape();
    }


}
