-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Feb 09, 2021 alle 16:47
-- Versione del server: 10.4.11-MariaDB
-- Versione PHP: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sicve_db`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `amministratore`
--

CREATE TABLE `amministratore` (
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `amministratore`
--

INSERT INTO `amministratore` (`username`, `password`) VALUES
('admin', 'admin'),
('a', 'a');

-- --------------------------------------------------------

--
-- Struttura della tabella `autoveicolo`
--

CREATE TABLE `autoveicolo` (
  `password` varchar(32) NOT NULL,
  `marca` varchar(32) NOT NULL,
  `modello` varchar(32) NOT NULL,
  `targa` varchar(7) NOT NULL,
  `telefono` varchar(16) NOT NULL,
  `sms` int(1) NOT NULL DEFAULT 0,
  `nome` varchar(32) NOT NULL,
  `cognome` varchar(32) NOT NULL,
  `cf` varchar(16) NOT NULL,
  `data_di_nascita` date NOT NULL,
  `via_piazza` varchar(64) NOT NULL,
  `civico` varchar(16) NOT NULL,
  `cap` varchar(5) NOT NULL,
  `citta` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `autoveicolo`
--

INSERT INTO `autoveicolo` (`password`, `marca`, `modello`, `targa`, `telefono`, `sms`, `nome`, `cognome`, `cf`, `data_di_nascita`, `via_piazza`, `civico`, `cap`, `citta`) VALUES
('a', 'a', 'a', 'a', 'a', 1, 'a', 'a', 'a', '2021-02-02', 'a', 'A/206', '80365', 'a'),
('123', 'opel', 'corsa', 'xx000xx', '3333333333', 0, 'francesco', 'mabilia', 'lcrgtn96c03f839z', '1996-03-03', 'Via luca giordano', 'A/206', '80136', 'Napoli');

-- --------------------------------------------------------

--
-- Struttura della tabella `autovelox`
--

CREATE TABLE `autovelox` (
  `id_autovelox` int(11) NOT NULL,
  `id_tratta` int(11) NOT NULL,
  `posizione_km` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `autovelox`
--

INSERT INTO `autovelox` (`id_autovelox`, `id_tratta`, `posizione_km`) VALUES
(1, 1, 15),
(2, 1, 16),
(3, 1, 19),
(1, 2, 60);

-- --------------------------------------------------------

--
-- Struttura della tabella `infrazione`
--

CREATE TABLE `infrazione` (
  `id_infrazione` int(3) NOT NULL,
  `id_tratta` int(11) NOT NULL,
  `id_autovelox` int(11) DEFAULT NULL,
  `descrizione` varchar(256) NOT NULL,
  `targa` varchar(7) NOT NULL,
  `velocita_istantanea` int(3) DEFAULT NULL,
  `velocita_media` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `infrazione`
--

INSERT INTO `infrazione` (`id_infrazione`, `id_tratta`, `id_autovelox`, `descrizione`, `targa`, `velocita_istantanea`, `velocita_media`) VALUES
(1, 1, 2, 'Superamento velocita massima della tratta', 'a', 1105, NULL);

-- --------------------------------------------------------

--
-- Struttura della tabella `percorrenza`
--

CREATE TABLE `percorrenza` (
  `id_percorrenza` int(11) NOT NULL,
  `orario_inizio` datetime NOT NULL,
  `orario_fine` datetime NOT NULL,
  `targa` varchar(7) NOT NULL,
  `id_tratta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `percorrenza`
--

INSERT INTO `percorrenza` (`id_percorrenza`, `orario_inizio`, `orario_fine`, `targa`, `id_tratta`) VALUES
(35, '2021-02-09 10:05:43', '2021-02-09 10:19:22', 'a', 1),
(36, '2021-02-09 10:26:15', '2021-02-09 10:43:05', 'a', 1),
(37, '2021-02-09 10:27:03', '2021-02-09 10:44:32', 'a', 1),
(38, '2021-02-09 11:39:06', '2021-02-09 11:52:27', 'a', 1),
(39, '2021-02-09 11:40:53', '2021-02-09 11:58:15', 'a', 1),
(40, '2021-02-09 11:45:32', '2021-02-09 12:01:03', 'a', 1),
(41, '2021-02-09 11:49:06', '2021-02-09 12:03:44', 'a', 1),
(42, '2021-02-09 11:55:29', '2021-02-09 12:07:33', 'a', 1),
(43, '2021-02-09 11:56:32', '2021-02-09 12:11:11', 'a', 1),
(44, '2021-02-09 11:59:17', '2021-02-09 12:13:27', 'a', 1),
(45, '2021-02-09 12:00:31', '2021-02-09 12:18:21', 'a', 1),
(46, '2021-02-09 12:41:42', '2021-02-09 12:58:44', 'a', 1),
(47, '2021-02-09 12:45:09', '2021-02-09 13:01:11', 'a', 1),
(48, '2021-02-09 12:50:11', '2021-02-09 13:05:53', 'a', 1),
(49, '2021-02-09 12:51:22', '2021-02-09 13:01:48', 'a', 3),
(50, '2021-02-09 12:52:35', '2021-02-09 12:58:50', 'a', 9);

