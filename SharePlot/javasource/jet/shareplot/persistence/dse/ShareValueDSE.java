package jet.shareplot.persistence.dse;

import java.rmi.RemoteException;
import java.util.concurrent.Callable;

import javax.ejb.FinderException;
import javax.ejb.ObjectNotFoundException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import jet.framework.manager.datamodel.interfaces.AbstractDataSourceExecutor2;
import jet.framework.manager.datamodel.interfaces.DataModelConverter2;
import jet.framework.manager.datamodel.interfaces.DataModelRootNode;
import jet.framework.util.JetConstants;
import jet.framework.util.jta.JETDuplicateKeyException;
import jet.shareplot.persistence.dmc.ShareValueDMC;
import jet.shareplot.persistence.ejb.sharevalue.ShareValueHome;
import jet.shareplot.persistence.ejb.sharevalue.ShareValueRemote;
import jet.shareplot.persistence.pojo.ShareValueItem;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * ShareValue DataSourceExecutor2.
 *
 * Generated by JetTools, do not edit this file directly.
 */
public final class ShareValueDSE extends AbstractDataSourceExecutor2<ShareValueHome, ShareValueRemote> {

    private static final long serialVersionUID = 1303211696L;
    private transient ShareValueHome ejbHome;
    private transient DataModelConverter2<ShareValueRemote> dataModelConverter;

    @Override
    public void updateFromDataModel(final @NonNull Model dataModel) throws JETException, ObjectNotFoundException {
        final Callable<@Nullable Object> callable = new Callable<@Nullable Object>() {
            @Override
            public Object call() throws Exception {
                final ShareValueRemote ejbObject = getObjectFromStore(dataModel);
                getDataModelConverter().writeDataModelToObject(dataModel, ejbObject);
                return null;
            }
        };

        callUpdateTransaction(callable);

        // reset the dirty flag, record has just been written to the db, can not be dirty
        if (dataModel instanceof DataModelRootNode) {
            final DataModelRootNode dmrn = (DataModelRootNode) dataModel;
            dmrn.resetDirtyFlag();
        }
    }

    @Override
    public void createFromDataModel(final @NonNull Model dataModel) throws JETException, JETDuplicateKeyException {
        final Callable<@Nullable Object> callable = new Callable<@Nullable Object>() {
            @Override
            public Object call() throws Exception {
                final ShareValueItem shareValueItem = new ShareValueItem(dataModel);

                final ShareValueHome shareValueHome = getEJBHome();
                final ShareValueRemote shareValueRemote = shareValueHome.create(shareValueItem.getIdShareValue(), shareValueItem.getIdShare(), shareValueItem.getValue(), shareValueItem.getValueDate());

                // has autoincrement PK, must update
                shareValueItem.get_IdShareValue_Model().setNodeValue(shareValueRemote.getIdShareValue());

                return null;
            }
        };

        callCreateTransaction(callable);

        // reset the dirty flag, record has just been written to the db, can not be dirty
        if (dataModel instanceof DataModelRootNode) {
            final DataModelRootNode dmrn = (DataModelRootNode) dataModel;
            dmrn.resetDirtyFlag();
        }
    }

    @Override
    public void removeFromDataModel(final @NonNull Model dataModel) throws JETException, ObjectNotFoundException {
        final Callable<@Nullable Object> callable = new Callable<@Nullable Object>() {
            @Override
            public Object call() throws Exception {
                final ShareValueRemote shareValueRemote = getObjectFromStore(dataModel);
                shareValueRemote.remove();
                return null;
            }
        };

        callUpdateTransaction(callable);

        // set the dirty flag, record has just been deleted from the db, can only be dirty
        if (dataModel instanceof DataModelRootNode) {
            final DataModelRootNode dmrn = (DataModelRootNode) dataModel;
            dmrn.setDirtyFlag();
        }

        // if has autoincrement PK, must reset pk to null
        final ShareValueItem shareValueItem = new ShareValueItem(dataModel);
        shareValueItem.get_IdShareValue_Model().setNodeValue(null);
    }

    @Override
    public @NonNull ShareValueHome getEJBHome() {
        ShareValueHome result = this.ejbHome;
        if (result == null) {
            try {
                result = this.ejbHome = (ShareValueHome) new InitialContext().lookup(JetConstants.EJB_CONTEXT + ShareValueHome.BEAN_NAME);
            } catch (final NamingException e) {
                throw new IllegalArgumentException("Unable to locate EJB Home : " + ShareValueHome.BEAN_NAME, e);
            }
        }
        return result;
    }

    @Override
    public @NonNull DataModelConverter2<ShareValueRemote> getDataModelConverter() {
        DataModelConverter2<ShareValueRemote> result = this.dataModelConverter;
        if (result == null) {
            result = this.dataModelConverter = new ShareValueDMC();
        }

        return result;
    }

    /**
     * Get object from the persistent store corresponding to the data Model. Depending on the implementation
     * it may not be necessary to provide a full data Model.
     * <p>
     * This should be used with care as this may entail Transaction problems, depending on the underlying persistance layer.
     * </p>
     *
     * @param dataModel Model identifying the object to retrieve
     * @return E Persistent object corresponding to the Model
     * @throws JETException Thrown if there was an error whilst retrieving the object
     * @throws ObjectNotFoundException Thrown if there is no corresponding object
     */
    private @NonNull ShareValueRemote getObjectFromStore(final @NonNull Model dataModel) throws JETException, ObjectNotFoundException {
        assert dataModel != null : "Can not delete null model";

        final ShareValueItem shareValueItem = new ShareValueItem(dataModel);
        final ShareValueHome shareValueHome = getEJBHome();

        ShareValueRemote shareValueRemote;
        try {
            // As it come from the database, it should not be possible that field(s) in the PK are null.
            shareValueRemote = shareValueHome.findByPrimaryKey(shareValueItem.getIdShareValue());
        } catch (final RemoteException e) {
            throw new JETException(e.getMessage(), e);
        } catch (final ObjectNotFoundException e) {
            throw e;
        } catch (final FinderException e) {
            throw new JETException(e.getMessage(), e);
        }

        return shareValueRemote;
    }
}
