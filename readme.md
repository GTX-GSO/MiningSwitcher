# MiningSwitcher

####  **Project Description**  **简介**

本工具抓取并解析全网实时币价与挖矿难度，计算当前显卡实时日收益，并自动切换到对应币种以实现收益最大化，数据刷新时间可自定义，推荐大于10分钟，频繁切换会导致pool端收益降低。

目前支持币种：ETH ETC RVN CFX SERO AE BEAM MOAC

本工具需配合NBMiner使用：https://github.com/NebuTech/NBMiner

#### **Quick instructions  快速使用指南**

**1.**下载最新版本的release：https://github.com/GTX-GSO/MiningSwitcher/releases

**2.**将压缩包内的文件全部解压至NBMiner文件夹

**3.**打开config.json，填入挖矿显卡对应币种的算力，单位为M

参考数据可在https://www.beepool.com/income/top?gpu找到

**4.**安装JRE1.8.0 版本251以上 ，并设置好系统环境变量，教程后附

**5.**请确认已填写好nbminer内相关币种矿池与钱包地址，双击bat文件，设置刷新时间，按回车程序开始工作





#### 系统环境变量配置教程

jre-8u281-windows-x64下载地址：

https://www.oracle.com/webapps/redirect/signon?nexturl=https://download.oracle.com/otn/java/jdk/8u281-b09/89d678f2be164786b292527658ca1605/jre-8u281-windows-x64.exe

##### Windows 7,8版本

1. 计算机鼠标右键,选择`属性 ` 

![环境变量3](D:/JAVA%20Basic/day01%E3%80%90%E5%89%8D%E8%A8%80%E3%80%81%E5%85%A5%E9%97%A8%E7%A8%8B%E5%BA%8F%E3%80%81%E5%B8%B8%E9%87%8F%E3%80%81%E5%8F%98%E9%87%8F%E3%80%91/01_%E7%AC%94%E8%AE%B0/img/%E7%8E%AF%E5%A2%83%E5%8F%98%E9%87%8F3.jpg)

1. 选择`高级系统设置` 

![环境变量4](D:/JAVA%20Basic/day01%E3%80%90%E5%89%8D%E8%A8%80%E3%80%81%E5%85%A5%E9%97%A8%E7%A8%8B%E5%BA%8F%E3%80%81%E5%B8%B8%E9%87%8F%E3%80%81%E5%8F%98%E9%87%8F%E3%80%91/01_%E7%AC%94%E8%AE%B0/img/%E7%8E%AF%E5%A2%83%E5%8F%98%E9%87%8F4.jpg)

1. `高级` 选项卡，点击`环境变量` 

![环境变量5](D:/JAVA%20Basic/day01%E3%80%90%E5%89%8D%E8%A8%80%E3%80%81%E5%85%A5%E9%97%A8%E7%A8%8B%E5%BA%8F%E3%80%81%E5%B8%B8%E9%87%8F%E3%80%81%E5%8F%98%E9%87%8F%E3%80%91/01_%E7%AC%94%E8%AE%B0/img/%E7%8E%AF%E5%A2%83%E5%8F%98%E9%87%8F5.jpg)

1. 点击`新建` ，创建新的环境变量

![环境变量6](D:/JAVA%20Basic/day01%E3%80%90%E5%89%8D%E8%A8%80%E3%80%81%E5%85%A5%E9%97%A8%E7%A8%8B%E5%BA%8F%E3%80%81%E5%B8%B8%E9%87%8F%E3%80%81%E5%8F%98%E9%87%8F%E3%80%91/01_%E7%AC%94%E8%AE%B0/img/%E7%8E%AF%E5%A2%83%E5%8F%98%E9%87%8F6.jpg)

1. 变量名输入`JAVA_HOME`，变量值输入JRE8的安装目录 ‪C:\Program Files\Java\jre1.8.0_281

![环境变量7](D:/JAVA%20Basic/day01%E3%80%90%E5%89%8D%E8%A8%80%E3%80%81%E5%85%A5%E9%97%A8%E7%A8%8B%E5%BA%8F%E3%80%81%E5%B8%B8%E9%87%8F%E3%80%81%E5%8F%98%E9%87%8F%E3%80%91/01_%E7%AC%94%E8%AE%B0/img/%E7%8E%AF%E5%A2%83%E5%8F%98%E9%87%8F7.jpg)

1. 选中`Path` 环境变量，`双击`或者`点击编辑` 

![环境变量8](D:/JAVA%20Basic/day01%E3%80%90%E5%89%8D%E8%A8%80%E3%80%81%E5%85%A5%E9%97%A8%E7%A8%8B%E5%BA%8F%E3%80%81%E5%B8%B8%E9%87%8F%E3%80%81%E5%8F%98%E9%87%8F%E3%80%91/01_%E7%AC%94%E8%AE%B0/img/%E7%8E%AF%E5%A2%83%E5%8F%98%E9%87%8F8.jpg)

