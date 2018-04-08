# IndexedStateT

Stateモナドのトランスフォーマーです。名前の通り実際のclassは`Indexed`モナドになっていますが、最初のうちは単なる普通のStateモナドトランスフォーマーと思っておけばいいでしょう。

基本的な使い方にはあまり変更はありませんが、[7.1と7.2で内部構造が変更](https://github.com/scalaz/scalaz/commit/a07dc366363a9b3ac311b35abd)されています。
内部構造の変更とは、スタックオーバーフローしないようにするための変更です。

実際の7.2時点のIndexedStateTの定義は以下のようなものです。

```tut:invisible
import scalaz._
import scalaz.Id.Id
```

```tut:silent
sealed abstract class IndexedStateT[F[_], -S1, S2, A] {
  def getF[S <: S1]: Monad[F] => F[S => F[(S2, A)]]

  // その他のメソッド省略
}
```

その他に、関連する`StateT`や`State`は[scalazのpackage object](https://github.com/scalaz/scalaz/blob/v7.2.21/core/src/main/scala/scalaz/package.scala#L145-L148)にtype aliasとして定義されています。

```tut:silent
type StateT[F[_], S, A] = IndexedStateT[F, S, S, A]
type IndexedState[-S1, S2, A] = IndexedStateT[Id, S1, S2, A]
type State[S, A] = StateT[Id, S, A]
```

このように、モナドトランスフォーマーのaliasとしてモナドを定義するのは、Scalaz内の他のモナドトランスフォーマーでも共通することですし、Haskellにおいてもそのように定義されることが多いです。
