# Foldable1

Foldableを継承した型クラスです。Traverse1も含めて、基本的には[ekmett/semigroupoids](https://hackage.haskell.org/package/semigroupoids-5.0.1/docs/Data-Semigroup-Foldable-Class.html#t:Foldable1)にあるものと同じです。

一言で表すと、
「要素が1つ以上あることが必ず保証されているもの」
が、Foldable1のインスタンスになります。具体的には、以下のものがFoldable1のインスタンスです

- NonEmptyList
- Tree
- TreeLoc

他にも、`OneAnd`, `Cofree`, `Coproduct`, `Free` などは、特定の条件を満たす場合にFoldable1になります。
