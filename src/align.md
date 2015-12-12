# Align

Zipと似たような型クラスですが、Zipよりある意味汎用的に使える型クラスです。
以下のようなシグネチャの`alignWith`という抽象メソッドがあります。

```scala
def alignWith[A, B, C](f: A \&/ B => C): (F[A], F[B]) => F[C]
```

`\&/`はTheseとも呼ばれるデータ構造です。
Alignは`\&/`と密接に関連しており、`\&/`を理解していないとAlignの説明をするのは難しいので、
`\&/`を知らない人はまずそちらの説明を参照してください。


まず、標準ライブラリのListを使った例を見てみましょう。
標準ライブラリのListのzipメソッドでは、長さが揃っていない場合は、短い方に合わせて切り捨てられますが


```tut:invisible
import scalaz._, std.list._
```

```tut:silent
val x = List("a", "b", "c", "d")
val y = List(1, 2)
```

```tut
x zip y
```

Alignを使用した場合、切り捨てられるのではなく

```tut
Align[List].align(x, y)
Align[List].align(y, x)
```

- 両方が存在する部分まではBoth
- 1つめの引数のほうが長い場合は、残りはThis
- 2つめの引数のほうが長い場合は、残りはThat

というような結果になります。

List以外にもAlignのインスタンスになっているデータ型はいくつかあります。
