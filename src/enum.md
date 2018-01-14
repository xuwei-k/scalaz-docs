# Enum

[HaskellにおけるEnum](https://hackage.haskell.org/package/base-4.8.1.0/docs/Prelude.html#t:Enum)とある程度近いですが、Scalazのものは、いくつの点でHaskellのものとは異なっています。

- ScalazのEnumはOrderを継承しているが、HaskellのEnumに親のクラスはない
- ScalazのEnumには[HaskellのBounded](https://hackage.haskell.org/package/base-4.8.1.0/docs/Prelude.html#t:Bounded)のようなメソッドもあるが、HaskellにおいてEnumとBoundedは継承関係のない別のクラス
