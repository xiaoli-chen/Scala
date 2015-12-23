object classtest {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(62); 
  println("Welcome to the Scala worksheet");$skip(28); 
  val x = new rational(1,3);System.out.println("""x  : rational = """ + $show(x ));$skip(32); 
   
  val y = new rational(5,7);System.out.println("""y  : rational = """ + $show(y ));$skip(31); 
  
  val z = new rational(3,2);System.out.println("""z  : rational = """ + $show(z ));$skip(15); val res$0 = 
  
  x - y - z;System.out.println("""res0: rational = """ + $show(res$0));$skip(8); val res$1 = 
  x.neg;System.out.println("""res1: rational = """ + $show(res$1));$skip(12); val res$2 = 
  x.neg.num;System.out.println("""res2: Int = """ + $show(res$2));$skip(14); val res$3 = 
  x.neg.denom;System.out.println("""res3: Int = """ + $show(res$3));$skip(8); val res$4 = 
  x < y;System.out.println("""res4: Boolean = """ + $show(res$4));$skip(10); val res$5 = 
  x max y;System.out.println("""res5: rational = """ + $show(res$5));$skip(34); 
  val strange = new rational(1,2);System.out.println("""strange  : rational = """ + $show(strange ));$skip(18); val res$6 = 
  new rational(2)
	//strange.add(strange)
	type Set = Int => Boolean;System.out.println("""res6: rational = """ + $show(res$6));$skip(103); 
	def contains(s: Set, elem: Int): Boolean = s(elem);System.out.println("""contains: (s: Int => Boolean, elem: Int)Boolean""");$skip(49); 
	def singletonSet(elem: Int): Set = n => n==elem;System.out.println("""singletonSet: (elem: Int)Int => Boolean""");$skip(26); 
  val a = singletonSet(1);System.out.println("""a  : Int => Boolean = """ + $show(a ));$skip(8); val res$7 = 
			a(0);System.out.println("""res7: Boolean = """ + $show(res$7));$skip(51); 
	def union(s: Set, t:Set): Set = n => s(n) || t(n);System.out.println("""union: (s: Int => Boolean, t: Int => Boolean)Int => Boolean""");$skip(24); 
	val b= singletonSet(2);System.out.println("""b  : Int => Boolean = """ + $show(b ));$skip(19); 
	val c= union(a,b);System.out.println("""c  : Int => Boolean = """ + $show(c ));$skip(7); val res$8 = 
  c(1);System.out.println("""res8: Boolean = """ + $show(res$8));$skip(7); val res$9 = 
  c(2);System.out.println("""res9: Boolean = """ + $show(res$9));$skip(27); 
  
  val d=singletonSet(3);System.out.println("""d  : Int => Boolean = """ + $show(d ));$skip(19); 
  val e=union(a,d);System.out.println("""e  : Int => Boolean = """ + $show(e ));$skip(7); val res$10 = 
  e(1);System.out.println("""res10: Boolean = """ + $show(res$10));$skip(7); val res$11 = 
  e(3);System.out.println("""res11: Boolean = """ + $show(res$11));$skip(59); 
  
  def intersect(s: Set, t: Set): Set = n=> s(n) && t(n);System.out.println("""intersect: (s: Int => Boolean, t: Int => Boolean)Int => Boolean""");$skip(25); 
  val f = intersect(c,e);System.out.println("""f  : Int => Boolean = """ + $show(f ));$skip(10); val res$12 = 
  
  f(1);System.out.println("""res12: Boolean = """ + $show(res$12));$skip(7); val res$13 = 
  f(2);System.out.println("""res13: Boolean = """ + $show(res$13));$skip(7); val res$14 = 
  f(3);System.out.println("""res14: Boolean = """ + $show(res$14));$skip(57); 
    def diff(s: Set, t: Set): Set = n => s(n) && (!t(n));System.out.println("""diff: (s: Int => Boolean, t: Int => Boolean)Int => Boolean""");$skip(20); 
  val h = diff(c,e);System.out.println("""h  : Int => Boolean = """ + $show(h ));$skip(7); val res$15 = 
  h(1);System.out.println("""res15: Boolean = """ + $show(res$15));$skip(7); val res$16 = 
  h(2);System.out.println("""res16: Boolean = """ + $show(res$16));$skip(7); val res$17 = 
  h(3);System.out.println("""res17: Boolean = """ + $show(res$17));$skip(62); 
  def filter(s: Set, p: Int => Boolean): Set = intersect(s,p);System.out.println("""filter: (s: Int => Boolean, p: Int => Boolean)Int => Boolean""");$skip(49); 
  def evennum(elem: Int): Set = n => (n%elem==0);System.out.println("""evennum: (elem: Int)Int => Boolean""");$skip(22); 
  val ev = evennum(2);System.out.println("""ev  : Int => Boolean = """ + $show(ev ));$skip(8); val res$18 = 
  ev(4);System.out.println("""res18: Boolean = """ + $show(res$18));$skip(21); 
    val bound = 1000;System.out.println("""bound  : Int = """ + $show(bound ));$skip(273); 

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
  };System.out.println("""forall: (s: Int => Boolean, p: Int => Boolean)Boolean""");$skip(173); 

  /**
   * Returns whether there exists a bounded integer within `s`
   * that satisfies `p`.
   */
  def exists(s: Set, p: Int => Boolean): Boolean = !forall(s,diff(s,p));System.out.println("""exists: (s: Int => Boolean, p: Int => Boolean)Boolean""")}
  
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
