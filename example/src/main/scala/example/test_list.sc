object Lists{
  /**
    * This method computes the sum of all elements in the list xs. There are
    * multiple techniques that can be used for implementing this method, and
    * you will learn during the class.
    *
    * For this example assignment you can use the following methods in class
    * `List`:
    *
    * - `xs.isEmpty: Boolean` returns `true` if the list `xs` is empty
    * - `xs.head: Int` returns the head element of the list `xs`. If the list
    * is empty an exception is thrown
    * - `xs.tail: List[Int]` returns the tail of the list `xs`, i.e. the the
    * list `xs` without its `head` element
    *
    * ''Hint:'' instead of writing a `for` or `while` loop, think of a recursive
    * solution.
    *
    * @param xs A list of natural numbers
    * @return The sum of all elements in `xs`
    */
  def sum(xs: List[Int]): Int = {
    def loop(acc: Int, n: Int): Int = {
      if (n == 0) acc
      else loop(acc + xs(n - 1), n - 1)
    }
    loop(0, xs.length)

  }

  sum(List(1,2,3))
}