package typechecker

import syntax._

sealed trait Type
case object NumT extends Type
case object StrT extends Type

object Typechecker {
  def typeOf(e: Expr): Option[Type] = e match {
    case _:Num ⇒ Some(NumT)
    case _:Str ⇒ Some(StrT)
    case Add(e1, e2) ⇒
      for {
        t1 ← typeOf(e1)
        t2 ← typeOf(e2) if t1 == t2 && t2 == NumT
      } yield NumT
  }

  def dummy = 3
}
