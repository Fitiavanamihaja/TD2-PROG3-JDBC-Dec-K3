CREATE TYPE player_position AS ENUM ('GK', 'DEF', 'MIDF', 'STR');

CREATE TYPE team_continent AS ENUM ('AFRICA', 'EUROPA', 'ASIA', 'AMERICA');

CREATE TABLE team (
                      id SERIAL PRIMARY KEY,
                      name VARCHAR(100) NOT NULL,
                      continent team_continent NOT NULL
);

CREATE TABLE player (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        age INT NOT NULL,
                        position player_position NOT NULL,
                        id_team INT,
                        CONSTRAINT fk_team
                            FOREIGN KEY (id_team)
                                REFERENCES team(id)
                                ON DELETE SET NULL
);
