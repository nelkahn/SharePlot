package jet.shareplot.persistence.dmc;

import static org.junit.Assert.assertFalse;
import static jet.framework.util.JUnitAsserter.any;
import static jet.framework.util.JUnitAsserter.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import jet.shareplot.persistence.ejb.portfolio.PortfolioRemote;
import jet.shareplot.persistence.pojo.PortfolioItem;
import jet.util.models.interfaces.Model;

/**
 * Portfolio DataModelConverter2 JUnit test class
 *
 * Generated by JetTools, do not edit this file directly.
 */
public class PortfolioDMC_JUnitTest {

    @org.junit.Test
    public void testReadDataModelFromObject() throws Exception {
        // arrange : set up the test
        final PortfolioDMC dmc = new PortfolioDMC();
        final PortfolioRemote portfolioRemote = mock(PortfolioRemote.class);

        // if AI, ensure mock provides non null value
        when(portfolioRemote.getIdPortfolio()).thenReturn(Long.valueOf(1));

        // act : run the test
        final Model portfolioModel = dmc.readDataModelFromObject(portfolioRemote);
        final PortfolioItem portfolioItem = new PortfolioItem(portfolioModel);

        // assert : verify that the test run correctly
        assertFalse(portfolioItem.isNew());
        assertFalse(portfolioItem.isDirty());

        // test that all data read from remote
        verify(portfolioRemote, times(1)).getIdPortfolio();
        verify(portfolioRemote, times(1)).getIsFake();
        verify(portfolioRemote, times(1)).getName();
    }

    @org.junit.Test
    public void testWriteDataModelToObject() throws Exception {
        // arrange : set up the test
        final PortfolioDMC dmc = new PortfolioDMC();
        final PortfolioRemote portfolioRemote = mock(PortfolioRemote.class);
        final PortfolioItem portfolioItem = new PortfolioItem();

        // act : run the test
        dmc.writeDataModelToObject(portfolioItem.get_Model(), portfolioRemote);

        // assert : verify that the test run correctly
        // check data written to all non pk fields
        verify(portfolioRemote, times(1)).setIsFake(any(String.class));
        verify(portfolioRemote, times(1)).setName(any(String.class));
    }

}
