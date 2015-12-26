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
      if(c>r) {
        println("Error, count > row")
        0
      }
      else{
        if (c == 0 || c == r) 1
        else pascal(c, r - 1) + pascal(c - 1, r - 1)
      }

  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def loop(n: Int, L: List[Char]): AnyVal = {

      if (L.isEmpty) n
      else if (n < 0) {
        n
      }
      else {
        if (L.head == '(') {
          loop(n + 1, L.tail)
        }
        else if (L.head == ')') {
          loop(n - 1, L.tail)
        }
        else loop(n,L.tail)

      }
    }
    val n = loop(0,chars)
    if(n==0) true
    else false
  }

  /**
   * Exercise 3 My method is much better than the standard recursive method
   */
   // countChange: using the most simplist recursive method 
  def countChange(money: Int, coins: List[Int]): Int ={
    val sortcoins = coins.sorted
    val sortC= sortcoins.reverse
    def loop(money: Int,sortL: List[Int]):Int={
        if (sortL.isEmpty) {
          0
        } else{

          if (money < 0) {
            0
          }
          else if(money == 0) {
              1
            }
          else {
              loop(money - sortL.head, sortL) + loop(money, sortL.tail)
          }

        }
    }
    loop(money,sortC)
  }
}
