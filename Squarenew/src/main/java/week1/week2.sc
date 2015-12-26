object exercise{
  def factorial(n: Int): Int = {
    def loop(acc: Int, n:Int): Int=
        if(n==0) acc
        else loop(acc*n, n-1)
    loop(1,n)
  }

  factorial(10)

  //val xs=List(12,3,4,5)

  def sum(xs: List[Int]):Int = {
    def loop(acc: Int, n:Int): Int={
      if(n==0) acc
      else loop(acc+xs(n-1),n-1)
    }
    loop(0,xs.length)
  }
  sum(List(1,2,3))

  def max(xs: List[Int]): Int = {
    def loop(M: Int, n: Int): Int={
      if(n==0) M
      else  loop((if(M>xs(n-1)) M; else xs(n-1)),n-1)
    }
    loop(xs.last,xs.length-1)
  }

  max(List(1,5,3,12,6))


}