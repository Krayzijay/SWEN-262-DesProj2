--Clears existing tables
DROP TABLE IF EXISTS Library;
DROP TABLE IF EXISTS Song;
DROP TABLE IF EXISTS Artist;
DROP TABLE IF EXISTS Release;

--Creates Library with Song, Artist, and Release Collection with search results
CREATE TABLE Library(
            SongCollection TEXT DEFAULT '',
            ArtistCollection TEXT DEFAULT '',
            ReleaseCollection TEXT DEFAULT '',
            SearchResults TEXT DEFAULT ''
);

--Creates table for a song
CREATE TABLE Song(
            id SERIAL PRIMARY KEY,
            GUID VARCHAR(37),
            Title TEXT DEFAULT '',
            Artist VARCHAR(37),
            Duration MEDIUMINT, 
            UserRating FLOAT,
            AvgRating FLOAT
);

--Creates table for an Artist
CREATE TABLE Artist(
            id SERIAL PRIMARY KEY,
            GUID VARCHAR(37),
            Name TEXT '',
            TYPE TEXT ''
);

--Creates table for a Release
CREATE TABLE Release(
            id SERIAL PRIMARY KEY,
            GUID VARCHAR(37),
            Title TEXT '',
            Artist VARCHAR(37),
            IssueDate TEXT '',
            Medium ENUM('Digital', 'CD', 'Vinyl'),
            Tracks TEXT '',
            UserRating FLOAT,
            AvgRating FLOAT
);

--Inner joins the Artist GUID in Song/Release with the Artist's GUID
SELECT Song.Artist FROM Song INNER JOIN Artist ON Song.Artist=Artist.GUID;
SELECT Release.Artist FROM Release INNER JOIN Artist ON Release.Artist=Artist.GUID;