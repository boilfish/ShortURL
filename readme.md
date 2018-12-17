SpringMVC-MyBatis-ShortURL
==============================
一个基于SpringMVC + Mybatis的短链接转换网站

Frameworks and Tools
---------------------------
* Java&IDE: JDK8 IntelliJ IDEA
* Backend:  Spring 4.3.13 MyBatis 3.4.5 (Configured by XML)
* Database: MySQL
* Web Server: Tomcat 8
* Web: jQuery Layui HTML + JavaScript

功能
-------------
* 创建随机短码短链接
* 创建用户自定义短码短链接
* 用户登录/登出/注册
* 用户短链接管理

其他
---------------
* DB：url表存储urlId，短码，长链接，归属用户id，创建时间。user表中存储userId，用户基本信息。其中url表未登录用户归属用户id为0。
* 短码生成：使用随机算法生成六位随机小写字母+数字，添加一个自增urlId写入数据库，如果短码有碰撞则重新计算。
* 用户登陆状态：session储存用户名，用户ID。
* 数据交互：前台使用AJAX请求与接收数据，后台返回json。
* 鉴权：对查询用户url页面，查询用户所有url接口和删除接口设置拦截器进行验证，无权限操作跳转登陆界面。

About
-----------------------------------
* GitHub：https://github.com/boilfish/ShortURL
* Demo：http://url302.pw