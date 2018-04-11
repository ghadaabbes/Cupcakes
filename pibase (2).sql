-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 11 avr. 2018 à 11:55
-- Version du serveur :  5.7.19
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `pibase`
--

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
CREATE TABLE IF NOT EXISTS `categorie` (
  `patisserie_id` int(11) DEFAULT NULL,
  `id_Categorie` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_Categorie`),
  KEY `IDX_497DD6341031BC6E` (`patisserie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`patisserie_id`, `id_Categorie`, `nom`) VALUES
(3, 1, 'gateaux d\'anniversaire'),
(10, 2, 'hello');

-- --------------------------------------------------------

--
-- Structure de la table `commandes`
--

DROP TABLE IF EXISTS `commandes`;
CREATE TABLE IF NOT EXISTS `commandes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `date` datetime NOT NULL,
  `prixtotal` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_35D4282CA76ED395` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

DROP TABLE IF EXISTS `commentaire`;
CREATE TABLE IF NOT EXISTS `commentaire` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idrecette` int(11) DEFAULT NULL,
  `iduser` int(11) DEFAULT NULL,
  `comment` longtext COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_67F068BC96BF31FE` (`idrecette`),
  KEY `IDX_67F068BC5E5C27E9` (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `commentaire`
--

INSERT INTO `commentaire` (`id`, `idrecette`, `iduser`, `comment`) VALUES
(2, 7, 5, 'Excellent recette! j\'adore'),
(3, 7, 5, 'c\'est délicieux'),
(4, 6, 5, 'Bonne recette'),
(5, 5, 5, 'superbe recette'),
(6, 2, 5, 'Magnifique recette'),
(7, 2, 5, 'uis le temps que je voulais la faire ! très bonne ! j ai mis moins de sucre ( cassonnade) dans la crème car j ai fait une pâte sucrée et j ai cuit 15 mn de plus en couvrant mes pommes vers la fin pour ne pas les brûler'),
(8, 3, 5, 'Super à faire au plus vite'),
(9, 3, 5, 'Tres bien gateaux.Excellence une photos '),
(10, 4, 5, 'Super à faire au plus vite'),
(11, 4, 5, 'Tres bien gateaux.Excellence une photo'),
(12, 2, 4, 'Merci bcp'),
(14, 26, 6, 'testtttttttttttt'),
(18, 13, 6, 'pffff'),
(29, 13, 6, 'modify test5'),
(30, 13, 6, 'modify test6'),
(39, 19, 6, 'mmmmmmmpppppp'),
(41, 13, 4, 'test'),
(44, 13, 5, 'test2'),
(47, 7, 6, 'Merci'),
(48, 3, 6, 'good'),
(49, 13, 6, 'abc'),
(51, 7, 48, 'test client 1'),
(52, 7, 50, 'client 2 test 1'),
(53, 7, 50, 'client 2 test2'),
(54, 7, 51, 'a'),
(55, 7, 51, 'ab'),
(56, 7, 51, 'abc');

-- --------------------------------------------------------

--
-- Structure de la table `evaluation`
--

DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE IF NOT EXISTS `evaluation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `patisserie_id` int(11) DEFAULT NULL,
  `mail` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `local` int(11) NOT NULL,
  `service` int(11) NOT NULL,
  `noteprix` int(11) NOT NULL,
  `noteproduit` int(11) NOT NULL,
  `decor` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_1323A5751031BC6E` (`patisserie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `fos_user`
--

DROP TABLE IF EXISTS `fos_user`;
CREATE TABLE IF NOT EXISTS `fos_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `username_canonical` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `email_canonical` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `salt` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_login` datetime DEFAULT NULL,
  `confirmation_token` varchar(180) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password_requested_at` datetime DEFAULT NULL,
  `roles` longtext COLLATE utf8_unicode_ci NOT NULL COMMENT '(DC2Type:array)',
  `firstname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lastname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_957A647992FC23A8` (`username_canonical`),
  UNIQUE KEY `UNIQ_957A6479A0D96FBF` (`email_canonical`),
  UNIQUE KEY `UNIQ_957A6479C05FB297` (`confirmation_token`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `fos_user`
--

INSERT INTO `fos_user` (`id`, `username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `last_login`, `confirmation_token`, `password_requested_at`, `roles`, `firstname`, `lastname`) VALUES
(4, 'Ahmed', 'ahmed', 'pidev57@gmail.com', 'pidev57@gmail.com', 1, NULL, '$2y$13$rZ4JJMdj0pZAfJsRYZn1auCwXUVQFUojY6QuGXvFCY2X9wU0f3T0S', '2018-02-28 20:12:51', NULL, NULL, 'a:1:{i:0;s:16:\"ROLE_RESPONSABLE\";}', NULL, NULL),
(5, 'Sirine', 'sirine', 'marwa.siala2017@gmail.com', 'marwa.siala2017@gmail.com', 1, NULL, '$2y$13$dKaN9wZNvpzQDjvkKvlsdO4fxqfaeVI9ukyOUuSJ6kpgaeeBEDgNq', '2018-03-01 10:00:21', NULL, NULL, 'a:1:{i:0;s:10:\"ROLE_ADMIN\";}', NULL, NULL),
(6, 'marwa', 'marwa', 'marwa.siala@esprit.tn', 'marwa.siala@esprit.tn', 1, NULL, '$2y$13$feGXBqr17r.kLJOamUeo7uz1OLQ93fYpLCicKmbPZ22BwkqGCvuVO', '2018-02-28 21:04:24', NULL, NULL, 'a:1:{i:0;s:11:\"ROLE_CLIENT\";}', NULL, NULL),
(7, 'siwar1', 'siwar1', 'siwar1@gmail.com', 'siwar1@gmail.com', 1, NULL, '$2y$13$Wo4AjAUC6wXJgvsPDR57AuGyyASe.ILgPCdUhRXYN5oLrTXCYXg/e', '2018-03-01 10:04:01', NULL, NULL, 'a:1:{i:0;s:16:\"ROLE_RESPONSABLE\";}', NULL, NULL),
(35, 'ClientTest', 'ClientTest', 'test@justfortry.com', 'test@justfortry.com', 1, NULL, '1234', NULL, NULL, NULL, 'a:1:{i:0;s:11:\"ROLE_CLIENT\";}', NULL, NULL),
(37, 'ABCDEFGH', 'ABCDEFGH', 'M.M@espt.tn', 'M.M@espt.tn', 1, NULL, '55', NULL, NULL, NULL, '	\na:1:{i:0;s:11:\"ROLE_CLIENT\";}', NULL, NULL),
(48, 'clients1', 'clients1', 'hello@justfortry.com', 'hello@justfortry.com', 1, NULL, '1234', NULL, NULL, NULL, 'a:1:{i:0;s:11:\"ROLE_CLIENT\";}', NULL, NULL),
(50, 'client2', 'client2', 'client2@justfortry.com', 'client2@justfortry.com', 1, NULL, '1234', NULL, NULL, NULL, 'a:1:{i:0;s:11:\"ROLE_CLIENT\";}', NULL, NULL),
(51, 'client3', 'client3', 'client3@justfortry.com', 'client3@justfortry.com', 1, NULL, '1234', NULL, NULL, NULL, 'a:1:{i:0;s:11:\"ROLE_CLIENT\";}', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `image`
--

DROP TABLE IF EXISTS `image`;
CREATE TABLE IF NOT EXISTS `image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `alt` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `image`
--

INSERT INTO `image` (`id`, `url`, `alt`) VALUES
(1, '10021019.jpg', ''),
(2, 'jpeg', '1519898894.jpeg');

-- --------------------------------------------------------

--
-- Structure de la table `ligne_commande`
--

DROP TABLE IF EXISTS `ligne_commande`;
CREATE TABLE IF NOT EXISTS `ligne_commande` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `commande` int(11) DEFAULT NULL,
  `produit` int(11) DEFAULT NULL,
  `quantite` int(11) NOT NULL,
  `prixp` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_3170B74B6EEAA67D` (`commande`),
  KEY `IDX_3170B74B29A5EC27` (`produit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `patisserie`
--

DROP TABLE IF EXISTS `patisserie`;
CREATE TABLE IF NOT EXISTS `patisserie` (
  `user` int(11) DEFAULT NULL,
  `idPatisserie` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `adresse` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `nomImage` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `note` decimal(7,2) NOT NULL,
  `altitude` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `longitude` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idPatisserie`),
  KEY `IDX_8941F5138D93D649` (`user`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `patisserie`
--

INSERT INTO `patisserie` (`user`, `idPatisserie`, `nom`, `adresse`, `description`, `nomImage`, `note`, `altitude`, `longitude`) VALUES
(7, 3, 'DELICIOUS', 'Adresse : La Soukra : 61 av Fattouma Bourguiba (Route de la soukra au niveau de l’UTC)\r\nEnnasr : C1 immeuble Ryadh Ennasr, Rue Chedly Ben Abdallah Ennasr 2', 'Pâtisserie DELICIOUS faite avec des ingrédients entiers, naturels et nourrissants et sans gluten, produits laitiers et sucre raffiné ,Livraison gratuite sur les offres qualifiées. Le livre de cuisine ultime pour tous ceux qui aiment cuisiner et expériment', 'téléchargement.jpg', '1.00', NULL, NULL),
(7, 6, 'hello', '123', '123', 'file:/C:/Users/Siala/Pictures/ask_food_pushen1.png', '0.00', NULL, NULL),
(7, 7, 'miau', '1', '1', 'file:/C:/Users/Siala/Pictures/ask_food_pushen1.png', '0.00', NULL, NULL),
(7, 8, 'miau', '1', '1', 'file:/C:/Users/Siala/Pictures/ask_food_pushen1.png', '0.00', NULL, NULL),
(7, 9, 'a', 'a', 'a', 'file:/C:/Users/Siala/Pictures/ask_food_pushen1.png', '0.00', NULL, NULL),
(7, 10, 'a', 'a', 'a', 'file:/C:/Users/Siala/Pictures/ask_food_pushen1.png', '0.00', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `idProduit` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `prix` double NOT NULL,
  `stock` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `nomImage` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Categorie_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProduit`),
  KEY `IDX_29A5EC27A4C43CD5` (`Categorie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`idProduit`, `nom`, `prix`, `stock`, `nomImage`, `Categorie_id`) VALUES
(1, 'Citron des neiges', 80, 'En stock', 'mscupcake2.jpg', 1),
(2, 'test', 10, 'EN STOCK', 'msValide1.png', 1),
(4, 'Citron des neiges', 80, 'En stock', 'mscupcake2.jpg', 1);

-- --------------------------------------------------------

--
-- Structure de la table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
CREATE TABLE IF NOT EXISTS `promotion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `produit_id` int(11) DEFAULT NULL,
  `patisserie_id` int(11) DEFAULT NULL,
  `image_id` int(11) DEFAULT NULL,
  `date_debut_promotion` date NOT NULL,
  `date_fin_promotion` date NOT NULL,
  `pourcentage` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_C11D7DD13DA5256D` (`image_id`),
  KEY `IDX_C11D7DD1F347EFB` (`produit_id`),
  KEY `IDX_C11D7DD11031BC6E` (`patisserie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `promotion`
--

INSERT INTO `promotion` (`id`, `produit_id`, `patisserie_id`, `image_id`, `date_debut_promotion`, `date_fin_promotion`, `pourcentage`) VALUES
(2, 1, 3, 2, '2018-03-02', '2018-03-03', 15);

-- --------------------------------------------------------

--
-- Structure de la table `recette`
--

DROP TABLE IF EXISTS `recette`;
CREATE TABLE IF NOT EXISTS `recette` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `iduser` int(11) DEFAULT NULL,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `type` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `nom_image` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cout` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `temps_preparation` time NOT NULL,
  `temps_repos` time NOT NULL,
  `temps_cuisson` time NOT NULL,
  `nb_personne` int(11) NOT NULL,
  `difficulte` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `astuces` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ingredients` longtext COLLATE utf8_unicode_ci NOT NULL,
  `etapes` longtext COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5` (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `recette`
--

INSERT INTO `recette` (`id`, `iduser`, `nom`, `type`, `description`, `nom_image`, `cout`, `temps_preparation`, `temps_repos`, `temps_cuisson`, `nb_personne`, `difficulte`, `astuces`, `ingredients`, `etapes`) VALUES
(2, 4, 'Fondant au chocolat', 'Chocolat', 'Découvrez la recette de Fondant au chocolat croustillant sur le dessus et fondant à l\'intérieur.', '946bbec2c2c2827bd9a7549c6210bb40.jpeg', 'Pas cher', '01:00:00', '00:50:00', '00:45:00', 4, 'Facile', 'Placez le sucre glace sur le dessus du gâteau une fois que celui-ci a totalement refroidi. À servir froid.', '200 g de chocolat noir\r\n150 g de beurre\r\n150 g de sucre en poudre\r\n50 g de farine\r\n3 oeufs', 'Commencez par sortir le beurre du réfrigérateur afin qu\'il ramollisse. Si vous avez oublié, il suffit de le passer au micro-ondes pendant une dizaine de secondes, il vous sera plus facile de le travailler par la suite.\r\n2\r\nDans une casserole, cassez le chocolat en morceaux auxquels vous ajoutez 3 cuillères à soupe d\'eau et mettez le tout à fondre à feu moyen au bain-marie (dans une casserole plus grande remplie d\'eau).\r\n3\r\nPendant ce temps, dans un saladier, vous travaillez, à l\'aide d\'une cuillère en bois, le beurre mou en pommade, auquel vous ajoutez le sucre en poudre. Continuez de remuer jusqu\'à ce que le mélange devienne léger et onctueux. Vous pouvez aussi vous aider d\'un batteur électrique, plus efficace pour obtenir la consistance désirée.'),
(3, 4, 'Opéra', 'Chocolat', 'de crème au beurre et de ganache au chocolat, recouvert de glaçage au chocolat. Un classique toujours apprécié !', '8be1a497ea8c0573371fa60e8cd65f35.jpeg', 'Pas cher', '00:50:00', '00:45:00', '01:00:00', 6, 'Medium', 'Quand l\'ensemble a suffisamment refroidi, le sortir du réfrigérateur puis le recouvrir d\'une partie de la ganache restante - Bien lisser à la spatule puis remettre au froid', 'Pour le biscuit :\r\n150 g de pâte d\'amandes blanche (50%)\r\n6 oeufs\r\n100 g de sucre cristal\r\n50 g de farine\r\nPour la crème au beurre :\r\n4 jaunes d\'oeufs\r\n100 g de sucre\r\n1 cuillère à soupe d\'extrait de café\r\n40 g d\'eau\r\n300 g de beurre doux\r\nPour la ganache :\r\n250 g de crème fleurette\r\n50 g de lait', 'Biscuit à opéra : Dans le mixer (cutter à lame) mettre la pâte d\'amandes coupées en dés, la farine et les jaunes d\'oeufs. Mixer environ 4 à 5 minutes jusqu\'à l\'obtention d\'un appareil homogène. Battre les blancs en neige ferme avec une pincée de sel en incorporant à mi-parcours le sucre cristal. Mélanger les blancs délicatement à l\'appareil précédent en soulevant délicatement la masse. Coucher l\'appareil sur une plaque de cuisson chemisée de papier sulfurisé et entreposer au réfrigérateur environ 30 minutes - Préchauffer le four à 230°C (thermostat 8) et cuire environ 7 minutes (jusqu\'à coloration) - Réserver.'),
(4, 4, 'Mousse chocolat', 'Chocolat', 'Découvrez la recette de Mousse au chocolat onctueuse et légère qui ravira tout les passionnés de chocolat,', 'f56bba6c11b88deaca9ce5779a24711d.jpeg', 'Pas cher', '00:40:00', '00:45:00', '00:30:00', 6, 'Difficile', 'Mettez au réfrigérateur pendant 1 heure puis répartissez la mousse dans 6 coupes à l\'aide d\'une poche à douille si vous en possédez une. Remettez au frais encore 1 heure minimum avant de servir.', '250 g de chocolat noir\r\n3 jaunes d\'oeufs\r\n6 blancs d\'oeufs\r\n40 g de sucre en poudre\r\n10 cl de crème fraîche liquide\r\n1 gousse de vanille', 'Cassez le chocolat en morceaux et faites-le fondre au bain-marie avec la crème.\r\n2\r\nHors de feu, ajoutez les graines de la gousse de vanille. Mélangez et laissez tiédir.\r\n3\r\nIncorporez les jaunes d\'oeufs en fouettant. Laissez refroidir complètement.\r\n4\r\nMontez les blancs en neige ferme avec une pincée de sel. À mi-parcours, versez le sucre.\r\n5\r\nIncorporez-les délicatement à la crème au chocolat en soulevant la préparation. La mousse doit être lisse, légère et homogène.'),
(5, 4, 'Gâteau au yaourt', 'Gateux et Entremets', 'Découvrez la recette du Gâteau au yaourt, le préféré des enfants. Un classique des premiers essais des pâtissiers en herbe.', 'c3d3aed12e6127218f70b068798f8c0e.jpeg', 'Adorable', '10:00:00', '01:20:00', '00:00:00', 8, 'Facile', '.', 'Dans cette recette le pot de yaourt sert de mesure :\r\n1 yaourt nature\r\n2 pots de sucre\r\n1 sachet de sucre vanillé\r\n3 pots de farine\r\n1/2 pot d\'huile\r\n3 œufs\r\n1/2 sachet de levure chimique\r\n1 pincée de sel', 'Allumer le four thermostat 5-6 (180°C). Beurrer un moule rond.\r\n2\r\nVerser le yaourt dans un saladier et ajouter dans l\'ordre en mélangeant bien avec une cuillère en bois : les sucres, les œufs un à un, la farine, la levure, le sel, l\'huile.\r\nPour finir\r\nMettre la préparation dans le moule beurré et faire cuire 35 minutes. Laisser refroidir et démouler.'),
(6, 4, 'Tiramissu', 'Gateux et Entremets', 'Découvrez la recette incontournable du Tiramisu, dessert italien crémeux et onctueux que personne ne veut jamais partager. À vos cuillères !', 'c540429009762db61654e71ccdcb6c2d.jpeg', 'Adorable', '00:50:00', '20:00:00', '03:30:00', 4, 'Medium', 'Étalez une couche de crème au mascarpone au fond du plat, puis placez une couche de biscuits légèrement imbibés de café à l\'Amaretto', '250 g de mascarpone\r\n3 oeufs\r\n100 g de sucre glace ou semoule\r\n20 cl de café fort\r\n2 cuillères à soupe d\'Amaretto (ou marsala ou rhum)\r\nune vingtaine de biscuits cuillères\r\npoudre de cacao amer ou copeaux de chocolat', 'Fouettez vivement 3 jaunes d\'œufs avec le sucre glace jusqu\'à ce que le mélange blanchisse et devienne mousseux. Ajoutez ensuite le mascarpone puis mélangez jusqu\'à ce que le résultat soit bien homogène.\r\n2\r\nMontez 3 blancs en neige ferme en y ajoutant une pincée de sel, puis mélangez-les à la crème au mascarpone. Attention, pour garder un mélange bien mousseux et léger, les blancs ne doivent pas être \"cassés\". Mélangez délicatement de haut en bas avec une spatule en silicone en tournant votre récipient d\'un quart de tour à chaque fois.\r\n3\r\nPréparez une grande tasse de café fort, de préférence un expresso. Ajoutez-y l\'Amaretto, un alcool italien à l\'amande qui parfumera incroyablement votre dessert, puis mélangez. Coupez le bout des biscuits afin qu\'ils adhèrent parfaitement à la paroi de votre plat. Utilisez les bouts pour compléter les trous au centre de votre tiramisu.'),
(7, 4, 'Cheesecake', 'Gateux et Entremets', 'Élevé au rang de dessert national au Etats-unis, le cheesecake fait de plus en plus d\'émule en France.', '0e548af048104711c81438025fa138e7.jpeg', 'Adorable', '00:50:00', '03:00:00', '01:00:00', 8, 'Difficile', 'Mettez le cheesecake à cuire à four préchauffé à 180°c pendant 45 minutes, puis laissez-le reposer à l\'intérieur du four éteint pendant encore une trentaine de minutes.', '250 grammes de speculoos\r\n500 grammes de ricotta (ou alors St-Morêt ou Carré frais)\r\n120 grammes de beurre\r\n120 grammes de crème fraîche épaisse\r\n120 grammes de sucre\r\n2 oeufs\r\nune cuillère à soupe d\'arome de vanille naturel', 'Émiettez les biscuits spéculoos ou bastogne à l\'aide d\'un robot mixeur ou d\'un rouleau à pâtisserie. Le but est d\'obtenir des miettes assez fines mais pas de la poudre. Faites fondre le beurre. Vous pouvez utiliser d\'autres types de biscuits, comme des cookies, des petits beurres ou des oreos par exemple.\r\n2\r\nDans un saladier, versez le beurre sur les miettes de biscuits et mélangez-les pour obtenir une pâte granuleuse. Versez cette pâte dans le fond d\'un moule à manquer recouvert d\'une feuille de papier sulfurisé. Répartissez l\'ensemble de façon homogène en faisant légèrement remonter les biscuits sur les bords. Laissez reposer au réfrigérateur pendant 30 minutes environ.\r\n3\r\nMélangez la ricotta avec les œufs légèrement battus, la crème fraîche épaisse, le sucre en poudre et une cuillère à soupe d\'arôme de vanille naturel.\r\nPour finir\r\nQuand le mélange est bien homogène, versez-le sur les biscuits.'),
(8, 5, 'Tarte aux fraises', 'Tartes', 'Une texture fondante et crémeuse, une tarte croustillante au goût d\'amandes caramélisées... une explosion de saveurs pour le palais.', '43cd495ea671af6846deadd4a859b28f.jpeg', 'assez cher', '02:00:00', '01:00:00', '00:50:00', 10, 'Facile', 'vif sans cesser de mélanger, jusqu\'à ce qu\'elles prennent une belle teinte acajou. Répartissez-les immédiatement à la surface de la tarte. Dégustez.', '1 pâte brisée ou sablée\r\n4 pommes\r\n120 g de sucre\r\n35 g de Maïzena\r\n3 jaunes d\'oeufs\r\n250 ml de lait\r\n2 cuillères à café de cannelle\r\nPour le croustillant :\r\n60 g d\'amandes effilées\r\n20 g de beurre\r\n2 cuillères à soupe bombées de sucre', 'Préchauffez le four à 200°C (thermostat 6). Foncez un moule à tarte beurré avec la pâte ou mettez du papier de cuisson.\r\n2\r\nPelez et épépinez les pommes, coupez-les en lamelles et disposez-les sur la pâte.\r\n3\r\nDans un saladier, mélangez les jaunes d\'oeufs avec le sucre, le lait, la Maïzena et la cannelle. Fouettez énergiquement. Versez sur les pommes.\r\n4\r\nFaites cuire 30 à 35 minutes selon les fours.\r\nPour finir\r\nUne fois la tarte cuite, préparez les amandes caramélisées : faites fondre le beurre dans une petite poêle, ajoutez le sucre puis les amandes et laissez-les cuire sur feu'),
(13, 6, 'test22220', 'Tartes', 'atest', NULL, 'Adorable', '00:00:01', '00:00:01', '00:00:01', 10, 'Facile', 'ab', 'ab', 'ab'),
(17, 6, 'testabcd', 'Cremes et Confitures', 'a', 'file:/C:/Users/Siala/Pictures/mini_pusheen_eating.png', 'Adorable', '10:00:00', '00:00:10', '00:00:00', 2, 'Medium', 'a', 'a', 'a'),
(18, 6, 'marwa', 'Tartes', 'a', 'file:/C:/Users/Siala/Pictures/mini_pusheen_eating.png', 'Pas cher', '00:00:00', '00:00:00', '00:00:00', -1, 'Facile', 'a', 'a', 'a'),
(19, 6, 'a', 'Chocolat', 'a', 'file:/C:/Users/Siala/Pictures/ask_food_pushen1.png', 'Adorable', '00:00:00', '00:00:00', '00:00:00', 10, 'Medium', 'a', 'a', 'a'),
(21, 6, 'l', 'Biscuits', 'm', 'file:/C:/Users/Siala/Pictures/ask_food_pushen5.png', 'Adorable', '00:00:00', '00:00:00', '00:00:00', 0, 'Facile', ':', ':', ':'),
(22, 6, 'a', 'Chocolat', '00:00:00', 'file:/C:/Users/Siala/AppData/Roaming/Microsoft/Windows/Network%20Shortcuts/Imagen1.png', 'Pas cher', '00:00:00', '00:00:00', '00:00:00', 5, 'Facile', '00:00:00', '00:00:00', '00:00:00'),
(24, 6, 'm', 'Diététiques', 'a', 'file:/C:/Users/Siala/Pictures/Sin%20título4.pdn', 'Pas cher', '22:22:22', '22:22:22', '22:22:22', 3, 'Facile', ':', ':', ':'),
(25, 6, 'xxxxxxxxxxxxxx', 'Cremes et Confitures', 'x', 'file:/C:/Users/Siala/AppData/Roaming/Microsoft/Windows/Network%20Shortcuts/Imagen1.png', 'Pas cher', '00:00:00', '00:00:00', '00:00:00', 7, 'Medium', '00:00:00', '00:00:00', '00:00:00'),
(26, 6, 'miau', 'Gateux et Entremets', '00:00:00', 'file:/C:/Users/Siala/Pictures/ask_food_pushen1.png', 'Adorable', '00:00:00', '00:00:00', '00:00:00', 2, 'Difficile', '5', '5', '00:00:00'),
(27, 6, 'testing', 'Biscuits', 'a', 'file:/C:/Users/Siala/AppData/Roaming/Microsoft/Windows/Network%20Shortcuts/Imagen1.png', 'Pas cher', '00:00:00', '00:00:00', '00:00:00', 5, 'Facile', 'l', 'ù', 'm'),
(28, 6, 'lm', 'Gateux et Entremets', 'a', 'file:/C:/Users/Siala/AppData/Roaming/Microsoft/Windows/Network%20Shortcuts/Imagen1.png', 'Pas cher', '00:00:00', '00:00:00', '00:00:00', 7, 'Facile', 'i', 'u', 'i'),
(29, 6, 'test', 'Chocolat', 'a', 'file:/C:/Users/Siala/AppData/Roaming/Microsoft/Windows/Network%20Shortcuts/Imagen1.png', 'Pas cher', '00:00:00', '00:00:00', '00:00:00', 5, 'Medium', 'a', 'a', 'a'),
(30, 6, 'hello this is marwa testing', 'Gateux et Entremets', 'a', 'file:/C:/Users/Siala/Pictures/Sin%20título4.pdn', 'Pas cher', '00:00:00', '00:00:00', '00:00:00', 7, 'Facile', '00:00:00', '00:00:00', '00:00:00'),
(31, 6, 'a', 'Biscuits', 'a', NULL, 'Pas cher', '00:00:12', '00:00:00', '11:11:11', 1, 'Facile', '2', 's', 's'),
(32, 6, 'Testing', 'Biscuits', 'a', 'file:/C:/Users/Siala/Pictures/ask_food_pushen1.png', 'Pas cher', '00:30:00', '00:20:20', '03:22:20', 2, 'Facile', 'u', 'u', 'u'),
(33, 6, 'hello', 'Traiteur(salé)', 'k', 'file:/C:/Users/Siala/Pictures/ask_food_pushen1.png', 'Pas cher', '12:12:13', '12:12:13', '12:12:13', 7, 'Facile', 'w', 'v', 'x'),
(34, 6, 'hello world', 'Biscuits', 'a', 'file:/C:/Users/Siala/Pictures/ask_food_pushen1.png', 'Pas cher', '11:11:44', '11:11:44', '11:11:44', 8, 'Facile', 'a', 'a', 'a'),
(35, 6, 'a', 'Gateux et Entremets', 'a', 'file:/C:/Users/Siala/Pictures/ask_food_pushen1.png', 'Pas cher', '11:22:33', '11:22:33', '11:22:33', 2, 'Facile', 'a', 'a', 'a'),
(36, 6, 'have a good dat ', 'Chocolat', 'x', 'file:/C:/Users/Siala/AppData/Roaming/Microsoft/Windows/Network%20Shortcuts/Imagen1.png', 'Pas cher', '11:22:33', '11:33:22', '01:30:00', 5, 'Facile', 'a', 'a', 'a'),
(37, 6, '123Miau', 'Biscuits', 'a', 'file:/C:/Users/Siala/Pictures/ask_food_pushen1.png', 'Pas cher', '00:20:00', '01:30:30', '00:45:00', 2, 'Facile', 'm', 'm', 'm'),
(38, 6, 'test10', 'Chocolat', 'a', 'file:/C:/Users/Siala/Pictures/ask_food_pushen5.png', 'assez cher', '01:02:03', '01:02:03', '01:02:03', 8, 'Medium', 'a', 'a', 'a'),
(39, 6, 'aj1', 'Chocolat', 'a', 'file:/C:/Users/Siala/Pictures/home2.png', 'Pas cher', '22:00:20', '00:55:55', '10:10:10', 7, 'Facile', '4', '4', '4');

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

DROP TABLE IF EXISTS `reclamation`;
CREATE TABLE IF NOT EXISTS `reclamation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `patisserie_id` int(11) DEFAULT NULL,
  `mail` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` longtext COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_CE6064041031BC6E` (`patisserie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `username_canonical` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `email_canonical` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `salt` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_login` datetime DEFAULT NULL,
  `confirmation_token` varchar(180) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password_requested_at` datetime DEFAULT NULL,
  `roles` longtext COLLATE utf8_unicode_ci NOT NULL COMMENT '(DC2Type:array)',
  `firstname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lastname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_8D93D64992FC23A8` (`username_canonical`),
  UNIQUE KEY `UNIQ_8D93D649A0D96FBF` (`email_canonical`),
  UNIQUE KEY `UNIQ_8D93D649C05FB297` (`confirmation_token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs_adresses`
--

DROP TABLE IF EXISTS `utilisateurs_adresses`;
CREATE TABLE IF NOT EXISTS `utilisateurs_adresses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `prenom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `telephone` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `cp` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `pays` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ville` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `complement` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_F4167640A76ED395` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `vote`
--

DROP TABLE IF EXISTS `vote`;
CREATE TABLE IF NOT EXISTS `vote` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idrecette` int(11) DEFAULT NULL,
  `rating` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_5A10856496BF31FE` (`idrecette`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `vote`
--

INSERT INTO `vote` (`id`, `idrecette`, `rating`) VALUES
(3, 7, 5),
(4, 7, 3),
(5, 7, 1),
(6, 7, 1),
(7, 6, 5),
(8, 6, 4),
(9, 5, 4),
(10, 2, 1),
(11, 3, 5),
(12, 4, 5),
(13, 4, 2),
(14, 2, 5),
(15, 4, 3),
(16, 13, 2),
(17, 13, 3),
(18, 13, 1),
(19, 13, 3),
(20, 2, 5),
(21, 3, 1),
(22, 2, 1),
(23, 2, 5),
(24, 2, 1),
(25, 2, 2),
(26, 2, 4),
(27, 2, 1),
(28, 2, 1),
(29, 2, 1),
(30, 2, 1),
(31, 2, 5),
(32, 2, 5);

-- --------------------------------------------------------

--
-- Structure de la table `wishlist`
--

DROP TABLE IF EXISTS `wishlist`;
CREATE TABLE IF NOT EXISTS `wishlist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `produit_id` int(11) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_9CE12A31F347EFB` (`produit_id`),
  KEY `IDX_9CE12A318D93D649` (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD CONSTRAINT `FK_497DD6341031BC6E` FOREIGN KEY (`patisserie_id`) REFERENCES `patisserie` (`idPatisserie`);

--
-- Contraintes pour la table `commandes`
--
ALTER TABLE `commandes`
  ADD CONSTRAINT `FK_35D4282CA76ED395` FOREIGN KEY (`user_id`) REFERENCES `fos_user` (`id`);

--
-- Contraintes pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD CONSTRAINT `FK_67F068BC5E5C27E9` FOREIGN KEY (`iduser`) REFERENCES `fos_user` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_67F068BC96BF31FE` FOREIGN KEY (`idrecette`) REFERENCES `recette` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `evaluation`
--
ALTER TABLE `evaluation`
  ADD CONSTRAINT `FK_1323A5751031BC6E` FOREIGN KEY (`patisserie_id`) REFERENCES `patisserie` (`idPatisserie`);

--
-- Contraintes pour la table `ligne_commande`
--
ALTER TABLE `ligne_commande`
  ADD CONSTRAINT `FK_3170B74B29A5EC27` FOREIGN KEY (`produit`) REFERENCES `produit` (`idProduit`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_3170B74B6EEAA67D` FOREIGN KEY (`commande`) REFERENCES `commandes` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `patisserie`
--
ALTER TABLE `patisserie`
  ADD CONSTRAINT `FK_8941F5138D93D649` FOREIGN KEY (`user`) REFERENCES `fos_user` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `produit`
--
ALTER TABLE `produit`
  ADD CONSTRAINT `FK_29A5EC27A4C43CD5` FOREIGN KEY (`Categorie_id`) REFERENCES `categorie` (`id_Categorie`);

--
-- Contraintes pour la table `promotion`
--
ALTER TABLE `promotion`
  ADD CONSTRAINT `FK_C11D7DD11031BC6E` FOREIGN KEY (`patisserie_id`) REFERENCES `patisserie` (`idPatisserie`),
  ADD CONSTRAINT `FK_C11D7DD13DA5256D` FOREIGN KEY (`image_id`) REFERENCES `image` (`id`),
  ADD CONSTRAINT `FK_C11D7DD1F347EFB` FOREIGN KEY (`produit_id`) REFERENCES `produit` (`idProduit`);

--
-- Contraintes pour la table `recette`
--
ALTER TABLE `recette`
  ADD CONSTRAINT `FK_49BB63905E5C27E9` FOREIGN KEY (`iduser`) REFERENCES `fos_user` (`id`);

--
-- Contraintes pour la table `reclamation`
--
ALTER TABLE `reclamation`
  ADD CONSTRAINT `FK_CE6064041031BC6E` FOREIGN KEY (`patisserie_id`) REFERENCES `patisserie` (`idPatisserie`);

--
-- Contraintes pour la table `utilisateurs_adresses`
--
ALTER TABLE `utilisateurs_adresses`
  ADD CONSTRAINT `FK_F4167640A76ED395` FOREIGN KEY (`user_id`) REFERENCES `fos_user` (`id`);

--
-- Contraintes pour la table `vote`
--
ALTER TABLE `vote`
  ADD CONSTRAINT `FK_5A10856496BF31FE` FOREIGN KEY (`idrecette`) REFERENCES `recette` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `wishlist`
--
ALTER TABLE `wishlist`
  ADD CONSTRAINT `FK_9CE12A318D93D649` FOREIGN KEY (`user`) REFERENCES `fos_user` (`id`),
  ADD CONSTRAINT `FK_9CE12A31F347EFB` FOREIGN KEY (`produit_id`) REFERENCES `produit` (`idProduit`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