1. 在变量值的最前面，键入`%JAVA_HOME%\bin;`  分号必须要写，必须是英文格式。

![环境变量9](D:/JAVA%20Basic/day01%E3%80%90%E5%89%8D%E8%A8%80%E3%80%81%E5%85%A5%E9%97%A8%E7%A8%8B%E5%BA%8F%E3%80%81%E5%B8%B8%E9%87%8F%E3%80%81%E5%8F%98%E9%87%8F%E3%80%91/01_%E7%AC%94%E8%AE%B0/img/%E7%8E%AF%E5%A2%83%E5%8F%98%E9%87%8F9.jpg)

1. 环境变量配置完成，重新开启DOS命令行，在任意目录下输入`javac` 命令，运行成功。

![环境变量10](D:/JAVA%20Basic/day01%E3%80%90%E5%89%8D%E8%A8%80%E3%80%81%E5%85%A5%E9%97%A8%E7%A8%8B%E5%BA%8F%E3%80%81%E5%B8%B8%E9%87%8F%E3%80%81%E5%8F%98%E9%87%8F%E3%80%91/01_%E7%AC%94%E8%AE%B0/img/%E7%8E%AF%E5%A2%83%E5%8F%98%E9%87%8F10.jpg)

##### Windows 10 版本

1. 文件资源管理器 --> 此电脑鼠标右键 --> 选择`属性 ` 

![](D:/JAVA%20Basic/day01%E3%80%90%E5%89%8D%E8%A8%80%E3%80%81%E5%85%A5%E9%97%A8%E7%A8%8B%E5%BA%8F%E3%80%81%E5%B8%B8%E9%87%8F%E3%80%81%E5%8F%98%E9%87%8F%E3%80%91/01_%E7%AC%94%E8%AE%B0/img/win10-01.JPG)

1. 选择`高级系统设置`  --> 选择  `环境变量`

![](D:/JAVA%20Basic/day01%E3%80%90%E5%89%8D%E8%A8%80%E3%80%81%E5%85%A5%E9%97%A8%E7%A8%8B%E5%BA%8F%E3%80%81%E5%B8%B8%E9%87%8F%E3%80%81%E5%8F%98%E9%87%8F%E3%80%91/01_%E7%AC%94%E8%AE%B0/img/win10-02.JPG)

1. 点击下方系统变量的 `新建` ，创建新的环境变量，变量名输入`JAVA_HOME`，变量值输入JDK9的安装目录 ‪C:\Program Files\Java\jre1.8.0_281

![](D:/JAVA%20Basic/day01%E3%80%90%E5%89%8D%E8%A8%80%E3%80%81%E5%85%A5%E9%97%A8%E7%A8%8B%E5%BA%8F%E3%80%81%E5%B8%B8%E9%87%8F%E3%80%81%E5%8F%98%E9%87%8F%E3%80%91/01_%E7%AC%94%E8%AE%B0/img/win10-03.JPG)

1. 选中`Path` 环境变量，`双击`或者`点击编辑`

![](D:/JAVA%20Basic/day01%E3%80%90%E5%89%8D%E8%A8%80%E3%80%81%E5%85%A5%E9%97%A8%E7%A8%8B%E5%BA%8F%E3%80%81%E5%B8%B8%E9%87%8F%E3%80%81%E5%8F%98%E9%87%8F%E3%80%91/01_%E7%AC%94%E8%AE%B0/img/win10-04.JPG)

1. 点击` 新建`，键入`%JAVA_HOME%\bin` ，必须是英文格式。选中该行，上移到最上方，点击确定。

![](D:/JAVA%20Basic/day01%E3%80%90%E5%89%8D%E8%A8%80%E3%80%81%E5%85%A5%E9%97%A8%E7%A8%8B%E5%BA%8F%E3%80%81%E5%B8%B8%E9%87%8F%E3%80%81%E5%8F%98%E9%87%8F%E3%80%91/01_%E7%AC%94%E8%AE%B0/img/win10-05.JPG)

1. 环境变量配置完成，重新开启DOS命令行，在任意目录下输入`javac` 命令。

![环境变量10](D:/JAVA%20Basic/day01%E3%80%90%E5%89%8D%E8%A8%80%E3%80%81%E5%85%A5%E9%97%A8%E7%A8%8B%E5%BA%8F%E3%80%81%E5%B8%B8%E9%87%8F%E3%80%81%E5%8F%98%E9%87%8F%E3%80%91/01_%E7%AC%94%E8%AE%B0/img/%E7%8E%AF%E5%A2%83%E5%8F%98%E9%87%8F10.jpg)



