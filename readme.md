# MiningSwitcher

####  Project Description  简介

本工具抓取并解析全网实时币价与挖矿难度，计算当前显卡实时日收益，并自动切换到对应币种以实现收益最大化，数据刷新时间可自定义，推荐大于10分钟，频繁切换会导致pool端收益降低。

目前支持币种：ETH ETC RVN CFX SERO AE BEAM MOAC  A/N卡通用

本工具需配合NBMiner使用：https://github.com/NebuTech/NBMiner

#### Quick instructions  快速使用指南

##### 1.下载最新版本的release：https://github.com/GTX-GSO/MiningSwitcher/releases

##### 2.将压缩包内的文件全部解压至NBMiner文件夹

##### 3.打开config.json，填入挖矿显卡对应币种的算力，单位为M

算力数据可参考https://www.beepool.com/income/top?gpu

##### 4.安装JRE1.8.0 版本251以上 ，并设置好系统环境变量，教程后附

##### 5.请确认已填写好nbminer内相关币种矿池与钱包地址，双击bat文件，设置刷新时间，按回车程序开始工作



#### 系统环境变量配置教程

jre-8u281-windows-x64下载地址：

https://www.oracle.com/webapps/redirect/signon?nexturl=https://download.oracle.com/otn/java/jdk/8u281-b09/89d678f2be164786b292527658ca1605/jre-8u281-windows-x64.exe

##### Windows 7,8版本

1. 计算机鼠标右键,选择`属性 ` 

2. 选择`高级系统设置` 

3. `高级` 选项卡，点击`环境变量`

4. 点击`新建` ，创建新的环境变量

5. 变量名输入`JAVA_HOME`，变量值输入JRE8的安装目录 ‪C:\Program Files\Java\jre1.8.0_281

6. 选中`Path` 环境变量，`双击`或者`点击编辑` 

7. 在变量值的最前面，键入`%JAVA_HOME%\bin;`  分号必须要写，必须是英文格式。

8. 环境变量配置完成，重新开启DOS命令行，在任意目录下输入`javac` 命令，运行成功。

##### Windows 10 版本

1. 文件资源管理器 --> 此电脑鼠标右键 --> 选择`属性 ` 

2. 选择`高级系统设置`  --> 选择  `环境变量`

3. 点击下方系统变量的 `新建` ，创建新的环境变量，变量名输入`JAVA_HOME`，变量值输入JDK9的安装目录 ‪C:\Program Files\Java\jre1.8.0_281

4. 选中`Path` 环境变量，`双击`或者`点击编辑`

5. 点击` 新建`，键入`%JAVA_HOME%\bin` ，必须是英文格式。选中该行，上移到最上方，点击确定。

6. 环境变量配置完成，重新开启DOS命令行，在任意目录下输入`javac` 命令测试
