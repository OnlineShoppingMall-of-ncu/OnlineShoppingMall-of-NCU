create database shopmall;
use shopmall;
CREATE TABLE `users` (
`username` varchar(15) NOT NULL,
`password` varchar(15) NULL,
`role` int(6) NULL,
`sex` char(6) NULL,
`address` varchar(20) NULL,
`phone` varchar(20) NULL,
`name` varchar(30) NULL,
`idcard` varchar(30) NULL,
PRIMARY KEY (`username`) 
);
CREATE TABLE `shoppingcar` (
`username` varchar(15) NULL,
`commodityid` int(15) NULL
);
CREATE TABLE `commodity` (
`commodityid` int(15) NOT NULL,
`decription` varchar(200) NULL,
`category` varchar(15) NULL,
`price` float(10,0) NULL,
`shopid` int(15) NOT NULL,
PRIMARY KEY (`commodityid`) 
);
CREATE TABLE `Evaluation` (
`evaluationid` int(15) NOT NULL,
`username` varchar(15) NULL,
`commodity` int(15) NULL,
`content` varchar(200) NULL,
PRIMARY KEY (`evaluationid`) 
);
CREATE TABLE `shop` (
`shopid` int(15) NOT NULL,
`username` varchar(15) NULL,
`commodityid` int(15) NULL
);
