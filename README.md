YelpDataExtractor

This utility is used to convert yelp data in json to csv data which can be imported to the blu cloud.
Software Required

    JDK 7
    Eclipse IDE

Input Data

Yelp Academic dataset can be downloaded from https://www.yelp.com/academic_dataset. Unzip the data and place it at location @ YELP_DATA_FOLDER
Project Structure

src :- main java source of the project lib : jar library dependencies for the project blu_data_files : csv blu data files used to upload the data to blu cloud
Installation Instructions

    Import the project as Java Project
    Include the jar libraries present @ lib folder to the classpath of the project
    Update ReadYelpData.java , set YELP_DIR_PATH point to the full path of the YELP_DATA_FOLDER
    Update ReadYelpData.java , set YELP_OUTPUT_DIR_PATH point to the full path of the output folder
    Run ReadYelpData as a Java Application through Eclipse. It will generate csv data files in YELP_OUTPUT_DIR_PATH folder which can be used to upload data to blu cloud.
    When execution for ReadYelpData is complete it will also print the SQL DDL for the tables in the output console of Eclipse. Copy this DDL annd use it to create tables in blu cloud.

RUN OUTPUT

Number of businesses : 11537

Number of Categories : 508

Number of Checkins : 262764

Number of Users : 43873

Number of Reviews : 229907

CREATE TABLE USER ( USER_ID VARCHAR(22) ,NAME VARCHAR(30) ,TYPE VARCHAR(10) ,FUNNY_VOTES INT,USEFUL_VOTES INT,COOL_VOTES INT,REVIEW_COUNT INT,AVERAGE_STARS DOUBLE);

User Data Written

CREATE TABLE REVIEW ( USER_ID VARCHAR(22) ,BUSINESS_ID VARCHAR(22) ,REVIEW_ID VARCHAR(22) ,TYPE VARCHAR(10) ,FUNNY_VOTES INT,USEFUL_VOTES INT,COOL_VOTES INT,STARS INT,REVIEW_DATE DATE);

Review Data Written

CREATE TABLE BUSINESS_TO_CHECKIN ( BUSINESS_ID VARCHAR(22) ,TYPE VARCHAR(10) ,DAY VARCHAR(10),HOUR VARCHAR(10),COUNT INT);

CheckIn Data Written

CREATE TABLE CATEGORY ( ID INT ,NAME VARCHAR(50));

Category Data Written

CREATE TABLE BUSINESS ( BUSINESS_ID VARCHAR(22) ,CITY VARCHAR(30) ,NAME VARCHAR(50) ,STATE VARCHAR(50) ,TYPE VARCHAR(10) ,LONGITUDE DOUBLE,LATITUDE DOUBLE,REVIEW_COUNT DOUBLE,STARS INT);

CREATE TABLE BUSINESS_TO_CATEGORY ( BUSINESS_ID VARCHAR(22) ,CATEGORY_ID INT);

Business Data Written

Processing Complete
