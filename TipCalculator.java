// Java Program to create a VBox, add 
// spaces between its elements and add 
// it to the stage 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import javafx.scene.image.Image;
import javafx.application.Application; 
import javafx.event.ActionEvent;
import javafx.scene.Scene; 
import javafx.scene.control.*; 
import javafx.scene.layout.*; 
import javafx.stage.Stage; 
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;



public class TipCalculator extends Application { 

	// launch the application 
        @Override
	public void start(Stage stage) 
	{ 

		try { 

			// set title for the stage 
			stage.setTitle("Tip Calculator"); 

			// create a VBox 
			VBox vbox = new VBox(10); 
                        
                        // centre alignment 
                        vbox.setAlignment(Pos.CENTER); 
                        
                        // spacing between elements
                        vbox.setSpacing(10);
                        
                        // setting padding
                        vbox.setPadding( new Insets(10,10,10,10));
                        
                        //background color 
                        vbox.setBackground(Background.EMPTY);
                        String style = "-fx-background-color: rgba(0, 128, 128, 0.5);";
                        vbox.setStyle(style);
                        
			// create a label 
			Label label1 = new Label("Restaurant Charges"); 
			Label label2 = new Label("Amount To Tip:"); 
			Label label3 = new Label(); 
                        
                        // CSS of labels 
                        // color
                        label1.setTextFill(Color.web("#B18904"));
                        
                        // font
                       label1.setFont(new Font("Cambria", 20));
                       
                  
                        label2.setTextFill(Color.web("#B18904"));
                       label2.setFont(new Font("Cambria", 18));
                       
                        label3.setTextFill(Color.web("#610B0B"));
                       label3.setFont(new Font("Cambria", 22));
                        
                        
                        //Creating an image 
                          Image image = new Image(new FileInputStream("image.jpeg"));  
      
                        //Setting the image view 
                          ImageView imageView = new ImageView(image); 
      
                         //Setting the position of the image 
                         imageView.setX(50); 
                         imageView.setY(50); 
      
                         //setting the fit height and width of the image view 
                         imageView.setFitHeight(200); 
                         imageView.setFitWidth(200); 
      
                         //Setting the preserve ratio of the image view 
                          imageView.setPreserveRatio(true);  
                        
                          // adding image view in vbox 
                          vbox.getChildren().add(imageView);
                        
                        
                        
                        
			// add label to vbox 
			vbox.getChildren().add(label1);
                        
                        
                        // add text field
                        TextField textField = new TextField();
                       
                        // setting tha textfield width size
                        textField.setMaxWidth(200);
                        
                        // add TextField to vbox 
			vbox.getChildren().add(textField);

			// init new button 
			Button calculate = new Button("Calculate Tip");
                        
                        // adding Action Handler
                       calculate.setOnAction((ActionEvent action) -> {
                           String data = textField.getText();
                        
                           
                           // empty input validation 
                           
                            if ("".equals(data)) {
                                
                                // set label value to null
                                 label3.setText("");
                                 
                                 // new dialog stage 
                                Stage dialogStage = new Stage();
                                dialogStage.initModality(Modality.WINDOW_MODAL);
                                
                                // ok button on error message 
                                Button x=new Button("Ok");
                                
                                VBox vbox1 = new VBox(new Text("Empty Input"),x );
                                vbox1.setAlignment(Pos.CENTER);
                                vbox1.setSpacing(10);
                                
                                // event handler on error message button "OK"
                                x.setOnAction((ActionEvent a) -> {
                                    
                                   // close dialogue
                                dialogStage.close();
                                    
                                });
                                // css on the error dialogue        
                                vbox.setAlignment(Pos.CENTER);
                                vbox1.setPadding(new Insets(15));
                                dialogStage.setScene(new Scene(vbox1));
                                dialogStage.show();
                                
                            }else{
                                
                                // check for valid input (double/ intergers)
                            if(data.matches("\\d{0,9}([\\.]\\d{0,4})?"))
                            {
                                // convert string  input of textfield into douoble 
                               double d= Double.parseDouble(data);
                              // percentage formula 
                               double percent=.20;
                               double res = d * percent;
                               
                               // setting the result format/ precision
                               DecimalFormat dec = new DecimalFormat("#0.00");
                               
                                // adding result in label3
                               label3.setText("$ " + dec.format(res));
                               
                              
                            }else
                            {
                                 // set label3 value to null
                                 label3.setText("");
                                 
                                 // new stage for invalid error message 
                                 Stage dialogStage = new Stage();
                                dialogStage.initModality(Modality.WINDOW_MODAL);
                                
                                Button x=new Button("Ok");
                                
                                VBox vbox1 = new VBox(new Text("Invalid Input"),x );
                                vbox1.setAlignment(Pos.CENTER);
                                vbox1.setSpacing(10);
                                
                                // button handler on invalid error (OK button)
                                x.setOnAction((ActionEvent a) -> {
                               
                                    // close invalid dialogue box 
                                    dialogStage.close();
                                    
                                });

                                // invalid error box CSS/ alignments 
                                vbox.setAlignment(Pos.CENTER);
                                vbox1.setPadding(new Insets(15));
                                dialogStage.setScene(new Scene(vbox1));
                                dialogStage.show();
                            }
                            
                            }
                            
                            
                        });
			 
                        
                        // adding button to vbox
                        vbox.getChildren().add(calculate);
                        
                        
                        // adding label 2 and label 3
                        vbox.getChildren().add(label2);
                        vbox.getChildren().add(label3);

                    
			// create a scene 
			Scene scene = new Scene(vbox, 300, 450); 

			// set the scene 
			stage.setScene(scene); 
                        
                        // stage show 
			stage.show(); 
		} 

		catch (FileNotFoundException e) { 
                    //exception handler
		} 
	} 

	// Main Method 
	public static void main(String args[]) 
	{ 

		// launch the application 
		launch(args); 
	} 
} 
