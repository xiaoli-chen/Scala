class Rational(x: Int, y:Int){
  private def gcd(a:Int,b:Int): Int=if (b==0) a else gcd(b,a%b)
  private val g = gcd(x,y)
  def numer = x / g
  def denom = y / g

  def + (that: Rational) =
    new Rational(
      numer * that.denom + that.numer* denom,
      denom * that.denom
    )

  def unary_- : Rational= new Rational(-numer,denom)


  def -(that: Rational) = this + -that


  println(numer + "/" + denom + "\n")
}

val t = new Rational(1,2)

val x = new Rational(1,3)
val y = new Rational(5,8)

x + y

x - y



-y
x-y
