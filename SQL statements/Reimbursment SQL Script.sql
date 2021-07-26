DROP TABLE IF EXISTS ers_reimbursement;
DROP TABLE IF EXISTS ers_reimbursement_status;
DROP TABLE IF EXISTS ers_reimbursement_type;
DROP TABLE IF EXISTS ers_users;
DROP TABLE IF EXISTS ers_user_roles;

CREATE TABLE ers_reimbursement_status(
reimb_status_id integer NOT NULL PRIMARY KEY,
reimb_status varchar(10) NOT NULL
)

CREATE TABLE ers_reimbursement_type(
reimb_type_id integer NOT NULL PRIMARY KEY,
reimb_type varchar(10) NOT NULL
)

CREATE TABLE ers_user_roles(
ers_user_role_id integer NOT NULL PRIMARY KEY,
user_role varchar(10)NOT NULL
)

CREATE TABLE ers_users(
ers_user_id integer NOT NULL PRIMARY KEY,
ers_username varchar(50) UNIQUE,
ers_password varchar(50) NOT NULL,
user_first_name varchar(100) NOT NULL,
user_last_name varchar(100) NOT NULL,
user_email varchar(150) UNIQUE NOT NULL,
user_role_id integer NOT NULL REFERENCES ers_user_roles(ers_user_role_id)
)

CREATE TABLE ers_reimbursement(
reimb_id integer NOT NULL PRIMARY KEY,
reimb_amount numeric(20,2) NOT NULL,
reimb_submitted timestamp NOT NULL,
reimb_resolved timestamp,
reimb_description varchar(250),
reimb_author integer NOT NULL REFERENCES ers_users(ers_user_id),
reimb_resolver integer REFERENCES ers_users(ers_user_id),
reimb_status_id integer REFERENCES ers_reimbursement_status(reimb_status_id), 
reimb_type_id integer NOT NULL REFERENCES ers_reimbursement_type(reimb_type_id)
)

INSERT INTO ers_reimbursement_status
	VALUES (1, 'pending'),
	(2, 'resolved');
	
INSERT INTO ers_reimbursement_type
	VALUES (1, 'lodging'),
	(2, 'travel'),
	(3, 'food'),
	(4, 'other');
	
INSERT INTO ers_user_roles
	VALUES (1, 'employee'),
	(2, 'manager');

INSERT INTO ers_users
	VALUES (1, 'fwilmott', 'password', 'fletcher', 'wilmott', 'fwilmottct@gmail.com', '2');
	
INSERT INTO ers_reimbursement
	VALUES (1, 20.21, current_timestamp, current_timestamp, 'test reimbursment', 1, 1, 2, 3);



