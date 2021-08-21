# StreamT

`Stream`のモナドトランスフォーマー、といって間違いではないのですが、
このクラスの使い方などの説明に入る前に、多少前提の説明が必要です。

まず、Scala標準のStreamが実装に使われているわけではありません。
`ListT`のページにも書きましたが単純に以下のようなクラス

```scala mdoc:silent
case class StreamT[F[_], A](run: F[Stream[A]])
```

にすると、すべての場合でモナド則を満たさないので、
Scala標準のStreamを使って上記のような実装にするわけにはいきません。
また、現状の`scalaz.ListT`は間違っているので、**正しいListモナドトランスフォーマー**が必要な場合は、Scalazの範囲内では`StreamT`がある意味唯一の選択肢であるとも言えます。[^listT-freeT]
StreamTはListTと同じ間違いはしていません。


言い換えると

**StreamTは単なるListTの遅延評価版ではなく、構造が全く異なる別のもの**

ということです。


さて、前置きはこれくらいにして、実際に`StreamT`そのものの説明に入っていきます。


[^listT-freeT]: ただし、FreeTを使ってListTを作成できるかもしれない？という話はあります https://gist.github.com/paf31/eac16f0795165a285820
