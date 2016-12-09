# セットアップ

```tut:invisible
import sbt._, Keys._
```

Scalazにはいくつかのモジュールがありますが、`"scalaz-core"` が一番大きくよく利用されることが多いです。
モジュールの詳細については、別のページで説明します。
ひとまず `"scalaz-core"` のみを使う場合は、`build.sbt` に以下のように記述してください。

```tut:silent
libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.2.8"
```

必要に応じて、以下のように `scalaVersion` など他のkeyの設定をしてください。

```tut:silent
scalaVersion := "2.12.0"
```
