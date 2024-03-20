-- CUSTOMER
INSERT INTO public.customer(
	customernumber, name, forename, bdate, salutation, createdat, changedat)
	VALUES ('000100201', 'Name1', 'Vorname1', '2001-01-11', 'Herr', '2024-02-29', '2024-02-29');
INSERT INTO public.customer(
	customernumber, name, forename, bdate, salutation, createdat, changedat)
	VALUES ('000100202', 'Name2', 'Vorname2', '2001-01-12', 'Herr', '2024-02-29', '2024-02-29');
INSERT INTO public.customer(
	customernumber, name, forename, bdate, salutation, createdat, changedat)
	VALUES ('000100203', 'Name3', 'Vorname3', '2001-01-13', 'Herr', '2024-02-29', '2024-02-29');
INSERT INTO public.customer(
	customernumber, name, forename, bdate, salutation, createdat, changedat)
	VALUES ('000100204', 'Name4', 'Vorname4', '2001-01-14', 'Frau', '2024-02-29', '2024-02-29');
INSERT INTO public.customer(
	customernumber, name, forename, bdate, salutation, createdat, changedat)
	VALUES ('000100205', 'Name5', 'Vorname5', '2001-01-15', 'Frau', '2024-02-29', '2024-02-29');
INSERT INTO public.customer(
	customernumber, name, forename, bdate, salutation, createdat, changedat)
	VALUES ('000100206', 'Name6', 'Vorname6', '2001-01-16', 'Frau', '2024-02-29', '2024-02-29');
INSERT INTO public.customer(
	customernumber, name, forename, bdate, salutation, createdat, changedat)
	VALUES ('000100207', 'Name7', 'Vorname7', '2001-01-17', 'Dr.', '2024-02-29', '2024-02-29');

-- ADDRESS
INSERT INTO public.address(
	street, housenumber, citycode, city, addresstype, customer, createdat, changedat)
	VALUES ('Strasse 1', '1', '89080', 'Ulm', 'l', 1, '2024-02-29', '2024-02-29');

-- PRODUCT
INSERT INTO public.product(
	price, productnumber, description, createdat, changedat)
	VALUES (1.50, '10203040', 'Beschreibung 1', '2024-03-03', '2024-03-03');

-- SHOPORDER
INSERT INTO public.shoporder(
	customer, ordernumber, createdat, changedat)
	VALUES (3, '003000', '2024-02-29', '2024-02-29');
