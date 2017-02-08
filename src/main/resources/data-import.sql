CREATE TABLE `jpa-study`.`orders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customerId` bigint(20) DEFAULT NULL,
  `productId` bigint(20) DEFAULT NULL,
  `createdAt` datetime DEFAULT NULL,
  `createdBy` varchar(45) DEFAULT NULL,
  `modifiedAt` datetime DEFAULT NULL,
  `modifiedBy` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `jpa-study`.`orders` (`id`, `customerId`, `productId`, `createdBy`, `createdAt`, `modifiedBy`, `modifiedAt`) VALUES ('1', '1', '1', 'eclipse4j', '20170101', 'eclipse4j', '20170101');

CREATE TABLE `jpa-study`.`companies` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `streetAddress` varchar(45) DEFAULT NULL,
  `createdAt` datetime DEFAULT NULL,
  `createdBy` varchar(45) DEFAULT NULL,
  `modifiedAt` datetime DEFAULT NULL,
  `modifiedBy` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `jpa-study`.`companies` (`id`, `name`, `code`, `address`, `streetAddress`, `createdBy`, `createdAt`, `modifiedBy`, `modifiedAt`) 
VALUES ('1', 'company-name', 'company-code', 'address', 'streetAddress', 'eclipse4j', '20170101', 'eclipse4j', '20170101');
