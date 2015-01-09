package jet.shareplot.persistence.ic;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static jet.framework.util.JUnitAsserter.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;

import jet.shareplot.persistence.ejb.sharevalue.ShareValueRemote;
import jet.shareplot.persistence.pojo.ShareValueItem;
import jet.shareplot.persistence.imut.ShareValueImut;
import jet.framework.util.pojo2.validator.ValidationException;

/**
 * ShareValue ImutConverter JUnit test class.
 *
 * Generated by JetTools, do not edit this file directly.
 */
public class ShareValueIC_JUnitTest {

    @org.junit.Test(expected = ValidationException.class)
    public void testReadImutFromRemoteNullValidationError() throws Exception {
        // arrange : set up the test
        final ShareValueIC ic = new ShareValueIC();
        final ShareValueRemote shareValueRemote = mock(ShareValueRemote.class);
        assert shareValueRemote != null;
        when(shareValueRemote.getIdShareValue()).thenReturn(null);
        when(shareValueRemote.getIdShare()).thenReturn(null);
        when(shareValueRemote.getValue()).thenReturn(null);
        when(shareValueRemote.getValueDate()).thenReturn(null);

        // act : run the test
        final ShareValueImut imut = ic.readImutFromRemote(shareValueRemote);

        // test that all data read from remote
        verify(shareValueRemote, times(1)).getIdShareValue();
        verify(shareValueRemote, times(1)).getIdShare();
        verify(shareValueRemote, times(1)).getValue();
        verify(shareValueRemote, times(1)).getValueDate();
    }

    @org.junit.Test
    public void testReadImutFromRemote() throws Exception {
        // arrange : set up the test
        final ShareValueIC ic = new ShareValueIC();
        final ShareValueRemote shareValueRemote = mock(ShareValueRemote.class);
        assert shareValueRemote != null;
        when(shareValueRemote.getIdShareValue()).thenReturn(Long.valueOf(1));
        when(shareValueRemote.getIdShare()).thenReturn(Long.valueOf(1));
        when(shareValueRemote.getValue()).thenReturn(java.math.BigDecimal.valueOf(1));
        when(shareValueRemote.getValueDate()).thenReturn(new java.util.Date());

        // act : run the test
        final ShareValueImut imut = ic.readImutFromRemote(shareValueRemote);

        // test that all data read from remote
        verify(shareValueRemote, times(1)).getIdShareValue();
        verify(shareValueRemote, times(1)).getIdShare();
        verify(shareValueRemote, times(1)).getValue();
        verify(shareValueRemote, times(1)).getValueDate();
    }

    @org.junit.Test
    public void testWriteImutToRemote() throws Exception {
        // arrange : set up the test
        final ShareValueIC ic = new ShareValueIC();
        final ShareValueRemote shareValueRemote = mock(ShareValueRemote.class);
        assert shareValueRemote != null;

        final Long idShareValue = Long.valueOf(1);
        final Long idShare = Long.valueOf(1);
        final java.math.BigDecimal value = java.math.BigDecimal.valueOf(1);
        final jet.java.time.LocalDate valueDate = jet.framework.util.pojo2.imut.ImutDateUtilities.newLocalDate(new java.util.Date());

        final ShareValueImut shareValueImut = new ShareValueImut(idShareValue, idShare, value, valueDate);

        // act : run the test
        ic.writeImutToRemote(shareValueImut, shareValueRemote);

        // assert : verify that the test run correctly
        // check data written to all non pk fields
        verify(shareValueRemote, times(1)).setIdShare(any(Long.class));
        verify(shareValueRemote, times(1)).setValue(any(java.math.BigDecimal.class));
        verify(shareValueRemote, times(1)).setValueDate(any(java.util.Date.class));
    }

    @org.junit.Test(expected = ValidationException.class)
    public void testReadImutFromPojoNullValidationError() throws Exception {
        // arrange : set up the test
        final ShareValueIC ic = new ShareValueIC();
        final ShareValueItem shareValueItem = new ShareValueItem();
        assert shareValueItem != null;

        // act : run the test
        final ShareValueImut imut = ic.readImutFromPojo(shareValueItem);

        // test that all data read from remote
        // nothing to do
    }

