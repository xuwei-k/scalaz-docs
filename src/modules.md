# モジュール構成

初心者や、core以外に興味が無い大半のユーザーは、このページは読み飛ばしてもらって構いません

```tut:invisible
import sbt._, Keys._
```

## scalaz-core

```tut:silent
libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.2.28"
```

- 一番多く利用されるモジュールです 
- Scala標準ライブラリ以外の依存はゼロです
- 逆に、Scalazの他のモジュールはすべてcoreに依存します
- もう少し正確には
 - `7.1.x` においては、標準のxmlとparserには依存しています
 - `7.2.x` では、xmlやparserにも依存しません
- 様々なデータ型や型クラスが含まれています

## scalaz-effect

```tut:silent
libraryDependencies += "org.scalaz" %% "scalaz-effect" % "7.2.28"
```

- `scalaz-core` に依存します
- IOモナド、STモナドなどがあります


## scalaz-concurrent

```tut:silent
libraryDependencies += "org.scalaz" %% "scalaz-concurrent" % "7.2.28"
```

- `scalaz-effect` に依存します
- Task, Future, Actorなどがあります

## scalaz-iteratee

```tut:silent
libraryDependencies += "org.scalaz" %% "scalaz-iteratee" % "7.2.28"
```

- `scalaz-effect` に依存します
- IterateeそのものがScala界隈でもHaskell界隈でもオワコンらしく、新機能追加も全然されていないので、使わないほうがいいです

## scalaz-scalacheck-binding

```tut:silent
libraryDependencies += "org.scalaz" %% "scalaz-scalacheck-binding" % "7.2.28-scalacheck-1.14"
```

- iteratee, concurrent に依存します
- 主に [scalacheck](https://github.com/typelevel/scalacheck) によるテストをする場合に使います
- scalacheckのversion毎にクロスビルドされています
