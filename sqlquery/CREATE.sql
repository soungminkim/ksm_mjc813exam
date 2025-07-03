CREATE TABLE contact_tbl (
	id INT UNSIGNED NOT NULL auto_increment
	, name varchar(20) NOT NULL
	, phoneNumber varchar(20) NOT NULL
	, zipNumber varchar(5) NOT NULL
	, email varchar(100) NOT NULL
	, addr varchar(500) NOT NULL
	, CONSTRAINT pk_contact PRIMARY KEY (id)
);

CREATE TABLE location_tbl (
		id INT UNSIGNED NOT NULL auto_increment
		, location VARCHAR(500) NOT NULL
		, CONSTRAINT pk_location_tbl PRIMARY KEY (id)
);

CREATE TABLE saled_tbl (
		id INT UNSIGNED NOT NULL auto_increment
		, sale_dt DATE NOT NULL DEFAULT (CURRENT_DATE)
		, price INT UNSIGNED NOT NULL default 0
		, qty INT UNSIGNED NOT NULL default 0
		, product VARCHAR(100)  NOT NULL
		, location_id INT UNSIGNED
		, discount INT UNSIGNED NOT NULL default 0
		, contact_id INT UNSIGNED
		, CONSTRAINT pk_saled_tbl PRIMARY KEY (id)
		, CONSTRAINT fk_saled_location FOREIGN KEY (location_id) REFERENCES location_tbl(id)
    	, CONSTRAINT fk_saled_contact FOREIGN KEY (contact_id) REFERENCES contact_tbl(id)
);


CREATE TABLE learn_tbl(
		id INT UNSIGNED NOT NULL auto_increment
		, lecture_id INT UNSIGNED NOT NULL
		, socre DECIMAL(3,1) NOT NULL
		, contact_id INT UNSIGNED NOT NULL
		, CONSTRAINT pk_learn_tbl PRIMARY KEY (id)
		, CONSTRAINT fk_learn_tbl FOREIGN KEY (contact_id) REFERENCES contact_tbl(id)
);


CREATE TABLE lecture_tbl (
		id INT UNSIGNED NOT NULL auto_increment
		, subject VARCHAR(100) NOT NULL
		, teacher VARCHAR(20) NOT NULL
		, root_num VARCHAR(10) NOT NULL
		, start_dt DATE NOT NULL
		, end_dt DATE NOT NULL
		, CONSTRAINT pk_lecture_tbl PRIMARY KEY (id)
);

DROP TABLE learn_tbl  CASCADE; 
