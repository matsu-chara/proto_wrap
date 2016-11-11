import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.StringValue;
import com.google.protobuf.util.JsonFormat;
import example.Mofu.Example;

public class Main {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        Example ex = Example.newBuilder()
                .setFoo("foo")
                .setBar(Example.Bar.newBuilder().setValue("bar"))
                .setBaz("baz")
                .setMofu(StringValue.newBuilder().setValue("mofu"))
                .build();

        System.out.println("instance.toString");
        System.out.println(ex.toString());
        System.out.println("json");
        System.out.println(JsonFormat.printer().print(ex));
        System.out.printf("");

        Example empty = Example.getDefaultInstance();
        // foo == ""
        System.out.println("foo isEmpty: " + empty.getFoo().isEmpty());

        // bar == null (getBar returns defaultBar if bar == null)
        System.out.println("hasBar: " + empty.hasBar());
        System.out.println("bar isEmpty: " + empty.getBar().getValue().isEmpty());

        // baz ==  BAZOPTION_NOT_SET (getBaz returns "" if BazOptionCase != Baz)
        System.out.println("bazOptionCase: " + empty.getBazOptionCase());
        System.out.println("baz isEmpty: " + empty.getBaz().isEmpty());

        // mofu == null (getMofu returns defaultMofu if mofu == null)
        System.out.println("mofu hasMofu: " + empty.hasMofu());
        System.out.println("mofu isEmpty: " + empty.getMofu().getValue().isEmpty());
    }
}

/*
instance.toString
foo: "foo"
bar {
  value: "bar"
}
baz: "baz"
mofu {
  value: "mofu"
}

json
{
  "foo": "foo",
  "bar": {
    "value": "bar"
  },
  "baz": "baz",
  "mofu": "mofu"
}
foo isEmpty: true
hasBar: false
bar isEmpty: true
bazOptionCase: BAZOPTION_NOT_SET
baz isEmpty: true
mofu hasMofu: false
mofu isEmpty: true
*/
