# ApplicativePlus

[HaskellでのAlternative](https://hackage.haskell.org/package/base-4.8.1.0/docs/Control-Applicative.html#t:Alternative)に相当する型クラスです。Scalaz内にも[Alternativeのaliasが定義](https://github.com/scalaz/scalaz/blob/v7.2.14/core/src/main/scala/scalaz/package.scala#L200)されています。[^why-not-alternative]
その名の通り、ApplicativeとPlusを継承しています。

Haskellと同じように`some`と`many`というメソッドが定義されていますが、現状では問題があり、以下のissueで議論がされています。

<https://github.com/scalaz/scalaz/issues/1097>

[^why-not-alternative]: Traverseの場合は、標準ライブラリとの名前衝突という問題でHaskellと異なる名前にしたのは妥当だと思いますが、なぜAlternativeをApplicativePlusと違う名前にしたのかは不明です
