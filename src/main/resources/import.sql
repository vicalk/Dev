insert into users(AFM,LASTNAME,FIRSTNAME,ADDRESS,EMAIL,PASSWORD,user_type) values ('123456789','Doe','John','skoufa 26','john@mail.com','pass1234','ADMIN');
insert into users(AFM,LASTNAME,FIRSTNAME,ADDRESS,EMAIL,PASSWORD,user_type) values ('145678923','Doe','Jane','skoufa 26','jane@mail.com','pass1234','SIMPLE');

insert into vehicles(PLATENO,CAR_MODEL,YEAR,COLOR,USER_ID) values ('IMA-8357','AUDI','2007','GREY','1');
insert into vehicles(PLATENO,CAR_MODEL,YEAR,COLOR,USER_ID) values ('IMA-8356','AUDI','2007','GREY','2');

insert into repairs(REPAIR_DATE,REPAIR_STATUS,REPAIR_TYPE,REPAIR_COST,REPAIR_DESCRIPTION,VEHICLE_ID) values ('2007-10-11','IN PROGRESS','SMALL','500','OIL CHANGE',1);
insert into repairs(REPAIR_DATE,REPAIR_STATUS,REPAIR_TYPE,REPAIR_COST,REPAIR_DESCRIPTION,VEHICLE_ID) values ('2007-11-11','COMPLETED','LARGE','1000','FILTER CHANGE',2);


insert into parts(USER_ID,AFM,FIRSTNAME,LASTNAME,email,PASSWORD,user_type) values ('2','23','Jane','Doe','jane@mail.com','pass1234','SIMPLE');

