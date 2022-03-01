Me funciona el codigo  arrancandolo desde *ProyectoFinalDeSpringApplication* (lo tengo comentado)
Pero he probado en otro ordenador y me da errores.
He escrito todo el codigo para meterlo en mysql dentro
de la terminal, es la unica forma en la que me va de las dos formas
```sql
INSERT INTO FNACuel.area (nombre) VALUES('Zona 1');
INSERT INTO FNACuel.area (nombre) VALUES('Zona 2');
INSERT INTO FNACuel.area (nombre) VALUES('Zona 3');

INSERT INTO FNACuel.categoria (id, imagen, nombre) VALUES(1, 'https://www.eluniverso.com/resizer/zTz3yKqRzQ6iwofrGIjh0zI24tg=/1200x669/smart/filters:quality(70)/cloudfront-us-east-1.images.arcpublishing.com/eluniverso/IJLSKMNQANH2NEGXXKWZXRT37Y.png', 'libros');
INSERT INTO FNACuel.categoria (id, imagen, nombre) VALUES(2, 'https://blog.orange.es/wp-content/uploads/sites/4/2021/09/todointernet.jpg', 'servicios');
INSERT INTO FNACuel.categoria (id, imagen, nombre) VALUES(3, 'https://es-commerce.com/imagenes/como-crear-una-tienda-online-de-productos-de-segunda-mano.jpg', 'digital');

INSERT INTO FNACuel.compania (ano_fundacion, calidad, nombre) VALUES(1923, 'media', 'iberia');
INSERT INTO FNACuel.compania (ano_fundacion, calidad, nombre) VALUES(1923, 'media-alta', 'Air europa');
INSERT INTO FNACuel.compania (ano_fundacion, calidad, nombre) VALUES(1923, 'baja', 'Russian airlines');
INSERT INTO FNACuel.compania (ano_fundacion, calidad, nombre) VALUES(1923, 'alta', 'Ukranian Airlines');


INSERT INTO FNACuel.marca(ano_fundacion, imagen, nombre) VALUES(1923, 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/36/Hasbro_4c_no_R.png/1024px-Hasbro_4c_no_R.png' ,'Hasbro');
INSERT INTO FNACuel.marca(ano_fundacion, imagen, nombre) VALUES(1985, 'https://yt3.ggpht.com/ytc/AKedOLQNlslsaaTg6EpR5HNWBoDFw2BdoY91ZXsCI9312g=s900-c-k-c0x00FFF-no-rj' , 'Devir');
INSERT INTO FNACuel.marca(ano_fundacion, imagen, nombre) VALUES(1945, 'http://www.edgeent.com/static/img/LOGO_EDGE_WHITE.jpg' ,'Edge');
INSERT INTO FNACuel.marca(ano_fundacion, imagen, nombre) VALUES(1995, 'https://wargarage.org/wp-content/uploads/2018/05/asmodee-logo.jpg' ,'Asmodee');
INSERT INTO FNACuel.marca(ano_fundacion, imagen, nombre) VALUES(1995, 'https://www.planetadelibros.com/img/sellos_og/logo_DESTINO.jpg' ,'Destino');
INSERT INTO FNACuel.marca(ano_fundacion, imagen, nombre) VALUES(1995, 'https://pbs.twimg.com/profile_images/1274933503864590341/20Imga6R_400x400.png' ,'Planeta');
INSERT INTO FNACuel.marca(ano_fundacion, imagen, nombre) VALUES(1995, 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/5f/Microsoft_Office_logo_%282019%E2%80%93present%29.svg/640px-Microsoft_Office_logo_%282019%E2%80%93present%29.svg.png' ,'Microsoft');
INSERT INTO FNACuel.marca(ano_fundacion, imagen, nombre) VALUES(1995, 'https://latam.kaspersky.com/content/es-mx/images/repository/pr/the-company-unveils-new-branding-and-visual-identity-1.jpg' ,'Kaspersky');
INSERT INTO FNACuel.marca(ano_fundacion, imagen, nombre) VALUES(1995, 'https://i.blogs.es/a4eda0/mcafee/1366_2000.jpeg' ,'McAfee');




INSERT INTO FNACuel.producto
(imagen, material, titulo, area, categoria, marca, fechalanzamiento)
VALUES('https://imagessl4.casadellibro.com/a/l/t5/24/8432715140924.jpg', 'papel y carton', 'La Vall de la Llum', 1, 1, 5, '2021-03-22');

INSERT INTO FNACuel.producto
(imagen, material, titulo, area, categoria, marca, fechalanzamiento)
VALUES('https://images-na.ssl-images-amazon.com/images/I/81uBU-ZSxQL.jpg', 'papel', 'Violeta', 1, 1, 5, '2020-12-20');

INSERT INTO FNACuel.producto
(imagen, material, titulo, area, categoria, marca, fechalanzamiento)
VALUES('https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcSxvDTAnwQ5ODp5MZNN2piKUIdY20H1kgHiyd4OY5raiYabH3HbjYvwsAePMfOY9VSjFAxCr0dUjzAXbcrJiHqpTDyUPiGjP7FkzOm9h6xu-qMURz3YSqFE&usqp=CAY', 'papel', 'La bestia', 1, 1, 5, '2020-12-20');



INSERT INTO FNACuel.servicio
(duracion, fecha, horario, imagen, localizacion, nombre, area, compania, categoria)
VALUES(2 , '2021-11-30', 14, 'https://cdn.businessinsider.es/sites/navi.axelspringer.es/public/styles/bi_1752/public/media/image/2020/06/aeropuerto-madrid-barajas-adolfo-suarez-1974959.jpeg?itok=uMcdbz6c', 'Aeropuerto Adolfo Suarez', 'Vuelo a Italia', 3, 1, 2);

INSERT INTO FNACuel.servicio
(duracion, fecha, horario, imagen, localizacion, nombre, area, compania, categoria)
VALUES(4 , '2021-11-30', 14, 'https://cronicaglobal.elespanol.com/uploads/s1/11/47/44/78/barcelona-aeropuerto.jpeg', 'Aeropuerto de El Prat', 'Vuelo a Ucrania', 3, 4, 2);

INSERT INTO FNACuel.servicio
(duracion, fecha, horario, imagen, localizacion, nombre, area, compania, categoria)
VALUES(4 , '2021-11-30', 14, 'https://www.i-torrestrella.com/wp-content/uploads/aeropuerto-internacional-lima-1200x478.jpg', 'Aeropuerto internacional Jorge Chavez', 'Vuelo a Madrid', 3, 3, 2);



INSERT INTO FNACuel.digital
(claveactivacion, duracion, imagen, nombre, area, categoria, marca)
VALUES(65261655, 12, 'https://www.cubicamultimedia.com/wp-content/uploads/Office.png', 'Office 365', 2, 3, 7);

INSERT INTO FNACuel.digital
(claveactivacion, duracion, imagen, nombre, area, categoria, marca)
VALUES(65432687, 24, 'https://m.media-amazon.com/images/I/61QN710V21L._AC_SX342_.jpg', 'Karpesky Total Security', 2, 3, 8);

INSERT INTO FNACuel.digital
(claveactivacion, duracion, imagen, nombre, area, categoria, marca)
VALUES(69781614, 6, 'https://assets.mmsrg.com/isr/166325/c1/-/ASSET_MMS_82117022/fee_786_587_png', 'McAfee LiveSafe', 2, 3, 9);

```