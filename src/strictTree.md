# StrictTree

その名の通り、StrictなTreeです。
以前から存在していた`scalaz.Tree`は`scala.Stream`を使用したlazyな実装のため、
後から追加されたこちらがこういう名前になりました。
7.2.x系では、version 7.2.4から追加されています。

`scalaz.Tree`と比較した場合、lazyかstrictかが違うだけで、構造は同じrose treeと呼ばれるものです。
また、メソッドに関しても大体lazyなほうと同じメソッドが実装されています。
素直に実装するとスタックオーバーフローしてしまうメソッドでも、
Trampolineを駆使してスタックが溢れない工夫がされています。
