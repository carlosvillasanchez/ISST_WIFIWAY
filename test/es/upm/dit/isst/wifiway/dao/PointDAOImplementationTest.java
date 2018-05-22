package es.upm.dit.isst.wifiway.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.upm.dit.isst.wifiway.dao.PointDAOImplementation;
import es.upm.dit.isst.wifiway.dao.WifiDAOImplementation;
import es.upm.dit.isst.wifiway.dao.StrengthDAOImplementation;

import es.upm.dit.isst.wifiway.dao.model.Point;
import es.upm.dit.isst.wifiway.dao.model.Wifi;
import es.upm.dit.isst.wifiway.dao.model.Strength;


public class PointDAOImplementationTest {
	
	
	private Point point1;
	private Wifi wifi1;
	private Strength strength1;
	
	@Before
	public void setUp() throws Exception {
		point1 = new Point();
		point1.setLatitud(40.40);
		point1.setLongitud(-122.56);
		point1.setId();
		PointDAOImplementation.getInstance().createPoint(point1);
		 
		wifi1 = new Wifi();
		wifi1.setMAC("04:A1:51:14:7C:87");
		wifi1.setOpen(false);
		wifi1.setSsid("RED WIFI 1");
		wifi1.setType("wep");
		WifiDAOImplementation.getInstance().createWifi(wifi1);
		
		strength1 = new Strength();
		strength1.setPoint(point1);
		strength1.setWifi(wifi1);
		strength1.setId();
		StrengthDAOImplementation.getInstance().createStrength(strength1);

	}
	
	@After
	public void tearDown() throws Exception {
		PointDAOImplementation.getInstance().deletePoint(point1);
		WifiDAOImplementation.getInstance().deleteWifi(wifi1);
		StrengthDAOImplementation.getInstance().deleteStrength(strength1);
	}

	


	@Test
	public void testCreatePoint() {
		Point point2 = new Point();
		point2.setLatitud(43.567);
		point2.setLongitud(-122.566);
		point2.setId();
		PointDAOImplementation.getInstance().createPoint(point2);
		
		Point point3 = PointDAOImplementation.getInstance().readPoint(point2.getId());
		PointDAOImplementation.getInstance().deletePoint(point2);
		assertEquals(point2.getId(), point3.getId());
		assertEquals(point2.getLongitud() + "", point3.getLongitud()+ "");
		assertEquals(point2.getLatitud() +"", point3.getLatitud()+ "");
		
	}

	@Test
	public void testReadPoint() {
		Point point2 = new Point();
		point2.setLatitud(43.567);
		point2.setLongitud(-122.566);
		point2.setId();
		PointDAOImplementation.getInstance().createPoint(point2);
		
		Point point3 = PointDAOImplementation.getInstance().readPoint(point2.getId());
		PointDAOImplementation.getInstance().deletePoint(point2);
		assertEquals(point2.getId(), point3.getId());
		assertEquals(point2.getLongitud() + "", point3.getLongitud()+ "");
		assertEquals(point2.getLatitud() +"", point3.getLatitud()+ "");
		PointDAOImplementation.getInstance().deletePoint(point3);
	}

	@Test
	public void testUpdatePoint() {
		point1.setLatitud(133.5);
		
		assertEquals(133.5+"", point1.getLatitud()+"");
		
		
	}

	@Test
	public void testDeletePoint() {
		Point point2 = new Point();
		point2.setLatitud(43.567);
		point2.setLongitud(-122.566);
		point2.setId();
		PointDAOImplementation.getInstance().createPoint(point2);
		PointDAOImplementation.getInstance().deletePoint(point2);
		Point point3 = PointDAOImplementation.getInstance().get(43.567, -122.566);
		
		assertNull(point3);
	}

	@Test
	public void testGet() {
		Point point2 = new Point();
		point2.setLatitud(43.567);
		point2.setLongitud(-122.566);
		point2.setId();
		PointDAOImplementation.getInstance().createPoint(point2);
		
		Point point3 = PointDAOImplementation.getInstance().get(43.567, -122.566);
		PointDAOImplementation.getInstance().deletePoint(point2);
		assertEquals(point2.getId(), point3.getId());
		assertEquals(point2.getLongitud() + "", point3.getLongitud()+ "");
		assertEquals(point2.getLatitud() +"", point3.getLatitud()+ "");
		PointDAOImplementation.getInstance().deletePoint(point3);
	}

}
