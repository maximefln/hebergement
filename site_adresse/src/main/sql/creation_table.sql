DROP TABLE adresse;
DROP TABLE commentaire;
DROP TABLE recommandation;
DROP TABLE message;
DROP TABLE membre;


CREATE TABLE adresse(
	`id` INT NOT NULL AUTO_INCREMENT,
	 `date_ajout` date NOT NULL,
  `Nom` VARCHAR(50) NOT NULL,
	`Type` VARCHAR(50) NOT NULL,
     `presentation` VARCHAR(50) NOT NULL,
    `Visiteur` VARCHAR(50) NOT NULL,
  `coordonnee_x` DOUBLE NOT NULL,
  `coordonnee_y` DOUBLE NOT NULL,
  `lien_image` VARCHAR(100),
  `lien_image_accueil` VARCHAR(100),
	`note` DOUBLE NULL DEFAULT 0,
    `nb_like` INT NULL DEFAULT 0,
    `nbdislike` INT NULL DEFAULT 0,
  PRIMARY KEY (`id`));

CREATE TABLE commentaire(
	`id` INT NOT NULL AUTO_INCREMENT,
	`date` DATE NULL,
	 `nom` VARCHAR(50) NOT NULL,
	 `prenom` VARCHAR(50) NOT NULL,
	 `commentaire` VARCHAR(500) NOT NULL,
	 `id_article` INT NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE recommandation(
  `id` INT NOT NULL AUTO_INCREMENT,
  `Nom` VARCHAR(50) NOT NULL,
  `prenom` VARCHAR(50) NOT NULL,
  `mail` VARCHAR(50) NOT NULL,
  `adresse` VARCHAR(50) NOT NULL,
  `type` VARCHAR(50) NOT NULL,
  `rue` VARCHAR (80) NOT NULL,
  `numero` INT NOT NULL,
  `Ville` VARCHAR (50),
  PRIMARY KEY  (`id`));

CREATE TABLE message(
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NULL,
  `Nom` VARCHAR(50) NOT NULL,
  `prenom` VARCHAR(50) NOT NULL,
  `adresse_mail` VARCHAR(50) NOT NULL,
  `message` VARCHAR(800) NOT NULL,
  PRIMARY KEY  (`id`));

CREATE TABLE membre(
  `id` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(50) NOT NULL,
  `prenom` VARCHAR(50) NOT NULL,
  `fonction` VARCHAR(50) NOT NULL,
  `lien_image` VARCHAR(200) NOT NULL,
  PRIMARY KEY  (`id`));

ALTER TABLE adresse AUTO_INCREMENT=0;
ALTER TABLE commentaire AUTO_INCREMENT=0;
ALTER TABLE recommandation AUTO_INCREMENT=0;
ALTER TABLE message AUTO_INCREMENT=0;
ALTER TABLE membre AUTO_INCREMENT=0;

INSERT INTO membre(nom, prenom, fonction, lien_image) VALUES ('FILLION', 'Maxime', 'Président', 'img/equipe/maxime.jpg');
INSERT INTO membre(nom, prenom, fonction, lien_image) VALUES ('LANFRANCHI', 'Vincent', 'Vice-Président', 'img/equipe/vincent.jpg');
INSERT INTO membre(nom, prenom, fonction, lien_image) VALUES ('BILLON', 'Marie-Caroline', 'Secrétaire', 'img/equipe/marie_caroline.jpg');
INSERT INTO membre(nom, prenom, fonction, lien_image) VALUES ('NAVELLOU', 'Sarah', 'Trésorière', 'img/equipe/sarah.jpg');
INSERT INTO membre(nom, prenom, fonction, lien_image) VALUES ('STRANGE', 'Nicolas', 'Responsable Communication', 'img/equipe/nicolas.jpg');
INSERT INTO membre(nom, prenom, fonction, lien_image) VALUES ('MOUQUET', 'Lise', 'Communication', 'img/equipe/lise.jpg');
INSERT INTO membre(nom, prenom, fonction, lien_image) VALUES ('GAS', 'Louis', 'Communication', 'img/equipe/louis.jpg');
INSERT INTO membre(nom, prenom, fonction, lien_image) VALUES ('AUBRY', 'Sébastien', 'Responsable sponsors', 'img/equipe/sebastien.jpg');
INSERT INTO membre(nom, prenom, fonction, lien_image) VALUES ('COSTEAU', 'Martin', 'sponsors', 'img/equipe/martin.jpg');
INSERT INTO membre(nom, prenom, fonction, lien_image) VALUES ('LOPES', 'Alexandre', 'Responsable Recrutement', 'img/equipe/alexandre.jpg');

INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-01', 'La Luck', 'bar', 'L\'Antre du gaming Lillois', 'Maxime Fillion', 50.6462, 3.05978, 'img/articles/la_luck.jpg', 'test', 4, 0, 0);
INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-02', 'Bibovino', 'bar', 'Description à venir', 'Maxime Fillion', 50.641169, 3.06147, 'img/articles/bibovino.jpg', 'test', 3, 0, 0);
INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-03', 'La Capsule', 'bar', 'Description à venir', 'Maxime Fillion', 50.640498, 3.060141, 'img/articles/la_capsule.jpg', 'img/accueil/la_capsule.jpg', 4, 0, 0);
INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-04', 'Le Point de Départ', 'bar', 'Description à venir', 'Maxime Fillion', 50.634885, 3.047588, 'img/articles/le_point_de_depart.jpg', 'img/accueil/le_point_de_depart.jpg', 3, 0, 0);
INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-05', 'La part des anges', 'bar', 'Description à venir', 'Maxime Fillion', 50.64148, 3.062211, 'img/articles/la_part_des_anges.jpg', 'img/accueil/la_part_des_anges.JPG', 4, 0, 0);
INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-06', 'L\'Adresse', 'restaurant', 'Description à venir', 'Maxime Fillion', 50.637879, 3.058189, 'img/articles/l_adresse.jpg', 'img/accueil/adresse.jpg', 4, 0, 0);
INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-07', 'T\'Rijsel', 'restaurant', 'Description à venir', 'Maxime Fillion', 50.642121, 3.065889, 'img/articles/t_rijsel.jpg', 'img/accueil/t_rijsel.jpg', 4, 0, 0);
INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-08', 'Le Pot Beaujolais', 'restaurant', 'Description à venir', 'Maxime Fillion', 50.63656, 3.065094, 'img/articles/le_pot_beaujolais.jpg', 'img/accueil/le_pot_beaujolais.jpg', 4, 0, 0);
INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-06', 'L\'Adresse', 'musee', 'Description à venir', 'Maxime Fillion', 50.637879, 3.058189, 'img/articles/l_adresse.jpg', 'img/accueil/adresse.jpg', 4, 0, 0);
INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-07', 'T\'Rijsel', 'musee', 'Description à venir', 'Maxime Fillion', 50.642121, 3.065889, 'img/articles/t_rijsel.jpg', 'img/accueil/t_rijsel.jpg', 4, 0, 0);
INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-08', 'Le pot beaujolais', 'musee', 'Description à venir', 'Maxime Fillion', 50.63656, 3.065094, 'img/articles/le_pot_beaujolais.jpg', 'img/accueil/le_pot_beaujolais.jpg', 4, 0, 0);

