package week1

object test {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  1+1                                             //> res0: Int(2) = 2
  def abs(x: Double) = if (x<0) -x else x         //> abs: (x: Double)Double
  def sqrtIter(guess: Double, x: Double): Double =
  	if (isGoodEnough(guess, x)) guess
  	else sqrtIter(improve(guess,x),x)         //> sqrtIter: (guess: Double, x: Double)Double

	def isGoodEnough(guess: Double, x: Double) =
		abs(guess * guess - x) < x/(1e8)  //> isGoodEnough: (guess: Double, x: Double)Boolean
		
	def improve(guess: Double, x: Double) =
		(guess + x / guess)/2             //> improve: (guess: Double, x: Double)Double
		
	def sqrt(x: Double) = sqrtIter(1, x)      //> sqrt: (x: Double)Double
	
	sqrt(2)                                   //> res1: Double = 1.4142135623746899
	sqrt(1e-6)                                //> res2: Double = 0.0010000000000000117
	sqrt(1e-20)                               //> res3: Double = 1.000000000002308E-10
}