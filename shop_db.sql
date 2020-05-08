-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Апр 28 2020 г., 13:29
-- Версия сервера: 10.1.36-MariaDB
-- Версия PHP: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `shop_db`
--

-- --------------------------------------------------------

--
-- Структура таблицы `devices`
--

CREATE TABLE `devices` (
  `id` int(11) NOT NULL,
  `model` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  `count1` int(11) NOT NULL,
  `cpu` varchar(255) NOT NULL,
  `ram` int(11) NOT NULL,
  `device_type` varchar(255) NOT NULL,
  `sold` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `devices`
--

INSERT INTO `devices` (`id`, `model`, `price`, `count1`, `cpu`, `ram`, `device_type`, `sold`) VALUES
(3, 'fdf', 1000, 2, 'corei7', 12, 'computer', 9),
(4, 'bbb', 5000, 20, 'corei5', 12, 'laptop', 2),
(5, 'hhh', 6000, 15, 'corei7', 1212, 'tablet', 5),
(12, 'bbb', 15000, 23, 'corei5', 12, 'laptop', 0),
(13, 'samat', 9000, 15, 'corei3', 12, 'laptop', 3),
(14, 'arman', 85000, 23, 'corei3', 12, 'computer', 0),
(16, 'Sultan', 6500, 20, 'corei3', 12, 'tablet', 2),
(17, 'Sultan', 6500, 20, 'corei3', 12, 'tablet', 0),
(18, 'Sultan', 6500, 20, 'corei3', 12, 'tablet', 0),
(19, 'Technica', 6500, 5, 'corei3', 12, 'tablet', 15),
(20, 'Electronics', 6500, 17, 'corei3', 12, 'tablet', 3),
(21, 'Electronics', 85000, 990, 'corei3', 12, 'laptop', 10);

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `fullname` varchar(255) NOT NULL,
  `role` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`id`, `login`, `password`, `fullname`, `role`) VALUES
(1, 'admin', 'admin', 'Administrator', 1),
(2, 'musa', '123', 'Uatbayev Musa', 2),
(3, 'dias', 'dias123', 'Mr.Dias', 2),
(4, 'erik', '789456', 'Erik Utemuratov', 2),
(5, 'Beka', '456456', 'Beka', 2),
(6, 'amina', '123456', 'Bolysova Amina', 2),
(7, 'nur', 'nur123', 'Nurakhmet', 2),
(8, 'bek', 'bek123', 'Bekzat', 2);

-- --------------------------------------------------------

--
-- Структура таблицы `users_buy`
--

CREATE TABLE `users_buy` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `good_type` varchar(255) NOT NULL,
  `count1` int(11) NOT NULL,
  `totalsum` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `users_buy`
--

INSERT INTO `users_buy` (`id`, `user_id`, `good_type`, `count1`, `totalsum`) VALUES
(1, 6, 'laptop', 4, 92),
(2, 6, 'tablet', 3, 2100),
(3, 6, 'laptop', 10, 230),
(4, 6, 'laptop', 1, 11111),
(5, 6, 'laptop', 2, 22222),
(6, 6, 'tablet', 5, 3500),
(7, 6, 'tablet', 5, 3500),
(8, 6, 'laptop', 5, 115),
(9, 6, 'laptop', 1, 23),
(10, 6, 'laptop', 1, 12),
(11, 6, 'laptop', 3, 69),
(12, 6, 'laptop', 3, 69),
(13, 7, 'tablet', 3, 19500),
(14, 7, 'laptop', 10, 850000),
(15, 7, 'computer', 9, 9000),
(16, 8, 'laptop', 2, 10000),
(17, 8, 'tablet', 15, 97500);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `devices`
--
ALTER TABLE `devices`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `users_buy`
--
ALTER TABLE `users_buy`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `devices`
--
ALTER TABLE `devices`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT для таблицы `users_buy`
--
ALTER TABLE `users_buy`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
