# \&/

Theseとも呼ばれるデータ構造です。記号名の由来は、

"数学の論理和の記号の∨をASCIIの範囲でバックスラッシュとスラッシュで表現したもの`\/`"

と`&`を合成したものです。以下のような、3通りのどれかを表現するデータ型です。


```tut:silent
sealed abstract class \&/[+A, +B] extends Product with Serializable
final case class This[A](aa: A) extends (A \&/ Nothing)
final case class That[B](bb: B) extends (Nothing \&/ B)
final case class Both[A, B](aa: A, bb: B) extends (A \&/ B)
```

日本語で言い表すと

"A、またはB、またはAとBの両方、のどれか"

ということになります。
