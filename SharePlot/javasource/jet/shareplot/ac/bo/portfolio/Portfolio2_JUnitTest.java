package jet.shareplot.ac.bo.portfolio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import jet.container.managers.session.interfaces.Session;
import jet.framework.component.resource.ResourceNotificationApplicationComponent;
import jet.framework.nuts.store.StoreNut;
import jet.framework.util.exception.FormatedJetException;
import jet.framework.util.pojo2.JFErrorHandler;
import jet.shareplot.persistence.pojo.PortfolioItem;
import jet.util.throwable.JETException;

/**
 * JUnit skeleton for the Portfolio object
 * 
 * @author JetTools
 */
public class Portfolio2_JUnitTest {

    /**
     * Test constructor
     */
    @org.junit.Test
    public void testPortfolio() {
        // arrange : set up the test
        final PortfolioApplicationComponent portfolioAC = mock(PortfolioApplicationComponent.class);

        // act : run the test
        final Portfolio portfolio = new Portfolio(portfolioAC);

        // assert : verify that the test run correctly
        // object should be instanciated
        assertNotNull(portfolio);

        // values should be null
        assertNull(portfolio.getIdPortfolio());
        assertNull(portfolio.getIsFake());
        assertNull(portfolio.getName());
        assertTrue(portfolio.isNotNullableNull());

        // starts up as new
        assertTrue(portfolio.isNew());

        // data nodes should be non null
        assertNotNull(portfolio.get_IdPortfolio_Model());
        assertNotNull(portfolio.get_IsFake_Model());
        assertNotNull(portfolio.get_Name_Model());
        assertNotNull(portfolio.get_Model());
    }

    /**
     * Test model based constructor
     */
    @org.junit.Test
    public void testPortfolioModel() {
        // arrange : set up the test
        final PortfolioApplicationComponent portfolioAC = mock(PortfolioApplicationComponent.class);
        final PortfolioItem item = new PortfolioItem();

        // act : run the test
        final Portfolio portfolio = new Portfolio(item.get_Model(), portfolioAC);

        // assert : verify that the test run correctly
        // object should be instanciated
        assertNotNull(portfolio);
    }

    /**
     * Test model based constructor
     */
    @org.junit.Test
    public void testPortfolioModelData() {
        // arrange : set up the test
        final PortfolioApplicationComponent portfolioAC = mock(PortfolioApplicationComponent.class);
        final PortfolioItem item = new PortfolioItem();
        // TODO insert data in PortfolioItem

        // act : run the test
        final Portfolio portfolio = new Portfolio(item.get_Model(), portfolioAC);

        // assert : verify that the test run correctly
        // object should be instanciated
        assertNotNull(portfolio);
        // TODO check that data is in the portfolio
    }

    /**
     * Test model based constructor
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testPortfolioModelNull() {
        // arrange : set up the test
        final PortfolioApplicationComponent portfolioAC = mock(PortfolioApplicationComponent.class);

        // act : run the test
        new Portfolio(null, portfolioAC);

        // assert : verify that the test run correctly
        // should have thrown an exception
        fail("Expected exception was not thrown.");
    }

    /**
     * Test copy constructor
     */
    @org.junit.Test
    public void testPortfolioPortfolio() {
        // arrange : set up the test
        final PortfolioApplicationComponent portfolioAC = mock(PortfolioApplicationComponent.class);
        final Portfolio item = new Portfolio(portfolioAC);

        // act : run the test
        final Portfolio portfolio = new Portfolio(item);

        // assert : verify that the test run correctly
        // object should be instanciated
        assertNotNull(portfolio);
    }

    /**
     * Test copy constructor
     */
    @org.junit.Test
    public void testPortfolioPortfolioData() {
        // arrange : set up the test
        final PortfolioApplicationComponent portfolioAC = mock(PortfolioApplicationComponent.class);
        final Portfolio item = new Portfolio(portfolioAC);
        // TODO insert data in Portfolio

        // act : run the test
        final Portfolio portfolio = new Portfolio(item);

        // assert : verify that the test run correctly
        // object should be instanciated
        assertNotNull(portfolio);
        // TODO check that data is in the portfolio
    }

    /**
     * Test copy constructor
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testPortfolioPortfolioNull() {
        // arrange : set up the test
        final Portfolio item = null;

        // act : run the test
        new Portfolio(item);

        // assert : verify that the test run correctly
        // should have thrown an exception
        fail("Expected exception was not thrown.");
    }

    /**
     * isNotNullableNull
     */
    @org.junit.Test
    public void testIsNotNullableNullTrue() {
        // arrange : set up the test
        final PortfolioApplicationComponent portfolioAC = mock(PortfolioApplicationComponent.class);
        final Portfolio portfolio = new Portfolio(portfolioAC);

        // act : run the test
        final boolean result = portfolio.isNotNullableNull();

        // assert : verify that the test run correctly
        assertTrue(result);
    }

