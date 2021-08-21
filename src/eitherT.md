# EitherT

Eitherのモナドトランスフォーマーです。
`MaybeT`, `OptionT` の関係とは違い、この`EitherT`は`scalaz.\/`が使われており、
`scala.Either`が使われているモナドトランスフォーマーは存在しません。

実態は以下のようなcase classです

```scala mdoc:invisible
import scalaz._
```

```scala mdoc:silent
final case class EitherT[A, F[_], B](run: F[A \/ B])
```

関連するclassとして、`LazyEitherT`も存在します。
