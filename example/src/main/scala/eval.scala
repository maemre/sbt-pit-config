package eval

import syntax._

object Eval {
  def eval(e: Expr): Any = e match {
    case Num(n) ⇒ n
    case Str(s) ⇒ s
    case Add(e1, e2) ⇒ (eval(e1), eval(e2)) match {
      case (n1:Int, n2:Int) ⇒ n1 + n2
      case _ ⇒ sys.error("type error on addition")
    }
  }
}
