/*
 * MusicController
 * This is the controller for the FXML document that contains the view. 
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HealthController implements Initializable {
      
  @FXML
  private Button btnSearch;
  
  private int count = 0;
  
  @FXML
  private Button btnPrev;
  
  @FXML
  private Button btnNext;
  
  @FXML
  private TextField txtIngred;

  @FXML
  private Label lblTitle;

  @FXML
  private Label lblIngred;

  @FXML
  private Label lblLink;

  @FXML
  private ImageView icon;

  @FXML
  private void handleButtonAction(ActionEvent e) {
    
    count = 0;
    HealthModel recipe = new HealthModel();
  
    String ingred = txtIngred.getText();
        
    if (!ingred.equals("") && recipe.getInfo(ingred,count))
    {
       lblTitle.setText(recipe.getTitle());
       lblIngred.setText(recipe.getIngred());
       lblLink.setText(recipe.getLink());
       icon.setImage(recipe.getImage());
    }
    else
    {
        lblTitle.setText("Recipe not found!");
        lblIngred.setText("");
        lblLink.setText("");
        icon.setImage(new Image("badartistname.png"));
    }
  }
  
  @FXML
  private void prevAction(ActionEvent e) {
   if (count > 0){
      count--;
      HealthModel recipe = new HealthModel();
  
    String ingred = txtIngred.getText();
    
    if (!ingred.equals("") && recipe.getInfo(ingred,count))
    {
       lblTitle.setText(recipe.getTitle());
       lblIngred.setText(recipe.getIngred());
       lblLink.setText(recipe.getLink());
       icon.setImage(recipe.getImage());
    }
    else
    {
        lblTitle.setText("Recipe not found!");
        lblIngred.setText("");
        lblLink.setText("");
        icon.setImage(new Image("badartistname.png"));
    }
   } 
  }
  
  @FXML
  private void nextAction(ActionEvent e) {
      count++;
      HealthModel recipe = new HealthModel();
  
    String ingred = txtIngred.getText();
    
    if (!ingred.equals("") && recipe.getInfo(ingred,count))
    {
       lblTitle.setText(recipe.getTitle());
       lblIngred.setText(recipe.getIngred());
       lblLink.setText(recipe.getLink());
       icon.setImage(recipe.getImage());
    }
    else
    {
        lblTitle.setText("Recipe not found!");
        lblIngred.setText("");
        lblLink.setText("");
        icon.setImage(new Image("badartistname.png"));
    }
  }
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }    

}
