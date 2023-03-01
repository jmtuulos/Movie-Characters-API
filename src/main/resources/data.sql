/*Initial data injection to the DB */
/*Insert some movies to the franchise*/
insert into franchise
(description, franchise_name) values
        ('The best movies ever', 'Star Wars'),
        ('lord of the rings', 'Lord of the Rings');

insert into movie
(movie_title) values
        ('Star Wars: A New Hope'),
        ('Star Wars: The Empire Strikes Back'),
        ('Star Wars: Return of the Jedi'),
        ('Star Wars: The Phantom Menace'),
        ('Star Wars: Attack of the Clones'),
        ('Star Wars: Revenge of the Sith'),
        ('Star Wars: The Force Awakens'),
        ('Star Wars: The Last Jedi'),
        ('Star Wars: The Rise of Skywalker'),
        ('The Lord of the Rings: The Fellowship of the Ring'),
        ('The Lord of the Rings: The Two Towers'),
        ('The Lord of the Rings: The Return of the King');

insert into character
(alias, gender, full_name) values
        ('R2-D2','Robot', 'Kenny Baker'),
        ('Frodo', 'Male', 'Elijah Wood'),
        ('Obi-Wan Kenobi', 'Male', 'Evan McGrecor');
