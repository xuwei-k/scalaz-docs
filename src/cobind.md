# Cobind

Functorの子であり、Comonadの親の型クラスです。
Haskellの標準ライブラリには直接対応するものは存在しません。
ekmett/semigroupoidsには、Extendという名前で同様のものが存在します。

<https://hackage.haskell.org/package/semigroupoids-5.0.1/docs/Data-Functor-Extend.html#t:Extend>

過去にはHaskellのComonadパッケージのComonad型クラスはExtendを継承していたようですが、
ライブラリ間の依存関係の都合上、継承をやめたようです。

- <https://github.com/ekmett/comonad/commit/532c2c324463c>
- <https://github.com/ekmett/comonad/commit/a847f527a8fe3>
