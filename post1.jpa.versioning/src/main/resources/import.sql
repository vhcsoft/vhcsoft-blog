CREATE TRIGGER 	IF NOT EXISTS version_trigger BEFORE UPDATE ON USER FOR EACH ROW CALL "vhcsoft.com.vhcsoft.blog.versioning.h2.trigger.VersionTrigger"
insert into User(id, name,CREATED_DATE, version) values (1, 'UserX','2018-02-03',1);