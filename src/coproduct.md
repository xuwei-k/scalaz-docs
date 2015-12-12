# Coproduct

以下のようなフィールドを1つ保持したcase classです。

```tut:invisible
import scalaz._
```

```tut:silent
final case class Coproduct[F[_], G[_], A](run: F[A] \/ G[A])
```

FreeやInjectと組み合わせて使われることがあります。

[shapelssのCoproduct](https://github.com/milessabin/shapeless/blob/shapeless-2.2.5/core/src/main/scala/shapeless/coproduct.scala)と似ていますが、微妙に異なるものなので注意してください。
