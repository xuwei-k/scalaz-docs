# OptionT

`scala.Option` のモナドトランスフォーマーです。
関連するものとして、`scalaz.MaybeT`, `scalaz.LazyOptionT` というものもあります。

実装としては、単に以下のような`run`というフィールドを1つだけ保持したcase classです。

```tut:silent
final case class OptionT[F[_], A](run: F[Option[A]])
```
