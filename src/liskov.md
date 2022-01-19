# Liskov

[Scala標準ライブラリの`<:<`](https://github.com/scala/scala/blob/v2.13.8/src/library/scala/typeConstraints.scala#L63)と同じような役割をするものです。

本体にメソッドはそれほど多くなく、7.3.6時点で以下のような定義です。
(シグネチャのみで、実装は省略しています)

```scala mdoc:invisible
import scalaz._
```

```scala mdoc:silent
sealed abstract class Liskov[-A, +B] {
  def apply(a: A): B
  def substCo[F[+_]](p: F[A]): F[B]
  def substCt[F[-_]](p: F[B]): F[A]
  def *[x[+_, +_], C, D](that: Liskov[C, D]): Liskov[A x C, B x D]
  def andThen[C](that: Liskov[B, C]): Liskov[A, C]
  def compose[C](that: Liskov[C, A]): Liskov[C, B]
  def onF[X](fa: X => A): X => B
}

```

コンパニオンオブジェクトに`<~<`と`>~>`というaliasが定義されていて、基本的にはこのaliasが使われます。


```scala mdoc:silent
type <~<[-A, +B] = Liskov[A, B]

type >~>[+B, -A] = Liskov[A, B]
```

`def apply(a: A): B`に関しては、Scala標準ライブラリのものと全く同じ用途です。scalaz.Liskovが優れているのは、その他にもいくつかのメソッドを持っている点です。

ただし、Scala 2.13 からは、Scala本体にも同様のメソッドが入っています。

[Add substitute methods and tests](https://github.com/scala/scala/commit/0c9f08068dfd4b49239fe68b95eaa3ea9341554f)

Liskovに関しては、以下の記事も読むとよいでしょう。

[typelevel.scala | When can Liskov be lifted?](https://typelevel.org/blog/2014/03/09/liskov_lifting.html)
