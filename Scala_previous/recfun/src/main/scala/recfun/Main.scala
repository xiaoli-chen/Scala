package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
	if ( c == 0 || c == r) 1 else pascal(c-1,r-1) + pascal(c,r-1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
   
    def cbalan(c: Int, chars: List[Char]): Int = {
      if (c < 0) c
      else if (chars.isEmpty) c;
      else if (chars.head == '(' ) cbalan(c+1,chars.tail);
      else if (chars.head == ')' ) cbalan(c-1,chars.tail);
      else cbalan(c, chars.tail);
      }
    (cbalan(0,chars) == 0)
    
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def change(money:Int, coins: List[Int]): Int={
    	if (coins.isEmpty) 0
        else{
        	  if (money<0) 0 
        	  else if (money == 0) 1
        	  else{
          		  change(money, coins.tail) + change(money-coins.head,coins)
        	  }
        }
  
    }
    change(money,coins.sorted)
  }
}