INSERT INTO commentaire(`date`, `nom`, `prenom`, `commentaire`, `id_article`)  VALUES ('2018-02-01', 'Dupuis', 'Paul', 'Vraiment très intéréssant cet article', 1);
INSERT INTO commentaire(`date`, `nom`, `prenom`, `commentaire`, `id_article`)  VALUES ('2018-02-01', 'Dupuis', 'Paul', 'Vraiment très intéréssant cet article', 1);
INSERT INTO commentaire(`date`, `nom`, `prenom`, `commentaire`, `id_article`)  VALUES ('2018-02-01', 'Dupuis', 'Paul', 'Vraiment très intéréssant cet article', 1);
INSERT INTO commentaire(`date`, `nom`, `prenom`, `commentaire`, `id_article`)  VALUES ('2018-02-01', 'Dupuis', 'Paul', 'Vraiment très intéréssant cet article', 2);
INSERT INTO commentaire(`date`, `nom`, `prenom`, `commentaire`, `id_article`)  VALUES ('2018-02-01', 'Dupuis', 'Paul', 'Vraiment très intéréssant cet article', 2);
INSERT INTO commentaire(`date`, `nom`, `prenom`, `commentaire`, `id_article`)  VALUES ('2018-02-01', 'Dupuis', 'Paul', 'Vraiment très intéréssant cet article', 2);

