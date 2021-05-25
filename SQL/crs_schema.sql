-- MySQL Script generated by MySQL Workbench
-- Tue May 25 20:55:44 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema test_schema
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema test_schema
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `test_schema` ;
USE `test_schema` ;

-- -----------------------------------------------------
-- Table `test_schema`.`Admin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `test_schema`.`Admin` ;

CREATE TABLE IF NOT EXISTS `test_schema`.`Admin` (
  `user_name` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `joining_year` INT NOT NULL,
  `contact_number` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test_schema`.`Course Catalog`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `test_schema`.`Course Catalog` ;

CREATE TABLE IF NOT EXISTS `test_schema`.`Course Catalog` (
  `courseID` VARCHAR(45) NOT NULL,
  `course_name` VARCHAR(45) NOT NULL,
  `instructor` VARCHAR(45) NULL,
  `offered_semester` INT NULL,
  `available_seats` INT NOT NULL DEFAULT 10,
  PRIMARY KEY (`courseID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test_schema`.`Professor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `test_schema`.`Professor` ;

CREATE TABLE IF NOT EXISTS `test_schema`.`Professor` (
  `user_name` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `joining_year` INT NOT NULL,
  `contact_number` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `instructor_ID` INT NOT NULL,
  `designation` VARCHAR(45) NOT NULL,
  `department` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`instructor_ID`, `user_name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test_schema`.`Registered_courses`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `test_schema`.`Registered_courses` ;

CREATE TABLE IF NOT EXISTS `test_schema`.`Registered_courses` (
  `student_id` INT NOT NULL,
  `primary_course1` VARCHAR(45) NOT NULL,
  `primary_course2` VARCHAR(45) NOT NULL,
  `primary_course3` VARCHAR(45) NOT NULL,
  `primary_course4` VARCHAR(45) NOT NULL,
  `alt_course1` VARCHAR(45) NOT NULL,
  `alt_course2` VARCHAR(45) NOT NULL,
  `semester_id` INT NOT NULL,
  `grade1` INT NULL,
  `grade2` INT NULL,
  `grade3` INT NULL,
  `grade4` INT NULL,
  `is_paid` TINYINT(1) NULL,
  `is_approved` TINYINT(1) NULL,
  PRIMARY KEY (`student_id`, `semester_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test_schema`.`Student`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `test_schema`.`Student` ;

CREATE TABLE IF NOT EXISTS `test_schema`.`Student` (
  `user_name` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  `student_id` INT NOT NULL,
  `department` VARCHAR(45) NOT NULL,
  `joining_year` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `contact_number` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_name`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