    /**
     * isNotNullableNull with non null values
     */
    @org.junit.Test
    public void testIsNotNullableNullFalse() {
        // arrange : set up the test
        final PortfolioApplicationComponent portfolioAC = mock(PortfolioApplicationComponent.class);
        final Portfolio portfolio = new Portfolio(portfolioAC);
        portfolio.setIsFake("");
        portfolio.setName("");

        // act : run the test
        final boolean result = portfolio.isNotNullableNull();

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * isPkEquals with equal values
     */
    @org.junit.Test
    public void testIsPkEqualsTrue() {
        // arrange : set up the test
        final PortfolioApplicationComponent portfolioAC = mock(PortfolioApplicationComponent.class);
        final Portfolio otherPortfolio = mock(Portfolio.class);
        // TODO init mock pk
        // eg : when(otherPortfolio.getIdPortfolio()).thenReturn(Long.valueOf(1));

        final Portfolio portfolio = new Portfolio(portfolioAC);
        // TODO init portfolio pk
        // eg : portfolio.get_IdPortfolio_Model().setNodeValue(Long.valueOf(1));

        // act : run the test
        final boolean result = portfolio.isPkEquals(otherPortfolio);

        // assert : verify that the test run correctly
        assertTrue(result);
    }

    /**
     * isPkEquals with non equal values
     */
    @org.junit.Test
    public void testIsPkEqualsFalse() {
        // arrange : set up the test
        final PortfolioApplicationComponent portfolioAC = mock(PortfolioApplicationComponent.class);
        final Portfolio otherPortfolio = mock(Portfolio.class);
        // TODO init mock pk
        // eg : when(otherPortfolio.getIdPortfolio()).thenReturn(Long.valueOf(1));

        final Portfolio portfolio = new Portfolio(portfolioAC);
        // TODO init portfolio pk
        // eg : portfolio.get_IdPortfolio_Model().setNodeValue(Long.valueOf(2));

        // act : run the test
        final boolean result = portfolio.isPkEquals(otherPortfolio);

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * isPkEquals with null pk values
     */
    @org.junit.Test
    public void testIsPkEqualsNullFalse() {
        // arrange : set up the test
        final PortfolioApplicationComponent portfolioAC = mock(PortfolioApplicationComponent.class);
        final Portfolio otherPortfolio = mock(Portfolio.class);

        final Portfolio portfolio = new Portfolio(portfolioAC);

        // act : run the test
        final boolean result = portfolio.isPkEquals(otherPortfolio);

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * isPkEquals with null other object
     */
    @org.junit.Test
    public void testIsPkEqualsFalseNull() {
        // arrange : set up the test
        final PortfolioApplicationComponent portfolioAC = mock(PortfolioApplicationComponent.class);

        final Portfolio portfolio = new Portfolio(portfolioAC);
        // TODO init portfolio pk
        // eg : portfolio.get_IdPortfolio_Model().setNodeValue(Long.valueOf(1));

        // act : run the test
        final boolean result = portfolio.isPkEquals(null);

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * getJFErrorHandler
     */
    @org.junit.Test
    public void testGetJFErrorHandler() {
        // arrange : set up the test
        final PortfolioApplicationComponent portfolioAC = mock(PortfolioApplicationComponent.class);

        final Portfolio portfolio = new Portfolio(portfolioAC);

        // act : run the test
        final JFErrorHandler result = portfolio.getJFErrorHandler();

        // assert : verify that the test run correctly
        assertNull(result);
    }

    /**
     * setJFErrorHandler
     */
    @org.junit.Test
    public void testSetJFErrorHandler() {
        // arrange : set up the test
        final PortfolioApplicationComponent portfolioAC = mock(PortfolioApplicationComponent.class);
        final JFErrorHandler errorHandler = mock(JFErrorHandler.class);

        final Portfolio portfolio = new Portfolio(portfolioAC);

        // act : run the test
        portfolio.setJFErrorHandler(errorHandler);

        // assert : verify that the test run correctly
        final JFErrorHandler result = portfolio.getJFErrorHandler();
        assertNotNull(result);
    }

    /**
     * isValid with valid object
     */
    @org.junit.Test
    public void testIsValidTrue() {
        // arrange : set up the test
        final PortfolioApplicationComponent portfolioAC = mock(PortfolioApplicationComponent.class);

        final Portfolio portfolio = new Portfolio(portfolioAC);
        // TODO set up valid portfolio

        // act : run the test
        final boolean result = portfolio.isValid();

        // assert : verify that the test run correctly
        assertTrue(result);
    }

    /**
     * isValid with NON valid object
     */
    @org.junit.Test
    public void testIsValidFalse() {
        // arrange : set up the test
        final PortfolioApplicationComponent portfolioAC = mock(PortfolioApplicationComponent.class);

        final Portfolio portfolio = new Portfolio(portfolioAC);
        // TODO set up NON valid portfolio

        // act : run the test
        final boolean result = portfolio.isValid();

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * isNew with a new portfolio
     */
    @org.junit.Test
    public void testIsNewTrue() {
        // arrange : set up the test
        final PortfolioApplicationComponent portfolioAC = mock(PortfolioApplicationComponent.class);

        final Portfolio portfolio = new Portfolio(portfolioAC);

        // act : run the test
        final boolean result = portfolio.isNew();

        // assert : verify that the test run correctly
        assertTrue(result);
    }

    /**
     * isNew with an old portfolio
     */
    @org.junit.Test
    public void testIsNewFalse() {
        // arrange : set up the test
        final PortfolioApplicationComponent portfolioAC = mock(PortfolioApplicationComponent.class);

        final Portfolio portfolio = new Portfolio(portfolioAC);
        // TODO set up NON new portfolio

        // act : run the test
        final boolean result = portfolio.isNew();

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * Save, creation
     * 
     * @throws FormatedJetException should be thrown as saving invalid portfolio
     */
    @org.junit.Test(expected = FormatedJetException.class)
    public void testSaveCreateInvalid() throws FormatedJetException {
        // arrange : set up the test
        final PortfolioApplicationComponent portfolioAC = mock(PortfolioApplicationComponent.class);
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        when(portfolioAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(portfolioAC.getStoreNut(anyString())).thenReturn(storeNut);

        final Portfolio portfolio = new Portfolio(portfolioAC);
        // TODO set up invalid portfolio

        // act : run the test
        portfolio.save();

        // assert : verify that the test run correctly
        fail("Expected an exception");
    }

    /**
     * Save, creation
     */
    @org.junit.Test
    public void testSaveCreateValid() {
        // arrange : set up the test
        final PortfolioApplicationComponent portfolioAC = mock(PortfolioApplicationComponent.class);
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        when(portfolioAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(portfolioAC.getStoreNut(anyString())).thenReturn(storeNut);

        final Portfolio portfolio = new Portfolio(portfolioAC);
        // TODO set up valid portfolio

        // act : run the test
        try {
            portfolio.save();
        } catch (final FormatedJetException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }

        // assert : verify that the test run correctly
        try {
            verify(storeNut, only()).createDataModel(portfolio.get_Model());
        } catch (final JETException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }
        verify(resourceAC).notifyListeners(eq(PortfolioResource.RESOURCE_NAME), any(PortfolioResource.class));
    }

    /**
     * Save, update
     */
    @org.junit.Test
    public void testSaveUpdate() {
        // arrange : set up the test
        final PortfolioApplicationComponent portfolioAC = mock(PortfolioApplicationComponent.class);
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        when(portfolioAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(portfolioAC.getStoreNut(anyString())).thenReturn(storeNut);

        final Portfolio portfolio = new Portfolio(portfolioAC);
        // TODO set up valid portfolio
        // TODO init portfolio pk
        // eg : portfolio.get_IdPortfolio_Model().setNodeValue(Long.valueOf(1));

        // act : run the test
        try {
            portfolio.save();
        } catch (final FormatedJetException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }

        // assert : verify that the test run correctly
        try {
            verify(storeNut, only()).updateDataModel(portfolio.get_Model());
        } catch (final JETException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }
        verify(resourceAC).notifyListeners(eq(PortfolioResource.RESOURCE_NAME), any(PortfolioResource.class));
    }

    /**
     * Delete new record
     */
    @org.junit.Test
    public void testDeleteNew() {
        // arrange : set up the test
        final PortfolioApplicationComponent portfolioAC = mock(PortfolioApplicationComponent.class);
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        when(portfolioAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(portfolioAC.getStoreNut(anyString())).thenReturn(storeNut);

        final Portfolio portfolio = new Portfolio(portfolioAC);

        // act : run the test
        try {
            portfolio.delete();
        } catch (final FormatedJetException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }

        // assert : verify that the test run correctly
        try {
            verify(storeNut, never()).removeDataModel(portfolio.get_Model());
        } catch (final JETException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }
        verify(resourceAC, never()).notifyListeners(eq(PortfolioResource.RESOURCE_NAME), any(PortfolioResource.class));
    }

    /**
     * Delete old record
     */
    @org.junit.Test
    public void testDeleteOld() {
        // arrange : set up the test
        final PortfolioApplicationComponent portfolioAC = mock(PortfolioApplicationComponent.class);
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        when(portfolioAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(portfolioAC.getStoreNut(anyString())).thenReturn(storeNut);

        final Portfolio portfolio = new Portfolio(portfolioAC);
        // TODO init portfolio pk
        // eg : portfolio.get_IdPortfolio_Model().setNodeValue(Long.valueOf(1));

        // act : run the test
        try {
            portfolio.delete();
        } catch (final FormatedJetException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }

        // assert : verify that the test run correctly
        try {
            verify(storeNut, only()).removeDataModel(portfolio.get_Model());
        } catch (final JETException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }
        verify(resourceAC).notifyListeners(eq(PortfolioResource.RESOURCE_NAME), any(PortfolioResource.class));
    }

}