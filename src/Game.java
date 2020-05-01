import java.util.concurrent.Executors;

import java.util.concurrent.TimeUnit;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Game extends Application{
	private Circle targ1=new Circle(40,40, 40);
	private Circle targ11=new Circle(40,40, 40);
	private Circle targ111=new Circle(40,40, 40);
	private Circle targ1111= new Circle(40,40, 40);
	private Circle targ2=new Circle(30,30,30);
	private Circle targ22=new Circle(30,30,30);
	private Circle targ222=new Circle(30,30,30);
	private Circle targ3=new  Circle(24,24,24);
	private Circle targ33=new Circle(24,24,24);

	private Circle targ4=new Circle(17,17,17);
	private Gun gun=new Gun();
	private int score=0;

private Text screenText=new Text("Score:"+String.valueOf(score));
	public static void main(String []args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		targ1.setFill(Color.RED);
		targ11.setFill(Color.RED);
		targ111.setFill(Color.RED);
		targ1111.setFill(Color.RED);
		targ2.setFill(Color.DARKGREEN);
		targ22.setFill(Color.DARKGREEN);
		targ222.setFill(Color.DARKGREEN);
		targ3.setFill(Color.BEIGE);
		targ33.setFill(Color.BEIGE);
		targ4.setFill(Color.GOLD);
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
		
		screenText.setTranslateX(500);
		screenText.setTranslateY(50);



		


		Pane root=new Pane();
		root.setPrefSize(720, 720);
		root.getChildren().addAll(screenText,targ1,targ11,targ111,targ1111,targ2,targ22,targ222,targ3,targ33,targ4);
		Scene scene=new Scene(root);
		scene.setOnMouseClicked(event->{
			if(event.getButton()==MouseButton.PRIMARY) {
				gun.fire();
			
					
				}else {
					gun.reload();
				}

			gun.printSyate();
		});
		Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(()->{
			Platform.runLater(()->{
				targ1.setTranslateX(Math.random()*680);
				targ1.setTranslateY(Math.random()*680);
				targ11.setTranslateX(Math.random()*680);
				targ11.setTranslateY(Math.random()*680);
				targ111.setTranslateX(Math.random()*680);
				targ111.setTranslateY(Math.random()*680);
				targ1111.setTranslateX(Math.random()*680);
				targ1111.setTranslateY(Math.random()*680);
				targ2.setTranslateX(Math.random()*690);
				targ2.setTranslateY(Math.random()*690);
				targ22.setTranslateX(Math.random()*690);
				targ22.setTranslateY(Math.random()*690);
				targ222.setTranslateX(Math.random()*690);
				targ222.setTranslateY(Math.random()*690);
				targ3.setTranslateX(Math.random()*696);
				targ3.setTranslateY(Math.random()*696);
				targ33.setTranslateX(Math.random()*696);
				targ33.setTranslateY(Math.random()*696);
				targ4.setTranslateX(Math.random()*703);
				targ4.setTranslateY(Math.random()*703);
			});
		}, 0, 1, TimeUnit.SECONDS);

		primaryStage.setOnCloseRequest(event->System.exit(0));
		primaryStage.setOnCloseRequest(event ->System.exit(0));
		primaryStage.setScene(scene);
		primaryStage.show();




	}
	

}
