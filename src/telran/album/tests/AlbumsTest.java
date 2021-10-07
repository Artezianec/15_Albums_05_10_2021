package telran.album.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.album.model.Albums;
import telran.album.model.IAlbums;
import telran.album.model.Photo;

import java.time.LocalDateTime;


public class AlbumsTest {
    IAlbums album;
    Photo[] photos;

    @BeforeEach
    public void setUp() throws Exception {
        album = new Albums(5);
        photos = new Photo[5];
        photos[0] = new Photo(1, 1, "title", "localhost:80/1.jpg", LocalDateTime.now());
        photos[1] = new Photo(1, 2, "title 1", "localhost:80/2.jpg", LocalDateTime.now());
        photos[2] = new Photo(2, 3, "title 2", "localhost:80/3.jpg", LocalDateTime.now());
        photos[3] = new Photo(2, 4, "title 3", "localhost:80/4.jpg", LocalDateTime.now());
        photos[4] = new Photo(3, 1, "title 4", "localhost:80/5.jpg", LocalDateTime.now());
        for (int i = 0; i < photos.length; i++) {
            album.addPhoto(photos[i]);
        }
    }

    @Test
    public void testAddPhoto() {
        assertFalse(album.addPhoto(photos[0]));
        Photo photoNew = new Photo(4, 1, "title", "localhost:80/6.jpg", LocalDateTime.now());
        assertFalse(album.addPhoto(photoNew));
    }

    @Test
    public void testRemovePhoto() {
        assertTrue(album.removePhoto(1, 1));
        assertFalse(album.removePhoto(1, 11));
    }

    @Test
    public void testUpdatePhoto() {
        assertFalse(album.updatePhoto(55, 4, "localhost:80/7.jpg"));
        assertTrue(album.updatePhoto(1, 1, "test print"));
    }

    @Test
    public void testGetPhotoFromAlbum() {
        assertEquals(photos[0], album.getPhotoFromAlbum(1, 1));
        assertEquals(photos[4], album.getPhotoFromAlbum(1, 3));
    }

    @Test
    public void testGetAllPhotoFromAlbum() {
        assertEquals(photos[4], album.getAllPhotoFromAlbum(3));
    }

/*    @Test
    public void testGetPhotoBetweenDate() {
        assertEquals(photos[0],photos[1],photos[2],photos[3],photos[4],photos[5],album.getPhotoBetweenDate(LocalDateTime.now()));
    }*/
}