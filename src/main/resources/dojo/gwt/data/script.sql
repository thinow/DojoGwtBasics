
CREATE TABLE beer (
	id varchar PRIMARY KEY,						-- Identifiant
	label varchar,								-- Libellé
	description varchar,						-- Description
	grade double CHECK grade BETWEEN 0 AND 1	-- Note (pourcentage)
);

INSERT INTO beer (id, grade, label, description) VALUES
	('1', 0.75, 'Une bière', 'C''est une bonne bière...'),
	('2', 0.80, 'Une autre bière', 'Sympa...'),
	('3', 0.90, 'Ma super bière', 'C''est l''histoire d''une bière...');
