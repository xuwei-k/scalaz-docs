# BindRec

`scalaz.Bind`を継承した型クラスです。`scalaz.Free`や`scalaz.FreeT`で使います。

移植元のpurescriptにおいては、BindRecではなくMonadRecでした。
つまり、BindではなくMonadを継承しています。

https://github.com/purescript/purescript-tailrec/blob/v0.3.1/src/Control/Monad/Rec/Class.purs

```haskell
class (Monad m) <= MonadRec m where
  tailRecM :: forall a b. (a -> m (Either a b)) -> a -> m b
```

Freeの場合は、`runM`や`foldMap`メソッドはstack safeではありませんが、BindRecを使った`runRecM`や`foldMapRec`はstack safeになります。