    @org.junit.Test(expected = ValidationException.class)
    public void testReadImutFromPojoNewPojo() throws Exception {
        // arrange : set up the test
        final ShareValueIC ic = new ShareValueIC();
        final ShareValueItem shareValueItem = new ShareValueItem();
        assert shareValueItem != null;
        shareValueItem.setIdShare(Long.valueOf(1));
        shareValueItem.setValue(java.math.BigDecimal.valueOf(1));
        shareValueItem.setValueDate(new java.util.Date());

        // act : run the test
        final ShareValueImut imut = ic.readImutFromPojo(shareValueItem);

        // test that all data read from remote
        fail("Should have thrown an exception");
    }

    @org.junit.Test
    public void testReadImutFromPojo() throws Exception {
        // arrange : set up the test
        final ShareValueIC ic = new ShareValueIC();
        final ShareValueItem shareValueItem = new ShareValueItem();
        assert shareValueItem != null;
        shareValueItem.get_IdShareValue_Model().setNodeValue(Long.valueOf(1));
        shareValueItem.setIdShare(Long.valueOf(1));
        shareValueItem.setValue(java.math.BigDecimal.valueOf(1));
        shareValueItem.setValueDate(new java.util.Date());

        // act : run the test
        final ShareValueImut imut = ic.readImutFromPojo(shareValueItem);

        // test that all data read from remote
        assertEquals(Long.valueOf(1), imut.getIdShare());
        assertEquals(java.math.BigDecimal.valueOf(1), imut.getValue());
        assertNotNull(imut.getValueDate());
    }

    @org.junit.Test
    public void testWriteImutToPojo() throws Exception {
        // arrange : set up the test
        final ShareValueIC ic = new ShareValueIC();

        final Long idShareValue = Long.valueOf(1);
        final Long idShare = Long.valueOf(1);
        final java.math.BigDecimal value = java.math.BigDecimal.valueOf(1);
        final jet.java.time.LocalDate valueDate = jet.framework.util.pojo2.imut.ImutDateUtilities.newLocalDate(new java.util.Date());

        final ShareValueImut shareValueImut = new ShareValueImut(idShareValue, idShare, value, valueDate);

        // act : run the test
        final ShareValueItem shareValueItem = ic.writeImutToPojo(shareValueImut);

        // assert : verify that the test run correctly
        // check data written to all non pk fields
        assertEquals(idShare, shareValueItem.getIdShare());
        assertEquals(value, shareValueItem.getValue());
        assertEquals(jet.framework.util.pojo2.imut.ImutDateUtilities.newDate(valueDate), shareValueItem.getValueDate());
        // by definition pojo must be non new
        assertFalse(shareValueItem.isNew());
    }

    @org.junit.Test
    public void testReadImutFromResultSet() throws Exception {
        // arrange : set up the test
        final Long idShareValue = Long.valueOf(1);
        final Long idShare = Long.valueOf(1);
        final java.math.BigDecimal value = java.math.BigDecimal.valueOf(1);
        final java.util.Date valueDate = new java.util.Date();

        final ResultSet resultSet = mock(ResultSet.class);
        assert resultSet != null;
        when(resultSet.getLong("idShareValue")).thenReturn(idShareValue);
        when(resultSet.getLong("idShare")).thenReturn(idShare);
        when(resultSet.getBigDecimal("value")).thenReturn(value);
        when(resultSet.getDate("valueDate")).thenReturn(new java.sql.Date(valueDate.getTime()));

        // act : run the test
        final ShareValueIC ic = new ShareValueIC();
        final ShareValueImut imut = ic.readImutFromResultSet(resultSet);

        // test that all data read from remote
        assertEquals(idShareValue, imut.getIdShareValue());
        assertEquals(idShare, imut.getIdShare());
        assertEquals(value, imut.getValue());
        assertEquals(jet.framework.util.pojo2.imut.ImutDateUtilities.newLocalDate(valueDate), imut.getValueDate());
    }

}
