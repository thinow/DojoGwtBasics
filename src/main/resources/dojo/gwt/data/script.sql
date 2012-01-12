
CREATE TABLE beer (
	id serial PRIMARY KEY,						-- Identifiant
	label varchar,								-- Libellé
	description varchar,						-- Description
	grade double CHECK grade BETWEEN 0 AND 1,	-- Note (pourcentage)
	alcohol double CHECK alcohol >= 0,			-- Degré d'alcool
	brewery varchar,							-- Brasserie
	country varchar,							-- Pays
);

INSERT INTO beer (grade, label, alcohol, brewery, country, description) VALUES (0.800, 'Duvel', 8.5, 'Moortgat', 'Belgique', 'La Bière Duvel rouge est une bière de type blonde forte à fermentation , conçue par le brasseur Moortgat à Anvers (Belgique). La Duvel est une bière particulièrement réputée chez les connaisseurs. Créée en 1923, son nom provient du premier employé qui l''a gouté après sa fabrication et qui l''a qualifié de "Bière du Diable" (Duven en Allemand). Malgré son importante teneur en alcool de 8.5° et son goût puissant elle n''en demeure pas moins fraiche et désaltérante. Une bière idéale pour être dégusté en apéritif.');
INSERT INTO beer (grade, label, alcohol, brewery, country, description) VALUES (0.760, 'Rince-cochon', 8.5, 'SBA (Annoeullin)', 'France', 'La Bière Rince-cochon est une bière de type garde à fermentation haute, conçue par le brasseur SBA (Annoeullin) à (France). Autrefois brassée à Annoeullin par la SBA sous le nom de "Le Rince Cochon", cette bière est aujourd''hui brassée par la brasserie Haacht, en Belgique, qui brasse notamment les bières Primus et Tongerlo.');
INSERT INTO beer (grade, label, alcohol, brewery, country, description) VALUES (0.880, 'Kwak', 8.0, 'Bosteels', 'Belgique', 'La Bière Kwak est une bière de type spéciale à fermentation haute, conçue par le brasseur Bosteels à Buggenhout (Belgique). Couleur rubis, claire. Limpide et peu saturée , son goût est légèrement acerbe, bon équilibre général malgré tout, amertume plutôt faible. Bière forte et capiteuse , appréciable. Son verre Kwak à la forme si singulière fait de la dégustation de cette bière belge un moment spécial');
INSERT INTO beer (grade, label, alcohol, brewery, country, description) VALUES (0.820, 'Triple Karmeliet', 8.0, 'Bosteels', 'Belgique', 'La Bière Triple karmeliet est une bière de type spéciale à fermentation haute, conçue par le brasseur Bosteels à (Belgique).  La bière Tripel Karmeliet est une bière belge brassée aujourd''hui selon une recette de bière authentique de 1679, provenant de l''ancien couvent des Carmes à Termonde, dans la region du Brabant Flamand. Cette recette de bière plus de 3 fois centenaire décrit l''usage de 3 variétés de céréales : le froment, l''avoine et l''orge. Le nom de Tripel Karmeliet fait donc référence à son origine, mais aussi à sa méthode de brassage.');
INSERT INTO beer (grade, label, alcohol, brewery, country, description) VALUES (0.750, 'Bush', 10.5, 'Dubuisson', 'Belgique', 'La Bière Bush blonde est une bière de type blonde forte à fermentation , conçue par le brasseur Dubuisson à (Belgique). En 1998, à l’occasion du 65e anniversaire de la Bush Ambrée lancée par son grand-père, Hugues Dubuisson a créé une nouvelle Bush pour satisfaire les amateurs de bière blonde… La Bush Blonde était née. Bière de haute fermentation, filtrée, elle s’inscrit parfaitement dans la lignée de ses aînées, la Bush Ambrée et la Bush de Noël. Elle bénéficie notamment du même savoir-faire et des mêmes levures maison. Néanmoins, elle affiche une personnalité propre. L’utilisation de malts traditionnels associée à l’emploi exclusif du fameux houblon de Saaz lui procure une robe claire chatoyante ainsi qu’une palette harmonieuse de saveurs subtiles et d’arômes typés mais néanmoins équilibrés. Une fermentation prolongée lui confère non seulement un taux d’alcool de 10,5% mais également une digestibilité exceptionnelle. La Bush blonde, une découverte dans l’univers des bières blondes fortes');
INSERT INTO beer (grade, label, alcohol, brewery, country, description) VALUES (0.700, '3 Monts', 8.0, 'De St Sylvestre', 'France', 'La Bière 3 monts est une bière de type spéciale à fermentation haute, conçue par le brasseur de St Sylvestre à St Sylvestre Cappel (France). Bière dorée, limpide, mousse blanche serrée assez stable, fine saturation. Nez doux de malt et de houblon aromatique, assez classique. Bouche bien charpentée, goût doux à l''amertume bien balancée et durable, corps ferme, bouche aux tons liquoreux. Bonne bière des Flandres, typée et capiteuse.');
INSERT INTO beer (grade, label, alcohol, brewery, country, description) VALUES (0.740, 'Goudale', 7.2, 'Les Brasseurs de Gayant', 'France', 'La Bière La goudale est une bière de type garde à fermentation haute, conçue par le brasseur Les Brasseurs de Gayant à (France). Tout droit issue d''une recette du Moyen-Age, la Goudale tire son nom de son histoire, comme cela est mentionné sur la bouteille. Faite à partir de malts spéciaux, aromatisée aux houblons des Flandres, la Goudale est une bière dorée, dense, goûteuse et longue en bouche. Son léger goût de malts spéciaux, aromatisé aux houblons des Flandres ainsi que ses arômes de fermentation haute, donnent à la Goudale tout son caractère et son équilibre. ');
INSERT INTO beer (grade, label, alcohol, brewery, country, description) VALUES (0.680, 'Chimay', 9.0, 'Abbaye Notre-Dame de Scourmont', 'Belgique', 'La Bière Chimay bleue est une bière de type trappiste à fermentation haute, conçue par le brasseur Abbaye Notre-Dame de Scourmont à Forges (Hameau de scourmont) (Belgique). En 1850, le prince de Chimay donne une partie de ses terres à dix-sept moines de l''abbaye de westvleteren, afin qu''ils créent l''abbaye de Scourmont, proche des Ardennes. Douze ans plus tard, ils se lancent dans la production de bière, afin de subvenir à leurs besoins. Par la suite, les bières de Chimay vont devenir les plus connues des bières trappistes, au point de recevoir un Prix Royal pour leur sucées à l''exportation, qui en retour, a eu droit à l''insigne honneur d''être enterré dans le cimetière de l''abbaye. Si le brassage et la fermentation sont toujours effectués dans l''enceinte monastique (condition sine qua non pour avoir le label trappiste); l''embouteillage est réalisé depuis 1978 à quelques kilomètres, afin de préserver la tranquillité et le recueillement des moines, la bière étant transportée en camion-citerne.');
INSERT INTO beer (grade, label, alcohol, brewery, country, description) VALUES (0.850, 'Maredsous blonde', 6.0, 'Moortgat', 'Belgique', 'La Bière Maredsous blonde 6° est une bière de type abbaye à fermentation haute, conçue par le brasseur Moortgat à Breendonk (Belgique). La Maredsous blonde est de couleur jaune antique, à peine troublée. Cette bière a une mousse blanche abondante, serrée et stable. La saturation en grosses bulle est forte. Son nez est malté élégamment houblonné et profond. Sa saveur est fruitée et légèrement acre. Son amertume est douce et aromatique, au corps bien formé et équilibré. C''est un très bon classique parmi les bières belges. C''est la toute première bière de l''Abbaye Maredsous, encore consommée par les moines pour le repas du midi.');
INSERT INTO beer (grade, label, alcohol, brewery, country, description) VALUES (0.840, 'Westmalle', 9.0, 'Abb. Notre-Dame du sacré coeur', 'Belgique', 'La Bière Westmalle tripel est une bière de type trappiste à fermentation haute, conçue par le brasseur Abb. Notre-Dame du sacré coeur à Westmalle (Belgique). La Triple de Westmalle se présente sous une couleur dorée intense et développe, dès son entrée dans le verre, une mousse abondante, crémeuse et stable. La saturation est fine mais assez abondante et régulière. Les arômes vous assaillent de tons doux, maltés et alcoolisés, ainsi que quelques nuances houblonnées fruitées (pâte d''orange, mandarine confite, vanille ?). l''entrée en bouche est saisissante, d''une force et d''un corps hors du commun. Les saveurs d''alcool et de levure jouent pleinement ; on retrouve les arômes orangés, sucrés, des tons de gomme arabique, whisky, essences de fruits, et phénols multiples et complexes. l''amplitude est longue, le corps ample, et l''amertume moyenne, car essentiellement aromatique (Goldings, Tettnanger, Saaz ainsi que d''autres houblons entrent dans sa composition). l''arrière goût est doux, miellé, aux subtils tons d''épices douces (coriandre ?); et encore empli de saveurs spiritueuses. C''est une bière d''une grande force et d''une immense complexité, qu''il faut déguster à l''apéritif ou, mieux encore le soir pour se délasser. Une vraie bière trappiste de classe mondiale, à surtout boire dans son verre calice approprié. 9% alc/vol, à boire fraîche (12°-14°) mais pas froide');
INSERT INTO beer (grade, label, alcohol, brewery, country, description) VALUES (0.690, 'Kaastel', 11.0, 'Van Honsebrouck', 'Belgique', 'La Bière Kasteel bier est une bière de type spéciale à fermentation haute, conçue par le brasseur Van Honsebrouck à Ingelmunster (Belgique). Acajou, foncée, limpide (sur levure ); mousse beige crémeuse et vivante, peu saturée. Nez puissant, réglissé et liquoreux, légèrement épicé. Saveur très sucrée et amère, dense et ample, liquoreuse. Robe accrocheuse (alcool). Forte et capiteuse , mais trop sucrée. Manque d''équilibre et de vrai relief.');
INSERT INTO beer (grade, label, alcohol, brewery, country, description) VALUES (0.760, 'Orval', 6.2, 'Abbaye trappiste d''Orval', 'Belgique', 'La Bière Orval est une bière de type trappiste à fermentation haute, conçue par le brasseur Abbaye trappiste d''Orval à Villers devant Orval (Belgique). C''est la bière que l''on peut trouver couramment sur le marché. D''une couleur mordorée-orangée, troublée par sa levure. Sa mousse est assez crémeuse et abondante. La bière ne présente pas de saturation excessive. Son nez est très complexe, on y détecte des tons de fruits acides et amers (pomme, rhubarbe ?); des tons sûrs (les levures Brettanomyces jouent leur rôle). En bouche, l''arôme est mêlé de tons de levure acre et de houblons aromatiques. La saveur est simplement extra-ordinaire, son amertume sèche et intense, son corps ample et velouté révèle une légère acidité salée/sèche. C''est une bière belge qu''on aime ou que l''on déteste, mais c''est à mon sens une très grande bière trappiste, absolument unique en son genre. Un vrai "classique", à déguster à température de cave');
INSERT INTO beer (grade, label, alcohol, brewery, country, description) VALUES (0.810, 'Brigand', 9.0, 'Van Honsebrouck', 'Belgique', 'La Bière Brigand est une bière de type spéciale à fermentation haute, conçue par le brasseur Van Honsebrouck à Ingelmunster (Belgique). La Brigand est une bière blonde au goût évolutif . Un peu aigre au début, elle reprend vite un goût plus moelleux, fruité et doux mais fort en alcool. Sa mousse forme une belle crème de tenue satisfaisante. C''est une bière d''histoire : son nom provient du 18ème siècle, où dans les Flandres, les fermiers flamand se faisaient appelés les brigands.');
--INSERT INTO beer (grade, label, alcohol, brewery, country, description) VALUES (0.770, 'Cuvée des Trolls', 7.0, '(inconnue)', 'Belgique', 'La Bière Cuvee des trolls est une bière de type à fermentation haute, conçue par le brasseur à Louvain-La-Neuve (Belgique). La bière Cuvée des Trolls est la dernière née de la brasserie Dubuisson, plus précisément, elle est fabriquée à la micro-brasserie du "Brasse-temps". Non filtrée, elle est naturellement trouble. C''est une bière moyennement forte à 7%. Son arôme est fruité avec des notes d'écorces d'orange. Avec son logo, le Troll, cette bière belge au premier aspect humouristique tient toutes ses promessses ! La brasserie Dubuisson la présente comme une bière étrangement sympathique. Elle sera le partenaire idéal de vos apéritifs et soirées autour de la bières...');
INSERT INTO beer (grade, label, alcohol, brewery, country, description) VALUES (0.730, 'Delirium tremens', 9.0, 'Huyghe', 'Belgique', 'La Bière Delirium tremens est une bière de type spéciale à fermentation haute, conçue par le brasseur Huyghe à Gand (Belgique). Abricot-trouble, bien saturée, mousse blanche fine subsistant sur 3 mm. Cette bière belge au nez à la fois doux et puissant révéle une certaine acreté et un maltage profond. Bouche pleine et douce, amertume et acreté prononcées et durables. Saveur puissante, post-saveur durable. Corsée, forte et capiteuse.');
INSERT INTO beer (grade, label, alcohol, brewery, country, description) VALUES (0.900, 'Gouden Carolus', 8.3, 'Het Anker', 'Belgique', 'La Bière Gouden carolus est une bière de type spéciale à fermentation haute, conçue par le brasseur Het anker à Mechelen (Malines) (Belgique). Brun-rouge, léger trouble, peu saturée , mousse abondante mais peu serrée de tenue moyenne. Arôme légèrement vineux et caramélisé, moelleux et assez puissant. Bouche pleine, moelleuse, très amère et légèrement vineuse, aux nuances liquoreuses. Arrière goût amer persistant et grillé. Très forte.');
INSERT INTO beer (grade, label, alcohol, brewery, country, description) VALUES (0.670, 'Achel', 6.0, 'De Achelse Kluis', 'Belgique', 'La Bière Achel 6° est une bière de type trappiste à fermentation haute, conçue par le brasseur De Achelse Kluis à (Belgique). D''un nez léger presque plus fin que la 4°, elle présente une bouche fine et moins sucrée que cette dernière malgré une teneur en alcool plus élevée. l''amertume est également moins présente. Le corps est ferme et bien étalée. Elle apparaît mieux équilibrée et moins "collante" que la 4° et l''amertume est bien balancée. Bière honnête et désaltérante, qui était disponible uniquement à la pression.');
INSERT INTO beer (grade, label, alcohol, brewery, country, description) VALUES (0.790, 'Queue de charrue', 9.0, 'Van steenberge', 'Belgique', 'La Bière Queue de charrue blonde est une bière de type spéciale à fermentation haute, conçue par le brasseur Van steenberge à Ploegsteert (Belgique). Brassée depuis 1992 par la brasserie Van Steenberghe en Belgique pour le caviste Vanuxem !');
INSERT INTO beer (grade, label, alcohol, brewery, country, description) VALUES (0.805, 'Chouffe', 8.0, 'Achouffe', 'Belgique', 'La Bière La chouffe est une bière de type garde à fermentation haute, conçue par le brasseur Achouffe à Achouffe (Belgique).');
INSERT INTO beer (grade, label, alcohol, brewery, country, description) VALUES (0.780, 'Wambrechies', 7.5, 'Du Bocq', 'Belgique', 'La Bière Wambrechies bière au genièvre pur vieux malt (la) est une bière de type spéciale à fermentation haute, conçue par le brasseur Du Bocq à (Belgique).');
