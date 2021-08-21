# IsEmpty

`PlusEmpty`を継承した型クラスです。以下のような定義です。

```scala mdoc:invisible
import scalaz._
```

```scala mdoc:silent
trait IsEmpty[F[_]] extends PlusEmpty[F] { self =>

  def isEmpty[A](fa: F[A]): Boolean

  // その他のメソッド省略
}
```

日本語で説明すれば

「型引数がどんなものであろうとも、それに関係なく空かどうか？が必ず判断可能な型クラス」

といったところでしょうか。
この説明は`PlusEmpty`と比べた場合の話です。

`PlusEmpty`には`def empty[A]: F[A]`というメソッドがあります。
Fが`PlusEmpty`のインスタンスで`IsEmpty`のインスタンスではない場合でも、`Equal[F[A]]`のインスタンスがあれば`empty`メソッドで生成したものと比較することによって「空かどうか？」は判断可能です。
逆に言うと
`PlusEmpty`のインスタンスだが`IsEmpty`のインスタンスではない場合は **`Equal[F[A]]`のインスタンスがなければ** 空かどうかは判断できません。

単にそれだけの型クラスで、あまり難しくはないと思います。自分が知る限り、他の型クラスがある言語でも、この型クラスはあまり見かけません[^other-lang]。


[^other-lang]: 誰か他の言語での例があれば教えて下さい
