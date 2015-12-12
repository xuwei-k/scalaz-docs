# Cord

FingerTreeを使った、以下のようなデータ型です。

```tut:invisible
import scalaz._
```

```tut:silent
final case class Cord(self: FingerTree[Int, String])
```

`scalaz.Show`などで使われていますが、どのくらい効率的なのかは微妙な部分もあります[^performance]。
[Rope](https://en.wikipedia.org/wiki/Rope_(data_structure)と呼ばれるデータ構造に近く、実際7.1.xまでは[RopeがScalaz内に存在](https://github.com/scalaz/scalaz/blob/series/7.1.x/core/src/main/scala/scalaz/Rope.scala)していました。


[^performance]: Stringを普通に連結するより遅い場合がありえる？そもそもScalazのFingerTree自体が、あまりパフォーマンス計測がされていない？
