# Liskov

[Scala標準ライブラリの`<:<`](https://github.com/scala/scala/blob/v2.12.0/src/library/scala/Predef.scala#L480-L500)と同じような役割をするものです。

本体にメソッドはそれほど多くなく、7.2.7時点で以下のような定義です。
(シグネチャのみで、実装は省略しています)

```tut:invisible
import scalaz._
```

```tut:silent
sealed abstract class Liskov[-A, +B] {
  def apply(a: A): B
  def subst[F[-_]](p: F[B]): F[A]
  def *[+[+_, +_], C, D](that: Liskov[C, D]): Liskov[A + C, B + D]
  def andThen[C](that: Liskov[B, C]): Liskov[A, C]
  def compose[C](that: Liskov[C, A]): Liskov[C, B]
  def onF[X](fa: X => A): X => B
}
```

コンパニオンオブジェクトに`<~<`と`>~>`というaliasが定義されていて、基本的にはこのaliasが使われます。


```tut:silent
type <~<[-A, +B] = Liskov[A, B]

type >~>[+B, -A] = Liskov[A, B]
```

`def apply(a: A): B`に関しては、Predefのものと全く同じ用途です。scalaz.Liskovが優れているのは、その他にもいくつかのメソッドを持っている点です。

ちなみに、Scala本体にも同様のメソッドを入れる動きがありましたが、結局mergeするまでには至っていません。

[Add composition and subst methods to =:= and &lt;:&lt; by puffnfresh · Pull Request #3992 · scala/scala](https://github.com/scala/scala/pull/3992)

Liskovに関しては、以下の記事も読むとよいでしょう。

[typelevel.scala | When can Liskov be lifted?](http://typelevel.org/blog/2014/03/09/liskov_lifting.html)
