# TiPicker

> 在工作中，为了避免遗忘，使用了Typora作为工作记录，记下了工作中的各种细节内容，并且根据类型不同添加了不同的emoji作为标记，这一点也是受[gitmoji](https://gitmoji.carloscuesta.me)启发。然而，这种记录往往很长，混杂在一篇文章里如果能有个办法进行筛选，那就很方便了。于是，第一个想法诞生了：做一个基于JavaFX的桌面记录软件。然而，对于Java桌面应用开发我只是略懂皮毛，还是web上手更快，于是便有了本项目。 

以上是一种使用场景，即工作日志，可能有的emoji标签入下：

​:sparkles:  sparkles 添加新文件 
:art:  art 修改文件
:cold_sweat:  cold_sweat 有疑问，需确认（非技术上的问题）
:construction:  construction 未完成
:bug:  bug 有问题，需确认
:memo: memo（可能）还需要做的事情
:clap:  clap 学到了，知道了
:question:  question 需要研究一下 
:exclamation:  exclamation 需要注意，别忘了
:pushpin:  pushpin 标记，告知，声明，常用
​:x:  x 纯删除，没有添加新的替代

另一种使用场景是心情日志，可以使用表情类emoji+日期时间作为标签

也可以做个简单的记账，标签为收/支+日期时间等等。

核心功能在于，**MD编辑器筛选标签+标签管理**

文章本身（或者说标题）也可以加标签分类，默认至少具备创建时间的日期时间标签。

ps，由于最近对Go颇有兴趣，还在想是不是应该用Go写，然而我现在只不过刚刚了解了基本语法，用来做web开发着实勉强。想来现阶段，实战还是把Java搞好再说，Go还是先放在培养皿里面吧。

ps，此坑要在2018年之前填完！