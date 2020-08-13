# GiledeRose  镶金玫瑰

## Context

这是一家魔兽世界里的小商店，出售的商品也都是高价值的。但不妙的是，随着商品逐渐接近保质期，它们的价值也不断下滑。你需要开发一个IT系统来更新库存信息。

首先，简单介绍一下我们的系统：
*   所有商品都有一个SellIn值，这是商品距离过期的天数，最好在这么多天之内卖掉
*   所有商品都有一个Quality值，代表商品的价值
*   商品的SellIn值和Quality值，它们每天会发生变化

商品的价格规则说明如下：
*   商品的价值永远不会小于0，也永远不会超过50
*   普通商品每过一天价值会下滑1点，一旦过了保质期，价值就以双倍的速度下滑
*   后台门票（Backstage pass）是一种特殊商品：
       *  越接近演出日，商品的价值反而上升
       *  在演出前10天，价值每天上升2点
       *  演出前5天，价值每天上升3点
       *  一旦过了演出日，价值就马上变成0


## Tasking

### Task1

Given: 普通商品，保质期内，价值在 0 ~ 50之间

When:  按天更新

Then:  保质期和价值均减1

### Task2

Given: 普通商品，保质期内，价值为0 

When:  按天更新

Then:  保质期减1，价值不变

### Task3

Given: 普通商品，保质期内，价值小于0 

When:  按天更新

Then:  抛出异常，message 为商品价值不得低于0

### Task4

Given: 普通商品，保质期内，价值大于50

When:  按天更新

Then:  抛出异常，message 为商品价值不得超过50

### Task5

Given: 普通商品，超过保质期，价值在 0 ~ 50之间

When:  按天更新

Then:  保质期减1，商品价值减2

### Task6

Given: 特殊商品（后台门票），在演出前10天（保质期内），价值在 0 ~ 50之间

When:  按天更新

Then:  保质期减1，商品价值加2

### Task7

Given: 特殊商品（后台门票），在演出前5天（保质期内），价值在 0 ~ 50之间

When:  按天更新

Then:  保质期减1，商品价值加3

### Task8

Given: 特殊商品（后台门票），超过保质期，价值在 0 ~ 50之间

When:  按天更新

Then:  保质期减1，商品价值变为0