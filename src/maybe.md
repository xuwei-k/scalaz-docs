# Maybe

いわゆるHaskellのMaybeと同じようなものです。
Scala標準ライブラリには、すでに[`scala.Option`](https://github.com/scala/scala/blob/v2.12.0/src/library/scala/Option.scala)というものがありますが、いくつかの理由により、Scalaz独自のものが作られました。

具体的に作られた理由、標準のOptionとの違いを挙げると
- 標準のOptionは共変(covariant)だが、ScalazのMaybeは非変(invariant)
- 標準の `implicit def option2Iterable[A](xo: Option[A]): Iterable[A]` というメソッドの存在を嫌った
- 標準のOptionには`get`や`foreach`などの、安全ではなかったり副作用前提のメソッドがあるが、ScalazのMaybeにはそういったメソッドは存在しない
