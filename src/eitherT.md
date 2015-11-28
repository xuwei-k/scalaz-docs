# EitherT

Eitherのモナドトランスフォーマーです。
`MaybeT`, `OptionT` の関係とは違い、この`EitherT`は`scalaz.\/`が使われており、
`scala.Either`が使われているモナドトランスフォーマーは存在しません。

実態は以下のようなcase classです

```tut:invisible
import scalaz._
```

```tut:silent
final case class EitherT[F[_], A, B](run: F[A \/ B])
```

関連するclassとして、`LazyEitherT`も存在します。
