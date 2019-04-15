-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Хост: localhost
-- Время создания: Апр 15 2019 г., 20:55
-- Версия сервера: 5.7.24-0ubuntu0.18.04.1
-- Версия PHP: 7.2.10-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `testdb`
--

-- --------------------------------------------------------

--
-- Структура таблицы `achievement`
--

CREATE TABLE `achievement` (
                             `Id` bigint(20) NOT NULL,
                             `IsDeleted` tinyint(4) DEFAULT NULL,
                             `Name` varchar(50) NOT NULL,
                             `Type` bigint(20) DEFAULT NULL,
                             `User` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `achievmenttype`
--

CREATE TABLE `achievmenttype` (
                                `Id` bigint(20) NOT NULL,
                                `IsDeleted` tinyint(4) DEFAULT NULL,
                                `Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `achievmenttype`
--

INSERT INTO `achievmenttype` (`Id`, `IsDeleted`, `Name`) VALUES
(1, NULL, '1-я помощь'),
(2, NULL, 'Электрик 1-го уровня');

-- --------------------------------------------------------

--
-- Структура таблицы `auto`
--

CREATE TABLE `auto` (
                      `Id` bigint(20) NOT NULL,
                      `HaveCable` tinyint(4) DEFAULT NULL,
                      `IsDeleted` tinyint(4) DEFAULT NULL,
                      `Name` varchar(50) NOT NULL,
                      `TransmissionType` bigint(20) DEFAULT NULL,
                      `User` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `auto`
--

INSERT INTO `auto` (`Id`, `HaveCable`, `IsDeleted`, `Name`, `TransmissionType`, `User`) VALUES
(1, 1, 0, 'BMW 325', 3, 2),
(2, 1, 0, 'BMW 325', 1, 4),
(3, 1, 0, 'BMW 325', 1, 3);

-- --------------------------------------------------------

--
-- Структура таблицы `files`
--

CREATE TABLE `files` (
                       `Id` bigint(20) NOT NULL,
                       `CompactPhotoPath` varchar(200) DEFAULT NULL,
                       `CreationDate` datetime(6) DEFAULT NULL,
                       `CreationUser` bigint(20) DEFAULT NULL,
                       `Description` varchar(100) DEFAULT NULL,
                       `fileName` varchar(200) DEFAULT NULL,
                       `fileType` varchar(200) DEFAULT NULL,
                       `FullPhotoPath` varchar(200) DEFAULT NULL,
                       `IsDeleted` tinyint(4) DEFAULT NULL,
                       `ModifyDate` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `files`
--

INSERT INTO `files` (`Id`, `CompactPhotoPath`, `CreationDate`, `CreationUser`, `Description`, `fileName`, `fileType`, `FullPhotoPath`, `IsDeleted`, `ModifyDate`) VALUES
(1, NULL, '2019-01-26 21:44:03.164000', 2, 'description', 'fileName', 'image', '/opt/tomcat/files/message_photo/-3422289281548528243196fileName', 0, '2019-01-26 21:44:03.164000'),
(2, NULL, '2019-01-28 20:31:28.572000', 2, '', 'txtfile.txt', '', NULL, 0, '2019-01-28 20:31:28.572000'),
(3, NULL, '2019-01-28 20:31:51.212000', 2, '', 'txtfile.txt', '', NULL, 0, '2019-01-28 20:31:51.212000'),
(4, NULL, '2019-01-28 20:36:14.674000', 2, '', 'txtfile.txt', '', NULL, 0, '2019-01-28 20:36:14.674000'),
(5, NULL, '2019-01-28 20:36:34.796000', 2, 'descr', 'txtfile', '456456', NULL, 0, '2019-01-28 20:36:34.796000'),
(6, NULL, '2019-01-28 20:38:10.153000', 2, 'descr', 'txtfile', '456456', NULL, 0, '2019-01-28 20:38:10.153000'),
(7, NULL, '2019-01-28 20:38:54.688000', 2, 'descr', 'txtfile', '456456', NULL, 0, '2019-01-28 20:38:54.688000'),
(8, NULL, '2019-01-28 20:43:58.123000', 2, 'descr', 'txtfile', '456456', NULL, 0, '2019-01-28 20:43:58.123000'),
(9, NULL, '2019-01-28 20:44:00.088000', 2, 'descr', 'txtfile', '456456', NULL, 0, '2019-01-28 20:44:00.088000'),
(10, NULL, '2019-01-28 20:47:45.417000', 2, 'descr', 'txtfile', '456456', NULL, 0, '2019-01-28 20:47:45.417000'),
(11, NULL, '2019-01-28 20:49:20.910000', 2, 'descr', 'txtfile', '456456', NULL, 0, '2019-01-28 20:49:20.910000'),
(12, NULL, '2019-01-28 20:52:03.406000', 2, 'descr', 'txtfile', '456456', NULL, 0, '2019-01-28 20:52:03.406000'),
(13, NULL, '2019-01-28 20:52:08.246000', 2, 'descr', 'txtfile', '456456', NULL, 0, '2019-01-28 20:52:08.246000'),
(14, NULL, '2019-01-28 20:56:16.678000', 2, 'descr', 'txtfile', '456456', NULL, 0, '2019-01-28 20:56:16.678000'),
(15, NULL, '2019-01-28 20:56:17.901000', 2, 'descr', 'txtfile', '456456', NULL, 0, '2019-01-28 20:56:17.901000'),
(16, NULL, '2019-01-28 21:02:36.109000', 2, 'descr', 'txtfile', '456456', NULL, 0, '2019-01-28 21:02:36.109000'),
(17, NULL, '2019-01-28 21:02:36.105000', 2, 'descr', 'txtfile', '456456', NULL, 0, '2019-01-28 21:02:36.105000'),
(18, NULL, '2019-01-28 21:06:10.591000', 2, 'descr', 'txtfile', '456456', NULL, 0, '2019-01-28 21:06:10.591000'),
(19, NULL, '2019-01-28 21:06:39.942000', 2, 'descr', 'txtfile', '456456', NULL, 0, '2019-01-28 21:06:39.942000'),
(20, NULL, '2019-01-28 21:17:29.043000', 2, 'descr', 'txtfile', '456456', NULL, 0, '2019-01-28 21:17:29.043000'),
(21, NULL, '2019-01-28 21:17:43.331000', 2, 'descr', 'txtfile', '456456', NULL, 0, '2019-01-28 21:17:43.331000'),
(22, NULL, '2019-01-28 21:21:20.358000', 2, 'descr', 'txtfile', '456456', '/opt/tomcat/files/message_photo/-7650016641548699680398txtfile', 0, '2019-01-28 21:21:20.358000'),
(23, NULL, '2019-01-28 21:22:35.176000', 2, 'descr', 'txtfile', '456456', NULL, 0, '2019-01-28 21:22:35.176000'),
(24, NULL, '2019-01-28 21:22:49.307000', 2, 'descr', 'txtfile', '456456', NULL, 0, '2019-01-28 21:22:49.307000'),
(25, NULL, '2019-01-28 21:23:12.988000', 2, 'descr', 'txtfile.jpeg', '456456', '/opt/tomcat/files/message_photo/8195932801548699793016txtfile.jpeg', 0, '2019-01-28 21:23:12.988000'),
(26, NULL, '2019-01-28 21:29:50.822000', 2, 'descr', 'txtfile.jpeg', '456456', '/opt/tomcat/files/message_photo/14663680641548700190867txtfile.jpeg', 0, '2019-01-28 21:29:50.822000'),
(27, NULL, '2019-01-28 21:52:38.778000', 2, 'descr', 'txtfile.jpeg', '456456', '/opt/tomcat/files/message_photo/-16372858241548701558831txtfile.jpeg', 0, '2019-01-28 21:52:38.778000'),
(28, NULL, '2019-01-28 21:52:40.813000', 2, 'descr', 'txtfile.jpeg', '456456', '/opt/tomcat/files/message_photo/5632492161548701560838txtfile.jpeg', 0, '2019-01-28 21:52:40.813000'),
(29, NULL, '2019-01-28 21:52:53.505000', 2, 'descr', 'txtfile.jpeg', '456456', '/opt/tomcat/files/message_photo/16276849281548701573530txtfile.jpeg', 0, '2019-01-28 21:52:53.505000'),
(30, NULL, '2019-01-28 21:52:55.534000', 2, 'descr', 'txtfile.jpeg', '456456', '/opt/tomcat/files/message_photo/-6981549441548701575556txtfile.jpeg', 0, '2019-01-28 21:52:55.534000'),
(31, NULL, '2019-01-28 22:11:38.404000', 2, 'descr', 'txtfile.jpeg', '456456', NULL, 0, '2019-01-28 22:11:38.404000'),
(32, NULL, '2019-01-28 22:16:16.696000', 2, 'description', '123.txt', 'image', '/opt/tomcat/webapps/upload/message_photo/-11592007041548702976724123.txt', 0, '2019-01-28 22:16:16.696000'),
(33, NULL, '2019-01-29 20:01:53.789000', 2, 'description', '123.txt', 'image', '/opt/tomcat/webapps/upload/message_photo/-15920987521548781313818123.txt', 0, '2019-01-29 20:01:53.789000'),
(34, NULL, '2019-01-29 20:32:19.264000', 2, 'description', '123.txt', 'image', '/opt/tomcat/webapps/upload/message_photo/5172101761548783139294123.txt', 0, '2019-01-29 20:32:19.264000'),
(35, NULL, '2019-01-29 21:00:11.400000', 2, 'description', '123.txt', 'image', '/opt/tomcat/webapps/upload/message_photo/6113198721548784811423123.txt', 0, '2019-01-29 21:00:11.400000'),
(36, NULL, '2019-01-29 21:04:26.998000', 2, 'description', '123.txt', 'image', '/opt/tomcat/webapps/upload/message_photo/19324600961548785067036123.txt', 0, '2019-01-29 21:04:26.998000'),
(37, NULL, '2019-01-29 21:06:20.825000', 2, 'description', '123.txt', 'image', '/opt/tomcat/webapps/upload/message_photo/12085166721548785180860123.txt', 0, '2019-01-29 21:06:20.825000'),
(38, NULL, '2019-01-29 21:08:20.390000', 2, 'description', '123.txt', 'image', '/opt/tomcat/webapps/upload/message_photo/10448405121548785300414123.txt', 0, '2019-01-29 21:08:20.390000'),
(39, NULL, '2019-01-29 21:12:53.681000', 2, 'description', '123.txt', 'image', '/opt/tomcat/webapps/upload/message_photo/2136801921548785573735123.txt', 0, '2019-01-29 21:12:53.681000'),
(40, NULL, '2019-01-29 21:15:10.717000', 2, 'description', '123.txt', 'image', '/opt/tomcat/webapps/upload/message_photo/-15291841921548785710749123.txt', 0, '2019-01-29 21:15:10.717000'),
(41, NULL, '2019-01-29 21:20:51.166000', 2, 'description', '123.txt', 'image', '/opt/tomcat/webapps/upload/message_photo/16102851201548786051193123.txt', 0, '2019-01-29 21:20:51.166000'),
(42, NULL, '2019-01-29 21:21:58.566000', 2, 'description', '123.txt', 'image', '/opt/tomcat/webapps/upload/message_photo/10112860801548786118646123.txt', 0, '2019-01-29 21:21:58.566000'),
(43, NULL, '2019-01-29 21:25:29.956000', 2, 'description', '123.txt', 'image', '/opt/tomcat/webapps/upload/message_photo/18249155201548786330005123.txt', 0, '2019-01-29 21:25:29.956000'),
(44, NULL, '2019-01-29 21:25:40.364000', 2, 'description', '123.txt', 'image', '/opt/tomcat/webapps/upload/message_photo/9386066561548786340391123.txt', 0, '2019-01-29 21:25:40.364000'),
(45, NULL, '2019-01-31 22:23:58.440000', 2, 'description', '123.txt', 'image', '/opt/tomcat/webapps/upload/message_photo/-11156848001548962638470123.txt', 0, '2019-01-31 22:23:58.440000'),
(46, NULL, '2019-01-31 22:31:44.058000', 2, '', '123.txt', '', '/opt/tomcat/webapps/upload/message_photo/-4146462081548963104079123.txt', 0, '2019-01-31 22:31:44.058000');

-- --------------------------------------------------------

--
-- Структура таблицы `message`
--

CREATE TABLE `message` (
                         `Id` bigint(20) NOT NULL,
                         `CreateUser` bigint(20) DEFAULT NULL,
                         `CreationDate` datetime(6) DEFAULT NULL,
                         `IsDeleted` tinyint(4) DEFAULT NULL,
                         `MessagePhotoPath` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
                         `ModifyDate` datetime(6) DEFAULT NULL,
                         `Region` bigint(20) DEFAULT NULL,
                         `Request` bigint(20) DEFAULT NULL,
                         `Text` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
                         `Type` bigint(20) DEFAULT NULL,
                         `UserRx` bigint(20) DEFAULT NULL,
                         `getCreateUserName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
                         `CreateUserName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
                         `files` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Структура таблицы `messagetype`
--

CREATE TABLE `messagetype` (
                             `Id` bigint(20) NOT NULL,
                             `IsDeleted` tinyint(4) DEFAULT NULL,
                             `Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `messagetype`
--

INSERT INTO `messagetype` (`Id`, `IsDeleted`, `Name`) VALUES
(1, NULL, 'broadcast'),
(2, NULL, 'private'),
(3, NULL, 'region');

-- --------------------------------------------------------

--
-- Структура таблицы `region`
--

CREATE TABLE `region` (
                        `Id` bigint(20) NOT NULL,
                        `IsDeleted` tinyint(4) DEFAULT NULL,
                        `Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `region`
--

INSERT INTO `region` (`Id`, `IsDeleted`, `Name`) VALUES
(1, 0, 'Izhevsk'),
(2, 0, 'Kazan'),
(3, 0, 'Moscow');

-- --------------------------------------------------------

--
-- Структура таблицы `request`
--

CREATE TABLE `request` (
                         `Id` bigint(20) NOT NULL,
                         `CloseDate` datetime(6) DEFAULT NULL,
                         `CreationDate` datetime(6) DEFAULT NULL,
                         `CreationUser` bigint(20) DEFAULT NULL,
                         `Description` varchar(45) DEFAULT NULL,
                         `IsDeleted` tinyint(4) DEFAULT NULL,
                         `IsResolvedByUser` tinyint(4) DEFAULT NULL,
                         `Latitude` double DEFAULT NULL,
                         `Longitude` double DEFAULT NULL,
                         `ModifyDate` datetime(6) NOT NULL,
                         `Region` bigint(20) DEFAULT NULL,
                         `RequestPhotoPath` varchar(100) DEFAULT NULL,
                         `ResolvedByUser` bigint(20) DEFAULT NULL,
                         `Status` bigint(20) DEFAULT NULL,
                         `Type` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `requeststatus`
--

CREATE TABLE `requeststatus` (
                               `Id` bigint(20) NOT NULL,
                               `IsDeleted` tinyint(4) DEFAULT NULL,
                               `Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `requeststatus`
--

INSERT INTO `requeststatus` (`Id`, `IsDeleted`, `Name`) VALUES
(1, NULL, 'Open'),
(2, NULL, 'Close'),
(3, NULL, 'Unknown');

-- --------------------------------------------------------

--
-- Структура таблицы `requesttype`
--

CREATE TABLE `requesttype` (
                             `Id` bigint(20) NOT NULL,
                             `IsDeleted` tinyint(4) DEFAULT NULL,
                             `Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `requesttype`
--

INSERT INTO `requesttype` (`Id`, `IsDeleted`, `Name`) VALUES
(4, NULL, 'Сел акуммулятор'),
(5, NULL, 'Не заводится'),
(6, NULL, 'Застрял'),
(7, NULL, 'Что то сломалось в машинке'),
(8, NULL, 'Проблема с сигнализацией'),
(9, NULL, 'Машина не открывается'),
(10, NULL, 'Нужен эвакуатор');

-- --------------------------------------------------------

--
-- Структура таблицы `session`
--

CREATE TABLE `session` (
                         `Id` bigint(20) NOT NULL,
                         `CreationDate` datetime(6) DEFAULT NULL,
                         `Token` varchar(50) NOT NULL,
                         `User` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `session`
--

INSERT INTO `session` (`Id`, `CreationDate`, `Token`, `User`) VALUES
(1, '2018-12-22 17:12:46.927000', '8639729E1A9A1DB25E428392867ECB5FFAA93A33', 2),
(2, '2018-12-26 16:59:50.885000', '386684AD9BF776A6283DC8D9F699595DAB6EBB25', 3),
(3, '2019-01-13 18:23:44.601000', '743D382419887B9AC70760238970062A9F6F6C3E', 4),
(4, '2019-01-17 07:24:59.712000', 'CB9845BA81CD9E9EEFC2D9C8C5ED129BBA436D8E', 5);

-- --------------------------------------------------------

--
-- Структура таблицы `tool`
--

CREATE TABLE `tool` (
                      `Id` bigint(20) NOT NULL,
                      `IsDeleted` tinyint(4) DEFAULT NULL,
                      `Type` bigint(20) DEFAULT NULL,
                      `User` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `tool`
--

INSERT INTO `tool` (`Id`, `IsDeleted`, `Type`, `User`) VALUES
(1, 1, 2, 2),
(2, 1, 3, 2),
(3, 1, 1, 2),
(4, 1, 2, 2),
(5, 1, 3, 2),
(6, 1, 4, 2),
(7, 1, 2, 2),
(8, 1, 3, 2),
(9, 1, 4, 2),
(10, 1, 1, 2),
(11, 1, 4, 2),
(12, 1, 2, 2),
(13, 1, 2, 2),
(14, 1, 3, 2),
(15, 1, 3, 2),
(16, 1, 1, 2),
(17, 1, 3, 2),
(18, 1, 4, 2),
(19, 1, 2, 2),
(20, 1, 1, 2),
(21, 1, 4, 2),
(22, 1, 2, 2),
(23, 1, 3, 2),
(24, 1, 4, 2),
(25, 0, 2, 4),
(26, 0, 4, 4),
(27, 1, 3, 2),
(28, 1, 2, 2),
(29, 1, 3, 2),
(30, 1, 4, 2),
(31, 1, 2, 2),
(32, 1, 3, 2),
(33, 0, 4, 2);

-- --------------------------------------------------------

--
-- Структура таблицы `tooltypes`
--

CREATE TABLE `tooltypes` (
                           `Id` bigint(20) NOT NULL,
                           `IsDeleted` tinyint(4) DEFAULT NULL,
                           `Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `tooltypes`
--

INSERT INTO `tooltypes` (`Id`, `IsDeleted`, `Name`) VALUES
(1, NULL, 'Тросс'),
(2, NULL, 'Огнетушитель'),
(3, NULL, 'Провода'),
(4, NULL, 'Инструменты');

-- --------------------------------------------------------

--
-- Структура таблицы `transmissiontype`
--

CREATE TABLE `transmissiontype` (
                                  `Id` bigint(20) NOT NULL,
                                  `IsDeleted` tinyint(4) DEFAULT NULL,
                                  `Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `transmissiontype`
--

INSERT INTO `transmissiontype` (`Id`, `IsDeleted`, `Name`) VALUES
(1, NULL, 'Механическая коробка'),
(2, NULL, 'АКПП'),
(3, NULL, 'Вариатор'),
(4, NULL, 'Робот');

-- --------------------------------------------------------

--
-- Структура таблицы `user`
--

CREATE TABLE `user` (
                      `Id` bigint(20) NOT NULL,
                      `CreationDate` datetime(6) DEFAULT NULL,
                      `Email` varchar(80) DEFAULT NULL,
                      `IsApprovedUser` tinyint(4) DEFAULT NULL,
                      `IsDeleted` tinyint(4) DEFAULT NULL,
                      `ModifyDate` datetime(6) NOT NULL,
                      `Name` varchar(50) NOT NULL,
                      `Password` varchar(50) NOT NULL,
                      `Phone` varchar(20) DEFAULT NULL,
                      `Region` bigint(20) DEFAULT NULL,
                      `Status` bigint(20) DEFAULT NULL,
                      `UserPhotoPath` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `user`
--

INSERT INTO `user` (`Id`, `CreationDate`, `Email`, `IsApprovedUser`, `IsDeleted`, `ModifyDate`, `Name`, `Password`, `Phone`, `Region`, `Status`, `UserPhotoPath`) VALUES
(2, '2019-04-15 19:26:57.144000', 'madruskor@gmail.com', NULL, 0, '2019-04-15 19:26:57.144000', 'madruskor@gmail.com', '11111111', '999999', 3, 2, '/opt/tomcat/webapps/upload/user_ava_photo/-15069821801555345617144filename'),
(3, '2018-12-26 16:59:50.344000', 'madruskor@gmail.com2', NULL, 0, '2018-12-26 16:59:50.344000', 'madruskor@gmail.com2', '22222222', '11111111', 3, 2, NULL),
(4, '2019-01-13 18:23:43.735000', 'madruskor@gmail.com1', NULL, 0, '2019-01-13 18:23:43.735000', 'madruskor@gmail.com1', '11111111', '11111111', 3, 2, NULL),
(5, '2019-01-17 07:24:59.342000', 'madruskor@gmail.com3', NULL, 0, '2019-01-17 07:24:59.342000', 'madruskor@gmail.com3', '11111111', '999999999', 1, 2, NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `userstatus`
--

CREATE TABLE `userstatus` (
                            `Id` bigint(20) NOT NULL,
                            `IsDeleted` tinyint(4) DEFAULT NULL,
                            `Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `userstatus`
--

INSERT INTO `userstatus` (`Id`, `IsDeleted`, `Name`) VALUES
(1, NULL, 'admin'),
(2, NULL, 'common'),
(3, NULL, 'Non-active');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `achievement`
--
ALTER TABLE `achievement`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FKdsm6sx8f6ncesjsb874wo7cl7` (`Type`);

--
-- Индексы таблицы `achievmenttype`
--
ALTER TABLE `achievmenttype`
  ADD PRIMARY KEY (`Id`);

--
-- Индексы таблицы `auto`
--
ALTER TABLE `auto`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FK45bu2tjqn0ycfodae38069ogl` (`TransmissionType`),
  ADD KEY `FKpq5ewqj3rojyqtn4bff43tgxv` (`User`);

--
-- Индексы таблицы `files`
--
ALTER TABLE `files`
  ADD PRIMARY KEY (`Id`);

--
-- Индексы таблицы `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FKqhlj1ykctqe7mugseblqwhmj8` (`Type`),
  ADD KEY `FKcg5vbk59wl14pn5gcegsw17c6` (`Region`),
  ADD KEY `FKcmibhcrkk1s7r4iuiy1j7kmv7` (`Request`),
  ADD KEY `FK68qlfmuklctrvcl9u7ec8bm1h` (`CreateUser`),
  ADD KEY `FKs81o58jdbs9sl2hjqr1cad734` (`UserRx`),
  ADD KEY `FK38qa4e39q1e1154ayxh5fw44h` (`files`);

--
-- Индексы таблицы `messagetype`
--
ALTER TABLE `messagetype`
  ADD PRIMARY KEY (`Id`);

--
-- Индексы таблицы `region`
--
ALTER TABLE `region`
  ADD PRIMARY KEY (`Id`);

--
-- Индексы таблицы `request`
--
ALTER TABLE `request`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FKi0jq89dg5tikp0qvwttqxd7cb` (`Region`),
  ADD KEY `FKlnbu1sw758xiqkcn41rgs40yl` (`Status`),
  ADD KEY `FKpxvr8a2vwcbbo9fl60ok98ytd` (`Type`),
  ADD KEY `FKm8egd6g1j1bvj3obnoh6mqg6q` (`CreationUser`),
  ADD KEY `FKn0hk7v20lhe9ot8x3pkrtsboh` (`ResolvedByUser`);

--
-- Индексы таблицы `requeststatus`
--
ALTER TABLE `requeststatus`
  ADD PRIMARY KEY (`Id`);

--
-- Индексы таблицы `requesttype`
--
ALTER TABLE `requesttype`
  ADD PRIMARY KEY (`Id`);

--
-- Индексы таблицы `session`
--
ALTER TABLE `session`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FKq0gcwqo9s3ceaba57gf2pk1s6` (`User`);

--
-- Индексы таблицы `tool`
--
ALTER TABLE `tool`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FK44i05m56h5orh1jadtm32lhmi` (`Type`),
  ADD KEY `FKs6gjm0sgu9v59mxaausq5x2r9` (`User`);

--
-- Индексы таблицы `tooltypes`
--
ALTER TABLE `tooltypes`
  ADD PRIMARY KEY (`Id`);

--
-- Индексы таблицы `transmissiontype`
--
ALTER TABLE `transmissiontype`
  ADD PRIMARY KEY (`Id`);

--
-- Индексы таблицы `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FKnc2peplky871rrckc4m1af5c8` (`Region`),
  ADD KEY `FK14fvu530im3mv48c8p6bsyiev` (`Status`);

--
-- Индексы таблицы `userstatus`
--
ALTER TABLE `userstatus`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `achievement`
--
ALTER TABLE `achievement`
  MODIFY `Id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблицы `achievmenttype`
--
ALTER TABLE `achievmenttype`
  MODIFY `Id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT для таблицы `auto`
--
ALTER TABLE `auto`
  MODIFY `Id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT для таблицы `files`
--
ALTER TABLE `files`
  MODIFY `Id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;
--
-- AUTO_INCREMENT для таблицы `message`
--
ALTER TABLE `message`
  MODIFY `Id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=386;
--
-- AUTO_INCREMENT для таблицы `messagetype`
--
ALTER TABLE `messagetype`
  MODIFY `Id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT для таблицы `region`
--
ALTER TABLE `region`
  MODIFY `Id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT для таблицы `request`
--
ALTER TABLE `request`
  MODIFY `Id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблицы `requeststatus`
--
ALTER TABLE `requeststatus`
  MODIFY `Id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT для таблицы `requesttype`
--
ALTER TABLE `requesttype`
  MODIFY `Id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT для таблицы `session`
--
ALTER TABLE `session`
  MODIFY `Id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT для таблицы `tool`
--
ALTER TABLE `tool`
  MODIFY `Id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;
--
-- AUTO_INCREMENT для таблицы `tooltypes`
--
ALTER TABLE `tooltypes`
  MODIFY `Id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT для таблицы `transmissiontype`
--
ALTER TABLE `transmissiontype`
  MODIFY `Id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT для таблицы `user`
--
ALTER TABLE `user`
  MODIFY `Id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT для таблицы `userstatus`
--
ALTER TABLE `userstatus`
  MODIFY `Id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `achievement`
--
ALTER TABLE `achievement`
  ADD CONSTRAINT `FKdsm6sx8f6ncesjsb874wo7cl7` FOREIGN KEY (`Type`) REFERENCES `achievmenttype` (`Id`);

--
-- Ограничения внешнего ключа таблицы `auto`
--
ALTER TABLE `auto`
  ADD CONSTRAINT `FK45bu2tjqn0ycfodae38069ogl` FOREIGN KEY (`TransmissionType`) REFERENCES `transmissiontype` (`Id`),
  ADD CONSTRAINT `FKpq5ewqj3rojyqtn4bff43tgxv` FOREIGN KEY (`User`) REFERENCES `user` (`Id`);

--
-- Ограничения внешнего ключа таблицы `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `FK38qa4e39q1e1154ayxh5fw44h` FOREIGN KEY (`files`) REFERENCES `files` (`Id`),
  ADD CONSTRAINT `FK68qlfmuklctrvcl9u7ec8bm1h` FOREIGN KEY (`CreateUser`) REFERENCES `user` (`Id`),
  ADD CONSTRAINT `FKcg5vbk59wl14pn5gcegsw17c6` FOREIGN KEY (`Region`) REFERENCES `region` (`Id`),
  ADD CONSTRAINT `FKcmibhcrkk1s7r4iuiy1j7kmv7` FOREIGN KEY (`Request`) REFERENCES `request` (`Id`),
  ADD CONSTRAINT `FKqhlj1ykctqe7mugseblqwhmj8` FOREIGN KEY (`Type`) REFERENCES `messagetype` (`Id`),
  ADD CONSTRAINT `FKs81o58jdbs9sl2hjqr1cad734` FOREIGN KEY (`UserRx`) REFERENCES `user` (`Id`);

--
-- Ограничения внешнего ключа таблицы `request`
--
ALTER TABLE `request`
  ADD CONSTRAINT `FKi0jq89dg5tikp0qvwttqxd7cb` FOREIGN KEY (`Region`) REFERENCES `region` (`Id`),
  ADD CONSTRAINT `FKlnbu1sw758xiqkcn41rgs40yl` FOREIGN KEY (`Status`) REFERENCES `requeststatus` (`Id`),
  ADD CONSTRAINT `FKm8egd6g1j1bvj3obnoh6mqg6q` FOREIGN KEY (`CreationUser`) REFERENCES `user` (`Id`),
  ADD CONSTRAINT `FKn0hk7v20lhe9ot8x3pkrtsboh` FOREIGN KEY (`ResolvedByUser`) REFERENCES `user` (`Id`),
  ADD CONSTRAINT `FKpxvr8a2vwcbbo9fl60ok98ytd` FOREIGN KEY (`Type`) REFERENCES `requesttype` (`Id`);

--
-- Ограничения внешнего ключа таблицы `session`
--
ALTER TABLE `session`
  ADD CONSTRAINT `FKq0gcwqo9s3ceaba57gf2pk1s6` FOREIGN KEY (`User`) REFERENCES `user` (`Id`);

--
-- Ограничения внешнего ключа таблицы `tool`
--
ALTER TABLE `tool`
  ADD CONSTRAINT `FK44i05m56h5orh1jadtm32lhmi` FOREIGN KEY (`Type`) REFERENCES `tooltypes` (`Id`),
  ADD CONSTRAINT `FKs6gjm0sgu9v59mxaausq5x2r9` FOREIGN KEY (`User`) REFERENCES `user` (`Id`);

--
-- Ограничения внешнего ключа таблицы `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK14fvu530im3mv48c8p6bsyiev` FOREIGN KEY (`Status`) REFERENCES `userstatus` (`Id`),
  ADD CONSTRAINT `FKnc2peplky871rrckc4m1af5c8` FOREIGN KEY (`Region`) REFERENCES `region` (`Id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
