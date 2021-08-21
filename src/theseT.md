# TheseT

Theseのモナドトランスフォーマーです。7.2.x系だと、7.2.4以降から入っています。
他の言語での例を見たことがないのですが[^other-impl]、モナド則は満たすようです。

定義は、単純に以下のようになっています。

```scala mdoc:invisible
import scalaz.\&/
```

```scala mdoc:silent
final case class TheseT[F[_], A, B](run: F[A \&/ B]) {
  // その他のメソッド省略
}
```

[^other-impl]: もし他の言語、もしくはライブラリで、scalazより先に実装された例があれば教えて下さい。
