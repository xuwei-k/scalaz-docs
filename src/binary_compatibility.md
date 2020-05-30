# バイナリ互換とバージョン

## バイナリ互換

Scalazは、多くのScalaのライブラリの中でも、バイナリ互換のポリシーがしっかり決まっているライブラリです。

Scalazでは、バージョン`7.0.0`以降は、同じ規則でバイナリ互換のポリシーが定められています。[^oldz]

具体的には、

- `7.x.y` の `y` の部分のみが変わった場合はバイナリ互換がある
 - 例 `7.0.0` から `7.0.2`, `7.1.3` から `7.1.5` など
- `7.x.y` の `x` の部分が変わった場合はバイナリ互換はない

[Semantic Versioning](https://semver.org/) にはしたがっていないので注意してください。

また、release candidateやmilestoneのリリースは、上記の範囲外であり、バイナリ互換は保証されません。release candidateとmilestoneのversion番号の規則は、以下のようになっています。
- release candidateの場合は後ろに`-RC` と数字がつく
 - 例 `7.2.0-RC1`
- milestoneの場合は後ろに`-M` と数字がつく
 - 例 `7.2.0-M4`


バイナリ互換は、Lightbend(旧 Typesafe)社がOSSで公開している [migration-manager](https://github.com/lightbend/migration-manager) と呼ばれるツールで自動でチェックされています。[^mima-bug]
このmigration-managerは、Scala本体のライブラリ自体のバイナリ互換のチェックにも使われているものです。


## バージョン


### 6以前

- だいぶ古いので詳細は割愛します
- すでに全くメンテはされないので、使わないでください

### 7.0.x

- バージョン `7.0.0` は、2013年4月にリリースされました。  [リリースの際のgoogle groupのスレッド](https://groups.google.com/d/topic/scalaz/_QFqVn3jOPU/discussion)
- Scala 2.9.2, 2.9.3, 2.10.x, 2.11.x, 2.12.xをサポートしています
- 執筆時点でのバージョン `7.0.x` 系統の最新は `7.0.9` です
- `7.0.x` 系統は、 `7.1.x` や `7.2.x` 系統がすでにだいぶ安定して広まっているので、今後はほぼ更新されない予定です

### 7.1.x

- バージョン `7.1.0` は、2014年8月にリリースされました
- [リリースの際のgoogle groupのスレッド](https://groups.google.com/d/msg/scalaz/79x3Frhe0Hs/tcGACPaXND8J)
- Scala 2.9.3, 2.10.x, 2.11.x, 2.12.x をサポートしています
- 執筆時点でのバージョン `7.1.x` 系統の最新は [`7.1.16`](https://github.com/scalaz/scalaz/wiki/7.1.16) (2017年12月リリース)です
- `7.1.x` 系統も、 `7.2.x` 系統がすでにだいぶ安定して広まっているので、今後はほぼ更新されない予定です

### 7.2.x

- バージョン `7.2.0` のfinalは、2015年12月5日にリリースされました
- [リリースの際のgoogle groupのスレッド](https://groups.google.com/d/topic/scalaz/BXW6BVxYEPE/discussion)
- 2020年5月現在の最新版は7.2.30です
- 7.2.0 final以降、7.2.1, 7.2.2という順番でリリースされており、それらはバイナリ互換を保持しています
- Scala 2.11.x, 2.12.x, 2.13.x をサポートしています(Scala 2.10は途中からサポートしなくなりました)
- 7.2.1以降、公式でScala.jsをサポートしています(concurrentモジュールを除く)
- 7.2.10以降、[scala-native](http://www.scala-native.org/) をサポートしています(core, effect, iterateeのみ)
- Java 8以降をサポートしています(Java 7でも動く可能性はありますが、途中からJava 8でのビルドに変わったので保証はされません)


### 7.3.x

- 7.2.0のfinalがリリースされたことにより、2015年12月頃から開発がはじまりました
- 7.3.0は2020年4月にリリースされました
- サポートするScalaのversionは2.11以降です(Scala 2.10は切り捨て)
- [Java 7のサポートを打ち切って、Java 8以上が必須です](https://github.com/scalaz/scalaz/pull/1063)

### 7.4.x

- 7.3.0のfinalがリリースされたことにより、2020年5月頃から開発がはじまりました
- Scala 2.12以前を切り捨てる予定です
- Dottyでもビルドする予定です
- それ以上の詳細はあまり決まっていません

### 8.x

- [7.3.xの次は8.xになりそうな雰囲気](https://github.com/scalaz/scalaz/issues/1480)だけありましたが、最近開発は停滞しています
- 7.xのgitの履歴をほぼ引き継がずに、ほとんど一から書き直しています
- これを書いている現在は `series/8.0.x` というbranchで開発されています https://github.com/scalaz/scalaz/tree/series/8.0.x
- 型クラス同士の関係を継承を使って表現することをやめることにより、implicitの衝突の問題を回避する予定らしいです

[^oldz]: Scalaz 6以前はこの規則にしたがっていません。migration-managerでもチェックされていません。
[^mima-bug]: migration-manager そのもののバグにより、一部7.1.x系統でバイナリ互換が崩れた、という問題はあります。 https://github.com/scalaz/scalaz/issues/1199 scalaz.syntax.ToTypeClassOps という、普通直接使わないものを継承した場合のみ発生するので、殆どの場合は問題ないでしょう。
