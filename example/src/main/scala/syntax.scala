package syntax

sealed trait Expr
case class Add(e1: Expr, e2: Expr) extends Expr
case class Num(n: Int) extends Expr
case class Str(s: String) extends Expr
