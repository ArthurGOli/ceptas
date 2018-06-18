-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Máquina: localhost
-- Data de Criação: 18-Jun-2018 às 12:54
-- Versão do servidor: 5.5.28
-- versão do PHP: 5.3.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de Dados: `ceptas`
--
CREATE DATABASE IF NOT EXISTS `ceptas` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `ceptas`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `ani_animal`
--

CREATE TABLE IF NOT EXISTS `ani_animal` (
  `ani_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ani_especie` varchar(50) NOT NULL,
  `ani_nomePopular` varchar(50) NOT NULL,
  `ani_grupoTaxonomico` varchar(50) NOT NULL,
  `ani_sexo` enum('M','F','I') NOT NULL,
  `ani_idade` enum('juvenil','adulto','sub-adulto') NOT NULL,
  `ani_marcacao` varchar(100) NOT NULL,
  PRIMARY KEY (`ani_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Extraindo dados da tabela `ani_animal`
--

INSERT INTO `ani_animal` (`ani_id`, `ani_especie`, `ani_nomePopular`, `ani_grupoTaxonomico`, `ani_sexo`, `ani_idade`, `ani_marcacao`) VALUES
(1, 'cachorro', 'vira-lata', 'algum grupo', 'M', 'juvenil', ''),
(2, 'gatus felinus', 'gato branco', 'felino', 'F', 'sub-adulto', 'gato1'),
(3, 'Cavalus Pangarus', 'Cavalo', 'Pangare', 'I', 'adulto', 'cavalo1'),
(4, 'Ararus', 'Arara', 'Ave', 'M', 'juvenil', 'ARA-001'),
(5, 'Canino', 'Cachorro', 'Vira-Lata', 'I', 'adulto', 'DOG01');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pro_prontuario`
--

CREATE TABLE IF NOT EXISTS `pro_prontuario` (
  `pro_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ani_id` int(10) unsigned DEFAULT NULL,
  `pro_dtEntrada` date DEFAULT NULL,
  `pro_Apreensao` varchar(200) DEFAULT NULL,
  `pro_localizacao` varchar(200) DEFAULT NULL,
  `pro_diagnostico` varchar(200) DEFAULT NULL,
  `pro_descProcedimento` varchar(200) DEFAULT NULL,
  `pro_dtSaida` date DEFAULT NULL,
  PRIMARY KEY (`pro_id`),
  KEY `ani_id` (`ani_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Extraindo dados da tabela `pro_prontuario`
--

INSERT INTO `pro_prontuario` (`pro_id`, `ani_id`, `pro_dtEntrada`, `pro_Apreensao`, `pro_localizacao`, `pro_diagnostico`, `pro_descProcedimento`, `pro_dtSaida`) VALUES
(1, 1, '2016-11-16', 'Apreensão', 'Santos', 'diagnostico teste', 'operado', '2016-11-17'),
(2, 1, '2015-05-16', 'Resgate', 'Sao vicente', 'diagnostico teste', 'procedimento teste', '2015-11-17'),
(3, 3, '2015-01-20', 'Apreensão', 'Praia Grande', NULL, NULL, NULL),
(4, 1, '2017-07-01', 'Voluntária', 'Santos', 'Febre', 'Tylenol', '2017-07-02'),
(5, 1, '2017-05-01', 'Resgate', 'Santos', 'Perna Quebrada', 'Tylenol', '2017-12-01'),
(7, 2, '2017-06-07', 'Resgate', 'São Vicente', 'Febre', 'Teste', '2017-06-08'),
(9, 5, '2017-06-08', 'Voluntária', 'Santos', 'Orelha quebrada', 'Pontos', '2017-06-09');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usu_usuario`
--

CREATE TABLE IF NOT EXISTS `usu_usuario` (
  `usu_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `usu_login` varchar(20) NOT NULL,
  `usu_senha` varchar(30) NOT NULL,
  `usu_ativo` tinyint(1) NOT NULL,
  PRIMARY KEY (`usu_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;

--
-- Extraindo dados da tabela `usu_usuario`
--

INSERT INTO `usu_usuario` (`usu_id`, `usu_login`, `usu_senha`, `usu_ativo`) VALUES
(1, 'arthurgo', 'art123', 1),
(6, 'julio', 'julio123', 1),
(19, 'rocha', 'rocha123', 1);

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `pro_prontuario`
--
ALTER TABLE `pro_prontuario`
  ADD CONSTRAINT `pro_prontuario_ibfk_1` FOREIGN KEY (`ani_id`) REFERENCES `ani_animal` (`ani_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
