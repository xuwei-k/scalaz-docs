# Free

Freeモナドです。バージョン7.1以前と7.2以降で、ある程度構造が異なっています。
7.2以降は、いわゆる

**Operational Monad**

と呼ばれる形式になっており、大抵のメソッドで`Functor`の制約が必要なくなっています。

Haskellと異なり、Haskellのものを単純に真似て実装するとstack overflowしてしまうので、一工夫されています。
それについての詳細は、[@runarorama](https://github.com/runarorama)さんが書いた

[Stackless Scala With Free Monads](http://blog.higher-order.com/assets/trampolines.pdf)

を読むといいでしょう。

[@runarorama](https://github.com/runarorama)さんは、[FP in Scala](https://www.manning.com/books/functional-programming-in-scala)の著者であり、Scalazの主要コミッターの一人です。
