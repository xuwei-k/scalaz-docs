# MaybeT

`scalaz.Maybe`のモナドトランスフォーマーです。
scalazにMaybeが入ったのとほぼ同じタイミングでMaybeTも追加されました。
実態は以下のようなcase classです。

```scala mdoc:invisible
import scalaz.Maybe
```

```scala mdoc:silent
final case class MaybeT[F[_], A](run: F[Maybe[A]])
```