-- --------------------------------------------------------

--
-- Struttura della tabella `percorrenza_autovelox`
--

CREATE TABLE `percorrenza_autovelox` (
  `id_percorrenza_autovelox` int(11) NOT NULL,
  `id_percorrenza` int(11) NOT NULL,
  `istante_rilevamento` datetime NOT NULL,
  `velocita` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `percorrenza_autovelox`
--

INSERT INTO `percorrenza_autovelox` (`id_percorrenza_autovelox`, `id_percorrenza`, `istante_rilevamento`, `velocita`) VALUES
(74, 35, '2021-02-09 10:05:43', 344),
(75, 35, '2021-02-09 10:05:43', 1085),
(76, 35, '2021-02-09 10:05:43', 419),
(77, 36, '2021-02-09 10:26:15', 122),
(78, 36, '2021-02-09 10:26:15', 727),
(79, 36, '2021-02-09 10:26:15', 188),
(80, 37, '2021-02-09 10:27:03', 100),
(81, 37, '2021-02-09 10:27:03', 338),
(82, 37, '2021-02-09 10:27:03', 565),
(83, 38, '2021-02-09 11:39:06', 82),
(84, 38, '2021-02-09 11:39:06', 1113),
(85, 38, '2021-02-09 11:39:06', 314),
(86, 39, '2021-02-09 11:40:53', 93),
(87, 39, '2021-02-09 11:40:53', 976),
(88, 39, '2021-02-09 11:40:53', 251),
(89, 40, '2021-02-09 11:45:32', 115),
(90, 40, '2021-02-09 11:45:32', 636),
(91, 40, '2021-02-09 11:45:32', 901),
(92, 41, '2021-02-09 11:49:06', 111),
(93, 41, '2021-02-09 11:49:06', 724),
(94, 41, '2021-02-09 11:49:06', 961),
(95, 42, '2021-02-09 11:55:29', 79),
(96, 42, '2021-02-09 11:55:29', 648),
(97, 42, '2021-02-09 11:55:29', 832),
(98, 43, '2021-02-09 11:56:32', 108),
(99, 43, '2021-02-09 11:56:32', 221),
(100, 43, '2021-02-09 11:56:32', 1110),
(101, 44, '2021-02-09 11:59:17', 90),
(102, 44, '2021-02-09 11:59:17', 398),
(103, 44, '2021-02-09 11:59:17', 934),
(104, 45, '2021-02-09 12:00:31', 82),
(105, 45, '2021-02-09 12:00:31', 922),
(106, 45, '2021-02-09 12:00:31', 975),
(107, 46, '2021-02-09 12:41:42', 93),
(108, 46, '2021-02-09 12:41:42', 1019),
(109, 46, '2021-02-09 12:41:42', 387),
(110, 47, '2021-02-09 12:45:09', 97),
(111, 47, '2021-02-09 12:45:09', 392),
(112, 47, '2021-02-09 12:45:09', 658),
(113, 48, '2021-02-09 12:50:11', 79),
(114, 48, '2021-02-09 12:50:11', 1105),
(115, 48, '2021-02-09 12:50:11', 429);

-- --------------------------------------------------------

--
-- Struttura della tabella `stazione`
--

CREATE TABLE `stazione` (
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `cap` varchar(5) NOT NULL,
  `comune` varchar(64) NOT NULL,
  `via_piazza` varchar(128) NOT NULL,
  `civico` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `stazione`
--

INSERT INTO `stazione` (`username`, `password`, `cap`, `comune`, `via_piazza`, `civico`) VALUES
('polizia', 'polizia', '80136', 'Napoli', 'Via Parthenope', '13'),
('p', 'p', 'p', 'Milano', 'c', 'c');

-- --------------------------------------------------------

--
-- Struttura della tabella `tratta`
--

CREATE TABLE `tratta` (
  `direzione` varchar(64) NOT NULL,
  `autostrada` varchar(5) NOT NULL,
  `velocita_minima` int(3) NOT NULL,
  `velocita_massima` int(3) NOT NULL,
  `kmTratta` int(5) NOT NULL,
  `id_tratta` int(11) NOT NULL,
  `comune` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `tratta`
--

INSERT INTO `tratta` (`direzione`, `autostrada`, `velocita_minima`, `velocita_massima`, `kmTratta`, `id_tratta`, `comune`) VALUES
('Milano-Bologna', 'A1', 80, 110, 24, 1, 'Milano'),
('Milano-Bologna', 'A1', 80, 110, 20, 2, 'Casale Dir Nord'),
('Bologna-Taranto', 'A14', 80, 110, 15, 3, 'Foggia Zona Industriale Dir Nord'),
('Milano-Napoli', 'A1', 80, 110, 30, 4, 'Caserta Nord Dir Sud'),
('Torino-Venezia', 'A4', 80, 110, 20, 5, 'Rovato Dir Est'),
('Genova-Serravalle', 'A7', 80, 110, 25, 6, 'Bolzaneto Dir Sud'),
('Milano-Varese', 'A8', 80, 110, 12, 7, 'Origgio Ovest Dir Sud'),
('Genova-Savona', 'A10', 80, 110, 40, 8, 'Albisola Dir Ovest'),
('Bologna-Padova', 'A13', 80, 110, 10, 9, 'Padova Sud Dir Sud'),
('Padova-Bologna', 'A13', 80, 110, 50, 10, 'Padova Sud Dir Sud'),
('Canosa-Bari-Taranto', 'A14', 80, 110, 40, 11, 'Bitonto Dir Sud'),
('Canosa-Napoli', 'A16', 50, 80, 28, 12, 'Baiano Dir Ovest'),
('Udine-Tarvisio', 'A23', 80, 110, 43, 13, 'Gemona Dir Nord'),
('Napoli-Canosa', 'A16', 50, 80, 40, 14, 'Avellino Ovest Dir Est'),
('Genova Voltri - Gravellona Toce', 'A26', 80, 110, 22, 15, 'Broglio Dir Nord');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `autoveicolo`
--
ALTER TABLE `autoveicolo`
  ADD PRIMARY KEY (`targa`);

--
-- Indici per le tabelle `autovelox`
--
ALTER TABLE `autovelox`
  ADD PRIMARY KEY (`id_autovelox`,`id_tratta`),
  ADD UNIQUE KEY `posizione_km` (`posizione_km`),
  ADD KEY `FK_IdTrattaAutovelox` (`id_tratta`);

--
-- Indici per le tabelle `infrazione`
--
ALTER TABLE `infrazione`
  ADD KEY `FK_IdInfrazione` (`id_autovelox`),
  ADD KEY `FK_Targa` (`targa`),
  ADD KEY `FK_IdTrattaI` (`id_tratta`);

--
-- Indici per le tabelle `percorrenza`
--
ALTER TABLE `percorrenza`
  ADD PRIMARY KEY (`id_percorrenza`),
  ADD KEY `FK_Targa_P` (`targa`),
  ADD KEY `FK_IdTrattaP` (`id_tratta`);

--
-- Indici per le tabelle `percorrenza_autovelox`
--
ALTER TABLE `percorrenza_autovelox`
  ADD PRIMARY KEY (`id_percorrenza_autovelox`),
  ADD KEY `FK_IdPercorrenza` (`id_percorrenza`);

--
-- Indici per le tabelle `tratta`
--
ALTER TABLE `tratta`
  ADD PRIMARY KEY (`id_tratta`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `percorrenza`
--
ALTER TABLE `percorrenza`
  MODIFY `id_percorrenza` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT per la tabella `percorrenza_autovelox`
--
ALTER TABLE `percorrenza_autovelox`
  MODIFY `id_percorrenza_autovelox` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=116;

--
-- AUTO_INCREMENT per la tabella `tratta`
--
ALTER TABLE `tratta`
  MODIFY `id_tratta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `autovelox`
--
ALTER TABLE `autovelox`
  ADD CONSTRAINT `FK_IdTrattaAutovelox` FOREIGN KEY (`id_tratta`) REFERENCES `tratta` (`id_tratta`);

--
-- Limiti per la tabella `infrazione`
--
ALTER TABLE `infrazione`
  ADD CONSTRAINT `FK_IdInfrazione` FOREIGN KEY (`id_autovelox`) REFERENCES `autovelox` (`id_autovelox`),
  ADD CONSTRAINT `FK_IdTrattaI` FOREIGN KEY (`id_tratta`) REFERENCES `tratta` (`id_tratta`),
  ADD CONSTRAINT `FK_Targa` FOREIGN KEY (`targa`) REFERENCES `autoveicolo` (`targa`);

--
-- Limiti per la tabella `percorrenza`
--
ALTER TABLE `percorrenza`
  ADD CONSTRAINT `FK_IdTrattaP` FOREIGN KEY (`id_tratta`) REFERENCES `tratta` (`id_tratta`),
  ADD CONSTRAINT `FK_Targa_P` FOREIGN KEY (`targa`) REFERENCES `autoveicolo` (`targa`);

--
-- Limiti per la tabella `percorrenza_autovelox`
--
ALTER TABLE `percorrenza_autovelox`
  ADD CONSTRAINT `FK_IdPercorrenza` FOREIGN KEY (`id_percorrenza`) REFERENCES `percorrenza` (`id_percorrenza`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
