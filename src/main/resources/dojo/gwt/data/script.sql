
CREATE TABLE movie (
	id varchar PRIMARY KEY,						-- Identifiant
	label varchar,								-- Libellé
	description varchar,						-- Description
	grade double CHECK grade BETWEEN 0 AND 1	-- Note (pourcentage)
);

INSERT INTO movie (id, grade, label, description) VALUES
	('1', 0.75, 'Mon film', 'C''est un beau film...'),
	('2', 0.80, 'Un autre film', 'Sympa...'),
	('3', 0.90, 'Mon super film', 'C''est l''histoire d''un mec...');
