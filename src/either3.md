# Either3

以下のような、3つのうちのどれか？を表すデータ型です。

```tut:silent
sealed abstract class Either3[A, B, C] extends Product with Serializable {
  // メソッド省略
}

object Either3 {
  final case class Left3[A, B, C](a: A) extends Either3[A, B, C]
  final case class Middle3[A, B, C](b: B) extends Either3[A, B, C]
  final case class Right3[A, B, C](c: C) extends Either3[A, B, C]

  // メソッド省略
}
```

それほど多く使われてるのは見かけません。
通常のプログラミングにおいては、同じようなデータ型だとしても
Either3を使うのではなく、わかりやすさのために専用のデータ型を作ったほうがいいと思います。
