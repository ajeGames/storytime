create table weather (
	city	varchar(80),
	temp_lo	int,	-- low temperature
	temp_hi int, 	-- high temperature
	prcp	real,	-- precipitation
	date	date
);

create table cities (
	name	varchar(80),
	location	point
);

insert into weather (city, temp_lo, temp_hi, prcp, date) values ('San Francisco', 46, 50, 0.25, '1994-11-27');
insert into weather (city, temp_lo, temp_hi, prcp, date) values ('San Francisco', 43, 57, 0, '1994-11-29');
insert into weather (city, temp_lo, temp_hi, date) values ('Hayward', 37, 54, '1994-11-29');
insert into cities values('San Francisco', '(-194.0, 53.0)');
insert into cities (name) values('Hayward');

