# Kleisli

`ReaderT`という別名があります。つまり、Readerモナドトランスフォーマーです。
実態は、以下のようなcase classです。

```tut:silent
final case class Kleisli[M[_], A, B](run: A => M[B])
```


- https://hackage.haskell.org/package/mtl-2.2.1/docs/Control-Monad-Reader.html#t:ReaderT
