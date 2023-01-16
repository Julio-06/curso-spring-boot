INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (1, 'Julio', 'Tejeira', 'julio@email.com', '2023-01-09', ''), (2, 'Pablo', 'Tejeira', 'pablo@email.com', '2023-01-10', ''), (3, 'Cesar', 'Tejeira', 'cesar@email.com', '2023-01-11', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (4, 'Julio', 'Tejeira', 'julio@email.com', '2023-01-09', ''), (5, 'Pablo', 'Tejeira', 'pablo@email.com', '2023-01-10', ''), (6, 'Cesar', 'Tejeira', 'cesar@email.com', '2023-01-11', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (7, 'Julio', 'Tejeira', 'julio@email.com', '2023-01-09', ''), (8, 'Pablo', 'Tejeira', 'pablo@email.com', '2023-01-10', ''), (9, 'Cesar', 'Tejeira', 'cesar@email.com', '2023-01-11', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (10, 'Julio', 'Tejeira', 'julio@email.com', '2023-01-09', ''), (11, 'Pablo', 'Tejeira', 'pablo@email.com', '2023-01-10', ''), (12, 'Cesar', 'Tejeira', 'cesar@email.com', '2023-01-11', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (13, 'Julio', 'Tejeira', 'julio@email.com', '2023-01-09', ''), (14, 'Pablo', 'Tejeira', 'pablo@email.com', '2023-01-10', ''), (15, 'Cesar', 'Tejeira', 'cesar@email.com', '2023-01-11', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (16, 'Julio', 'Tejeira', 'julio@email.com', '2023-01-09', ''), (17, 'Pablo', 'Tejeira', 'pablo@email.com', '2023-01-10', ''), (18, 'Cesar', 'Tejeira', 'cesar@email.com', '2023-01-11', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (19, 'Julio', 'Tejeira', 'julio@email.com', '2023-01-09', ''), (20, 'Pablo', 'Tejeira', 'pablo@email.com', '2023-01-10', ''), (21, 'Cesar', 'Tejeira', 'cesar@email.com', '2023-01-11', '');


/* CARGANDO DATOS EN LA TABLA 'productos' */

INSERT INTO productos (nombre, precio, created_at) VALUES ('Laptop HP Omen 16', 1500, NOW()), ('Monitor LG', 120, NOW()), ('Teclado Razer', 110, NOW());
INSERT INTO productos (nombre, precio, created_at) VALUES ('Silla Gamer Sharkoon', 150, NOW()), ('Audifonos Sennheiser', 360, NOW()), ('Bocina Bose', 250, NOW());
INSERT INTO productos (nombre, precio, created_at) VALUES ('Escritorio de madera', 500, NOW()), ('Impresora HP', 400, NOW()), ('Resma de hojas blancas', 20, NOW());
INSERT INTO productos (nombre, precio, created_at) VALUES ('Router Gamer HP', 100, NOW()), ('Iphone 11', 900, NOW()), ('Televisión LG', 600, NOW());
INSERT INTO productos (nombre, precio, created_at) VALUES ('Lavadora Samsung de 25 Kg', 850, NOW()), ('Nevera Samsung', 1200, NOW()), ('Aire acondicionado 24 btu', 1000, NOW());
INSERT INTO productos (nombre, precio, created_at) VALUES ('Microondas', 150, NOW()), ('Mouse Logitech', 40, NOW()), ('Mouse pad', 15, NOW());
INSERT INTO productos (nombre, precio, created_at) VALUES ('Sistema operativo Windows 11 Pro', 50, NOW()), ('Anti-virus ESET Internet', 70, NOW()), ('Cargador de Iphone', 60, NOW());

/* CARGANDO FACTURAS DE EJEMPLO */
INSERT INTO facturas (folio, descripcion, observacion, cliente_id, created_at) VALUES (UUID(), 'Equipos de oficina', 'test', 1, NOW());
INSERT INTO facturas_items (cantidad, producto_id, factura_id, created_at) VALUES (1, 1, 1, NOW()), (1, 2, 1, NOW()), (1, 3, 1, NOW()), (1, 4, 1, NOW()), (1, 5, 1, NOW());
INSERT INTO facturas (folio, descripcion, observacion, cliente_id, created_at) VALUES (UUID(), 'Electrodomesticos', 'test', 1, NOW());
INSERT INTO facturas_items (cantidad, producto_id, factura_id, created_at) VALUES (1, 13, 2, NOW()), (1, 14, 2, NOW()), (1, 15, 2, NOW()), (1, 16, 2, NOW());