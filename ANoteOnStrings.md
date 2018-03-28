We know that `int`, `boolean`, and `double` all "fit in the box". Similarly, we know that objects of types like `Posn` are too large and so we have an arrow to the actual object in the box. But what about types like `String`?

One might think that a `String` "fits in the box" just like an `int`. After all, you make the two very similarly. For example,

```java
int y = 4;
String str = "hi";
```

However, in reality, the only reason these look similar is because Java abstracts away the constructor for `String`. When you have the statement `String str = "hi";`, Java is actually calling `String str = new String("hi");` which creates a new `String` object. (Java does a few other optimizations but we don't need to worry about those). Therefore, since we are making a new object, the `String` box only contains an arrow to the actual object, similar to `Posn`. However, `String` objects get a bit more interesting.

Based on the above information, try to do the problem below.

```java
void testString() {
    String s1 = "Fundies II";
    String s2 = " is awesome";
    String s3 = s1.concat(s2);
    
    // What do s1, s2, and s3 look like?
}
```

One might expect the diagram to look like the following at the end of this method:

![MG_462](/Users/manaspurohit/Downloads/IMG_4620.JPG)

However, in reality, the diagram is the following:

![MG_719](/Users/manaspurohit/Downloads/IMG_7195.JPG)

The reason lies within the concat method. The signature for concat is `String` -> `String`. This means that it is producing a **new** `String` instead of mutating the `String` it is called on. So, the object that s1 points to isn't mutated at all. Instead, the concat method takes the data within that object and combines it with the data from the object that s2 points to to create a new `String` object which it returns. s3 then points to this new `String`.

In fact, `String` objects are immutable meaning that there are no methods that you can call on a `String` to mutate it. This is analogous to how "object" versions of our primitives (`Integer`, `Boolean`, `Double`) behave. So, while a `String` is definitely an object, due to its immutability, it behaves a bit like a primitive.