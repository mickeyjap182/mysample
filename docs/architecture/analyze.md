BOK software architecture
### 凝集度


### 不安定度

主系列からの距離
D = |A + I − 1|

### 循環的複雑度(Cyclomatic Complexity:CC)
- 分岐の数が多いと複雑という指標
C C = E − N + 2 で、N はノード(式の数) を、E はエッジ(可能な遷移)
// CC = 3 - 2 + 2 = 3
public void decision(int c1, int c2) {
    if (c1 < 100) // ノード1
        return 0; // エッジ1
    else if (c1 + C2 > 500) // ノード2
        return 1; // エッジ2
    else
        return -1; // エッジ3
}

コナーセンス
