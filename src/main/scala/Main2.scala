import com.google.protobuf.util.JsonFormat
import com.google.protobuf.wrappers.StringValue
import com.trueaccord.scalapb.JavaProtoSupport
import example.Mofu.{ Example => JExample }
import example.mofu.Example
import example.mofu.Example.Bar
import example.mofu.Example.BazOption.Baz

object Main2 {
  def main(args: Array[String]): Unit = {
    val ex = Example().update(_.foo := "foo", _.bar := Bar("bar"), _.bazOption := Baz("baz"), _.mofu := StringValue("mofu"))
    println("instance.toString")
    println(ex.toString)
    println("json")
    println(JsonFormat.printer.print(implicitly[JavaProtoSupport[Example, JExample]].toJavaProto(ex)))
    printf("")

    val empty = Example()
    // foo == ""
    println("foo isEmpty: " + empty.foo.isEmpty)

    // bar == null (getBar returns defaultBar if bar == null)
    println("hasBar: " + empty.bar.isEmpty)
    println("bar isEmpty: " + empty.getBar.value.isEmpty)

    // baz ==  BAZOPTION_NOT_SET (getBaz returns "" if BazOptionCase != Baz)
    println("bazOption: " + empty.bazOption)
    println("baz isEmpty: " + empty.getBaz.isEmpty)

    // mofu == null (getMofu returns defaultMofu if mofu == null)
    println("mofu hasMofu: " + empty.mofu)
    println("mofu isEmpty: " + empty.getMofu.value.isEmpty)
  }
}
