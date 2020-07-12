# \/

- [ソースコード](https://github.com/scalaz/scalaz/blob/v7.3.2/core/src/main/scala/scalaz/Either.scala)
- [scaladoc](https://static.javadoc.io/org.scalaz/scalaz_2.13/7.3.2/scalaz/$bslash$div.html)
- 記号のクラス名でとっつきにくそうですが、かなり多く使われている、とても便利なクラスです
- 読み方は`Disjunction`あるいは`Either`です
- 数学の論理和 ∨ の記号由来です
- `\/` 自体は`sealed abstract class`であり、`\/-`と`-\/`というサブクラスが存在する
- 右に`-`がくっついているのがRight、左に`-`がくっついているのがLeft


```tut
import scalaz._

val a: Int \/ String = \/-("foo")  // rightを生成
val b: \/[Int, String] = a // 型は中置記法で書かれることが多いが、中置記法を使わなくても書ける
val c: Int \/ String  = \/.right("foo") // rightというメソッドもある
val d = a.map(_ + "bar") // rightをmapすると反映される
val e: Int \/ String  = \/.left(42)
e.map(_ + "bar") // leftをmapしても変わらない
e.leftMap(_ * 100) // leftの場合にmapするには、leftMapを使う
```
