# NonEmptyList

- [ソースコード](https://github.com/scalaz/scalaz/blob/v7.2.23/core/src/main/scala/scalaz/NonEmptyList.scala)
- [scaladoc](https://static.javadoc.io/org.scalaz/scalaz_2.12/7.2.23/scalaz/NonEmptyList.html)
- 名前の通り、**Non Empty**なListです。要素が1つ以上なことが必ず保証されています
- 内部実装は、以下のものが使われています
 - `7.1.x` まではScala標準ライブラリのList
 - `7.2.x` 以降は、Scalaz独自のIList(性能特性は標準のListと同じ)
- また、7.1と7.2で以下のような違いもあります。この違いにより、7.1から7.2に上げた際に、型推論の都合上書き方を変える必要がある場合があります
 - `7.1.x` までは共変(covariant)
 - `7.2.x` 以降は非変(invariant)
- 上記のような内部実装になっているので、性能特性もListと同じです。つまり
 - 先頭の要素へのアクセスは定数時間
 - 末尾の要素へのアクセス、末尾への追加、sizeの取得などは、長さに比例した時間がかかる
- いくつかのメソッドの使用例を書いておきます

```tut
import scalaz._

val a = NonEmptyList(1, 2, 3) // applyメソッドによる生成

val b = 100 <:: a // 先頭へ一つ追加

a.head // 先頭を取り出し

a.size // サイズ取得

a.reverse // 反転

a.map(_ + 1) // 要素をmap

a.flatMap(x => NonEmptyList(x, x + 10)) // Monadであり、flatMapメソッドがある
```
