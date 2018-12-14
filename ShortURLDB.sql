# Host: 192.168.43.120  (Version 5.5.5-10.1.26-MariaDB-0+deb9u1)
# Date: 2018-12-14 14:18:07
# Generator: MySQL-Front 6.0  (Build 1.136)


#
# Structure for table "url"
#

DROP TABLE IF EXISTS `url`;
CREATE TABLE `url` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shortUrl` varchar(20) DEFAULT NULL,
  `longUrl` varchar(255) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `timeStamp` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4;


#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `passwd` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `timeStamp` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

