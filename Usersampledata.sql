show databases;
use User1;
insert into User_details(Name,password,House_Number,Street,City) values ("Sparsh","root","1609","1333 South park street","Halifax");
insert into User_details(Name,password,House_Number,Street,City) values ("test","root","1798","1333 South park street","Halifax");
insert into User_details(Name,password,House_Number,Street,City) values ("test_root","root","1606","1333 South park street","Halifax");

insert into experience(UserId,rating,parking_id) values (1,"5",1);
insert into experience(UserId,rating,parking_id) values (2,"5",11);
insert into experience(UserId,rating,parking_id) values (3,"5",12);

insert into parking(UserId,parking_id) values (1,1);
insert into parking(UserId,parking_id) values (2,11);
insert into parking(UserId,parking_id) values (3,12);

insert into parking_location(latitude,longitude,parking_id,entry_time,exit_time) values (12,13,1,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP+2);
insert into parking_location(latitude,longitude,parking_id,entry_time,exit_time) values (12,13,11,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP+2);
insert into parking_location(latitude,longitude,parking_id,entry_time,exit_time) values (12,13,12,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP+2);

insert into parking_detail(number_of_spots,used_spot,parking_id) values(100,100,1);
insert into parking_detail(number_of_spots,used_spot,parking_id) values(50,50,11);
insert into parking_detail(number_of_spots,used_spot,parking_id) values(10,10,12);

insert into payment(UserId,payment_date,payment_method,payment_amount,transaction_id) values (1,"2021-10-21","card","100","jhcbwruyv");
insert into payment(UserId,payment_date,payment_method,payment_amount,transaction_id) values (2,"2020-10-21","cash","50","hvberihvberihe");
insert into payment(UserId,payment_date,payment_method,payment_amount,transaction_id) values (3,"2019-10-21","bitcoin","10","nkwmcnvr");

insert into vehicle(UserId,vehicle_type,vehicle_number) values (1,"SUV","BIJE3R");
insert into vehicle(UserId,vehicle_type,vehicle_number) values (2,"SEDAN","VIJ3R");
insert into vehicle(UserId,vehicle_type,vehicle_number) values (1,"SUV","YTY76G");













