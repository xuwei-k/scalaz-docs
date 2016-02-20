# PlusEmpty

`scalaz.Plus`を継承している型クラスです。また、サブクラスとして`ApplicativePlus`があります。
[ekmett/semigroupoidsにおけるPlus](http://hackage.haskell.org/package/semigroupoids-5.0.1/docs/Data-Functor-Plus.html)のようなものです。
ただし`scalaz.Plus`のページでも説明しましたが、ScalazのほうはFunctorを継承していない点が異なります。

また
- 「semigroupoidsにおけるPlus」が`scalaz.PlusEmpty`
- 「semigroupoidsにおけるAlt」が`scalaz.Plus`

ということは`scalaz.Plus`と「semigroupoidsの`Plus`」は異なるものなので注意してください。
