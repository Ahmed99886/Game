import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.Executors;

import java.util.concurrent.TimeUnit;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import jdk.jfr.consumer.EventStream;
import java.util.*;

import javax.imageio.plugins.tiff.FaxTIFFTagSet;


public class Main extends Application {

    private Circle targ1=new Circle(40,40, 40);
    private Circle targ11=new Circle(40,40, 40);
    private Circle targ111=new Circle(40,40, 40);
    private Circle targ1111= new Circle(40,40, 40);
    private Circle targ2=new Circle(30,30,30);
    private Circle targ22=new Circle(30,30,30);
    private Circle targ222=new Circle(30,30,30);
    private Circle targ3=new  Circle(24,24,24);
    private Circle targ33=new Circle(24,24,24);
    private Timeline timeline =new Timeline();
    private Circle targ4=new Circle(17,17,17);
    private Gun gun=new Gun();
    private Clip clip =new Clip();
   private int score=0;
    public int GRID_SIZE = 10;
    private int[][] grid;



    private Text screenText=new Text("Score:"+String.valueOf(score));
    private Text bulltesnum=new Text("bulltes:"+gun.getClip().getbullets());


    public static void main(String[] args) {

        launch(args);








    }













    Random ra=new Random();
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();

        Stage stage2 = new Stage();
        stage2.setMaxWidth(400);
        stage2.setMaxHeight(250);
        stage2.setTitle("Scoring board");

        Button buttonTop    = new Button("Replay");
        Button buttonRight  = new Button("score board");
        buttonTop.setOnMouseClicked(event ->{
           gun.reload();
            setscore(0);

           screenText.setText("score:"+String.valueOf(score));
            bulltesnum.setText("bulltes:"+ gun.getClip().getbullets());






        });
        buttonRight.setOnMouseClicked(event ->{

stage2.show();




        });

        root.setTop(buttonTop);
        root.setRight(buttonRight);

        buttonTop.setPrefWidth(Double.MAX_VALUE);

      buttonRight.setPrefSize(120, Double.MAX_VALUE);


        Scene scene = new Scene(root, 720, 720);
        targ1.setFill(randomColor());
        targ11.setFill(randomColor());
        targ111.setFill(randomColor());
        targ1111.setFill(randomColor());
        targ2.setFill(randomColor());
        targ22.setFill(randomColor());
        targ222.setFill(randomColor());
        targ3.setFill(randomColor());
        targ33.setFill(randomColor());
        targ4.setFill(randomColor());

        targ1.setOnMouseClicked(event ->{


            score+=1;
            System.out.println("targ:  ="+score);
            screenText.setText("Score:"+String.valueOf(score));


        });
        targ11.setOnMouseClicked(event ->{


            score+=1;
            System.out.println("targ:  ="+score);
            screenText.setText("Score:"+String.valueOf(score));


        });

        targ111.setOnMouseClicked(event ->{


            score+=1;
            System.out.println("targ:  ="+score);
            screenText.setText("Score:"+String.valueOf(score));


        });


        targ1111.setOnMouseClicked(event ->{


            score+=1;
            System.out.println("targ:  ="+score);
            screenText.setText("Score:"+String.valueOf(score));



        });


        targ2.setOnMouseClicked(event ->{


            score+=5;
            System.out.println("targ1:b  ="+score);
            screenText.setText("Score:"+String.valueOf(score));

        });
        targ22.setOnMouseClicked(event ->{


            score+=5;
            System.out.println("targ1:b  ="+score);
            screenText.setText("Score:"+String.valueOf(score));

        });
        targ222.setOnMouseClicked(event ->{


            score+=5;
            System.out.println("targ1:b  ="+score);
            screenText.setText("Score:"+String.valueOf(score));

        });
        targ3.setOnMouseClicked(event ->{


            score+=10;
            System.out.println("targ2  =:"+score);
            screenText.setText("Score:"+String.valueOf(score));

        });
        targ33.setOnMouseClicked(event ->{


            score+=10;
            System.out.println("targ2  =:"+score);
            screenText.setText("Score:"+String.valueOf(score));

        });
        targ4.setOnMouseClicked(event ->{


            score+=20;
            System.out.println("targ3  =:"+score);
            screenText.setText("Score:"+String.valueOf(score));
        });


        screenText.setTranslateX(620);
        screenText.setTranslateY(62);
        bulltesnum.setTranslateX(620);
        bulltesnum.setTranslateY(82);

        Separator separator = new Separator();
        separator.setTranslateX(620);
        separator.setTranslateY(600);
        separator.setPrefWidth(200);







        root.setPrefSize(720, 720);
        root.getChildren().addAll(separator,screenText,bulltesnum,targ1,targ11,targ111,targ1111,targ2,targ22,targ222,targ3,targ33,targ4);

        scene.setOnMouseClicked(event->{
            if(event.getButton()==MouseButton.PRIMARY) {
                gun.fire();


            }else {




            }



            bulltesnum.setText("Bulltes"+gun.getClip().getbullets());
        });
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(()->{
            Platform.runLater(()->{
                targ1.setTranslateX(Math.random()*500);
                targ1.setTranslateY(Math.random()*500);
                targ11.setTranslateX(Math.random()*500);
                targ11.setTranslateY(Math.random()*500);
                targ111.setTranslateX(Math.random()*500);
                targ111.setTranslateY(Math.random()*500);
                targ1111.setTranslateX(Math.random()*500);
                targ1111.setTranslateY(Math.random()*500);
                targ2.setTranslateX(Math.random()*500);
                targ2.setTranslateY(Math.random()*500);
                targ22.setTranslateX(Math.random()*500);
                targ22.setTranslateY(Math.random()*500);
                targ222.setTranslateX(Math.random()*500);
                targ222.setTranslateY(Math.random()*500);
                targ3.setTranslateX(Math.random()*500);
                targ3.setTranslateY(Math.random()*500);
                targ33.setTranslateX(Math.random()*500);
                targ33.setTranslateY(Math.random()*500);
                targ4.setTranslateX(Math.random()*500);
                targ4.setTranslateY(Math.random()*500);
            });
        }, 0, 1, TimeUnit.SECONDS);

        primaryStage.setOnCloseRequest(event->System.exit(0));
        primaryStage.setOnCloseRequest(event ->System.exit(0));
        primaryStage.setScene(scene);
        primaryStage.show();








    }
    public Color randomColor() {
        Random random = new Random();
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        return Color.rgb(r, g, b);
    }
    public void setscore(int score) {
        this.score = score;
    }
     public void setscreenText(Text screenText) {
        this.screenText = screenText;
    }
    public void setbulltesnum(Text bulltesnum) {
        this.bulltesnum = bulltesnum;
    }
    



}



