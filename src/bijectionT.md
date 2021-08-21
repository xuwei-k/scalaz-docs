# BijectionT

Bijectionを日本語に訳すと"全単射"という意味です。
BijectionT自体は以下のような定義です

```scala mdoc:silent
final class BijectionT[F[_], G[_], A, B] (_to: A => F[B], _from: B => G[A])
```

また、`Bijection`というaliasもあります

```scala mdoc:invisible
import scalaz.Id.Id
```

```scala mdoc:silent
type Bijection[A, B] = BijectionT[Id, Id, A, B]
```

Scalaz内にはIsomorphismと呼ばれる同じようなものもあります。
そもそもBijectionTの`T`の部分は意味が無いのではないか？というissueがあり、

https://github.com/scalaz/scalaz/issues/757

BijectionTがそのまま使われることは多くありません。
