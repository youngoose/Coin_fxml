package coin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class CoinController implements Initializable
{
   @Override
   public void initialize (URL url, ResourceBundle rb)
   {
      // TODO
   }

   @FXML
   private Label label;

   @FXML
   private TextField tamount;

   @FXML
   private GridPane coinGrid;

   @FXML
   public void show () throws Exception
   {
      try {
         int amount = Integer.parseInt(tamount.getText());

         if (amount < 0 || amount > 100) {
            throw new Exception();
         }

         Coin c = new Coin(amount);
         coinGrid.getChildren().clear();

         ImageView[] qImv = new ImageView[c.getqTimes()];
         for (int i = 0; i < qImv.length; i++) {
            Image qImg = new Image("images/quarter.jpg", 190, 190, false, false);
            qImv[i] = new ImageView(qImg);
            coinGrid.add(qImv[i], i, 0);
         }

         ImageView[] dImv = new ImageView[c.getdTimes()];
         for (int i = 0; i < dImv.length; i++) {
            Image dImg = new Image("images/dime.jpg", 145, 145, false, false);
            dImv[i] = new ImageView(dImg);
            coinGrid.add(dImv[i], qImv.length + i, 0);
         }

         ImageView[] nImv = new ImageView[c.getnTimes()];
         for (int i = 0; i < nImv.length; i++) {
            Image nImg = new Image("images/nickel.jpg", 155, 155, false, false);
            nImv[i] = new ImageView(nImg);
            coinGrid.add(nImv[i], qImv.length + dImv.length + i, 0);
         }

         ImageView[] pImv = new ImageView[c.getpTimes()];
         for (int i = 0; i < pImv.length; i++) {
            Image pImg = new Image("images/penny.jpg", 147, 147, false, false);
            pImv[i] = new ImageView(pImg);
            coinGrid.add(pImv[i], qImv.length + dImv.length + nImv.length + i, 0);
         }

         System.out.println("*******************");
         System.out.println(c.toString());
         System.out.println("Quarter: " + c.getqTimes());
         System.out.println("Dime: " + c.getdTimes());
         System.out.println("Nickel: " + c.getnTimes());
         System.out.println("Penny: " + c.getpTimes());
      }
      catch (Exception e) {
         System.out.println("******************************************");
         System.out.println("Please try again. Input between 0 and 100.");
         System.out.println("******************************************");
      }

   }
}
