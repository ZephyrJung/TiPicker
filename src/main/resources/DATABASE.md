#### 项目正式名称：pentatonic
表示五音的（没找到名词...)
即宫商角徵羽五音，代表五种文章聚合类型

### 可能要用的表
taglib：存放所有标签信息
tag_id：标签主键
tag_name：标签名称
tag_logo：标签logo
description：描述信息
creator：创建者ID
create_time：创建时间

messagelib：存放所有单元信息，有这些信息组成不同的文章类型。每一段大概500字
message_id
tag_id：关联标签
content：内容正文
creator：创建者ID
update_time：最后更新时间
create_time：创建时间

votelib：存放顶踩信息
vote_id
vote_oid：顶踩（投票）对象ID
vote_type：顶踩内容类型
vote_value：顶踩或者其他

pentatoniclib：存放所有文章聚合记录--聚合记录应该放到ES
penta_id
tag_id
description
message_list
creator
update_time
create_time

commentlib：存放所有评论（评论只能针对聚合或评论，单条内容只能顶和踩，甚至不为外人所见）
comment_id
comment_oid
comment_type
content
commenter
create_time




### 文章的存储方式
五种文章类型，均可以保存messagelib的主键字符串(+序号？)，仅做内容聚合
内容的增删改查还是要落实到messagelib中
五种页面读取到主键字符串后拆分，获得当前列表