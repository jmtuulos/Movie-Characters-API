/*Initial data injection to the DB */
/*Insert some movies to the franchise*/
insert into franchise
(description, franchise_name, id) values
        ('The best movies ever', 'Star Wars', 1),
        ('lord of the rings', 'Lord of the Rings', 2);

insert into movie
(movie_title, id) values
        ('Star Wars: A New Hope', 1),
        ('Star Wars: The Empire Strikes Back', 2),
        ('Star Wars: Return of the Jedi', 3),
        ('Star Wars: The Phantom Menace', 4),
        ('Star Wars: Attack of the Clones', 5),
        ('Star Wars: Revenge of the Sith', 6),
        ('Star Wars: The Force Awakens', 7),
        ('Star Wars: The Last Jedi', 8),
        ('Star Wars: The Rise of Skywalker', 9),
        ('The Lord of the Rings: The Fellowship of the Ring', 10),
        ('The Lord of the Rings: The Two Towers', 11),
        ('The Lord of the Rings: The Return of the King', 12);

insert into character
(alias, gender, full_name) values
        ('R2-D2','Robot', 'Kenny Baker'),
        ('Frodo', 'Male', 'Elijah Wood'),
        ('Obi-Wan Kenobi', 'Male', 'Evan McGrecor');

insert into movie_characters
(movie_id, character_id) values
        (1, 1),
        (10, 2),
        (1, 2);