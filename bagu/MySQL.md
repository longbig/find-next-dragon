# MySQL基础

### 1.[整数类型的 UNSIGNED 属性有什么用？](#整数类型的-unsigned-属性有什么用)

MySQL 中的整数类型可以使用可选的 UNSIGNED 属性来表示不允许负值的无符号整数。使用 UNSIGNED 属性可以将正整数的上限提高一倍，因为它不需要存储负数值。

例如， TINYINT UNSIGNED 类型的取值范围是 0 ~ 255，而普通的 TINYINT 类型的值范围是 -128 ~ 127。INT UNSIGNED 类型的取值范围是 0 ~ 4,294,967,295，而普通的 INT 类型的值范围是 -2,147,483,648 ~ 2,147,483,647。

### [CHAR 和 VARCHAR 的区别是什么？](#char-和-varchar-的区别是什么)

**CHAR 是定长字符串，VARCHAR 是变长字符串。**

CHAR 在存储时会在右边填充空格以达到指定的长度，检索时会去掉空格；VARCHAR 在存储时需要使用 1 或 2 个额外字节记录字符串的长度，检索时不需要处理。

### [VARCHAR(100)和 VARCHAR(10)的区别是什么？](https://javaguide.cn/database/mysql/mysql-questions-01.html#varchar-100-和-varchar-10-的区别是什么)

表示能存储最多 100 个字符和 10 个字符，超出的部分会被截断

### [DECIMAL 和 FLOAT/DOUBLE 的区别是什么？](https://javaguide.cn/database/mysql/mysql-questions-01.html#decimal-和-float-double-的区别是什么)

**DECIMAL 是定点数，FLOAT/DOUBLE 是浮点数。DECIMAL 可以存储精确的小数值，FLOAT/DOUBLE 只能存储近似的小数值。**

### [DATETIME 和 TIMESTAMP 的区别是什么？](https://javaguide.cn/database/mysql/mysql-questions-01.html#datetime-和-timestamp-的区别是什么)

DATETIME 类型没有时区信息，TIMESTAMP 和时区有关。

TIMESTAMP 只需要使用 4 个字节的存储空间，但是 DATETIME 需要耗费 8 个字节的存储空间。但是，这样同样造成了一个问题，Timestamp 表示的时间范围更小。

- DATETIME：1000-01-01 00:00:00 ~ 9999-12-31 23:59:59
- Timestamp：1970-01-01 00:00:01 ~ 2037-12-31 23:59:59

### [NULL 和 '' 的区别是什么？](https://javaguide.cn/database/mysql/mysql-questions-01.html#null-和-的区别是什么)

`NULL` 跟 `''`(空字符串)是两个完全不一样的值，区别如下：

- `NULL` 代表一个不确定的值,就算是两个 `NULL`,它俩也不一定相等。例如，`SELECT NULL=NULL`的结果为 false，但是在我们使用`DISTINCT`,`GROUP BY`,`ORDER BY`时,`NULL`又被认为是相等的。
- **`''`的长度是 0，是不占用空间的，而`NULL` 是需要占用空间的。**
- `NULL` 会影响聚合函数的结果。例如，`SUM`、`AVG`、`MIN`、`MAX` 等聚合函数会忽略 `NULL` 值。 `COUNT` 的处理方式取决于参数的类型。如果参数是 `*`(`COUNT(*)`)，则会统计所有的记录数，包括 `NULL` 值；如果参数是某个字段名(`COUNT(列名)`)，则会忽略 `NULL` 值，只统计非空值的个数。
- 查询 `NULL` 值时，必须使用 `IS NULL` 或 `IS NOT NULLl` 来判断，而不能使用 =、!=、 <、> 之类的比较运算符。而`''`是可以使用这些比较运算符的

**为什么 MySQL 不建议使用 `NULL` 作为列默认值？**看上面

### [Boolean 类型如何表示？](https://javaguide.cn/database/mysql/mysql-questions-01.html#boolean-类型如何表示)

MySQL 中没有专门的布尔类型，而是用 **TINYINT(1) 类型来表示布尔值**。TINYINT(1) 类型可以存储 0 或 1，分别对应 false 或 true

### 一条SQL语句是如何执行的？

MySQL架构图：

![](.\img\MySQL基础架构图.png)

从上图可以看出， MySQL 主要由下面几部分构成：

- **连接器：** 身份认证和权限相关(登录 MySQL 的时候)。
- **查询缓存：** 执行查询语句的时候，会先查询缓存（MySQL 8.0 版本后移除，因为这个功能不太实用）（执行过的语句才会命中）
- **分析器：** 没有命中缓存的话，SQL 语句就会经过分析器，分析器说白了就是要先看你的 SQL 语句要干嘛（词法分析识别表、列，语法分析SQL语句是否正确），再检查你的 SQL 语句语法是否正确。
- **优化器：** 按照 MySQL 认为最优的方案去执行（决定使用哪个索引，表连接顺序）。
- **执行器：** 执行语句，然后从存储引擎返回数据。 执行语句之前会先判断是否有权限，如果没有权限的话，就会报错。
- **插件式存储引擎**：主要负责数据的存储和读取，采用的是插件式架构，支持 InnoDB、MyISAM、Memory 等多种存储引擎。

### [MyISAM 和 InnoDB 有什么区别？](https://javaguide.cn/database/mysql/mysql-questions-01.html#myisam-和-innodb-有什么区别)

**1、是否支持行级锁**

MyISAM 只有表级锁(table-level locking)，而 InnoDB 支持行级锁(row-level locking)和表级锁,默认为行级锁。

**2、是否支持事务**

MyISAM 不提供事务支持。

InnoDB 提供事务支持，实现了 SQL 标准定义了四个隔离级别，具有提交(commit)和回滚(rollback)事务的能力。并且，InnoDB 默认使用的 REPEATABLE-READ（可重读）隔离级别是可以解决幻读问题发生的（基于 MVCC 和 Next-Key Lock）

**3、索引实现不一样。**

InnoDB是B+树索引结构，所有数据都存储在B+树中。

MyISAM是B+树结构，索引和数据是分离的





















