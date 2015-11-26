# NonEmptyList

- [ソースコード](https://github.com/scalaz/scalaz/blob/v7.1.5/core/src/main/scala/scalaz/NonEmptyList.scala)
- [scaladoc](https://oss.sonatype.org/service/local/repositories/releases/archive/org/scalaz/scalaz_2.11/7.1.5/scalaz_2.11-7.1.5-javadoc.jar/!/index.html#scalaz.NonEmptyList)
- 名前の通り、**Non Empty**なListです。要素が1つ以上なことが必ず保証されています
- 内部実装は、以下のものが使われています
 - `7.1.x` まではScala標準ライブラリのList
 - `7.2.x` 以降は、Scalaz独自のIList(性能特性は標準のListと同じ)
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
