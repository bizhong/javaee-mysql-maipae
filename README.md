# 建筑工程多主体交互平台（MAIPAE）

在校实习期间，使用 JSP、MySQL 数据库、MVC 框架和 MDL（Material Design Lite
）组件开发实现的建筑工程多主体交互平台（MAIPAE）。

## 目录

- [项目描述](#项目描述)
- [项目模块](#项目模块)
- [我的任务](#我的任务)
- [页面展示](#页面展示)

## 项目描述

建筑工程多主体交互平台主要通过对建筑工程各责任主体进行质量监督。主要包括工程报监督、工程监督、竣工备案。

## 项目模块

### 1 工程报监督

- 注册单位（各责任主体）
- 审核单位资料（系统管理员）
- 注册本单位人员（各责任主体）
- 注册建设项目（建设项目负责人）
- 完善项目信息（建设项目负责人）
- 报监审查（报监审核员）
- 分配监督组（站领导）

### 2 工程监督

#### 2.1 监督方案

- 制定监督方案（监督员、监督组长）
- 审核监督方案（监督组长）
- 发布监督方案（监督组长）

#### 2.2 日常监督

- 预约监督（建设项目负责人、施工项目负责人）
- 审核预约（监督员）
- 发布监督通知（监督员）
- 填写监督记录（监督员）

#### 2.3 整改

- 整改通知（监督员）
- 整改并通知验收（施工项目负责人）
- 整改验收（监督员）

#### 2.4 监督报告

- 填写监督报告（监督员）
- 审核监督报告（监督组长、站领导）

### 3 竣工备案

- 申请竣工资料预验收（建设项目负责人）
- 审核竣工资料（监督员）
- 填写竣工验收监督记录（监督员）
- 结束监督（监督员）

## 我的任务

在校实习期间（2016/7/15 - 2016/7/30），我（组长）的主要任务大体如下：

### 1 策划阶段

- 撰写《项目开发计划》
- 填写《项目进度计划》

### 2 需求阶段

- 撰写《软件需求规范》中的“工程报监督”
- 撰写《软件实现归约》中的“工程报监督”
- 整合《软件需求规范》
- 整合《软件实现归约》

### 3 编码测试阶段

- [编写“工程报监督“的《界面原型》][1]
- [编写”工程报监督”的《项目代码》][2] 

### 4 整个过程

- 开《周例会》
- 填写《项目工作日志》

## 页面展示

- 首页

![首页][3]

- 注册单位（各责任主体）

![注册单位][4]

- 用户登录（各责任主体、系统管理员、建设项目负责人、报监审核员、站领导、监督员、监督组长、施工项目负责人）

![用户登录][5]

- 系统管理员首页/待审核的单位注册列表（系统管理员）

![系统管理员首页/待审核的单位注册列表][6]

- 审核单位资料（系统管理员）

![审核单位资料][7]

- 用户管理（系统管理员）

![用户管理][8]

- 各责任主体首页/注册本单位人员（各责任主体）

![各责任主体首页/注册本单位人员][9]

- 注册建设项目（建设项目负责人）

建设项目负责人首页/查询建设项目工程（建设项目负责人）

![建设项目负责人首页/查询建设项目工程][10]

查询建设项目工程结果（建设项目负责人）

![查询建设项目工程结果][11]

修改建设项目工程（建设项目负责人）

![修改建设项目工程][12]

新增建设项目工程（建设项目负责人）

![新增建设项目工程][13]

- 报监审核员首页/建设项目工程列表（报监审核员）

![报监审核员首页/建设项目工程列表][14]

- 审核建设项目工程（报监审核员）

![审核建设项目工程][15]

- 站领导首页/分配（或修改）监督组列表（站领导）

![站领导首页/分配（或修改）监督组列表][16]

- 分配监督组（站领导）

![分配监督组][17]

  [1]: https://github.com/bizhong/javaee-mysql-maipae/tree/master/MAIPAE_%E7%95%8C%E9%9D%A2%E5%8E%9F%E5%9E%8B
  [2]: https://github.com/bizhong/javaee-mysql-maipae/tree/master/MAIPAE_%E9%A1%B9%E7%9B%AE%E4%BB%A3%E7%A0%81
  [3]: https://github.com/bizhong/javaee-mysql-maipae/blob/master/MAIPAE_images/index.png
  [4]: https://github.com/bizhong/javaee-mysql-maipae/blob/master/MAIPAE_images/enterprise-sign-up.png
  [5]: https://github.com/bizhong/javaee-mysql-maipae/blob/master/MAIPAE_images/sign-in.png
  [6]: https://github.com/bizhong/javaee-mysql-maipae/blob/master/MAIPAE_images/admin-index.png
  [7]: https://github.com/bizhong/javaee-mysql-maipae/blob/master/MAIPAE_images/admin-review-enterprise.png
  [8]: https://github.com/bizhong/javaee-mysql-maipae/blob/master/MAIPAE_images/admin-person-manage.png
  [9]: https://github.com/bizhong/javaee-mysql-maipae/blob/master/MAIPAE_images/enterprise-index.png
  [10]: https://github.com/bizhong/javaee-mysql-maipae/blob/master/MAIPAE_images/projectleader-index.png
  [11]: https://github.com/bizhong/javaee-mysql-maipae/blob/master/MAIPAE_images/projectleader-search-results.png
  [12]: https://github.com/bizhong/javaee-mysql-maipae/blob/master/MAIPAE_images/projectleader-modify-project.png
  [13]: https://github.com/bizhong/javaee-mysql-maipae/blob/master/MAIPAE_images/projectleader-new-project.png
  [14]: https://github.com/bizhong/javaee-mysql-maipae/blob/master/MAIPAE_images/auditor-index.png
  [15]: https://github.com/bizhong/javaee-mysql-maipae/blob/master/MAIPAE_images/auditor-audit-project.png
  [16]: https://github.com/bizhong/javaee-mysql-maipae/blob/master/MAIPAE_images/stationleader-index.png
  [17]: https://github.com/bizhong/javaee-mysql-maipae/blob/master/MAIPAE_images/stationleader-add-projectsupervisiongroup.png
