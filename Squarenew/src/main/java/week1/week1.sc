object week1{
  println("Welcome to the Scala worksheet")
  1+4
  def sqrtIter(guess: Double, x: Double): Double =
      if (isGoodEnough(guess, x)) guess
      else sqrtIter(improve(guess,x),x)

  def abs(x: Double) = if(x<0) -x else x
  def isGoodEnough(guess: Double, x: Double): Boolean =
      abs(guess * guess - x) < 0.00001*x

  def improve(guess: Double, x: Double): Double =
      (guess + x / guess ) / 2

  def sqrt(x: Double ): Double= sqrtIter(1.0,x)
  sqrt(2)
  sqrt(0.00001)
  sqrt(0.00000001)
  sqrt(1000000)
  sqrt(1e20)



}