INSERT INTO commentaire(`date`, `nom`, `prenom`, `commentaire`, `id_article`)  VALUES ('2018-02-01', 'Dupuis', 'Paul', 'Vraiment très intéréssant cet article', 6);
INSERT INTO commentaire(`date`, `nom`, `prenom`, `commentaire`, `id_article`)  VALUES ('2018-02-01', 'Dupuis', 'Paul', 'Vraiment très intéréssant cet article', 6);
INSERT INTO commentaire(`date`, `nom`, `prenom`, `commentaire`, `id_article`)  VALUES ('2018-02-01', 'Dupuis', 'Paul', 'Vraiment très intéréssant cet article', 6);

INSERT INTO recommandation(nom, prenom, mail, adresse, type, numero, rue, ville) VALUES ('paul', 'jean', 'paul@jean.fr', 'faluche', 'bar', 3, 'rue esquermoize', 'lille');
INSERT INTO recommandation(nom, prenom, mail, adresse, type, numero, rue, ville) VALUES ('max', 'thomas', 'max@thomas.fr', 'berkeley', 'bar', 3, 'rue esquermoize', 'lille');

INSERT INTO message(`date`, `nom`, `prenom`, `adresse_mail`, `message`) VALUES ('2018-03-14', 'premier', 'message', 'premier@message.fr', 'hello world');
INSERT INTO message(`date`, `nom`, `prenom`, `adresse_mail`, `message`) VALUES ('2018-03-15', 'second', 'message', 'second@message.fr', 'hello again');
INSERT INTO message(`date`, `nom`, `prenom`, `adresse_mail`, `message`) VALUES ('2018-03-14', 'premier', 'message', 'premier@message.fr', 'hello world');
INSERT INTO message(`date`, `nom`, `prenom`, `adresse_mail`, `message`) VALUES ('2018-03-15', 'second', 'message', 'second@message.fr', 'hello again');
INSERT INTO message(`date`, `nom`, `prenom`, `adresse_mail`, `message`) VALUES ('2018-03-14', 'premier', 'message', 'premier@message.fr', 'hello world');
INSERT INTO message(`date`, `nom`, `prenom`, `adresse_mail`, `message`) VALUES ('2018-03-15', 'second', 'message', 'second@message.fr', 'hello again');


