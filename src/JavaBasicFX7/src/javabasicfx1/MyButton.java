/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabasicfx1;

import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Sitth
 */
public final class MyButton {

    static public Button btnTime1 = new Button();
    static public Button btnTime2 = new Button();
    private double sizeHeight = 40;
    private double sizeWidth = 100;
    private int fontSize = 50;
    private double arcHeight;
    private double arcWidth;
    private double textWidth;
    private double textHeight;

    private String textString = "Button";
    private Text text;
    private Button button;
    private Rectangle rectangle;
    static private Font font;

    public MyButton() {
        System.out.println("MyButton Constructor1");
        allConstructorContain();

    }    

    public MyButton(String text) {
        System.out.println("MyButton Constructor2");
        textString = text;
        allConstructorContain();
    }

    public MyButton(double sizeWidth, double sizeHeight) {
        System.out.println("MyButton Constructor3");
        this.sizeHeight = sizeHeight;
        this.sizeWidth = sizeWidth;
        allConstructorContain();
    }

    public MyButton(String text, double sizeWidth, double sizeHeight) {
        System.out.println("MyButton Constructor4");
        this.sizeHeight = sizeHeight;
        this.sizeWidth = sizeWidth;
        textString = text;
        allConstructorContain();
    }

    public MyButton(String text, int font, double sizeWidth, double sizeHeight) {
        System.out.println("MyButton Constructor4");
        this.sizeHeight = sizeHeight;
        this.sizeWidth = sizeWidth;
        textString = text;
        this.fontSize = font;
        allConstructorContain();
    }
    
    public void setFont(int font) {
        this.fontSize = font;
    }

    private void makeArc(double sizeHeight) {
        System.out.println("makeArc");
        arcHeight = sizeHeight / 4 + sizeHeight / 2;
        arcWidth = sizeHeight / 4 + sizeHeight / 2;
    }

    public void setSizeHeight(double sizeHeight) {
        System.out.println("setSizeHeight");
        this.sizeHeight = sizeHeight;
    }

    public void setSizeWidth(double sizeWidth) {
        System.out.println("setSizeWidth");
        this.sizeWidth = sizeWidth;
    }

    public void setArcHeight(double arcHeight) {
        System.out.println("setArcHeight");
        this.arcHeight = arcHeight;
    }

    public void setArcWidth(double arcWidth) {
        System.out.println("setArcWidth");
        this.arcWidth = arcWidth;
    }

    public void setText(String text) {
        System.out.println("setText");
        this.text.setText(textString);
        this.text.applyCss();
    }

    public void makeRectangle() {
        System.out.println("makeRectangle");
        rectangle.setArcHeight(arcHeight);
        rectangle.setArcWidth(arcWidth);
        rectangle.setHeight(sizeHeight);
        rectangle.setWidth(sizeWidth);
    }

    public void makeButton() {
        System.out.println("makeButton");
        this.text.setFont(font);
        button.setText(this.text.getText());
        button.setShape(rectangle);
        button.setMinSize(sizeWidth, sizeHeight);
        button.applyCss();
        button.setWrapText(false);
        button.setMnemonicParsing(true);
        button.setDisable(false);
        button.setVisible(true);
        button.setStyle("-fx-focus-color:rgba( 0, 0, 0, 1.0); -fx-text-fill: #d8d8d8; -fx-faint-focus-color:rgba( 112, 112, 112, 0.0) ; -fx-inner-border:rgba( 112, 112, 112, 1.0); -fx-body-color:rgba( 112, 112, 112, 1.0);");
        button.setOnMouseEntered(eh -> button.setStyle("-fx-focus-color:rgba( 0, 0, 0, 1.0); -fx-faint-focus-color:rgba( 112, 112, 112, 0.0); -fx-outer-border:rgba( 0, 0, 0, 1.0); -fx-inner-border:rgba( 112, 112, 112, 1.0); -fx-body-color:rgba( 112, 112, 112, 1.0);"));
        button.setOnMouseClicked(eh  -> {if(eh.getButton() == MouseButton.PRIMARY){ button.setStyle("-fx-focus-color:rgba( 255, 255, 255, 1.0); -fx-faint-focus-color:rgba( 255, 255, 255, 0.0); -fx-outer-border:rgba( 250, 250, 250, 1.0); -fx-inner-border:rgba( 112, 112, 112, 1.0); -fx-body-color:rgba( 112, 112, 112, 1.0);");}});
        //button.setOnMouseReleased(eh-> {if(eh.getButton() == MouseButton.PRIMARY){button.setStyle("-fx-focus-color:rgba( 0, 0, 0, 1.0);  -fx-text-fill: #d8d8d8; -fx-faint-focus-color:rgba( 112, 112, 112, 0.0) ; -fx-inner-border:rgba( 112, 112, 112, 1.0); -fx-body-color:rgba( 112, 112, 112, 1.0);");}});
        button.setOnMouseExited(e -> button.setStyle("-fx-focus-color:rgba( 0, 0, 0, 1.0);  -fx-text-fill: #d8d8d8; -fx-faint-focus-color:rgba( 112, 112, 112, 0.0) ; -fx-inner-border:rgba( 112, 112, 112, 1.0); -fx-body-color:rgba( 112, 112, 112, 1.0);"));

    }

