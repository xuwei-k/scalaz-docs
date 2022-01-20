# FreeT

Freeモナドのモナドトランスフォーマーです。
現在、バージョン7.2以降のみであり、7.1系にはありません。

Haskellでは数年前から存在していましたが、Scalaで実装されたのは最近(2015年)です。
スタックオーバーフローしないFreeTの実装は不可能かと思われていましたが、
まずpurescriptという言語で実現され、それがScalazに移植されました。

[Stack Safety for Free](https://functorial.com/stack-safety-for-free/index.pdf)

Haskellにおいては[ekmett/freeに対応するものが存在](https://github.com/ekmett/free/blob/v4.12.1/src/Control/Monad/Trans/Free.hs)しています[^freeT-church]。


[^freeT-church]: 例によってChurch Encodeされたものと、2種類存在します https://github.com/ekmett/free/blob/v4.12.1/src/Control/Monad/Trans/Free/Church.hs