/* BDD de la partie test

use projet_100h;
DROP SCHEMA IF EXISTS projet_100h;
CREATE SCHEMA projet_100h;

CREATE TABLE adresse(
	`id` INT NOT NULL AUTO_INCREMENT,
	 `date_ajout` date NOT NULL,
  `Nom` VARCHAR(50) NOT NULL,
	`Type` VARCHAR(50) NOT NULL,
     `presentation` VARCHAR(50) NOT NULL,
    `Visiteur` VARCHAR(50) NOT NULL,
  `coordonnee_x` DOUBLE NOT NULL,
  `coordonnee_y` DOUBLE NOT NULL,
  `lien_image` VARCHAR(100),
  `lien_image_accueil` VARCHAR(100),
	`note` DOUBLE NULL DEFAULT 0,
    `nb_like` INT NULL DEFAULT 0,
    `nbdislike` INT NULL DEFAULT 0,
  PRIMARY KEY (`id`));

CREATE TABLE commentaire(
	`id` INT NOT NULL AUTO_INCREMENT,
	`date` DATE NULL,
	 `nom` VARCHAR(50) NOT NULL,
	 `prenom` VARCHAR(50) NOT NULL,
	 `commentaire` VARCHAR(500) NOT NULL,
	 `id_article` INT NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE recommandation(
  `id` INT NOT NULL AUTO_INCREMENT,
  `Nom` VARCHAR(50) NOT NULL,
  `prenom` VARCHAR(50) NOT NULL,
  `mail` VARCHAR(50) NOT NULL,
  `adresse` VARCHAR(50) NOT NULL,
  `type` VARCHAR(50) NOT NULL,
  `rue` VARCHAR (80) NOT NULL,
  `numero` INT NOT NULL,
  `Ville` VARCHAR (50),
  PRIMARY KEY  (`id`));

INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-01', 'La Luck', 'bar', 'L\'Antre du gaming Lillois', 'Maxime Fillion', 50.6462, 3.05978, 'img/articles/la_luck.jpg', 'test', 4, 0, 0);
INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-02', 'Bibovino', 'bar', 'Description à venir', 'Maxime Fillion', 50.641169, 3.06147, 'img/articles/bibovino.jpg', 'test', 3, 0, 0);
INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-03', 'La Capsule', 'bar', 'Description à venir', 'Maxime Fillion', 50.640498, 3.060141, 'img/articles/la_capsule.jpg', 'test', 4, 0, 0);
INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-04', 'Le Point de Départ', 'bar', 'Description à venir', 'Maxime Fillion', 50.634885, 3.047588, 'img/articles/le_point_de_depart.jpg', 'test', 3, 0, 0);
INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-05', 'La part des anges', 'bar', 'Description à venir', 'Maxime Fillion', 50.64148, 3.062211, 'img/articles/la_part_des_anges.jpg', 'test', 4, 0, 0);
INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-06', 'L\'Adresse', 'restaurant', 'Description à venir', 'Maxime Fillion', 50.637879, 3.058189, 'img/articles/l_adresse.jpg', 'test', 4.5, 0, 0);
INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-07', 'T\'Rijsel', 'restaurant', 'Description à venir', 'Maxime Fillion', 50.642121, 3.065889, 'img/articles/t_rijsel.jpg', 'test', 4, 0, 0);
INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-08', 'Le Pot Beaujolais', 'restaurant', 'Description à venir', 'Maxime Fillion', 50.63656, 3.065094, 'img/articles/le_pot_beaujolais.jpg', 'test', 4, 0, 0);
INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-06', 'L\'Adresse', 'musee', 'Description à venir', 'Maxime Fillion', 50.637879, 3.058189, 'img/articles/l_adresse.jpg', 'test', 4.5, 0, 0);
INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-07', 'T\'Rijsel', 'musee', 'Description à venir', 'Maxime Fillion', 50.642121, 3.065889, 'img/articles/t_rijsel.jpg', 'test', 4, 0, 0);
INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-08', 'Le pot beaujolais', 'musee', 'Description à venir', 'Maxime Fillion', 50.63656, 3.065094, 'img/articles/le_pot_beaujolais.jpg', 'test', 4, 0, 0);

INSERT INTO commentaire(`date`, `nom`, `prenom`, `commentaire`, `id_article`)  VALUES ('2018-02-01', 'Dupuis', 'Paul', 'Vraiment très intéréssant cet article', 1);
INSERT INTO commentaire(`date`, `nom`, `prenom`, `commentaire`, `id_article`)  VALUES ('2018-02-01', 'Dupuis', 'Paul', 'Vraiment très intéréssant cet article', 1);
INSERT INTO commentaire(`date`, `nom`, `prenom`, `commentaire`, `id_article`)  VALUES ('2018-02-01', 'Dupuis', 'Paul', 'Vraiment très intéréssant cet article', 1);
INSERT INTO commentaire(`date`, `nom`, `prenom`, `commentaire`, `id_article`)  VALUES ('2018-02-01', 'Dupuis', 'Paul', 'Vraiment très intéréssant cet article', 2);
INSERT INTO commentaire(`date`, `nom`, `prenom`, `commentaire`, `id_article`)  VALUES ('2018-02-01', 'Dupuis', 'Paul', 'Vraiment très intéréssant cet article', 2);
INSERT INTO commentaire(`date`, `nom`, `prenom`, `commentaire`, `id_article`)  VALUES ('2018-02-01', 'Dupuis', 'Paul', 'Vraiment très intéréssant cet article', 2);

INSERT INTO commentaire(`date`, `nom`, `prenom`, `commentaire`, `id_article`)  VALUES ('2018-02-01', 'Dupuis', 'Paul', 'Vraiment très intéréssant cet article', 6);
INSERT INTO commentaire(`date`, `nom`, `prenom`, `commentaire`, `id_article`)  VALUES ('2018-02-01', 'Dupuis', 'Paul', 'Vraiment très intéréssant cet article', 6);
INSERT INTO commentaire(`date`, `nom`, `prenom`, `commentaire`, `id_article`)  VALUES ('2018-02-01', 'Dupuis', 'Paul', 'Vraiment très intéréssant cet article', 6);

INSERT INTO recommandation(nom, prenom, mail, adresse, type, numero, rue, ville) VALUES ('paul', 'jean', 'paul@jean.fr', 'faluche', 'bar', 3, 'rue esquermoize', 'lille');
INSERT INTO recommandation(nom, prenom, mail, adresse, type, numero, rue, ville) VALUES ('max', 'thomas', 'max@thomas.fr', 'berkeley', 'bar', 3, 'rue esquermoize', 'lille');*/





