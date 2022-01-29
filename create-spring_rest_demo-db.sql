/* DROP DATABASE IF EXISTS `spring_rest_demo`; */
CREATE DATABASE `spring_rest_demo` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT ENCRYPTION='N';
DROP TABLE IF EXISTS `spring_rest_demo`.`actor`;
CREATE TABLE `spring_rest_demo`.`actor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `middle_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `affiliation` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
INSERT INTO `spring_rest_demo`.`actor` (`id`, `first_name`, `last_name`, `affiliation`) VALUES ('1', 'Dharmavarapu', 'Subramanyam', 'Tollywood');
INSERT INTO `spring_rest_demo`.`actor` (`id`, `first_name`, `middle_name`, `last_name`, `affiliation`) VALUES ('2', 'Chowdasandra', 'Honnappa', 'Bhagavathar', 'Chandanavana');
INSERT INTO `spring_rest_demo`.`actor` (`id`, `first_name`, `middle_name`, `last_name`, `affiliation`) VALUES ('3', 'Kota', 'Srinivasa', 'Rao', 'Tollywood');
INSERT INTO `spring_rest_demo`.`actor` (`id`, `first_name`, `middle_name`, `last_name`, `affiliation`) VALUES ('4', 'Veeramachaneni', 'Jagapathi', 'Chowdhary Babu', 'Tollywood');
INSERT INTO `spring_rest_demo`.`actor` (`id`, `first_name`, `middle_name`, `last_name`, `affiliation`) VALUES ('5', 'Gautham', 'Vasudev', 'Menon', 'Kollywood');
INSERT INTO `spring_rest_demo`.`actor` (`id`, `first_name`, `last_name`, `affiliation`) VALUES ('6', 'Amitabh', 'Srivastava Bachchan', 'Bollywood');
INSERT INTO `spring_rest_demo`.`actor` (`id`, `first_name`, `last_name`, `affiliation`) VALUES ('7', 'Amrish', 'Puri', 'Bollywood');
INSERT INTO `spring_rest_demo`.`actor` (`id`, `first_name`, `last_name`, `affiliation`) VALUES ('8', 'Prakash', 'Raj', 'Bollywood');
INSERT INTO `spring_rest_demo`.`actor` (`id`, `first_name`, `last_name`, `affiliation`) VALUES ('9', 'Biswajit', 'Chatterjee', 'Tollywood');
INSERT INTO `spring_rest_demo`.`actor` (`id`, `first_name`, `last_name`, `affiliation`) VALUES ('10', 'Kanneganti', 'Brahmanandam', 'Tollywood');
INSERT INTO `spring_rest_demo`.`actor` (`id`, `first_name`, `middle_name`, `last_name`, `affiliation`) VALUES ('11', 'Jaspal', 'Singh', 'Bhatti', 'Bollywood');
INSERT INTO `spring_rest_demo`.`actor` (`id`, `first_name`, `middle_name`, `last_name`, `affiliation`) VALUES ('12', 'Simhalan', 'Madhava', 'Panicker', 'Mollywood');
INSERT INTO `spring_rest_demo`.`actor` (`id`, `first_name`, `last_name`, `affiliation`) VALUES ('13', 'Hrithik', 'Roshan', 'Bollywood');
INSERT INTO `spring_rest_demo`.`actor` (`id`, `first_name`, `last_name`, `affiliation`) VALUES ('14', 'Zubeen', 'Borthakur Garg', 'Jollywood');
