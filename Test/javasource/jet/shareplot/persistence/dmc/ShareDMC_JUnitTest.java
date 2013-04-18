package jet.shareplot.persistence.dmc;

import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import jet.shareplot.persistence.ejb.share.ShareRemote;
import jet.shareplot.persistence.pojo.ShareItem;
import jet.util.models.interfaces.Model;

/**
 * Share DataModelConverter2 JUnit test class.
 *
 * Generated by JetTools, do not edit this file directly.
 */
public class ShareDMC_JUnitTest {

    @org.junit.Test
    public void testReadDataModelFromObject() throws Exception {
        // arrange : set up the test
        final ShareDMC dmc = new ShareDMC();
        final ShareRemote shareRemote = mock(ShareRemote.class);
        assert shareRemote != null;

        // if AI, ensure mock provides non null value
        when(shareRemote.getIdShare()).thenReturn(Long.valueOf(1));

        // act : run the test
        final Model shareModel = dmc.readDataModelFromObject(shareRemote);
        final ShareItem shareItem = new ShareItem(shareModel);

        // assert : verify that the test run correctly
        assertFalse(shareItem.isNew());
        assertFalse(shareItem.isDirty());

        // test that all data read from remote
        verify(shareRemote, times(1)).getIdShare();
        verify(shareRemote, times(1)).getCodeISIN();
        verify(shareRemote, times(1)).getCodeYahoo();
        verify(shareRemote, times(1)).getDescription();
        verify(shareRemote, times(1)).getIdPortfolio();
        verify(shareRemote, times(1)).getName();
    }

    @org.junit.Test
    public void testWriteDataModelToObject() throws Exception {
        // arrange : set up the test
        final ShareDMC dmc = new ShareDMC();
        final ShareRemote shareRemote = mock(ShareRemote.class);
        assert shareRemote != null;
        final ShareItem shareItem = new ShareItem();

        // act : run the test
        dmc.writeDataModelToObject(shareItem.get_Model(), shareRemote);

        // assert : verify that the test run correctly
        // check data written to all non pk fields
        verify(shareRemote, times(1)).setCodeISIN(any(String.class));
        verify(shareRemote, times(1)).setCodeYahoo(any(String.class));
        verify(shareRemote, times(1)).setDescription(any(String.class));
        verify(shareRemote, times(1)).setIdPortfolio(any(Long.class));
        verify(shareRemote, times(1)).setName(any(String.class));
    }

}
