--liquibase formatted sql logicalFilePath:db.changelog-1.0

--changeset afonso.oliveira:db.changelog-1.0

CREATE TABLE santa_secret.user(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    `email` VARCHAR(50) NOT NULL,
    `cellphone` INT NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE santa_secret.group(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    `owner_user_id` BIGINT(20) NOT NULL,
    `creation_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `event_date` TIMESTAMP NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE santa_secret.participant(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `group_id` BIGINT(20) NOT NULL,
    `user_id` BIGINT(20) NOT NULL,
    `checked` TINYINT(1) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE santa_secret.draw(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `group_id` BIGINT(20) NOT NULL,
    `user_from` BIGINT(20) NOT NULL,
    `user_to` BIGINT(20) NOT NULL,
    `creation_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE `santa_secret`.`group`
ADD CONSTRAINT `fk_group_user`
  FOREIGN KEY (`owner_user_id`)
  REFERENCES `santa_secret`.`user` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `santa_secret`.`participant`
  ADD CONSTRAINT `fk_participant_group`
    FOREIGN KEY (`group_id`)
    REFERENCES `santa_secret`.`group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_participant_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `santa_secret`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE `santa_secret`.`draw`
  ADD CONSTRAINT `fk_draw_group`
    FOREIGN KEY (`group_id`)
    REFERENCES `santa_secret`.`group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_draw_user_from`
    FOREIGN KEY (`user_from`)
    REFERENCES `santa_secret`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_draw_user_to`
    FOREIGN KEY (`user_to`)
    REFERENCES `santa_secret`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

--rollback DROP TABLE santa_secret.user;
--rollback DROP TABLE santa_secret.group;
--rollback DROP TABLE santa_secret.participant;
--rollback DROP TABLE santa_secret.draw;