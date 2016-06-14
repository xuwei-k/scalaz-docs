# Validation

- [ソースコード](https://github.com/scalaz/scalaz/blob/v7.2.4/core/src/main/scala/scalaz/Validation.scala)
- [scaladoc](https://oss.sonatype.org/service/local/repositories/releases/archive/org/scalaz/scalaz_2.11/7.2.4/scalaz_2.11-7.2.4-javadoc.jar/!/index.html#scalaz.Validation)


`Validation`自体は、以下のようなsealed abstract classで、`Success`と`Failure`という2つのサブクラスがあります。

```tut:silent
sealed abstract class Validation[+E, +A]
final case class Success[A](a: A) extends Validation[Nothing, A]
final case class Failure[E](e: E) extends Validation[E, Nothing]
```

つまり、`scala.Either`や`scalaz.\/`と同型です。
クラス名から想像がつくように、成功と失敗を表現するのに用いられることが多いです[^success-failure]。

Validationは、`Applicative`のインスタンスですが、`Monad`のインスタンスにはなっていません。
無理やり`Monad`のインスタンスにすることは不可能ではありませんが、そうすると、その`Monad`と`Applicative`のインスタンスに整合性がなくなってしまします[^consistent-monad-applicative]。


[^success-failure]: それ以外の使い方も可能です
[^consistent-monad-applicative]: 型クラスの継承関係やlawの整合性については、別のところで詳細に説明する予定