    public Button getButton() {
        System.out.println("getButton");
        return button;
    }

    private void allConstructorContain() {
        System.out.println("allConstructorContain");
        this.rectangle = new Rectangle();
        this.button = new Button();
        this.font = new Font(fontSize);
        this.text = new Text();
        this.text.applyCss();
        this.text.setText(textString);
        this.text.setFont(font);
        this.button.setFont(font);
        textWidth = this.text.getLayoutBounds().getWidth();
        textHeight = this.text.getLayoutBounds().getHeight();
        if (sizeHeight <= textHeight) {
            sizeHeight = textHeight + textHeight / 2;
        }
        if (sizeWidth <= textWidth) {
            sizeWidth = textWidth + textHeight * 2;
        }
        makeArc(sizeHeight);
        makeRectangle();
        makeButton();
    }    
    
    public Rectangle getButtonShape(){
        System.out.println("getButtonShape");
        rectangle.setFill(Color.web("rgba( 112, 112, 112,1.0)"));
        return rectangle;
        
    }
    
    public void debugSize(){
        System.out.println(this.text.getText() + " Shape Size H = " + this.rectangle.getLayoutBounds().getHeight() + " W = " + this.rectangle.getLayoutBounds().getWidth());

    }
    
    static public Button setAndGetBtnTime(Button button){
        System.out.println("------------------setAndGetBtnTime------------------");
        Rectangle rectangle = new Rectangle();
        rectangle.setArcHeight(40 / 4 + 40 / 2);
        rectangle.setArcWidth(40 / 4 + 40 / 2);
        rectangle.setHeight(40);
        rectangle.setWidth(250);
        Font font = new Font(20);
        button.setFont(font);
        button.setShape(rectangle);
        button.setMinSize(250, 40);
        button.applyCss();
        button.setWrapText(false);
        button.setMnemonicParsing(true);
        button.setDisable(false);
        button.setVisible(true);
        button.setStyle("-fx-focus-color:rgba( 0, 0, 0, 0.0); -fx-text-fill: #d8d8d8; -fx-faint-focus-color:rgba( 112, 112, 112, 0.0) ; -fx-inner-border:rgba( 112, 112, 112, 1.0); -fx-body-color:rgba( 112, 112, 112, 1.0);");
        //button.setOnMouseEntered(eh -> button.setStyle("-fx-focus-color:rgba( 0, 0, 0, 1.0); -fx-faint-focus-color:rgba( 112, 112, 112, 0.0); -fx-outer-border:rgba( 0, 0, 0, 1.0); -fx-inner-border:rgba( 112, 112, 112, 1.0); -fx-body-color:rgba( 112, 112, 112, 1.0);"));
        //button.setOnMouseClicked(eh  -> {if(eh.getButton() == MouseButton.PRIMARY){ button.setStyle("-fx-focus-color:rgba( 255, 255, 255, 1.0); -fx-faint-focus-color:rgba( 255, 255, 255, 0.0); -fx-outer-border:rgba( 250, 250, 250, 1.0); -fx-inner-border:rgba( 112, 112, 112, 1.0); -fx-body-color:rgba( 112, 112, 112, 1.0);");}});
        //button.setOnMouseReleased(eh-> {if(eh.getButton() == MouseButton.PRIMARY){button.setStyle("-fx-focus-color:rgba( 0, 0, 0, 1.0);  -fx-text-fill: #d8d8d8; -fx-faint-focus-color:rgba( 112, 112, 112, 0.0) ; -fx-inner-border:rgba( 112, 112, 112, 1.0); -fx-body-color:rgba( 112, 112, 112, 1.0);");}});
        //button.setOnMouseExited(e -> button.setStyle("-fx-focus-color:rgba( 0, 0, 0, 1.0);  -fx-text-fill: #d8d8d8; -fx-faint-focus-color:rgba( 112, 112, 112, 0.0) ; -fx-inner-border:rgba( 112, 112, 112, 1.0); -fx-body-color:rgba( 112, 112, 112, 1.0);"));

        return button;
        
    }
    
}
