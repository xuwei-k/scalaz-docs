# Band

Semigroupのサブクラスです。Semigroupと比べて追加のメソッドはありません。

Bandは
"同じものをappendした場合に、必ず同じものになる"
というものです。

例えば
- `List(1, 2)` と `List(1, 2)` をappendすると `List(1, 2, 1, 2)` となるため、ListはSemigroupですがBandではありません
- 一方 `Set(1, 2)` と `Set(1, 2)` をappendすると `Set(1, 2)` となるため、SetはBandのインスタンスです

もちろんSet以外にも、いくつかBandになるものは存在します。

Bandというのはそれほど聞き慣れない言葉かもしれませんが、数学の用語のようです。

<https://en.wikipedia.org/wiki/Band_(mathematics)>
