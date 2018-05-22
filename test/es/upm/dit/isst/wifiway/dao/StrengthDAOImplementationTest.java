package es.upm.dit.isst.wifiway.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.upm.dit.isst.wifiway.dao.model.Point;
import es.upm.dit.isst.wifiway.dao.model.Strength;
import es.upm.dit.isst.wifiway.dao.model.Wifi;

public class StrengthDAOImplementationTest {
	
	
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

	}
	
	@After
	public void tearDown() throws Exception {
		PointDAOImplementation.getInstance().deletePoint(point1);
		WifiDAOImplementation.getInstance().deleteWifi(wifi1);
		StrengthDAOImplementation.getInstance().deleteStrength(strength1);
	}
	
	@Test
	public void testAll() {
		strength1 = new Strength();
		strength1.setPoint(point1);
		strength1.setWifi(wifi1);
		strength1.setId();
		
		StrengthDAOImplementation.getInstance().createStrength(strength1);
		
		Strength strength2 =  StrengthDAOImplementation.getInstance().readStrength(strength1.getId());
		assertEquals(strength1.getPoint().getId(), strength2.getPoint().getId());
		assertEquals(strength1.getWifi().getMAC(), strength2.getWifi().getMAC());
		assertEquals(strength1.getId(), strength2.getId());
		
		StrengthDAOImplementation.getInstance().deleteStrength(strength2);
		Strength strength3 =  StrengthDAOImplementation.getInstance().readStrength(strength1.getId());
		assertNull(strength3);
		
	}

}
