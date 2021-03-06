package vgtu.ignas.teamsports;

import vgtu.ignas.teamsports.model.Location;
import vgtu.ignas.teamsports.model.PlayEvent;
import vgtu.ignas.teamsports.model.Player;
import vgtu.ignas.teamsports.model.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class PlayEventTests {
    private static final Logger log = LoggerFactory.getLogger( PlayEvent.class );

    private SessionFactory sf;




    @Test
    public void test() {
        Session session = null;
        Transaction txn = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            txn = session.beginTransaction();

            Location l1 = new Location();
            l1.setId(1);
            l1.setName("Axel");
            l1.setAddress("balcikonio 9");
            l1.setMaxCourts(5);
            l1.setFreeCourts(4);

            Player player = new Player();
            player.setUsername("Ignas");
            player.setPassword("kokokok");
            player.setEmail("jojo@jojo.com");
            player.setUserType(0);
            player.setRank(10);

            Player player2 = new Player();
            player2.setUsername("montini");
            player2.setPassword("energy");
            player2.setEmail("lemontini@gmail.com");
            player2.setUserType(0);
            player2.setRank(1);

            Review review = new Review();
            review.setTimestamp(new Timestamp(System.currentTimeMillis()));
            review.setDescription("New message from team-sport user.");
            review.setPlayer(player);

            Review review2 = new Review();
            review2.setTimestamp(new Timestamp(System.currentTimeMillis()));
            review2.setDescription("My text came in here");
            review2.setPlayer(player2);

            Set<Player> players = new HashSet<Player>();
            players.add(player);
            players.add(player2);

            Set<Review> reviews = new HashSet<>();
            reviews.add(review);
            reviews.add(review2);

            PlayEvent playEvent = new PlayEvent();
            playEvent.setLocation(l1);
            playEvent.setEventDate(new Date(2019-12-12));
            playEvent.setEventTime(new Time(System.currentTimeMillis()));
            playEvent.setTitle("UFC");
            playEvent.setGameType(2);
            playEvent.setFreeSlots(5);


            PlayEvent playEvent2 = new PlayEvent();
            playEvent2.setLocation(l1);
            playEvent2.setEventDate(new Date(2019-12-12));
            playEvent2.setEventTime(new Time(System.currentTimeMillis()));
            playEvent2.setTitle("UFC");
            playEvent2.setGameType(2);
            playEvent2.setFreeSlots(5);


            playEvent.setPlayers(players);
            playEvent.setReviews(reviews);


            session.save(player);
            session.save(player2);
            session.save(review);
            session.save(review2);
            session.save(l1);
            session.save(playEvent);
            session.save(playEvent2);


            txn.commit();
        } catch (RuntimeException e) {
            if ( txn != null && txn.isActive() ) txn.rollback();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}

