/*============================== CREATE DATABASE =======================================*/
/*======================================================================================*/
-- DROP DATABASE IF EXISTS heroku_acfc34e6179a4a3;
CREATE DATABASE heroku_acfc34e6179a4a3;
USE heroku_acfc34e6179a4a3;

/*============================== CREATE TABLE=== =======================================*/
/*======================================================================================*/
-- CREATE TABLE: Admin
DROP TABLE IF EXISTS `Admin`;
CREATE TABLE `Admin`(
	AdminID			INT UNSIGNED NOT NULL  PRIMARY KEY AUTO_INCREMENT ,
	Email 			VARCHAR(256)  NOT NULL UNIQUE KEY ,
	`Password`		NVARCHAR(256) NOT NULL
);

-- CREATE TABLE: User
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User`(
	UserID			INT UNSIGNED NOT NULL  PRIMARY KEY AUTO_INCREMENT,
    FacebookID		VARCHAR(250) NOT NULL UNIQUE,
	`Name`			NVARCHAR(250) NOT NULL,
    Email 			VARCHAR(50) NOT NULL UNIQUE KEY ,
    Address			NVARCHAR(250) NOT NULL
);

-- CREATE TABLE: Country
DROP TABLE IF EXISTS Country;
CREATE TABLE Country(
	CountryID 		INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	CountryName		NVARCHAR(250) NOT NULL UNIQUE KEY,
    `Description`	TEXT NOT NULL,
    Image			VARCHAR(400)
);

-- CREATE TABLE: City
DROP TABLE IF EXISTS City;
CREATE TABLE City(
	CityID 			INT UNSIGNED PRIMARY KEY  AUTO_INCREMENT,
	CityName		NVARCHAR(100) NOT NULL UNIQUE KEY,
    `Description`	TEXT NOT NULL ,
    CountryID 		INT UNSIGNED NOT NULL,
    Image			VARCHAR(400),
    FOREIGN KEY 	(CountryID) 	REFERENCES 		Country (CountryID)
);

-- CREATE TABLE: FavoriteCity
DROP TABLE IF EXISTS FavoriteCity;
CREATE TABLE FavoriteCity(
	UserID			INT UNSIGNED NOT NULL,
	CityID 			INT UNSIGNED NOT NULL,
    FOREIGN KEY 	(UserID) 		REFERENCES 		`User` 	(UserID),
    FOREIGN KEY 	(CityID) 		REFERENCES 		City 	(CityID),
    PRIMARY KEY 	(UserID, CityID)
);

/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- INSERT DATABASE TO TABLE Admin
INSERT INTO `Admin`		(	Email						, 	`Password` 		) 
VALUES 					(	"ngthanhtien@gmail.com"		,	"admin123"		),
						(	"nghoanggiang@gmail.com"	,	"admin123"		),
                        (	"quanghuybui@gmail.com"		,	"admin123"		),
                        (	"longduc@gmail.com"			,	"admin123"		),
                        (	"nguyendacngoc@gmail.com"	,	"admin123"		),
                        (	"tuvandai@gmail.com"		,	"admin123"		),
                        (	"damquangtrung@gmail.com"	,	"admin123"		),
                        (	"hatienhiepn@gmail.com"		,	"admin123"		);

-- INSERT DATABASE TO TABLE User
INSERT INTO `User`		(UserID,		FacebookID				,	`Name`						, 	Email					,	Address		)
VALUES					(	1	,	"2000000000000000"		,	"Nguyễn Thanh Tiến"			,	"ngthanhtien@gmail.com"	,	"Trung thôn, Đông Hội, Đông Anh, Hà Nội"),
						(	2	,	"1000000000000000"		,	"Nguyễn Hoàng Giang"		,	"nghoanggiang@gmail.com",	"Trung thôn, Đông Hội, Đông Anh, Hà Nội");
-- INSERT DATABASE TO TABLE COUNTRY
INSERT INTO Country		(CountryID, 	CountryName					, 	`Description` 			, 	Image		) 
VALUES 					(	1		,	"Brunei"					,		"abc"				,	"https://www.asean.org/wp-content/uploads/2012/05/Flag_of_Brunei-01-e1456993078833.jpg"		),
						(	2		,	"Campuchia"					,		"abc"				,	"https://www.asean.org/wp-content/uploads/2012/05/Flag_of_Cambodia-01-e1456993037933.jpg"		),
                        (	3		,	"Indonesia"					,		"abc"				,	"https://www.asean.org/wp-content/uploads/2012/05/Flag_of_Indonesia-01-e1456992989977.jpg"		),
                        (	4		,	"Lào"						,		"abc"				,	"https://www.asean.org/wp-content/uploads/2012/05/Flag_of_Laos-01-e1456992960442.jpg"		),
                        (	5		,	"Malaysia"					,		"abc"				,	"https://www.asean.org/wp-content/uploads/2012/05/Flag_of_Malaysia-01-e1456992923180.jpg"		),
                        (	6		,	"Myanmar"					,		"abc"				,	"https://www.asean.org/wp-content/uploads/2012/05/Flag_of_Myanmar-01-e1456992867392.jpg"		),
                        (	7		,	"Philippines"				,		"abc"				,	"https://www.asean.org/wp-content/uploads/2012/05/Flag_of_the_Philippines-01-e1456992734443.jpg"		),
                        (	8		,	"Singapore"					,		"abc"				,	"https://www.asean.org/wp-content/uploads/2012/05/Flag_of_Singapore-01-2-e1456992604763.jpg"		),
                        (	9		,	"Thái Lan"					,		"abc"				,	"https://www.asean.org/wp-content/uploads/2012/05/Flag_of_Thailand-01-e1456992789846.jpg"		),
						(	10		,	"Timor Leste"				,		"abc"				,	"https://upload.wikimedia.org/wikipedia/commons/9/90/Flag_of_East_Timor_3.png"		),
						(	11		,	"Việt Nam"					,		"abc"				,	"https://www.asean.org/wp-content/uploads/2012/05/Flag_of_Vietnam-01-e1456992769953.jpg"		);
                        
-- INSERT DATABASE TO TABLE City
INSERT INTO City		(CityID,	CityName					,	`Description`	,	CountryID	,	Image 		)
VALUES					(	1	,	"Bandar Seri Begawan"		,	"abc"			,		1		,	"abc"		),
						(	2	,	"Kampung Kota Batu"			,	"abc"			,		1		,	"abc"		),
                        (	3	,	"Tutong"					,	"abc"			,		1		,	"abc"		),
                        (	4	,	"Temburong"					,	"abc"			,		1		,	"abc"		),
                        (	5	,	"Melilas"					,	"abc"			,		1		,	"abc"		),
                        (	6	,	"Koh Rong"					,	"abc"			,		2		,	"abc"		),
                        (	7	,	"Sihanoukville"				,	"abc"			,		2		,	"abc"		),
                        (	8	,	"Kampot"					,	"abc"			,		2		,	"abc"		),
                        (	9	,	"Phnom Penh"				,	"abc"			,		2		,	"abc"		),
                        (	10 	,	"Kratie"					,	"abc"			,		2		,	"abc"		),
                        (	11	,	"Bukittinggi"				,	"abc"			,		3		,	"abc"		),
                        (	12	,	"Yogyakarta"				,	"abc"			,		3		,	"abc"		),
                        (	13	,	"Jakarta"					,	"abc"			,		3		,	"abc"		),
                        (	14	,	"Bandung"					,	"abc"			,		3		,	"abc"		),
                        (	15	,	"Manado"					,	"abc"			,		3		,	"abc"		),
                        (	16	,	"Pakxe"						,	"abc"			,		4		,	"abc"		),
                        (	17	,	"Vientiane"					,	"abc"			,		4		,	"abc"		),
                        (	18	,	"Vang Vieng"				,	"abc"			,		4		,	"abc"		),
                        (	19	,	"Champasak"					,	"abc"			,		4		,	"abc"		),
                        (	20	,	"Luang Prabang"				,	"abc"			,		4		,	"abc"		),
                        (	21	,	"Malacca"					,	"abc"			,		5		,	"abc"		),
						(	22	,	"Langkawi"					,	"abc"			,		5		,	"abc"		),
						(	23	,	"Kuantan"					,	"abc"			,		5		,	"abc"		),
						(	24	,	"Perhentian"				,	"abc"			,		5		,	"abc"		),
						(	25	,	"Kuala Lumpur"				,	"abc"			,		5		,	"abc"		),
                        (	26	,	"Yangon"					,	"abc"			,		6		,	"abc"		),
                        (	27	,	"Mandalay"					,	"abc"			,		6		,	"abc"		),
                        (	28	,	"Bagan"						,	"abc"			,		6		,	"abc"		),
                        (	29	,	"Mrauk-U"					,	"abc"			,		6		,	"abc"		),
                        (	30	,	"Nyaung Shwe"				,	"abc"			,		6		,	"abc"		),
                        (	31	,	"Manila"					,	"abc"			,		7		,	"abc"		),
                        (	32	,	"Palawan"					,	"abc"			,		7		,	"abc"		),
                        (	33	,	"Cebu"						,	"abc"			,		7		,	"abc"		),
                        (	34	,	"Padre Burgos"				,	"abc"			,		7		,	"abc"		),
                        (	35	,	"Bacolod"					,	"abc"			,		7		,	"abc"		),
                        (	36	,	"Singapore"					,	"abc"			,		8		,	"abc"		),
						(	37	,	"Sembawang"					,	"abc"			,		8		,	"abc"		),
                        (	38	,	"Jurong West"				,	"abc"			,		8		,	"abc"		),
                        (	39	,	"Bukit Batok"				,	"abc"			,		8		,	"abc"		),
                        (	40	,	"Lim Chu Kang"				,	"abc"			,		8		,	"abc"		),
                        (	41	,	"Bangkok"					,	"abc"			,		9		,	"abc"		),
                        (	42	,	"Phuket"					,	"abc"			,		9		,	"abc"		),
                        (	43	,	"Ayutthaya"					,	"abc"			,		9		,	"abc"		),
                        (	44	,	"Dok Mai"					,	"abc"			,		9		,	"abc"		),
                        (	45	,	"Pattaya"					,	"abc"			,		9		,	"abc"		),
                        (	46	,	"Ha Noi"					,	"abc"			,		11		,	"abc"		),
                        (	47	,	"Ho Chi Minh City"			,	"abc"			,		11		,	"abc"		),
                        (	48	,	"Hai Phong"					,	"abc"			,		11		,	"abc"		),
                        (	49	,	"Da Nang"					,	"abc"			,		11		,	"abc"		),
                        (	50	,	"Hoi An"					,	"abc"			,		11		,	"abc"		);
                        
-- INSERT DATABASE TO TABLE FavoriteCity
INSERT INTO FavoriteCity	(UserID	,	CityID	)
VALUES						(	1	,	1		),
							(	1	,	2		),
							(	1	,	3		),
							(	2	,	4		),
							(	2	,	2		),
							(	2	,	3		),
							(	2	,	1		);