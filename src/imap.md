# ==>>

`IMap`という別名がついています。HaskellのMapを移植したものです。
`scalaz.Order`を使っていて、順序を保持するtree mapになっています。
先頭のIは、IListやISetと同様、あまり深い意味はありません。[^imap-name]

- https://hackage.haskell.org/package/containers-0.5.6.3/docs/Data-Map.html


矢印のようになっているのは、`Key ==>> Value`という形式で中置記法で型を書くためだと思われます[^infix]。
実際Scalaz内部でも基本的に`==>>`の型は中置記法で書かれています。


[^imap-name]: (あえて言うなら、invariantもしくはimmutableあたりが由来?)
[^infix]: 記号に限らず、型パラメータを2つとる型について`A[B, C]`を`B A C`と書けるのは、Scala自体の言語仕様です。たとえば`Either[String, Int]`は`String Either Int`と書けます。
