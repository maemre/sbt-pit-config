package typechecker

import syntax._
import org.scalatest.{FlatSpec, Matchers}

class TypecheckerSpec extends FlatSpec with Matchers {
  "type of a number" should "be numt" in {
    Typechecker.typeOf(Num(1)) should be(Some(NumT))
  }
  "type of a string" should "be strt" in {
    Typechecker.typeOf(Str("a")) should be(Some(StrT))
  }
  "type of a valid add" should "be numt" in {
    Typechecker.typeOf(Add(Num(1), Num(1))) should be(Some(NumT))
  }
  "type of a valid larger add" should "be numt" in {
    Typechecker.typeOf(Add(Num(1), Add(Add(Num(1), Num(1)), Num(1)))) should be(Some(NumT))
  }
  "type of an invalid larger add" should "be numt" in {
    Typechecker.typeOf(Add(Num(1), Add(Add(Str("a"), Num(1)), Num(1)))) should be(None)
  }
  "dummy method" should "return 3" in {
    Typechecker.dummy should be(3)
  }
}
