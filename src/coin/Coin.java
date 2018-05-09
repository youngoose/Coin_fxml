package coin;
import java.util.*;

public class Coin
{
   private int amount;
   private final int QUARTER = 25;
   private final int DIME = 10;
   private final int NICKEL = 5;
   private final int PENNY = 1;
   private int qTimes;
   private int dTimes;
   private int nTimes;
   private int pTimes;
   
   public Coin ()
   {
   }
   
   public Coin (int amount)
   {
      filteredCoins(amount);
   }
   
   public void setAmount (int amount)
   {
      this.amount = amount;
   }
   
   public int getAmount ()
   {
      return amount;
   }
   
   public int getQUARTER ()
   {
      return QUARTER;
   }
   
   public int getDIME ()
   {
      return DIME;
   }
   
   public int getNICKEL ()
   {
      return NICKEL;
   }
   
   public int getPENNY ()
   {
      return PENNY;
   }
   
   public void setqTimes (int qTimes)
   {
      this.qTimes = qTimes;
   }
   
   public void setdTimes (int dTimes)
   {
      this.dTimes = dTimes;
   }
   
   public void setnTimes (int nTimes)
   {
      this.nTimes = nTimes;
   }
   
   public void setpTimes (int pTimes)
   {
      this.pTimes = pTimes;
   }
   
   public int getqTimes ()
   {
      return qTimes;
   }
   
   public int getdTimes ()
   {
      return dTimes;
   }
   
   public int getnTimes ()
   {
      return nTimes;
   }
   
   public int getpTimes ()
   {
      return pTimes;
   }
   
   @Override
   public String toString ()
   {
      return "Entered amount: " + amount;
   }
   
   public Map<Integer, Integer> filteredCoins (int amount)
   {
      setAmount(amount);
      Map<Integer, Integer> coins = new HashMap<Integer, Integer>();
      //entering default values to map
      coins.put(QUARTER, 0);
      coins.put(DIME, 0);
      coins.put(NICKEL, 0);
      coins.put(PENNY, 0);
      
      ArrayList<Integer> coinFace = new ArrayList<>();
      coinFace.addAll(coins.keySet());
      Collections.sort(coinFace);
      Collections.reverse(coinFace);
      
      for (Integer key : coinFace) {
         // number of coins or specific coin face
         int counterCoins = 0;
         while (amount >= key) {
            amount -= key;
            counterCoins++;
            coins.replace(key, counterCoins);
            // put - it will add new value or replace old value
            // replace - it will replace old value
         }
      }
      qTimes = coins.get(QUARTER);
      dTimes = coins.get(DIME);
      nTimes = coins.get(NICKEL);
      pTimes = coins.get(PENNY);
      return coins;
   }
   
}
