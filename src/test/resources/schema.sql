DROP TABLE IF EXISTS users;

CREATE TABLE "users" (
  "id"       SERIAL      NOT NULL,
  "name"     varchar(64) NOT NULL PRIMARY KEY,
  "password" TEXT        NOT NULL,
  "coin"     INTEGER     NOT NULL
)