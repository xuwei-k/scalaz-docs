# Cord

以下のような、Stringを内部に持ったTreeのようなデータ型です。

```scala mdoc:silent
sealed abstract class Cord {
  // メソッド省略
}

object Cord {
  final class Leaf private(val s: String) extends Cord
  final class Branch private (
    val leftDepth: Int,
    val left: Cord,
    val right: Cord
  ) extends Cord
}
```

`scalaz.Show`などで使われています。7.2以前は内部実装がFingerTreeでしたが、7.3から上記のようなものに置き換えられました。
