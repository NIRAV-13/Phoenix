Create database User1;
show databases;
use User1;
CREATE TABLE User_details (
    UserId int AUTO_INCREMENT NOT NULL,
    Name varchar(255),
    password varchar(255),
    House_Number varchar(255),
    Street varchar(255),
    City varchar(255),
    PRIMARY KEY (UserId)
);
CREATE TABLE vehicle (
    UserId int,
    vehicle_type varchar(255),
    vehicle_number varchar(255),
    FOREIGN KEY (UserId) REFERENCES User_details(UserId)
);

CREATE TABLE payment (
    UserId int,
    payment_date varchar(255),
    payment_method varchar(255),
    payment_amount varchar(255),
    transaction_id varchar(255),
    FOREIGN KEY (UserId) REFERENCES User_details(UserId)
);
CREATE TABLE parking (
    UserId int,
    parking_id int NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (parking_id),
    FOREIGN KEY (UserId) REFERENCES User_details(UserId)
);
CREATE TABLE experience (
    UserId int,
    rating varchar(255),
    parking_id Integer,
    FOREIGN KEY (UserId) REFERENCES User_details(UserId)
);
CREATE TABLE parking_location (
    latitude varchar(255),
    longitude varchar(255),
    parking_id int,
    entry_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	exit_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (parking_id) REFERENCES parking(parking_id)
);
CREATE TABLE parking_detail (
	number_of_spots Integer,
	used_spot Integer,
    parking_id int,
    FOREIGN KEY (parking_id) REFERENCES parking_location(parking_id)
);