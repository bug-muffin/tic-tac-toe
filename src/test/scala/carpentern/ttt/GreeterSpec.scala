import org.scalatest.FunSpec
import carpentern.ttt.Greeter

class GreeterSpec extends UnitSpec {
  val greeter = new Greeter()

  describe("Greeter") {
    describe("#sayHi") {
      it("should return a greeting") {
        assert(greeter.sayHi == "Hello World")
      }
    }
  }
}