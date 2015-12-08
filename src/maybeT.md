# MaybeT

`scalaz.Maybe`のモナドトランスフォーマーです。
scalazにMaybeが入ったのとほぼ同じタイミングでMaybeTも追加されました。
実態は以下のようなcase classです。

```tut:invisible
import scalaz.Maybe
```

```tut:silent
final case class MaybeT[F[_], A](run: F[Maybe[A]])
```
