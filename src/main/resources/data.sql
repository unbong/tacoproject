delete from Taco_Order_Tacos;
delete from Taco_Ingredients;
delete from Taco;
delete from Taco_Order;

delete from Ingredient;
insert into Ingredient (id, name, type) 
                values ('FLTO', 'Flour Tortilla', 0);
insert into Ingredient (id, name, type) 
                values ('COTO', 'Corn Tortilla', 0);
insert into Ingredient (id, name, type) 
                values ('GRBF', 'Ground Beef', 1);
insert into Ingredient (id, name, type) 
                values ('CARN', 'Carnitas', 1);
insert into Ingredient (id, name, type) 
                values ('TMTO', 'Diced Tomatoes', 2);
insert into Ingredient (id, name, type) 
                values ('LETC', 'Lettuce', 2);
insert into Ingredient (id, name, type) 
                values ('CHED', 'Cheddar', 3);
insert into Ingredient (id, name, type) 
                values ('JACK', 'Monterrey Jack', 3);
insert into Ingredient (id, name, type) 
                values ('SLSA', 'Salsa', 4);
insert into Ingredient (id, name, type) 
                values ('SRCR', 'Sour Cream', 4);

delete from Taco_Ingredients;
insert into Taco values (1, {ts '2012-09-17 18:47:52.69'}, 'favor');
insert into Taco values (2, {ts '2013-09-17 18:47:52.69'}, 'aavor');
insert into Taco values (3, {ts '2014-09-17 18:47:52.69'}, 'vavor');
insert into Taco values (4, {ts '2015-09-17 18:47:52.69'}, 'davor');

insert into Taco_Ingredients  values( 1, 'FLTO');
insert into Taco_Ingredients  values( 1, 'COTO');

insert into Taco_Ingredients  values( 2, 'GRBF');
insert into Taco_Ingredients  values( 2, 'CARN');

insert into Taco_Ingredients  values( 3, 'TMTO');
insert into Taco_Ingredients  values( 3, 'LETC');

insert into Taco_Ingredients  values( 4, 'CHED');
insert into Taco_Ingredients  values( 4, 'JACK');
insert into Taco_Ingredients  values( 4, 'SLSA');