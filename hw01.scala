object Hw01 {

  /**
  Consider the following language of propositional logic formulae:
   */
  sealed abstract class Exp
  case class True() extends Exp  // constant true
  case class False() extends Exp // constant false
  case class And(lhs: Exp, rhs: Exp) extends Exp
  case class Or(lhs: Exp, rhs: Exp) extends Exp
  case class Not(e: Exp) extends Exp
  case class Impl(lhs: Exp, rhs: Exp) extends Exp

  /**
  Tasks:
​
       1) Implement the missing parts of the interpreter for these formulae
          (the eval function).
          Test the correctness by evaluating the example proposition given
          below and add at least two more examples and test against these.
​
       2) Add implication as a new kind of expression "Impl" and extend
          the interpreter accordingly. Add at least two examples and test.
   */

  def eval(e: Exp) : Boolean = e match {
    case True()    => true
    case False()   => false
    case And(l, r) => eval(l) && eval(r)
    case Or(l, r)  => eval(l) || eval(r)
    case Not(e)    => if (eval(e) == true) {false} else {true}
    case Impl(l, r)=> eval(Or(Not(l), r))
  }

  val exampleProposition = And(Not(True()), False()) // should evaluate to false
  val exProp1 = Or(False(), True()) // True
  val exProp2 = And(Not(False()), Or(True(), False())) // True
  
  println(eval(exampleProposition))
  println(eval(exProp1))
  println(eval(exProp2))
  println()
  
  println(eval(Impl(False(), False()))) // True
  println(eval(Impl(False(), True())))  // True
  println(eval(Impl(True(), False())))  // False
  println(eval(Impl(True(), True())))   // True
}

Hw01
