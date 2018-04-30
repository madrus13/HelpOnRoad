-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Апр 30 2018 г., 10:27
-- Версия сервера: 5.7.14
-- Версия PHP: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `mydb`
--

-- --------------------------------------------------------

--
-- Структура таблицы `achievement`
--

CREATE TABLE `achievement` (
  `Id` bigint(20) UNSIGNED NOT NULL,
  `Name` varchar(50) NOT NULL,
  `User` bigint(20) UNSIGNED ZEROFILL DEFAULT NULL,
  `IsDeleted` tinyint(1) DEFAULT NULL,
  `Type` bigint(20) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `achievement`
--

INSERT INTO `achievement` (`Id`, `Name`, `User`, `IsDeleted`, `Type`) VALUES
(3, 'ach1', 0000000009, NULL, 3);

-- --------------------------------------------------------

--
-- Структура таблицы `achievmenttype`
--

CREATE TABLE `achievmenttype` (
  `Id` bigint(20) UNSIGNED NOT NULL,
  `Name` varchar(50) NOT NULL,
  `IsDeleted` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `achievmenttype`
--

INSERT INTO `achievmenttype` (`Id`, `Name`, `IsDeleted`) VALUES
(1, '1-я помощь', NULL),
(2, 'Электрик 1-го уровня', NULL),
(3, 'type1', NULL),
(4, 'type2', NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `auto`
--

CREATE TABLE `auto` (
  `Id` bigint(20) UNSIGNED NOT NULL,
  `Name` varchar(50) NOT NULL,
  `HaveCable` tinyint(1) DEFAULT NULL,
  `User` bigint(20) UNSIGNED DEFAULT NULL,
  `IsDeleted` tinyint(1) DEFAULT NULL,
  `TransmissionType` bigint(20) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `message`
--

CREATE TABLE `message` (
  `Id` bigint(20) UNSIGNED NOT NULL,
  `Text` varchar(255) DEFAULT NULL,
  `CreationDate` timestamp NULL DEFAULT NULL,
  `ModifyDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `CreateUser` bigint(20) UNSIGNED ZEROFILL DEFAULT NULL,
  `MessagePhotoPath` varchar(100) DEFAULT NULL,
  `IsDeleted` tinyint(1) DEFAULT NULL,
  `Request` bigint(20) UNSIGNED DEFAULT NULL,
  `Type` bigint(20) UNSIGNED DEFAULT NULL,
  `Region` bigint(20) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `messagetype`
--

CREATE TABLE `messagetype` (
  `Id` bigint(20) UNSIGNED NOT NULL,
  `Name` varchar(50) NOT NULL,
  `IsDeleted` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `messagetype`
--

INSERT INTO `messagetype` (`Id`, `Name`, `IsDeleted`) VALUES
(1, 'broadcast', NULL),
(2, 'private', NULL),
(3, 'region', NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `region`
--

CREATE TABLE `region` (
  `Id` bigint(20) UNSIGNED NOT NULL,
  `Name` varchar(50) NOT NULL,
  `IsDeleted` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `region`
--

INSERT INTO `region` (`Id`, `Name`, `IsDeleted`) VALUES
(3, 'Izhevsk', NULL),
(4, 'Казань', NULL),
(5, 'name_0', NULL),
(6, 'name_1', NULL),
(7, 'name_2', NULL),
(8, 'name_3', NULL),
(9, 'name_4', NULL),
(10, 'name_5', NULL),
(11, 'name_6', NULL),
(12, 'name_7', NULL),
(13, 'name_8', NULL),
(14, 'name_9', NULL),
(15, 'name_10', NULL),
(16, 'name_11', NULL),
(17, 'name_12', NULL),
(18, 'name_13', NULL),
(19, 'name_14', NULL),
(20, 'name_15', NULL),
(21, 'name_16', NULL),
(22, 'name_17', NULL),
(23, 'name_18', NULL),
(24, 'name_19', NULL),
(25, 'name_20', NULL),
(26, 'name_21', NULL),
(27, 'name_22', NULL),
(28, 'name_23', NULL),
(29, 'name_24', NULL),
(30, 'name_25', NULL),
(31, 'name_26', NULL),
(32, 'name_27', NULL),
(33, 'name_28', NULL),
(34, 'name_29', NULL),
(35, 'name_30', NULL),
(36, 'name_31', NULL),
(37, 'name_32', NULL),
(38, 'name_33', NULL),
(39, 'name_34', NULL),
(40, 'name_35', NULL),
(41, 'name_36', NULL),
(42, 'name_37', NULL),
(43, 'name_38', NULL),
(44, 'name_39', NULL),
(45, 'name_40', NULL),
(46, 'name_41', NULL),
(47, 'name_42', NULL),
(48, 'name_43', NULL),
(49, 'name_44', NULL),
(50, 'name_45', NULL),
(51, 'name_46', NULL),
(52, 'name_47', NULL),
(53, 'name_48', NULL),
(54, 'name_49', NULL),
(55, 'name_50', NULL),
(56, 'name_51', NULL),
(57, 'name_52', NULL),
(58, 'name_53', NULL),
(59, 'name_54', NULL),
(60, 'name_55', NULL),
(61, 'name_56', NULL),
(62, 'name_57', NULL),
(63, 'name_58', NULL),
(64, 'name_59', NULL),
(65, 'name_60', NULL),
(66, 'name_61', NULL),
(67, 'name_62', NULL),
(68, 'name_63', NULL),
(69, 'name_64', NULL),
(70, 'name_65', NULL),
(71, 'name_66', NULL),
(72, 'name_67', NULL),
(73, 'name_68', NULL),
(74, 'name_69', NULL),
(75, 'name_70', NULL),
(76, 'name_71', NULL),
(77, 'name_72', NULL),
(78, 'name_73', NULL),
(79, 'name_74', NULL),
(80, 'name_75', NULL),
(81, 'name_76', NULL),
(82, 'name_77', NULL),
(83, 'name_78', NULL),
(84, 'name_79', NULL),
(85, 'name_80', NULL),
(86, 'name_81', NULL),
(87, 'name_82', NULL),
(88, 'name_83', NULL),
(89, 'name_84', NULL),
(90, 'name_85', NULL),
(91, 'name_86', NULL),
(92, 'name_87', NULL),
(93, 'name_88', NULL),
(94, 'name_89', NULL),
(95, 'name_90', NULL),
(96, 'name_91', NULL),
(97, 'name_92', NULL),
(98, 'name_93', NULL),
(99, 'name_94', NULL),
(100, 'name_95', NULL),
(101, 'name_96', NULL),
(102, 'name_97', NULL),
(103, 'name_98', NULL),
(104, 'name_99', NULL),
(105, 'name_100', NULL),
(106, 'name_101', NULL),
(107, 'name_102', NULL),
(108, 'name_103', NULL),
(109, 'name_104', NULL),
(110, 'name_105', NULL),
(111, 'name_106', NULL),
(112, 'name_107', NULL),
(113, 'name_108', NULL),
(114, 'name_109', NULL),
(115, 'name_110', NULL),
(116, 'name_111', NULL),
(117, 'name_112', NULL),
(118, 'name_113', NULL),
(119, 'name_114', NULL),
(120, 'name_115', NULL),
(121, 'name_116', NULL),
(122, 'name_117', NULL),
(123, 'name_118', NULL),
(124, 'name_119', NULL),
(125, 'name_120', NULL),
(126, 'name_121', NULL),
(127, 'name_122', NULL),
(128, 'name_123', NULL),
(129, 'name_124', NULL),
(130, 'name_125', NULL),
(131, 'name_126', NULL),
(132, 'name_127', NULL),
(133, 'name_128', NULL),
(134, 'name_129', NULL),
(135, 'name_130', NULL),
(136, 'name_131', NULL),
(137, 'name_132', NULL),
(138, 'name_133', NULL),
(139, 'name_134', NULL),
(140, 'name_135', NULL),
(141, 'name_136', NULL),
(142, 'name_137', NULL),
(143, 'name_138', NULL),
(144, 'name_139', NULL),
(145, 'name_140', NULL),
(146, 'name_141', NULL),
(147, 'name_142', NULL),
(148, 'name_143', NULL),
(149, 'name_144', NULL),
(150, 'name_145', NULL),
(151, 'name_146', NULL),
(152, 'name_147', NULL),
(153, 'name_148', NULL),
(154, 'name_149', NULL),
(155, 'name_150', NULL),
(156, 'name_151', NULL),
(157, 'name_152', NULL),
(158, 'name_153', NULL),
(159, 'name_154', NULL),
(160, 'name_155', NULL),
(161, 'name_156', NULL),
(162, 'name_157', NULL),
(163, 'name_158', NULL),
(164, 'name_159', NULL),
(165, 'name_160', NULL),
(166, 'name_161', NULL),
(167, 'name_162', NULL),
(168, 'name_163', NULL),
(169, 'name_164', NULL),
(170, 'name_165', NULL),
(171, 'name_166', NULL),
(172, 'name_167', NULL),
(173, 'name_168', NULL),
(174, 'name_169', NULL),
(175, 'name_170', NULL),
(176, 'name_171', NULL),
(177, 'name_172', NULL),
(178, 'name_173', NULL),
(179, 'name_174', NULL),
(180, 'name_175', NULL),
(181, 'name_176', NULL),
(182, 'name_177', NULL),
(183, 'name_178', NULL),
(184, 'name_179', NULL),
(185, 'name_180', NULL),
(186, 'name_181', NULL),
(187, 'name_182', NULL),
(188, 'name_183', NULL),
(189, 'name_184', NULL),
(190, 'name_185', NULL),
(191, 'name_186', NULL),
(192, 'name_187', NULL),
(193, 'name_188', NULL),
(194, 'name_189', NULL),
(195, 'name_190', NULL),
(196, 'name_191', NULL),
(197, 'name_192', NULL),
(198, 'name_193', NULL),
(199, 'name_194', NULL),
(200, 'name_195', NULL),
(201, 'name_196', NULL),
(202, 'name_197', NULL),
(203, 'name_198', NULL),
(204, 'name_199', NULL),
(205, 'name_200', NULL),
(206, 'name_201', NULL),
(207, 'name_202', NULL),
(208, 'name_203', NULL),
(209, 'name_204', NULL),
(210, 'name_205', NULL),
(211, 'name_206', NULL),
(212, 'name_207', NULL),
(213, 'name_208', NULL),
(214, 'name_209', NULL),
(215, 'name_210', NULL),
(216, 'name_211', NULL),
(217, 'name_212', NULL),
(218, 'name_213', NULL),
(219, 'name_214', NULL),
(220, 'name_215', NULL),
(221, 'name_216', NULL),
(222, 'name_217', NULL),
(223, 'name_218', NULL),
(224, 'name_219', NULL),
(225, 'name_220', NULL),
(226, 'name_221', NULL),
(227, 'name_222', NULL),
(228, 'name_223', NULL),
(229, 'name_224', NULL),
(230, 'name_225', NULL),
(231, 'name_226', NULL),
(232, 'name_227', NULL),
(233, 'name_228', NULL),
(234, 'name_229', NULL),
(235, 'name_230', NULL),
(236, 'name_231', NULL),
(237, 'name_232', NULL),
(238, 'name_233', NULL),
(239, 'name_234', NULL),
(240, 'name_235', NULL),
(241, 'name_236', NULL),
(242, 'name_237', NULL),
(243, 'name_238', NULL),
(244, 'name_239', NULL),
(245, 'name_240', NULL),
(246, 'name_241', NULL),
(247, 'name_242', NULL),
(248, 'name_243', NULL),
(249, 'name_244', NULL),
(250, 'name_245', NULL),
(251, 'name_246', NULL),
(252, 'name_247', NULL),
(253, 'name_248', NULL),
(254, 'name_249', NULL),
(255, 'name_250', NULL),
(256, 'name_251', NULL),
(257, 'name_252', NULL),
(258, 'name_253', NULL),
(259, 'name_254', NULL),
(260, 'name_255', NULL),
(261, 'name_256', NULL),
(262, 'name_257', NULL),
(263, 'name_258', NULL),
(264, 'name_259', NULL),
(265, 'name_260', NULL),
(266, 'name_261', NULL),
(267, 'name_262', NULL),
(268, 'name_263', NULL),
(269, 'name_264', NULL),
(270, 'name_265', NULL),
(271, 'name_266', NULL),
(272, 'name_267', NULL),
(273, 'name_268', NULL),
(274, 'name_269', NULL),
(275, 'name_270', NULL),
(276, 'name_271', NULL),
(277, 'name_272', NULL),
(278, 'name_273', NULL),
(279, 'name_274', NULL),
(280, 'name_275', NULL),
(281, 'name_276', NULL),
(282, 'name_277', NULL),
(283, 'name_278', NULL),
(284, 'name_279', NULL),
(285, 'name_280', NULL),
(286, 'name_281', NULL),
(287, 'name_282', NULL),
(288, 'name_283', NULL),
(289, 'name_284', NULL),
(290, 'name_285', NULL),
(291, 'name_286', NULL),
(292, 'name_287', NULL),
(293, 'name_288', NULL),
(294, 'name_289', NULL),
(295, 'name_290', NULL),
(296, 'name_291', NULL),
(297, 'name_292', NULL),
(298, 'name_293', NULL),
(299, 'name_294', NULL),
(300, 'name_295', NULL),
(301, 'name_296', NULL),
(302, 'name_297', NULL),
(303, 'name_298', NULL),
(304, 'name_299', NULL),
(305, 'name_300', NULL),
(306, 'name_301', NULL),
(307, 'name_302', NULL),
(308, 'name_303', NULL),
(309, 'name_304', NULL),
(310, 'name_305', NULL),
(311, 'name_306', NULL),
(312, 'name_307', NULL),
(313, 'name_308', NULL),
(314, 'name_309', NULL),
(315, 'name_310', NULL),
(316, 'name_311', NULL),
(317, 'name_312', NULL),
(318, 'name_313', NULL),
(319, 'name_314', NULL),
(320, 'name_315', NULL),
(321, 'name_316', NULL),
(322, 'name_317', NULL),
(323, 'name_318', NULL),
(324, 'name_319', NULL),
(325, 'name_320', NULL),
(326, 'name_321', NULL),
(327, 'name_322', NULL),
(328, 'name_323', NULL),
(329, 'name_324', NULL),
(330, 'name_325', NULL),
(331, 'name_326', NULL),
(332, 'name_327', NULL),
(333, 'name_328', NULL),
(334, 'name_329', NULL),
(335, 'name_330', NULL),
(336, 'name_331', NULL),
(337, 'name_332', NULL),
(338, 'name_333', NULL),
(339, 'name_334', NULL),
(340, 'name_335', NULL),
(341, 'name_336', NULL),
(342, 'name_337', NULL),
(343, 'name_338', NULL),
(344, 'name_339', NULL),
(345, 'name_340', NULL),
(346, 'name_341', NULL),
(347, 'name_342', NULL),
(348, 'name_343', NULL),
(349, 'name_344', NULL),
(350, 'name_345', NULL),
(351, 'name_346', NULL),
(352, 'name_347', NULL),
(353, 'name_348', NULL),
(354, 'name_349', NULL),
(355, 'name_350', NULL),
(356, 'name_351', NULL),
(357, 'name_352', NULL),
(358, 'name_353', NULL),
(359, 'name_354', NULL),
(360, 'name_355', NULL),
(361, 'name_356', NULL),
(362, 'name_357', NULL),
(363, 'name_358', NULL),
(364, 'name_359', NULL),
(365, 'name_360', NULL),
(366, 'name_361', NULL),
(367, 'name_362', NULL),
(368, 'name_363', NULL),
(369, 'name_364', NULL),
(370, 'name_365', NULL),
(371, 'name_366', NULL),
(372, 'name_367', NULL),
(373, 'name_368', NULL),
(374, 'name_369', NULL),
(375, 'name_370', NULL),
(376, 'name_371', NULL),
(377, 'name_372', NULL),
(378, 'name_373', NULL),
(379, 'name_374', NULL),
(380, 'name_375', NULL),
(381, 'name_376', NULL),
(382, 'name_377', NULL),
(383, 'name_378', NULL),
(384, 'name_379', NULL),
(385, 'name_380', NULL),
(386, 'name_381', NULL),
(387, 'name_382', NULL),
(388, 'name_383', NULL),
(389, 'name_384', NULL),
(390, 'name_385', NULL),
(391, 'name_386', NULL),
(392, 'name_387', NULL),
(393, 'name_388', NULL),
(394, 'name_389', NULL),
(395, 'name_390', NULL),
(396, 'name_391', NULL),
(397, 'name_392', NULL),
(398, 'name_393', NULL),
(399, 'name_394', NULL),
(400, 'name_395', NULL),
(401, 'name_396', NULL),
(402, 'name_397', NULL),
(403, 'name_398', NULL),
(404, 'name_399', NULL),
(405, 'name_400', NULL),
(406, 'name_401', NULL),
(407, 'name_402', NULL),
(408, 'name_403', NULL),
(409, 'name_404', NULL),
(410, 'name_405', NULL),
(411, 'name_406', NULL),
(412, 'name_407', NULL),
(413, 'name_408', NULL),
(414, 'name_409', NULL),
(415, 'name_410', NULL),
(416, 'name_411', NULL),
(417, 'name_412', NULL),
(418, 'name_413', NULL),
(419, 'name_414', NULL),
(420, 'name_415', NULL),
(421, 'name_416', NULL),
(422, 'name_417', NULL),
(423, 'name_418', NULL),
(424, 'name_419', NULL),
(425, 'name_420', NULL),
(426, 'name_421', NULL),
(427, 'name_422', NULL),
(428, 'name_423', NULL),
(429, 'name_424', NULL),
(430, 'name_425', NULL),
(431, 'name_426', NULL),
(432, 'name_427', NULL),
(433, 'name_428', NULL),
(434, 'name_429', NULL),
(435, 'name_430', NULL),
(436, 'name_431', NULL),
(437, 'name_432', NULL),
(438, 'name_433', NULL),
(439, 'name_434', NULL),
(440, 'name_435', NULL),
(441, 'name_436', NULL),
(442, 'name_437', NULL),
(443, 'name_438', NULL),
(444, 'name_439', NULL),
(445, 'name_440', NULL),
(446, 'name_441', NULL),
(447, 'name_442', NULL),
(448, 'name_443', NULL),
(449, 'name_444', NULL),
(450, 'name_445', NULL),
(451, 'name_446', NULL),
(452, 'name_447', NULL),
(453, 'name_448', NULL),
(454, 'name_449', NULL),
(455, 'name_450', NULL),
(456, 'name_451', NULL),
(457, 'name_452', NULL),
(458, 'name_453', NULL),
(459, 'name_454', NULL),
(460, 'name_455', NULL),
(461, 'name_456', NULL),
(462, 'name_457', NULL),
(463, 'name_458', NULL),
(464, 'name_459', NULL),
(465, 'name_460', NULL),
(466, 'name_461', NULL),
(467, 'name_462', NULL),
(468, 'name_463', NULL),
(469, 'name_464', NULL),
(470, 'name_465', NULL),
(471, 'name_466', NULL),
(472, 'name_467', NULL),
(473, 'name_468', NULL),
(474, 'name_469', NULL),
(475, 'name_470', NULL),
(476, 'name_471', NULL),
(477, 'name_472', NULL),
(478, 'name_473', NULL),
(479, 'name_474', NULL),
(480, 'name_475', NULL),
(481, 'name_476', NULL),
(482, 'name_477', NULL),
(483, 'name_478', NULL),
(484, 'name_479', NULL),
(485, 'name_480', NULL),
(486, 'name_481', NULL),
(487, 'name_482', NULL),
(488, 'name_483', NULL),
(489, 'name_484', NULL),
(490, 'name_485', NULL),
(491, 'name_486', NULL),
(492, 'name_487', NULL),
(493, 'name_488', NULL),
(494, 'name_489', NULL),
(495, 'name_490', NULL),
(496, 'name_491', NULL),
(497, 'name_492', NULL),
(498, 'name_493', NULL),
(499, 'name_494', NULL),
(500, 'name_495', NULL),
(501, 'name_496', NULL),
(502, 'name_497', NULL),
(503, 'name_498', NULL),
(504, 'name_499', NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `request`
--

CREATE TABLE `request` (
  `Id` bigint(20) UNSIGNED NOT NULL,
  `Description` varchar(45) DEFAULT NULL,
  `CreationDate` timestamp NULL DEFAULT NULL,
  `ModifyDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `CloseDate` timestamp NULL DEFAULT NULL,
  `IsResolvedByUser` tinyint(1) DEFAULT NULL,
  `RequestPhotoPath` varchar(100) DEFAULT NULL,
  `IsDeleted` tinyint(1) DEFAULT NULL,
  `User` bigint(20) UNSIGNED DEFAULT NULL,
  `CreationUser` bigint(20) UNSIGNED DEFAULT NULL,
  `Latitude` double DEFAULT NULL,
  `Longitude` double DEFAULT NULL,
  `Type` bigint(20) UNSIGNED DEFAULT NULL,
  `Status` bigint(20) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `requeststatus`
--

CREATE TABLE `requeststatus` (
  `Id` bigint(20) UNSIGNED NOT NULL,
  `Name` varchar(50) NOT NULL,
  `IsDeleted` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `requeststatus`
--

INSERT INTO `requeststatus` (`Id`, `Name`, `IsDeleted`) VALUES
(1, 'Open', NULL),
(2, 'Close', NULL),
(3, 'Unknown', NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `requesttype`
--

CREATE TABLE `requesttype` (
  `Id` bigint(20) UNSIGNED NOT NULL,
  `Name` varchar(50) NOT NULL,
  `IsDeleted` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `requesttype`
--

INSERT INTO `requesttype` (`Id`, `Name`, `IsDeleted`) VALUES
(4, 'Сдох акуммулятор', NULL),
(5, 'Не заводится', NULL),
(6, 'Застрял', NULL),
(7, 'Что то сломалось в машинке', NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `session`
--

CREATE TABLE `session` (
  `Id` bigint(20) UNSIGNED NOT NULL,
  `Token` varchar(50) NOT NULL,
  `CreationDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `User` bigint(20) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `session`
--

INSERT INTO `session` (`Id`, `Token`, `CreationDate`, `User`) VALUES
(1, 'D5B4DC0D765B553733264DDBAD7846B10F9487FA', NULL, 9),
(2, 'BCEFEE4736697D800CCA2866157D0CF7B509E778', NULL, 9),
(3, '0438BB180B2C521796012C85DE100662DAEA2938', NULL, 9);

-- --------------------------------------------------------

--
-- Структура таблицы `tool`
--

CREATE TABLE `tool` (
  `Id` bigint(20) UNSIGNED NOT NULL,
  `Type` bigint(20) UNSIGNED DEFAULT NULL,
  `User` bigint(20) UNSIGNED DEFAULT NULL,
  `IsDeleted` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `tooltypes`
--

CREATE TABLE `tooltypes` (
  `Id` bigint(20) UNSIGNED NOT NULL,
  `Name` varchar(50) NOT NULL,
  `IsDeleted` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `tooltypes`
--

INSERT INTO `tooltypes` (`Id`, `Name`, `IsDeleted`) VALUES
(1, 'Тросс', NULL),
(2, 'Огнетушитель', NULL),
(3, 'Провода', NULL),
(4, 'Инструменты', NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `transmissiontype`
--

CREATE TABLE `transmissiontype` (
  `Id` bigint(20) UNSIGNED NOT NULL,
  `Name` varchar(50) NOT NULL,
  `IsDeleted` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `transmissiontype`
--

INSERT INTO `transmissiontype` (`Id`, `Name`, `IsDeleted`) VALUES
(1, 'Механическая коробка', NULL),
(2, 'АКПП', NULL),
(3, 'Вариатор', NULL),
(4, 'Робот', NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `user`
--

CREATE TABLE `user` (
  `Id` bigint(20) UNSIGNED NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `UserPhotoPath` varchar(100) DEFAULT NULL,
  `Email` varchar(80) DEFAULT NULL,
  `IsApprovedUser` tinyint(1) DEFAULT NULL,
  `CreationDate` timestamp NULL DEFAULT NULL,
  `ModifyDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `IsDeleted` tinyint(1) DEFAULT NULL,
  `Status` bigint(20) UNSIGNED DEFAULT NULL,
  `Region` bigint(20) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `user`
--

INSERT INTO `user` (`Id`, `Name`, `Password`, `UserPhotoPath`, `Email`, `IsApprovedUser`, `CreationDate`, `ModifyDate`, `IsDeleted`, `Status`, `Region`) VALUES
(1, 'rus', 'pass', NULL, 'mad@bad.ru', NULL, NULL, '2018-04-14 16:44:50', NULL, 4, 3),
(2, 'madrus13', '231234', NULL, 'notbad@kasd.ru', NULL, NULL, '2018-04-14 16:45:14', NULL, NULL, NULL),
(3, 'ololoshka123', 'pass123', NULL, NULL, NULL, NULL, '2018-04-15 09:29:00', NULL, NULL, NULL),
(4, 'ololoshka432', 'pass123', NULL, NULL, NULL, NULL, '2018-04-15 09:29:00', NULL, NULL, NULL),
(8, 'ololo', '67456', NULL, NULL, NULL, NULL, '2018-04-15 09:29:00', NULL, NULL, NULL),
(9, 'test', 'pass', NULL, NULL, NULL, '2018-04-27 18:36:01', '2018-04-27 18:36:01', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `userstatus`
--

CREATE TABLE `userstatus` (
  `Id` bigint(20) UNSIGNED NOT NULL,
  `Name` varchar(50) NOT NULL,
  `IsDeleted` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `userstatus`
--

INSERT INTO `userstatus` (`Id`, `Name`, `IsDeleted`) VALUES
(1, 'admin', NULL),
(2, 'common', NULL),
(4, 'Non-active', NULL);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `achievement`
--
ALTER TABLE `achievement`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Id_UNIQUE` (`Id`),
  ADD KEY `fk_achievement_achievmenttype1_idx` (`Type`);

--
-- Индексы таблицы `achievmenttype`
--
ALTER TABLE `achievmenttype`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Id_UNIQUE` (`Id`);

--
-- Индексы таблицы `auto`
--
ALTER TABLE `auto`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Id_UNIQUE` (`Id`),
  ADD KEY `fk_auto_user1_idx` (`User`),
  ADD KEY `fk_auto_transmissiontype1_idx` (`TransmissionType`);

--
-- Индексы таблицы `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Id_UNIQUE` (`Id`),
  ADD KEY `fk_message_messagetype1_idx` (`Type`),
  ADD KEY `fk_message_region1_idx` (`Region`),
  ADD KEY `fk_message_user1_idx` (`CreateUser`),
  ADD KEY `fk_message_request1_idx` (`Request`);

--
-- Индексы таблицы `messagetype`
--
ALTER TABLE `messagetype`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Id_UNIQUE` (`Id`);

--
-- Индексы таблицы `region`
--
ALTER TABLE `region`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Id_UNIQUE` (`Id`);

--
-- Индексы таблицы `request`
--
ALTER TABLE `request`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Id_UNIQUE` (`Id`),
  ADD KEY `fk_request_requesttype1_idx` (`Type`),
  ADD KEY `fk_request_requeststatus1_idx` (`Status`),
  ADD KEY `fk_request_user1_idx` (`User`),
  ADD KEY `fk_request_user2_idx` (`CreationUser`);

--
-- Индексы таблицы `requeststatus`
--
ALTER TABLE `requeststatus`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Id_UNIQUE` (`Id`);

--
-- Индексы таблицы `requesttype`
--
ALTER TABLE `requesttype`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Id_UNIQUE` (`Id`);

--
-- Индексы таблицы `session`
--
ALTER TABLE `session`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Id_UNIQUE` (`Id`),
  ADD KEY `fk_session_user1_idx` (`User`);

--
-- Индексы таблицы `tool`
--
ALTER TABLE `tool`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Id_UNIQUE` (`Id`),
  ADD KEY `fk_tool_tooltypes1_idx` (`Type`),
  ADD KEY `fk_tool_user1_idx` (`User`);

--
-- Индексы таблицы `tooltypes`
--
ALTER TABLE `tooltypes`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Id_UNIQUE` (`Id`);

--
-- Индексы таблицы `transmissiontype`
--
ALTER TABLE `transmissiontype`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Id_UNIQUE` (`Id`);

--
-- Индексы таблицы `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Id_UNIQUE` (`Id`),
  ADD UNIQUE KEY `Name_UNIQUE` (`Name`),
  ADD KEY `fk_user_userstatus_idx` (`Status`),
  ADD KEY `fk_user_region1_idx` (`Region`);

--
-- Индексы таблицы `userstatus`
--
ALTER TABLE `userstatus`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Id_UNIQUE` (`Id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `achievement`
--
ALTER TABLE `achievement`
  MODIFY `Id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT для таблицы `achievmenttype`
--
ALTER TABLE `achievmenttype`
  MODIFY `Id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT для таблицы `auto`
--
ALTER TABLE `auto`
  MODIFY `Id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблицы `message`
--
ALTER TABLE `message`
  MODIFY `Id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблицы `messagetype`
--
ALTER TABLE `messagetype`
  MODIFY `Id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT для таблицы `region`
--
ALTER TABLE `region`
  MODIFY `Id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=505;
--
-- AUTO_INCREMENT для таблицы `request`
--
ALTER TABLE `request`
  MODIFY `Id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблицы `requeststatus`
--
ALTER TABLE `requeststatus`
  MODIFY `Id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT для таблицы `requesttype`
--
ALTER TABLE `requesttype`
  MODIFY `Id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT для таблицы `session`
--
ALTER TABLE `session`
  MODIFY `Id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT для таблицы `tool`
--
ALTER TABLE `tool`
  MODIFY `Id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблицы `tooltypes`
--
ALTER TABLE `tooltypes`
  MODIFY `Id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT для таблицы `transmissiontype`
--
ALTER TABLE `transmissiontype`
  MODIFY `Id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT для таблицы `user`
--
ALTER TABLE `user`
  MODIFY `Id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT для таблицы `userstatus`
--
ALTER TABLE `userstatus`
  MODIFY `Id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `achievement`
--
ALTER TABLE `achievement`
  ADD CONSTRAINT `fk_achievement_achievmenttype1` FOREIGN KEY (`Type`) REFERENCES `achievmenttype` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ограничения внешнего ключа таблицы `auto`
--
ALTER TABLE `auto`
  ADD CONSTRAINT `fk_auto_transmissiontype1` FOREIGN KEY (`TransmissionType`) REFERENCES `transmissiontype` (`Id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_auto_user1` FOREIGN KEY (`User`) REFERENCES `user` (`Id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `fk_message_messagetype1` FOREIGN KEY (`Type`) REFERENCES `messagetype` (`Id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_message_region1` FOREIGN KEY (`Region`) REFERENCES `region` (`Id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_message_request1` FOREIGN KEY (`Request`) REFERENCES `request` (`Id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_message_user1` FOREIGN KEY (`CreateUser`) REFERENCES `user` (`Id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `request`
--
ALTER TABLE `request`
  ADD CONSTRAINT `fk_request_requeststatus1` FOREIGN KEY (`Status`) REFERENCES `requeststatus` (`Id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_request_requesttype1` FOREIGN KEY (`Type`) REFERENCES `requesttype` (`Id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_request_user1` FOREIGN KEY (`User`) REFERENCES `user` (`Id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_request_user2` FOREIGN KEY (`CreationUser`) REFERENCES `user` (`Id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `session`
--
ALTER TABLE `session`
  ADD CONSTRAINT `fk_session_user1` FOREIGN KEY (`User`) REFERENCES `user` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `tool`
--
ALTER TABLE `tool`
  ADD CONSTRAINT `fk_tool_tooltypes1` FOREIGN KEY (`Type`) REFERENCES `tooltypes` (`Id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_tool_user1` FOREIGN KEY (`User`) REFERENCES `user` (`Id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `fk_user_region1` FOREIGN KEY (`Region`) REFERENCES `region` (`Id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_user_userstatus` FOREIGN KEY (`Status`) REFERENCES `userstatus` (`Id`) ON DELETE SET NULL ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
