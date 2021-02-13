--liquibase formatted sql logicalFilePath:db.changelog-2.0

--changeset afonso.oliveira:db.changelog-2.0
ALTER TABLE `santa_secret`.`user`
ADD COLUMN `role` VARCHAR(500) NULL AFTER `cellphone`;


--rollback ALTER TABLE `santa_secret`.`user` DROP COLUMN `role`;
