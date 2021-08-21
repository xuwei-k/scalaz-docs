# NaturalTransformation

Scalaにおいて、[HaskellのRank N types](https://wiki.haskell.org/Rank-N_types)
が直接サポートされていないことにより必要なデータ型[^data]です。

```scala mdoc:invisible
import scalaz.NaturalTransformation
```

scalazのpackage objectに以下のようなtype aliasが定義されていて、こちらが使われることが多いです。

```scala mdoc:silent
type ~>[F[_], G[_]] = NaturalTransformation[F, G]
```

NaturalTransformationは、Scalaz内のいくつかのクラスで使われていますが、
ある程度よく使う代表的な例としては`scalaz.Free`の`foldMap`メソッドなどがあります。

[^data]: NaturalTransformationは関数のようなものなので、"データ型"という言い方は少し違和感があるかもしれません。ただ、"型クラス"ではないため、そういう意味でここでは"データ型"と言っています
