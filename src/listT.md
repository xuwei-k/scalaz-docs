# ListT

**間違った**モナドトランスフォーマーです。
可換(commutative)なモナド以外と組み合わせた場合は、モナド則を満たしません。
可換なモナド以外と組み合わせたい場合は、`StreamT`を使用してください。

- [Scalaz Issue 921. ListT violate the associative law](https://github.com/scalaz/scalaz/issues/921)
- https://wiki.haskell.org/ListT_done_right
- https://togetter.com/li/800229
