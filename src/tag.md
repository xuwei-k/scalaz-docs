# Tag

Haskellにおけるnewtypeのようなものを実現するための仕組みです。
現在、以下のTagが存在します。

- FirstVal
- LastVal
- MinVal
- MaxVal
- First
- Last
- Min
- Max
- Multiplication
- Dual
- Zip
- Disjunction
- Conjunction
- Parallel

以下のように、Tag名とScalaz内の別のもので名前の衝突があるので注意してください
- Disjunctionはデータ型としての`\/`の別名
- 型クラスとしてのZip
