object classtest {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val x = new rational(1,3)                       //> x  : rational = 1/3
   
  val y = new rational(5,7)                       //> y  : rational = 5/7
  
  val z = new rational(3,2)                       //> z  : rational = 3/2
  
  x - y - z                                       //> res0: rational = -79/42
  x.neg                                           //> res1: rational = 1/-3
  x.neg.num                                       //> res2: Int = -1
  x.neg.denom                                     //> res3: Int = 3
  x < y                                           //> res4: Boolean = true
  x max y                                         //> res5: rational = 5/7
  val strange = new rational(1,2)                 //> strange  : rational = 1/2
  new rational(2)                                 //> res6: rational = 2/1
	//strange.add(strange)
	type Set = Int => Boolean
	def contains(s: Set, elem: Int): Boolean = s(elem)
                                                  //> contains: (s: Int => Boolean, elem: Int)Boolean
	def singletonSet(elem: Int): Set = n => n==elem
                                                  //> singletonSet: (elem: Int)Int => Boolean
  val a = singletonSet(1)                         //> a  : Int => Boolean = <function1>
			a(0)                      //> res7: Boolean = false
	def union(s: Set, t:Set): Set = n => s(n) || t(n)
                                                  //> union: (s: Int => Boolean, t: Int => Boolean)Int => Boolean
	val b= singletonSet(2)                    //> b  : Int => Boolean = <function1>
	val c= union(a,b)                         //> c  : Int => Boolean = <function1>
  c(1)                                            //> res8: Boolean = true
  c(2)                                            //> res9: Boolean = true
  
  val d=singletonSet(3)                           //> d  : Int => Boolean = <function1>
  val e=union(a,d)                                //> e  : Int => Boolean = <function1>
  e(1)                                            //> res10: Boolean = true
  e(3)                                            //> res11: Boolean = true
  
  def intersect(s: Set, t: Set): Set = n=> s(n) && t(n)
                                                  //> intersect: (s: Int => Boolean, t: Int => Boolean)Int => Boolean
  val f = intersect(c,e)                          //> f  : Int => Boolean = <function1>
  
  f(1)                                            //> res12: Boolean = true
  f(2)                                            //> res13: Boolean = false
  f(3)                                            //> res14: Boolean = false
    def diff(s: Set, t: Set): Set = n => s(n) && (!t(n))
                                                  //> diff: (s: Int => Boolean, t: Int => Boolean)Int => Boolean
  val h = diff(c,e)                               //> h  : Int => Boolean = <function1>
  h(1)                                            //> res15: Boolean = false
  h(2)                                            //> res16: Boolean = true
  h(3)                                            //> res17: Boolean = false
  def filter(s: Set, p: Int => Boolean): Set = intersect(s,p)
                                                  //> filter: (s: Int => Boolean, p: Int => Boolean)Int => Boolean
  def evennum(elem: Int): Set = n => (n%elem==0)  //> evennum: (elem: Int)Int => Boolean
  val ev = evennum(2)                             //> ev  : Int => Boolean = <function1>
  ev(4)                                           //> res18: Boolean = true
    val bound = 1000                              //> bound  : Int = 1000

  /**
   * Returns whether all bounded integers within `s` satisfy `p`.
   */
  def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a>bound) true
      else if (contains(s,a)) p(a)
      else iter(a+1)
    }
    iter(-bound)
  }                                               //> forall: (s: Int => Boolean, p: Int => Boolean)Boolean

  /**
   * Returns whether there exists a bounded integer within `s`
   * that satisfies `p`.
   */
  def exists(s: Set, p: Int => Boolean): Boolean = !forall(s,diff(s,p))
                                                  //> exists: (s: Int => Boolean, p: Int => Boolean)Boolean
  
}
  
  
  class rational(a: Int, b: Int) {
    require( b != 0, "denominator should be non zeros")
    
    def this(x: Int) = this(x,1)
  	private def gcd(a: Int, b:Int): Int = if(b==0) a else gcd(b,a%b)
  	private val g=gcd(a,b)
  	def num = a
  	def denom = b
  	
  	def < (that: rational) = num * that.denom < that.num * denom
  	
  	def max(that: rational) = if (this < that) that else this
  	def neg: rational = new rational(-a,b)
  	def + (that: rational) = new rational(
  					num * that.denom + denom * that.num,
  					denom * that.denom
  	)
  	def - (that: rational) = new rational(
  					num * that.denom - denom * that.num,
  					denom * that.denom
  	)
  	
  	override def toString = {
  		val g = gcd(num,denom)
  		num/g + "/" +denom/g
  	}
  }