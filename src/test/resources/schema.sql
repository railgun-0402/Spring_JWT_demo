DROP TABLE IF EXISTS users;

CREATE TABLE "users" (
  "id"       SERIAL      NOT NULL,
  "name"     varchar(64) NOT NULL PRIMARY KEY,
  "password" TEXT        NOT NULL,
  "coin"     INTEGER     NOT NULL
);

CREATE TABLE "characters" (
	"id" SERIAL NOT NULL primary key,
	"name" TEXT NOT NULL,
	"lank" INTEGER NOT NULL
);

CREATE TABLE "stocks" (
	"id" SERIAL NOT NULL primary key,
	"user_id" INTEGER NOT NULL,
	"character_id" INTEGER NOT NULL
);