----create table net_enterprise
CREATE TABLE net_enterprise(
net_ep_id INT PRIMARY KEY auto_increment,
net_ep_name VARCHAR (32) NOT NULL,
net_ep_url VARCHAR(64) NOT NULL
)

----create table channel
CREATE TABLE channel(
channel_id int PRIMARY KEY auto_increment,
channel_name VARCHAR(128) NOT NULL,
channel_url VARCHAR(128) NOT NULL,
channel_fk_id INT
)

ALTER TABLE channel ADD CONSTRAINT FK_net_channel_id FOREIGN KEY (channel_fk_id) REFERENCES net_enterprise (net_ep_id) ON UPDATE CASCADE

----create table opml
CREATE TABLE opml(
opml_id INT PRIMARY KEY auto_increment,
opml_head_title VARCHAR(64) NOT NULL,
opml_body_title VARCHAR(64),
opml_body_text VARCHAR(128),
opml_outline_text VARCHAR(128),
opml_outline_title VARCHAR(128) NOT NULL,
opml_outline_type VARCHAR(24) ,
opml_outline_xmlUrl VARCHAR(128) NOT NULL,
opml_outline_htmlUrl VARCHAR(128),
opml_fk_id INT
)

ALTER TABLE opml ADD CONSTRAINT FK_channel_opml_id FOREIGN KEY (opml_fk_id) REFERENCES channel (channel_id) ON UPDATE CASCADE

----create table entry
CREATE TABLE entry(
entry_id INT PRIMARY KEY auto_increment,
entry_title VARCHAR (128) NOT NULL,
entry_link VARCHAR (128) NOT NULL,
entry_source VARCHAR (32),
entry_author VARCHAR (32),
entry_guid VARCHAR (128),
entry_category VARCHAR (32),
entry_pubDate datetime NOT NULL,
entry_comments TINYBLOB,
entry_description TEXT,
entry_fk_id INT
)

ALTER TABLE entry ADD CONSTRAINT FK_opml_entry_id FOREIGN KEY (entry_fk_id) REFERENCES opml (opml_id) ON UPDATE CASCADE

-------------Drop Table Clause----------------
--delete tables
DROP TABLE IF EXISTS net_enterprise
DROP TABLE IF EXISTS channel
DROP TABLE IF EXISTS opml
DROP TABLE IF EXISTS entry

-------------Just As Test Clause--------------
CREATE TABLE test(
content TINYBLOB
)