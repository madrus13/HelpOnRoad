-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Хост: localhost:3306
-- Время создания: Янв 22 2019 г., 18:58
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
(1, 1, 0, 'BMW 325', 1, 2),
(2, 1, 0, 'BMW 325', 1, 4),
(3, 1, 0, 'BMW 325', 1, 3);

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
  `CreateUserName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Дамп данных таблицы `message`
--

INSERT INTO `message` (`Id`, `CreateUser`, `CreationDate`, `IsDeleted`, `MessagePhotoPath`, `ModifyDate`, `Region`, `Request`, `Text`, `Type`, `UserRx`, `getCreateUserName`, `CreateUserName`) VALUES
(95, 2, '2019-01-13 16:26:51.272000', 0, NULL, '2019-01-13 16:26:51.272000', 3, NULL, 'чат', 3, NULL, NULL, NULL),
(96, 2, '2019-01-13 16:28:24.918000', 0, NULL, '2019-01-13 16:28:24.918000', 3, NULL, 'тем временем на земле в Москве находится ', 3, NULL, NULL, NULL),
(97, 2, '2019-01-13 16:28:44.456000', 0, NULL, '2019-01-13 16:28:44.456000', 3, NULL, 'шамиль еду на автобусы с Украины на улице хорошо с 89 88888 и с утра в Москве и в Москве и в Москве и ', 3, NULL, NULL, NULL),
(98, 2, '2019-01-13 17:27:08.542000', 0, NULL, '2019-01-13 17:27:08.542000', 3, NULL, 'шшш', 3, NULL, NULL, NULL),
(99, 2, '2019-01-13 18:03:41.256000', 0, NULL, '2019-01-13 18:03:41.256000', 3, NULL, 'тстта', 3, NULL, NULL, NULL),
(100, 2, '2019-01-13 18:12:15.623000', 0, NULL, '2019-01-13 18:12:15.623000', 3, NULL, 'тест', 3, NULL, NULL, NULL),
(101, 2, '2019-01-13 18:12:21.246000', 0, NULL, '2019-01-13 18:12:21.246000', 3, NULL, 'тест', 3, NULL, NULL, NULL),
(102, 4, '2019-01-13 18:46:13.313000', 0, NULL, '2019-01-13 18:46:13.313000', 3, NULL, 'privet', 3, NULL, NULL, NULL),
(103, 2, '2019-01-13 18:47:02.297000', 0, NULL, '2019-01-13 18:47:02.297000', 3, NULL, 'тест', 3, NULL, NULL, NULL),
(104, 2, '2019-01-13 18:47:20.828000', 0, NULL, '2019-01-13 18:47:20.828000', 3, NULL, 'пумс', 3, NULL, NULL, NULL),
(105, 4, '2019-01-13 18:47:28.341000', 0, NULL, '2019-01-13 18:47:28.341000', 3, NULL, 'sdssfg', 3, NULL, NULL, NULL),
(106, 2, '2019-01-13 18:48:14.877000', 0, NULL, '2019-01-13 18:48:14.877000', 3, NULL, 'да да слышал ', 3, NULL, NULL, NULL),
(107, 4, '2019-01-13 18:49:10.314000', 0, NULL, '2019-01-13 18:49:10.314000', 3, NULL, 'sss', 3, NULL, NULL, NULL),
(108, 2, '2019-01-13 19:11:34.268000', 0, NULL, '2019-01-13 19:11:34.268000', 3, NULL, 'тест', 3, NULL, NULL, NULL),
(109, 2, '2019-01-13 23:14:26.490000', 0, NULL, '2019-01-13 23:14:26.490000', 3, NULL, 'ррр', 3, NULL, NULL, NULL),
(110, 2, '2019-01-13 23:20:40.798000', 0, NULL, '2019-01-13 23:20:40.798000', 3, NULL, 'ооо', 3, NULL, NULL, NULL),
(111, 2, '2019-01-13 23:20:40.893000', 0, NULL, '2019-01-13 23:20:40.893000', 3, NULL, 'ооо', 3, NULL, NULL, NULL),
(112, 2, '2019-01-13 23:21:02.192000', 0, NULL, '2019-01-13 23:21:02.192000', 3, NULL, 'ллл', 3, NULL, NULL, NULL),
(113, 2, '2019-01-13 23:33:19.774000', 0, NULL, '2019-01-13 23:33:19.774000', 3, NULL, 'ооо', 3, NULL, NULL, NULL),
(114, 2, '2019-01-13 23:33:22.787000', 0, NULL, '2019-01-13 23:33:22.787000', 3, NULL, 'ггнг', 3, NULL, NULL, NULL),
(115, 2, '2019-01-13 23:34:42.611000', 0, NULL, '2019-01-13 23:34:42.611000', 3, NULL, 'ннн', 3, NULL, NULL, 'Name 2'),
(116, 2, '2019-01-13 23:35:10.301000', 0, NULL, '2019-01-13 23:35:10.301000', 3, NULL, 'ппр', 3, NULL, NULL, 'Name 3'),
(117, 2, '2019-01-13 23:45:33.619000', 0, NULL, '2019-01-13 23:45:33.619000', 3, NULL, 'ттоо', 3, NULL, NULL, 'Name 6'),
(118, 2, '2019-01-13 23:49:48.894000', 0, NULL, '2019-01-13 23:49:48.894000', 3, NULL, 'оог', 3, NULL, NULL, 'Name 7'),
(119, 2, '2019-01-14 14:53:33.807000', 0, NULL, '2019-01-14 14:53:33.807000', 3, NULL, 'hhh', 3, NULL, NULL, 'Name 9'),
(120, 2, '2019-01-14 20:50:00.889000', 0, NULL, '2019-01-14 20:50:00.889000', 3, NULL, 'ттт', 3, NULL, NULL, NULL),
(121, 2, '2019-01-14 21:12:04.565000', 0, NULL, '2019-01-14 21:12:04.565000', 3, NULL, 'ооо', 3, NULL, NULL, NULL),
(122, 2, '2019-01-14 21:12:31.979000', 0, NULL, '2019-01-14 21:12:31.979000', 3, NULL, 'ооо', 3, NULL, NULL, NULL),
(123, 2, '2019-01-14 21:31:52.966000', 0, NULL, '2019-01-14 21:31:52.966000', 3, NULL, 'ллл', 3, NULL, NULL, NULL),
(124, 2, '2019-01-14 23:29:32.171000', 0, NULL, '2019-01-14 23:29:32.171000', 3, NULL, 'талал', 3, NULL, NULL, NULL),
(125, 2, '2019-01-15 07:16:17.549000', 0, NULL, '2019-01-15 07:16:17.549000', 3, NULL, 'ттт', 3, NULL, NULL, NULL),
(126, 2, '2019-01-15 21:32:10.362000', 0, NULL, '2019-01-15 21:32:10.362000', 3, NULL, '666', 3, NULL, NULL, NULL),
(127, 2, '2019-01-15 21:32:19.736000', 0, NULL, '2019-01-15 21:32:19.736000', 3, NULL, 'yuy', 3, NULL, NULL, NULL),
(128, 2, '2019-01-15 21:33:04.708000', 0, NULL, '2019-01-15 21:33:04.708000', 3, NULL, '4', 3, NULL, NULL, NULL),
(129, 2, '2019-01-15 21:35:27.300000', 0, NULL, '2019-01-15 21:35:27.300000', 3, NULL, 'tt', 3, NULL, NULL, NULL),
(130, 2, '2019-01-15 21:35:40.524000', 0, NULL, '2019-01-15 21:35:40.524000', 3, NULL, '66', 3, NULL, NULL, NULL),
(131, 2, '2019-01-15 21:41:34.250000', 0, NULL, '2019-01-15 21:41:34.250000', 3, NULL, '666', 3, NULL, NULL, NULL),
(132, 2, '2019-01-15 23:30:16.964000', 0, NULL, '2019-01-15 23:30:16.964000', 3, NULL, 'олд', 3, NULL, NULL, NULL),
(133, 2, '2019-01-15 23:30:58.570000', 0, NULL, '2019-01-15 23:30:58.570000', 3, NULL, 'ггг', 3, NULL, NULL, NULL),
(134, 2, '2019-01-15 23:33:32.514000', 0, NULL, '2019-01-15 23:33:32.514000', 3, NULL, 'ллш', 3, NULL, NULL, NULL),
(135, 2, '2019-01-15 23:35:30.216000', 0, NULL, '2019-01-15 23:35:30.216000', 3, NULL, 'неее', 3, NULL, NULL, NULL),
(136, 2, '2019-01-15 23:35:48.156000', 0, NULL, '2019-01-15 23:35:48.156000', 3, NULL, '5', 3, NULL, NULL, NULL),
(137, 2, '2019-01-15 23:43:46.975000', 0, NULL, '2019-01-15 23:43:46.975000', 3, NULL, 'ррр', 3, NULL, NULL, NULL),
(138, 2, '2019-01-15 23:44:10.392000', 0, NULL, '2019-01-15 23:44:10.392000', 3, NULL, 'шшш', 3, NULL, NULL, NULL),
(139, 2, '2019-01-15 23:44:26.796000', 0, NULL, '2019-01-15 23:44:26.796000', 3, NULL, 'оо', 3, NULL, NULL, NULL),
(140, 2, '2019-01-16 20:23:48.099000', 0, NULL, '2019-01-16 20:23:48.099000', 3, NULL, '555', 3, NULL, NULL, NULL),
(141, 2, '2019-01-16 23:55:48.895000', 0, NULL, '2019-01-16 23:55:48.895000', 3, NULL, 'hhh', 3, NULL, NULL, NULL),
(142, 2, '2019-01-17 00:00:26.417000', 0, NULL, '2019-01-17 00:00:26.417000', 3, NULL, '999', 3, NULL, NULL, NULL),
(143, 2, '2019-01-17 00:02:25.179000', 0, NULL, '2019-01-17 00:02:25.179000', 3, NULL, '888', 3, NULL, NULL, NULL),
(144, 2, '2019-01-17 07:21:48.429000', 0, NULL, '2019-01-17 07:21:48.429000', 3, NULL, 'тест', 3, NULL, NULL, NULL),
(145, 2, '2019-01-17 07:22:25.318000', 0, NULL, '2019-01-17 07:22:25.318000', 3, NULL, 'пример', 3, NULL, NULL, NULL),
(146, 5, '2019-01-17 07:25:44.465000', 0, NULL, '2019-01-17 07:25:44.465000', 1, NULL, 'фром 2', 3, NULL, NULL, NULL),
(147, 2, '2019-01-17 07:26:41.942000', 0, NULL, '2019-01-17 07:26:41.942000', 3, NULL, 'фром 1', 3, NULL, NULL, NULL),
(148, 2, '2019-01-02 00:00:00.000000', NULL, NULL, '2019-01-15 00:00:00.000000', 3, NULL, 'Сервисное сообщение', 1, NULL, NULL, NULL),
(149, 2, '2019-01-17 18:11:58.850000', 0, NULL, '2019-01-17 18:11:58.850000', 3, NULL, 'лала', 3, NULL, NULL, NULL),
(150, 4, '2019-01-03 00:00:00.000000', NULL, NULL, '2019-01-19 00:00:00.000000', 3, NULL, 'Ouput сообщение с именем', 3, NULL, NULL, 'Username 3'),
(151, 2, '2019-01-17 23:04:19.735000', 0, NULL, '2019-01-17 23:04:19.735000', 3, NULL, 'лилп', 3, NULL, NULL, 'madruskor@gmail.com'),
(152, 2, '2019-01-18 21:35:55.032000', 0, NULL, '2019-01-18 21:35:55.032000', 3, NULL, '333', 3, NULL, NULL, 'madruskor@gmail.com'),
(153, 2, '2019-01-18 21:54:03.017000', 0, NULL, '2019-01-18 21:54:03.017000', 3, NULL, 'ггг', 3, NULL, NULL, 'madruskor@gmail.com'),
(154, 2, '2019-01-18 21:54:49.183000', 0, NULL, '2019-01-18 21:54:49.183000', 3, NULL, 'оол', 3, NULL, NULL, 'madruskor@gmail.com'),
(155, 2, '2019-01-18 21:56:02.185000', 0, NULL, '2019-01-18 21:56:02.185000', 3, NULL, 'ооо', 3, NULL, NULL, 'madruskor@gmail.com'),
(156, 2, '2019-01-19 09:51:29.380000', 0, NULL, '2019-01-19 09:51:29.380000', 3, NULL, 'tttt', 3, NULL, NULL, 'madruskor@gmail.com'),
(157, 2, '2019-01-19 09:52:02.484000', 0, NULL, '2019-01-19 09:52:02.484000', 3, NULL, 'ttt', 3, NULL, NULL, 'madruskor@gmail.com'),
(158, 2, '2019-01-19 18:41:38.591000', 0, NULL, '2019-01-19 18:41:38.591000', 3, NULL, 'yyy', 3, NULL, NULL, 'madruskor@gmail.com'),
(159, 2, '2019-01-19 18:42:32.577000', 0, NULL, '2019-01-19 18:42:32.577000', 3, NULL, 'test666', 3, NULL, NULL, 'madruskor@gmail.com'),
(160, 2, '2019-01-19 18:43:17.921000', 0, NULL, '2019-01-19 18:43:17.922000', 3, NULL, 'стопиццот', 3, NULL, NULL, 'madruskor@gmail.com'),
(161, 2, '2019-01-19 18:43:48.737000', 0, NULL, '2019-01-19 18:43:48.737000', 3, NULL, '200800', 3, NULL, NULL, 'madruskor@gmail.com'),
(162, 2, '2019-01-19 18:46:46.734000', 0, NULL, '2019-01-19 18:46:46.734000', 3, NULL, '300', 3, NULL, NULL, 'madruskor@gmail.com'),
(163, 2, '2019-01-19 18:47:05.683000', 0, NULL, '2019-01-19 18:47:05.683000', 3, NULL, '400', 3, NULL, NULL, 'madruskor@gmail.com'),
(164, 2, '2019-01-19 18:47:27.365000', 0, NULL, '2019-01-19 18:47:27.365000', 3, NULL, '666', 3, NULL, NULL, 'madruskor@gmail.com'),
(165, 2, '2019-01-19 19:10:01.051000', 0, NULL, '2019-01-19 19:10:01.051000', 3, NULL, '666', 3, NULL, NULL, 'madruskor@gmail.com'),
(166, 2, '2019-01-19 19:10:14.392000', 0, NULL, '2019-01-19 19:10:14.392000', 3, NULL, '444', 3, NULL, NULL, 'madruskor@gmail.com'),
(167, 2, '2019-01-19 19:10:21.938000', 0, NULL, '2019-01-19 19:10:21.938000', 3, NULL, '2222', 3, NULL, NULL, 'madruskor@gmail.com'),
(168, 2, '2019-01-19 19:10:43.658000', 0, NULL, '2019-01-19 19:10:43.659000', 3, NULL, 'тест', 3, NULL, NULL, 'madruskor@gmail.com'),
(169, 2, '2019-01-19 19:10:51.700000', 0, NULL, '2019-01-19 19:10:51.700000', 3, NULL, 'сто пиццоот', 3, NULL, NULL, 'madruskor@gmail.com'),
(170, 2, '2019-01-19 19:11:05.988000', 0, NULL, '2019-01-19 19:11:05.988000', 3, NULL, 'сто пиццттуу33', 3, NULL, NULL, 'madruskor@gmail.com'),
(171, 2, '2019-01-19 19:11:32.290000', 0, NULL, '2019-01-19 19:11:32.290000', 3, NULL, 'тттттест', 3, NULL, NULL, 'madruskor@gmail.com'),
(172, 2, '2019-01-19 19:11:40.968000', 0, NULL, '2019-01-19 19:11:40.968000', 3, NULL, '888888888', 3, NULL, NULL, 'madruskor@gmail.com'),
(173, 2, '2019-01-19 19:12:30.366000', 0, NULL, '2019-01-19 19:12:30.366000', 3, NULL, '66767777', 3, NULL, NULL, 'madruskor@gmail.com'),
(174, 2, '2019-01-19 19:28:40.624000', 0, NULL, '2019-01-19 19:28:40.624000', 3, NULL, '666', 3, NULL, NULL, 'madruskor@gmail.com'),
(175, 2, '2019-01-19 19:28:45.410000', 0, NULL, '2019-01-19 19:28:45.410000', 3, NULL, '777', 3, NULL, NULL, 'madruskor@gmail.com'),
(176, 2, '2019-01-19 19:28:51.278000', 0, NULL, '2019-01-19 19:28:51.278000', 3, NULL, '9999що', 3, NULL, NULL, 'madruskor@gmail.com'),
(177, 2, '2019-01-19 19:28:56.563000', 0, NULL, '2019-01-19 19:28:56.563000', 3, NULL, 'лиомгснашпш', 3, NULL, NULL, 'madruskor@gmail.com'),
(178, 2, '2019-01-19 19:29:03.249000', 0, NULL, '2019-01-19 19:29:03.249000', 3, NULL, 'вывыввспп', 3, NULL, NULL, 'madruskor@gmail.com'),
(179, 2, '2019-01-19 19:29:08.566000', 0, NULL, '2019-01-19 19:29:08.566000', 3, NULL, 'ддд', 3, NULL, NULL, 'madruskor@gmail.com'),
(180, 2, '2019-01-19 19:29:17.771000', 0, NULL, '2019-01-19 19:29:17.771000', 3, NULL, 'рсшпшпшпш', 3, NULL, NULL, 'madruskor@gmail.com'),
(181, 2, '2019-01-19 19:29:54.636000', 0, NULL, '2019-01-19 19:29:54.636000', 3, NULL, 'щрщпшашпшггпгппш', 3, NULL, NULL, 'madruskor@gmail.com'),
(182, 2, '2019-01-19 19:30:00.386000', 0, NULL, '2019-01-19 19:30:00.386000', 3, NULL, '777777777', 3, NULL, NULL, 'madruskor@gmail.com'),
(183, 2, '2019-01-19 19:30:14.548000', 0, NULL, '2019-01-19 19:30:14.548000', 3, NULL, '666666', 3, NULL, NULL, 'madruskor@gmail.com'),
(184, 2, '2019-01-19 19:30:23.507000', 0, NULL, '2019-01-19 19:30:23.507000', 3, NULL, '99999999999', 3, NULL, NULL, 'madruskor@gmail.com'),
(185, 2, '2019-01-19 19:30:57.780000', 0, NULL, '2019-01-19 19:30:57.780000', 3, NULL, '666666', 3, NULL, NULL, 'madruskor@gmail.com'),
(186, 2, '2019-01-19 19:31:05.925000', 0, NULL, '2019-01-19 19:31:05.925000', 3, NULL, '0000000', 3, NULL, NULL, 'madruskor@gmail.com'),
(187, 2, '2019-01-19 19:31:11.717000', 0, NULL, '2019-01-19 19:31:11.717000', 3, NULL, '8888888', 3, NULL, NULL, 'madruskor@gmail.com'),
(188, 2, '2019-01-19 19:36:47.916000', 0, NULL, '2019-01-19 19:36:47.916000', 3, NULL, 'тест', 3, NULL, NULL, 'madruskor@gmail.com'),
(189, 2, '2019-01-19 19:53:40.665000', 0, NULL, '2019-01-19 19:53:40.665000', 3, NULL, 'ггг', 3, NULL, NULL, 'madruskor@gmail.com'),
(190, 2, '2019-01-19 19:54:32.853000', 0, NULL, '2019-01-19 19:54:32.853000', 3, NULL, '555', 3, NULL, NULL, 'madruskor@gmail.com'),
(191, 2, '2019-01-19 19:54:48.200000', 0, NULL, '2019-01-19 19:54:48.200000', 3, NULL, '555', 3, NULL, NULL, 'madruskor@gmail.com'),
(192, 2, '2019-01-19 20:21:21.720000', 0, NULL, '2019-01-19 20:21:21.720000', 3, NULL, 'тем ', 3, NULL, NULL, 'madruskor@gmail.com'),
(193, 2, '2019-01-19 20:21:32.985000', 0, NULL, '2019-01-19 20:21:32.985000', 3, NULL, '5555', 3, NULL, NULL, 'madruskor@gmail.com'),
(194, 2, '2019-01-19 20:23:11.863000', 0, NULL, '2019-01-19 20:23:11.863000', 3, NULL, 'тест', 3, NULL, NULL, 'madruskor@gmail.com'),
(195, 2, '2019-01-19 21:21:21.442000', 0, NULL, '2019-01-19 21:21:21.442000', 3, NULL, 'тееееее', 3, NULL, NULL, 'madruskor@gmail.com'),
(196, 2, '2019-01-19 21:21:35.335000', 0, NULL, '2019-01-19 21:21:35.335000', 3, NULL, 'шалом', 3, NULL, NULL, 'madruskor@gmail.com'),
(197, 2, '2019-01-19 21:21:55.262000', 0, NULL, '2019-01-19 21:21:55.262000', 3, NULL, 'щддлл', 3, NULL, NULL, 'madruskor@gmail.com'),
(198, 2, '2019-01-19 21:22:17.707000', 0, NULL, '2019-01-19 21:22:17.707000', 3, NULL, 'щщщщ', 3, NULL, NULL, 'madruskor@gmail.com'),
(199, 2, '2019-01-19 21:22:24.530000', 0, NULL, '2019-01-19 21:22:24.530000', 3, NULL, '000000', 3, NULL, NULL, 'madruskor@gmail.com'),
(200, 2, '2019-01-19 21:29:15.718000', 0, NULL, '2019-01-19 21:29:15.718000', 3, NULL, '666', 3, NULL, NULL, 'madruskor@gmail.com'),
(201, 2, '2019-01-19 21:29:51.537000', 0, NULL, '2019-01-19 21:29:51.537000', 3, NULL, '8888', 3, NULL, NULL, 'madruskor@gmail.com'),
(202, 2, '2019-01-19 21:41:06.855000', 0, NULL, '2019-01-19 21:41:06.855000', 3, NULL, '666', 3, NULL, NULL, 'madruskor@gmail.com'),
(203, 2, '2019-01-19 21:41:17.366000', 0, NULL, '2019-01-19 21:41:17.366000', 3, NULL, '777', 3, NULL, NULL, 'madruskor@gmail.com'),
(204, 2, '2019-01-19 21:41:29.790000', 0, NULL, '2019-01-19 21:41:29.790000', 3, NULL, '888', 3, NULL, NULL, 'madruskor@gmail.com'),
(205, 2, '2019-01-19 21:41:49.514000', 0, NULL, '2019-01-19 21:41:49.514000', 3, NULL, '888', 3, NULL, NULL, 'madruskor@gmail.com'),
(206, 2, '2019-01-19 21:41:57.154000', 0, NULL, '2019-01-19 21:41:57.154000', 3, NULL, '888', 3, NULL, NULL, 'madruskor@gmail.com'),
(207, 2, '2019-01-19 21:42:58.279000', 0, NULL, '2019-01-19 21:42:58.279000', 3, NULL, '999', 3, NULL, NULL, 'madruskor@gmail.com'),
(208, 2, '2019-01-19 21:53:00.664000', 0, NULL, '2019-01-19 21:53:00.664000', 3, NULL, '555', 3, NULL, NULL, 'madruskor@gmail.com'),
(209, 2, '2019-01-19 21:53:15.457000', 0, NULL, '2019-01-19 21:53:15.457000', 3, NULL, '444444', 3, NULL, NULL, 'madruskor@gmail.com'),
(210, 2, '2019-01-19 21:53:23.193000', 0, NULL, '2019-01-19 21:53:23.193000', 3, NULL, '00000000', 3, NULL, NULL, 'madruskor@gmail.com'),
(211, 2, '2019-01-19 21:53:34.037000', 0, NULL, '2019-01-19 21:53:34.037000', 3, NULL, '44444444', 3, NULL, NULL, 'madruskor@gmail.com'),
(212, 2, '2019-01-19 21:53:44.840000', 0, NULL, '2019-01-19 21:53:44.840000', 3, NULL, '111111', 3, NULL, NULL, 'madruskor@gmail.com'),
(213, 2, '2019-01-19 21:53:50.028000', 0, NULL, '2019-01-19 21:53:50.028000', 3, NULL, '999999', 3, NULL, NULL, 'madruskor@gmail.com'),
(214, 2, '2019-01-19 21:57:34.648000', 0, NULL, '2019-01-19 21:57:34.648000', 3, NULL, '888', 3, NULL, NULL, 'madruskor@gmail.com'),
(215, 2, '2019-01-19 21:58:18.941000', 0, NULL, '2019-01-19 21:58:18.941000', 3, NULL, '33333', 3, NULL, NULL, 'madruskor@gmail.com'),
(216, 2, '2019-01-19 22:01:33.728000', 0, NULL, '2019-01-19 22:01:33.728000', 3, NULL, '0000000', 3, NULL, NULL, 'madruskor@gmail.com'),
(217, 2, '2019-01-19 22:29:47.157000', 0, NULL, '2019-01-19 22:29:47.157000', 3, NULL, '99999777777666666', 3, NULL, NULL, 'madruskor@gmail.com'),
(218, 2, '2019-01-19 22:42:55.102000', 0, NULL, '2019-01-19 22:42:55.102000', 3, NULL, 'млмос', 3, NULL, NULL, 'madruskor@gmail.com'),
(219, 2, '2019-01-19 22:43:01.387000', 0, NULL, '2019-01-19 22:43:01.387000', 3, NULL, 'ьилмлпшешешпщ', 3, NULL, NULL, 'madruskor@gmail.com'),
(220, 2, '2019-01-19 22:45:05.474000', 0, NULL, '2019-01-19 22:45:05.474000', 3, NULL, 'ннн', 3, NULL, NULL, 'madruskor@gmail.com'),
(221, 2, '2019-01-19 22:45:26.159000', 0, NULL, '2019-01-19 22:45:26.159000', 3, NULL, '666', 3, NULL, NULL, 'madruskor@gmail.com'),
(222, 2, '2019-01-19 22:47:29.489000', 0, NULL, '2019-01-19 22:47:29.489000', 3, NULL, '66699999', 3, NULL, NULL, 'madruskor@gmail.com'),
(223, 2, '2019-01-19 22:48:53.571000', 0, NULL, '2019-01-19 22:48:53.571000', 3, NULL, 'гнг', 3, NULL, NULL, 'madruskor@gmail.com'),
(224, 2, '2019-01-19 23:13:31.498000', 0, NULL, '2019-01-19 23:13:31.498000', 3, NULL, 'ьсьсь', 3, NULL, NULL, 'madruskor@gmail.com'),
(225, 2, '2019-01-19 23:13:44.987000', 0, NULL, '2019-01-19 23:13:44.987000', 3, NULL, 'ллллл', 3, NULL, NULL, 'madruskor@gmail.com'),
(226, 2, '2019-01-19 23:13:56.276000', 0, NULL, '2019-01-19 23:13:56.276000', 3, NULL, 'ьчьсььаьаьа', 3, NULL, NULL, 'madruskor@gmail.com'),
(227, 2, '2019-01-19 23:14:08.402000', 0, NULL, '2019-01-19 23:14:08.402000', 3, NULL, '0000555558888', 3, NULL, NULL, 'madruskor@gmail.com'),
(228, 2, '2019-01-19 23:35:35.281000', 0, NULL, '2019-01-19 23:35:35.281000', 3, NULL, 'ддддд', 3, NULL, NULL, 'madruskor@gmail.com'),
(229, 2, '2019-01-19 23:35:36.937000', 0, NULL, '2019-01-19 23:35:36.937000', 3, NULL, 'дддл', 3, NULL, NULL, 'madruskor@gmail.com'),
(230, 2, '2019-01-19 23:35:40.396000', 0, NULL, '2019-01-19 23:35:40.396000', 3, NULL, 'щщщлол', 3, NULL, NULL, 'madruskor@gmail.com'),
(231, 2, '2019-01-19 23:35:41.463000', 0, NULL, '2019-01-19 23:35:41.463000', 3, NULL, 'лщщ', 3, NULL, NULL, 'madruskor@gmail.com'),
(232, 2, '2019-01-19 23:35:42.815000', 0, NULL, '2019-01-19 23:35:42.815000', 3, NULL, 'лщщ', 3, NULL, NULL, 'madruskor@gmail.com'),
(233, 2, '2019-01-20 11:44:08.658000', 0, NULL, '2019-01-20 11:44:08.659000', 3, NULL, '444', 3, NULL, NULL, 'madruskor@gmail.com'),
(234, 2, '2019-01-20 14:46:52.813000', 0, NULL, '2019-01-20 14:46:52.813000', 3, NULL, '555', 3, NULL, NULL, 'madruskor@gmail.com'),
(235, 2, '2019-01-20 14:47:11.910000', 0, NULL, '2019-01-20 14:47:11.910000', 3, NULL, '7777', 3, NULL, NULL, 'madruskor@gmail.com'),
(236, 2, '2019-01-20 15:01:52.966000', 0, NULL, '2019-01-20 15:01:52.966000', 3, NULL, 'оалалал', 3, NULL, NULL, 'madruskor@gmail.com'),
(237, 2, '2019-01-20 15:01:59.214000', 0, NULL, '2019-01-20 15:01:59.214000', 3, NULL, 'придурок', 3, NULL, NULL, 'madruskor@gmail.com'),
(238, 2, '2019-01-20 15:02:12.719000', 0, NULL, '2019-01-20 15:02:12.719000', 3, NULL, 'ололо', 3, NULL, NULL, 'madruskor@gmail.com'),
(239, 2, '2019-01-20 15:05:43.747000', 0, NULL, '2019-01-20 15:05:43.747000', 3, NULL, 'тест', 3, NULL, NULL, 'madruskor@gmail.com'),
(240, 2, '2019-01-20 15:05:49.893000', 0, NULL, '2019-01-20 15:05:49.893000', 3, NULL, 'Ололо', 3, NULL, NULL, 'madruskor@gmail.com'),
(241, 2, '2019-01-20 15:05:56.211000', 0, NULL, '2019-01-20 15:05:56.211000', 3, NULL, 'круть', 3, NULL, NULL, 'madruskor@gmail.com'),
(242, 2, '2019-01-20 15:08:25.310000', 0, NULL, '2019-01-20 15:08:25.310000', 3, NULL, 'пппц', 3, NULL, NULL, 'madruskor@gmail.com'),
(243, 2, '2019-01-20 15:08:45.672000', 0, NULL, '2019-01-20 15:08:45.672000', 3, NULL, 'ололо', 3, NULL, NULL, 'madruskor@gmail.com'),
(244, 3, '2019-01-20 15:13:15.834000', 0, NULL, '2019-01-20 15:13:15.834000', 1, NULL, 'test', 3, NULL, NULL, 'madruskor@gmail.com2'),
(245, 3, '2019-01-20 15:16:24.678000', 0, NULL, '2019-01-20 15:16:24.678000', 3, NULL, 'test from', 3, NULL, NULL, 'madruskor@gmail.com2'),
(246, 2, '2019-01-20 15:17:06.099000', 0, NULL, '2019-01-20 15:17:06.099000', 3, NULL, 'ответ 1', 3, NULL, NULL, 'madruskor@gmail.com'),
(247, 2, '2019-01-20 15:17:51.039000', 0, NULL, '2019-01-20 15:17:51.039000', 3, NULL, 'ответ 4', 3, NULL, NULL, 'madruskor@gmail.com'),
(248, 2, '2019-01-20 15:18:44.321000', 0, NULL, '2019-01-20 15:18:44.321000', 3, NULL, 'нннн', 3, NULL, NULL, 'madruskor@gmail.com'),
(249, 3, '2019-01-20 15:21:54.508000', 0, NULL, '2019-01-20 15:21:54.508000', 3, NULL, 'test from', 3, NULL, NULL, 'madruskor@gmail.com2'),
(250, 2, '2019-01-20 15:25:12.613000', 0, NULL, '2019-01-20 15:25:12.613000', 3, NULL, 'го го го', 3, NULL, NULL, 'madruskor@gmail.com'),
(251, 3, '2019-01-20 15:25:36.663000', 0, NULL, '2019-01-20 15:25:36.663000', 3, NULL, 'otvet', 3, NULL, NULL, 'madruskor@gmail.com2'),
(252, 3, '2019-01-20 15:26:20.904000', 0, NULL, '2019-01-20 15:26:20.904000', 3, NULL, '6666', 3, NULL, NULL, 'madruskor@gmail.com2'),
(253, 3, '2019-01-20 15:26:24.645000', 0, NULL, '2019-01-20 15:26:24.645000', 3, NULL, '7777', 3, NULL, NULL, 'madruskor@gmail.com2'),
(254, 2, '2019-01-20 15:27:47.757000', 0, NULL, '2019-01-20 15:27:47.757000', 3, NULL, '777', 3, NULL, NULL, 'madruskor@gmail.com'),
(255, 3, '2019-01-20 15:29:49.617000', 0, NULL, '2019-01-20 15:29:49.617000', 3, NULL, 'ttttt', 3, NULL, NULL, 'madruskor@gmail.com2'),
(256, 3, '2019-01-20 15:38:02.944000', 0, NULL, '2019-01-20 15:38:02.944000', 3, NULL, 'tesssr', 3, NULL, NULL, 'madruskor@gmail.com2'),
(257, 3, '2019-01-20 15:38:46.888000', 0, NULL, '2019-01-20 15:38:46.888000', 3, NULL, '555', 3, NULL, NULL, 'madruskor@gmail.com2'),
(258, 3, '2019-01-20 15:39:01.483000', 0, NULL, '2019-01-20 15:39:01.483000', 3, NULL, '7888', 3, NULL, NULL, 'madruskor@gmail.com2'),
(259, 2, '2019-01-20 15:39:08.999000', 0, NULL, '2019-01-20 15:39:08.999000', 3, NULL, 'ололо', 3, NULL, NULL, 'madruskor@gmail.com'),
(260, 2, '2019-01-20 15:39:13.651000', 0, NULL, '2019-01-20 15:39:13.651000', 3, NULL, '847848к', 3, NULL, NULL, 'madruskor@gmail.com'),
(261, 3, '2019-01-20 15:39:21.147000', 0, NULL, '2019-01-20 15:39:21.147000', 3, NULL, 'gggy', 3, NULL, NULL, 'madruskor@gmail.com2'),
(262, 3, '2019-01-20 15:43:38.436000', 0, NULL, '2019-01-20 15:43:38.436000', 3, NULL, 'yyyy', 3, NULL, NULL, 'madruskor@gmail.com2'),
(263, 2, '2019-01-20 15:44:02.396000', 0, NULL, '2019-01-20 15:44:02.396000', 3, NULL, 'стопицот', 3, NULL, NULL, 'madruskor@gmail.com'),
(264, 3, '2019-01-20 15:44:42.664000', 0, NULL, '2019-01-20 15:44:42.664000', 3, NULL, 'ttt', 3, NULL, NULL, 'madruskor@gmail.com2'),
(265, 2, '2019-01-20 15:44:52.521000', 0, NULL, '2019-01-20 15:44:52.521000', 3, NULL, '888', 3, NULL, NULL, 'madruskor@gmail.com'),
(266, 2, '2019-01-20 15:45:12.218000', 0, NULL, '2019-01-20 15:45:12.218000', 3, NULL, '77777', 3, NULL, NULL, 'madruskor@gmail.com'),
(267, 2, '2019-01-20 15:45:57.571000', 0, NULL, '2019-01-20 15:45:57.571000', 3, NULL, 'лддд', 3, NULL, NULL, 'madruskor@gmail.com'),
(268, 3, '2019-01-20 15:46:44.097000', 0, NULL, '2019-01-20 15:46:44.097000', 3, NULL, '888', 3, NULL, NULL, 'madruskor@gmail.com2'),
(269, 2, '2019-01-20 15:46:49.456000', 0, NULL, '2019-01-20 15:46:49.456000', 3, NULL, '8889', 3, NULL, NULL, 'madruskor@gmail.com'),
(270, 2, '2019-01-20 15:47:04.487000', 0, NULL, '2019-01-20 15:47:04.487000', 3, NULL, 'ддд', 3, NULL, NULL, 'madruskor@gmail.com'),
(271, 2, '2019-01-20 15:49:12.103000', 0, NULL, '2019-01-20 15:49:12.103000', 3, NULL, '999', 3, NULL, NULL, 'madruskor@gmail.com'),
(272, 2, '2019-01-20 16:00:35.623000', 0, NULL, '2019-01-20 16:00:35.623000', 3, NULL, 'шклк', 3, NULL, NULL, 'madruskor@gmail.com'),
(273, 2, '2019-01-20 17:32:10.089000', 0, NULL, '2019-01-20 17:32:10.089000', 1, NULL, 'тест', 3, NULL, NULL, 'madruskor@gmail.com'),
(274, 2, '2019-01-20 18:21:09.857000', 0, NULL, '2019-01-20 18:21:09.857000', 3, NULL, 'чат 2', 3, NULL, NULL, 'madruskor@gmail.com'),
(275, 2, '2019-01-20 18:21:30.914000', 0, NULL, '2019-01-20 18:21:30.914000', 3, NULL, 'чат 1', 3, NULL, NULL, 'madruskor@gmail.com'),
(276, 2, '2019-01-20 18:26:14.497000', 0, NULL, '2019-01-20 18:26:14.497000', 3, NULL, '777', 3, NULL, NULL, 'madruskor@gmail.com'),
(277, 2, '2019-01-20 19:39:13.787000', 0, NULL, '2019-01-20 19:39:13.787000', 2, NULL, 'тест', 3, NULL, NULL, 'madruskor@gmail.com'),
(278, 2, '2019-01-20 19:39:22.273000', 0, NULL, '2019-01-20 19:39:22.273000', 2, NULL, 'говвдвдвд', 3, NULL, NULL, 'madruskor@gmail.com'),
(279, 2, '2019-01-20 19:39:42.733000', 0, NULL, '2019-01-20 19:39:42.733000', 2, NULL, 'ггоро', 3, NULL, NULL, 'madruskor@gmail.com'),
(280, 2, '2019-01-20 20:56:06.274000', 0, NULL, '2019-01-20 20:56:06.274000', 3, NULL, 'а ты чем занят тем и занимаешься тем больше от тебя как ты и как это происходит и как ты будешь в этом направлении ', 3, NULL, NULL, 'madruskor@gmail.com'),
(281, 2, '2019-01-20 20:56:19.090000', 0, NULL, '2019-01-20 20:56:19.090000', 3, NULL, 'а ты чем занимаешься в последнее время у меня вас в последнее время у меня не в жизни не было на работе не ', 3, NULL, NULL, 'madruskor@gmail.com'),
(282, 2, '2019-01-20 20:56:26.431000', 0, NULL, '2019-01-20 20:56:26.431000', 3, NULL, 'а ты чем занимаешься в последнее время не в работаешь в выходные дни в или в на работе у не в курсе что ты работаешь и работаешь и работаешь и работаешь и работаешь в ', 3, NULL, NULL, 'madruskor@gmail.com'),
(283, 2, '2019-01-20 20:57:22.812000', 0, NULL, '2019-01-20 20:57:22.812000', 3, NULL, 'а ты чем занимаешься в жизни последнее время когда ты хочешь стать в интернете этом в жизни не так уж и плохо с тобой только если есть смысл в жизни быть в одиночестве или как ты хочешь ты это все делаешь ', 3, NULL, NULL, 'madruskor@gmail.com'),
(284, 2, '2019-01-20 20:58:27.431000', 0, NULL, '2019-01-20 20:58:27.431000', 3, NULL, 'ггг', 3, NULL, NULL, 'madruskor@gmail.com'),
(285, 2, '2019-01-20 20:58:33.787000', 0, NULL, '2019-01-20 20:58:33.787000', 3, NULL, 'кккк', 3, NULL, NULL, 'madruskor@gmail.com'),
(286, 2, '2019-01-20 20:58:46.387000', 0, NULL, '2019-01-20 20:58:46.387000', 3, NULL, 'лмлпщкд в России в Азербайджане в декабре и 2 января на сайте в разделе новости и информация о 3 в Москве в течение недели начнётся с начала года в России в октябре прошлого века и в апреле этого месяца стало меньше ', 3, NULL, NULL, 'madruskor@gmail.com'),
(287, 2, '2019-01-20 21:10:50.298000', 0, NULL, '2019-01-20 21:10:50.298000', 3, NULL, 'шпллр', 3, NULL, NULL, 'madruskor@gmail.com'),
(288, 2, '2019-01-20 21:12:51.854000', 0, NULL, '2019-01-20 21:12:51.854000', 3, NULL, 'роо', 3, NULL, NULL, 'madruskor@gmail.com'),
(289, 2, '2019-01-20 21:12:53.163000', 0, NULL, '2019-01-20 21:12:53.163000', 3, NULL, 'шшш', 3, NULL, NULL, 'madruskor@gmail.com'),
(290, 2, '2019-01-20 21:12:54.354000', 0, NULL, '2019-01-20 21:12:54.354000', 3, NULL, 'ггш', 3, NULL, NULL, 'madruskor@gmail.com'),
(291, 2, '2019-01-20 21:12:56.907000', 0, NULL, '2019-01-20 21:12:56.907000', 3, NULL, 'ггг', 3, NULL, NULL, 'madruskor@gmail.com'),
(292, 2, '2019-01-20 21:12:58.746000', 0, NULL, '2019-01-20 21:12:58.746000', 3, NULL, 'урлунл', 3, NULL, NULL, 'madruskor@gmail.com'),
(293, 2, '2019-01-20 21:13:01.269000', 0, NULL, '2019-01-20 21:13:01.269000', 3, NULL, 'пулурлунл', 3, NULL, NULL, 'madruskor@gmail.com'),
(294, 2, '2019-01-20 21:13:03.108000', 0, NULL, '2019-01-20 21:13:03.108000', 3, NULL, 'пытыптвпт', 3, NULL, NULL, 'madruskor@gmail.com'),
(295, 2, '2019-01-20 21:13:07.413000', 0, NULL, '2019-01-20 21:13:07.413000', 3, NULL, '3нл3гон3он3оунь', 3, NULL, NULL, 'madruskor@gmail.com'),
(296, 2, '2019-01-20 21:13:09.517000', 0, NULL, '2019-01-20 21:13:09.517000', 3, NULL, 'уптупоунлуно', 3, NULL, NULL, 'madruskor@gmail.com'),
(297, 2, '2019-01-20 21:13:13.456000', 0, NULL, '2019-01-20 21:13:13.456000', 3, NULL, '6шнгераиаиаоаоеое', 3, NULL, NULL, 'madruskor@gmail.com'),
(298, 2, '2019-01-20 21:13:17.507000', 0, NULL, '2019-01-20 21:13:17.507000', 3, NULL, 'а че ты как отдыхаешь в детстве в детстве играл в футбол в футбол и в футбол играли ', 3, NULL, NULL, 'madruskor@gmail.com'),
(299, 2, '2019-01-20 21:13:27.217000', 0, NULL, '2019-01-20 21:13:27.217000', 3, NULL, 'а че ты как отдыхаешь в детстве в детстве играл ', 3, NULL, NULL, 'madruskor@gmail.com'),
(300, 2, '2019-01-20 21:13:57.534000', 0, NULL, '2019-01-20 21:13:57.534000', 3, NULL, 'оаоащаш', 3, NULL, NULL, 'madruskor@gmail.com'),
(301, 2, '2019-01-20 21:14:11.601000', 0, NULL, '2019-01-20 21:14:11.601000', 3, NULL, 'шащащашлаоалащаща', 3, NULL, NULL, 'madruskor@gmail.com'),
(302, 2, '2019-01-20 21:14:16.008000', 0, NULL, '2019-01-20 21:14:16.008000', 3, NULL, 'лащащклщещк', 3, NULL, NULL, 'madruskor@gmail.com'),
(303, 2, '2019-01-20 21:14:18.479000', 0, NULL, '2019-01-20 21:14:18.479000', 3, NULL, 'шашашшащалаллащк', 3, NULL, NULL, 'madruskor@gmail.com'),
(304, 2, '2019-01-20 21:15:25.287000', 0, NULL, '2019-01-20 21:15:25.287000', 3, NULL, 'а че ты как отдыхаешь в детстве в детстве играл в футбол в футбол и в футбол играли в футбол и в футбол играли в ', 3, NULL, NULL, 'madruskor@gmail.com'),
(305, 2, '2019-01-20 21:15:39.146000', 0, NULL, '2019-01-20 21:15:39.146000', 3, NULL, 'а че ты как отдыхаешь в детстве в детстве играл в футбол в футбол ', 3, NULL, NULL, 'madruskor@gmail.com'),
(306, 2, '2019-01-20 21:15:46.389000', 0, NULL, '2019-01-20 21:15:46.389000', 3, NULL, 'ну вот я уже в школу и не хочу ', 3, NULL, NULL, 'madruskor@gmail.com'),
(307, 2, '2019-01-20 21:15:51.783000', 0, NULL, '2019-01-20 21:15:51.783000', 3, NULL, 'ну вот я уже и не помню что там должно было ', 3, NULL, NULL, 'madruskor@gmail.com'),
(308, 2, '2019-01-20 21:22:48.095000', 0, NULL, '2019-01-20 21:22:48.095000', 2, NULL, 'ггг', 3, NULL, NULL, 'madruskor@gmail.com'),
(309, 2, '2019-01-20 21:22:51.935000', 0, NULL, '2019-01-20 21:22:51.935000', 2, NULL, 'ггг', 3, NULL, NULL, 'madruskor@gmail.com'),
(310, 2, '2019-01-20 21:22:58.474000', 0, NULL, '2019-01-20 21:22:58.474000', 2, NULL, 'ьддддд', 3, NULL, NULL, 'madruskor@gmail.com'),
(311, 2, '2019-01-20 21:23:24.734000', 0, NULL, '2019-01-20 21:23:24.734000', 3, NULL, 'тест', 3, NULL, NULL, 'madruskor@gmail.com'),
(312, 2, '2019-01-20 21:23:30.892000', 0, NULL, '2019-01-20 21:23:30.892000', 3, NULL, 'шшшш', 3, NULL, NULL, 'madruskor@gmail.com'),
(313, 2, '2019-01-20 21:24:08.825000', 0, NULL, '2019-01-20 21:24:08.825000', 3, NULL, 'шггггггг', 3, NULL, NULL, 'madruskor@gmail.com'),
(314, 2, '2019-01-20 21:25:04.835000', 0, NULL, '2019-01-20 21:25:04.835000', 3, NULL, '777', 3, NULL, NULL, 'madruskor@gmail.com'),
(315, 2, '2019-01-20 21:27:37.798000', 0, NULL, '2019-01-20 21:27:37.798000', 3, NULL, '6666', 3, NULL, NULL, 'madruskor@gmail.com'),
(316, 2, '2019-01-20 21:28:56.689000', 0, NULL, '2019-01-20 21:28:56.689000', 3, NULL, '123456789', 3, NULL, NULL, 'madruskor@gmail.com'),
(317, 2, '2019-01-20 21:32:42.791000', 0, NULL, '2019-01-20 21:32:42.791000', 3, NULL, '999888777', 3, NULL, NULL, 'madruskor@gmail.com'),
(318, 2, '2019-01-20 21:38:07.833000', 0, NULL, '2019-01-20 21:38:07.833000', 3, NULL, '888888', 3, NULL, NULL, 'madruskor@gmail.com'),
(319, 2, '2019-01-20 21:38:12.199000', 0, NULL, '2019-01-20 21:38:12.199000', 3, NULL, '637377373', 3, NULL, NULL, 'madruskor@gmail.com'),
(320, 2, '2019-01-20 21:38:15.610000', 0, NULL, '2019-01-20 21:38:15.610000', 3, NULL, 'лплплплпьешлелелел', 3, NULL, NULL, 'madruskor@gmail.com'),
(321, 2, '2019-01-20 21:38:21.387000', 0, NULL, '2019-01-20 21:38:21.387000', 3, NULL, 'ну вот и всё началось в конце недели в начале августа и в начале августа я буду в Киеве и буду ', 3, NULL, NULL, 'madruskor@gmail.com'),
(322, 2, '2019-01-20 21:39:18.291000', 0, NULL, '2019-01-20 21:39:18.291000', 3, NULL, 'тыщь', 3, NULL, NULL, 'madruskor@gmail.com'),
(323, 2, '2019-01-20 21:39:24.106000', 0, NULL, '2019-01-20 21:39:24.106000', 3, NULL, 'ололо', 3, NULL, NULL, 'madruskor@gmail.com'),
(324, 2, '2019-01-20 21:39:28.294000', 0, NULL, '2019-01-20 21:39:28.294000', 3, NULL, 'лвлвллвл', 3, NULL, NULL, 'madruskor@gmail.com'),
(325, 2, '2019-01-20 21:39:49.080000', 0, NULL, '2019-01-20 21:39:49.080000', 3, NULL, 'ьыщь', 3, NULL, NULL, 'madruskor@gmail.com'),
(326, 2, '2019-01-20 21:39:53.782000', 0, NULL, '2019-01-20 21:39:53.782000', 3, NULL, 'огого', 3, NULL, NULL, 'madruskor@gmail.com'),
(327, 2, '2019-01-20 21:53:28.095000', 0, NULL, '2019-01-20 21:53:28.095000', 3, NULL, 'лклклк', 3, NULL, NULL, 'madruskor@gmail.com'),
(328, 2, '2019-01-20 22:04:43.925000', 0, NULL, '2019-01-20 22:04:43.925000', 3, NULL, 'ттт', 3, NULL, NULL, 'madruskor@gmail.com'),
(329, 2, '2019-01-20 22:04:47.851000', 0, NULL, '2019-01-20 22:04:47.851000', 3, NULL, '888', 3, NULL, NULL, 'madruskor@gmail.com'),
(330, 2, '2019-01-20 22:04:50.221000', 0, NULL, '2019-01-20 22:04:50.221000', 3, NULL, '99', 3, NULL, NULL, 'madruskor@gmail.com'),
(331, 2, '2019-01-20 22:04:51.477000', 0, NULL, '2019-01-20 22:04:51.477000', 3, NULL, 'зщщ', 3, NULL, NULL, 'madruskor@gmail.com'),
(332, 2, '2019-01-20 22:04:53.198000', 0, NULL, '2019-01-20 22:04:53.198000', 3, NULL, 'щщ', 3, NULL, NULL, 'madruskor@gmail.com'),
(333, 2, '2019-01-20 22:04:54.228000', 0, NULL, '2019-01-20 22:04:54.228000', 3, NULL, 'щ', 3, NULL, NULL, 'madruskor@gmail.com'),
(334, 2, '2019-01-20 22:05:45.031000', 0, NULL, '2019-01-20 22:05:45.031000', 1, NULL, '7', 3, NULL, NULL, 'madruskor@gmail.com'),
(335, 2, '2019-01-20 22:06:42.749000', 0, NULL, '2019-01-20 22:06:42.749000', 3, NULL, '888', 3, NULL, NULL, 'madruskor@gmail.com');

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
(24, 0, 4, 2),
(25, 0, 2, 4),
(26, 0, 4, 4),
(27, 1, 3, 2);

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
(2, '2019-01-20 22:06:17.748000', 'madruskor@gmail.com', NULL, 0, '2019-01-20 22:06:17.748000', 'madruskor@gmail.com', '11111111', '999999', 3, 2, '/opt/tomcat/files/user_ava_photo/-3056001141546893429696filename'),
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
-- Индексы таблицы `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FKqhlj1ykctqe7mugseblqwhmj8` (`Type`),
  ADD KEY `FKcg5vbk59wl14pn5gcegsw17c6` (`Region`),
  ADD KEY `FKcmibhcrkk1s7r4iuiy1j7kmv7` (`Request`),
  ADD KEY `FK68qlfmuklctrvcl9u7ec8bm1h` (`CreateUser`),
  ADD KEY `FKs81o58jdbs9sl2hjqr1cad734` (`UserRx`);

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
-- AUTO_INCREMENT для таблицы `message`
--
ALTER TABLE `message`
  MODIFY `Id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=336;
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
  MODIFY `Id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
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
