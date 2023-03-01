-- insert some dummy data
INSERT INTO franchise (description, franchise_name)
VALUES
    ('A series of science fiction films featuring the blue-skinned Na''vi species native to the planet Pandora.', 'Avatar'),
    ('A series of films about cloned dinosaurs wreaking havoc on humans.', 'Jurassic Park'),
    ('A series of films based on the DC Comics character Batman.', 'The Dark Knight');

-- insert some dummy data
INSERT INTO movie (director, movie_genre, photo_url, movie_title, trailer_url, published_year, franchise_id)
VALUES
    ('James Cameron', 'Action', 'https://example.com/avatar.jpg', 'Avatar', 'https://example.com/avatar-trailer.mp4', 2009, 1),
    ('James Cameron', 'Action', 'https://example.com/avatar.jpg', 'Avatar 2', 'https://example.com/avatar-trailer.mp4', 2011, 1),
    ('Steven Spielberg', 'Adventure', 'https://example.com/jurassic-park.jpg', 'Jurassic Park', 'https://example.com/jurassic-park-trailer.mp4', 1993, 2),
    ('Christopher Nolan', 'Drama', 'https://example.com/dark-knight.jpg', 'The Dark Knight', 'https://example.com/dark-knight-trailer.mp4', 2008, 3),
    ('Quentin Tarantino', 'Crime', 'https://example.com/pulp-fiction.jpg', 'Pulp Fiction', 'https://example.com/pulp-fiction-trailer.mp4', 1994, NULL),
    ('Greta Gerwig', 'Comedy', 'https://example.com/lady-bird.jpg', 'Lady Bird', 'https://example.com/lady-bird-trailer.mp4', 2017, NULL);

-- insert some dummy data
INSERT INTO character (alias, gender, full_name, photo_url)
VALUES
    ('Jake Sully', 'Male', 'Jake Sully', 'https://example.com/jake-sully.jpg'),
    ('Neytiri', 'Female', 'Neytiri', 'https://example.com/neytiri.jpg'),
    ('Alan Grant', 'Male', 'Dr. Alan Grant', 'https://example.com/alan-grant.jpg'),
    ('Ian Malcolm', 'Male', 'Dr. Ian Malcolm', 'https://example.com/ian-malcolm.jpg'),
    ('Bruce Wayne', 'Male', 'Bruce Wayne / Batman', 'https://example.com/batman.jpg'),
    ('The Joker', 'Male', 'The Joker', 'https://example.com/joker');

INSERT INTO movie_characters (movie_id, character_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 3),
    (2, 4),
    (3, 5),
    (3, 6);

