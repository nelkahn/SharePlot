package jet.shareplot.persistence.dmc;

import java.rmi.RemoteException;

import javax.annotation.Nonnull;
import javax.ejb.EJBException;

import jet.framework.manager.datamodel.interfaces.DataModelConverter2;
import jet.framework.manager.datamodel.interfaces.DataModelRootNode;
import jet.shareplot.persistence.ejb.share.ShareRemote;
import jet.shareplot.persistence.pojo.ShareItem;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

/**
 * Share DataModelConverter2.
 *
 * Generated by JetTools, do not edit this file directly.
 */
public final class ShareDMC implements DataModelConverter2<ShareRemote> {

    private static final long serialVersionUID = -1265738400L;

    /**
     * Default constructor.
     * Nothing to do at the moment.
     */
    public ShareDMC() {
        super();
    }

    @Override
    @Nonnull
    public final Model readDataModelFromObject(@Nonnull final ShareRemote shareRemote) throws JETException {
        final ShareItem shareItem = new ShareItem();

        try {
            shareItem.get_IdShare_Model().setNodeValue(shareRemote.getIdShare());
            shareItem.get_CodeISIN_Model().setNodeValue(shareRemote.getCodeISIN());
            shareItem.get_CodeYahoo_Model().setNodeValue(shareRemote.getCodeYahoo());
            shareItem.get_Description_Model().setNodeValue(shareRemote.getDescription());
            shareItem.get_IdPortfolio_Model().setNodeValue(shareRemote.getIdPortfolio());
            shareItem.get_Name_Model().setNodeValue(shareRemote.getName());
        } catch (final EJBException e) {
            throw new JETException("EJBException while reading from ShareRemote.", e);
        } catch (final RemoteException e) {
            throw new JETException("RemoteException while reading from ShareRemote.", e);
        }

        // reset the dirty flag, record has just been read from db, can not be dirty
        if (shareItem.get_Model() instanceof DataModelRootNode) {
            final DataModelRootNode dmrn = (DataModelRootNode) shareItem.get_Model();
            dmrn.resetDirtyFlag();
        }

        return shareItem.get_Model();
    }

    @Override
    public final void writeDataModelToObject(@Nonnull final Model dataModel, @Nonnull final ShareRemote shareRemote) throws JETException {
        final ShareItem shareItem = new ShareItem(dataModel);

        try {
            // do not update pk fields
            shareRemote.setCodeISIN(shareItem.getCodeISIN());
            shareRemote.setCodeYahoo(shareItem.getCodeYahoo());
            shareRemote.setDescription(shareItem.getDescription());
            shareRemote.setIdPortfolio(shareItem.getIdPortfolio());
            shareRemote.setName(shareItem.getName());
        } catch (final EJBException e) {
            throw new JETException("EJBException while writing to ShareRemote.", e);
        } catch (final RemoteException e) {
            throw new JETException("RemoteException while writing to ShareRemote.", e);
        }
    }

}
