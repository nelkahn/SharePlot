package jet.shareplot.ac.bo.share;

import jet.framework.component.resource.ResourceNotificationApplicationComponent;
import jet.framework.manager.datamodel.interfaces.FinderObjectNotFoundException;
import jet.framework.nuts.store.StoreNut;
import jet.framework.util.exception.FormatedJetException;
import jet.framework.util.pojo2.AbstractResourceNotification;
import jet.framework.util.pojo2.Pojo2Bean;
import jet.shareplot.ac.SelectStoreApplicationComponent;
import jet.shareplot.persistence.pojo.ShareItem;
import jet.shareplot.ui.desktop.pojo2.SharePlotErrorHandler;
import jet.util.logger.JETLevel;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

/**
 * Sample bo class, extending the pojo ShareItem.
 * 
 * Generated by JetTools, you can edit this file directly, Once created it will not be overwritten
 * 
 * @author JetToolsFramework
 */
public class Share extends ShareItem implements Pojo2Bean {

    private static final long serialVersionUID = 2783588090226625437L;

    private static final String CAN_NOT_SAVE_KEY = "SharePlot/properties/task/Share/dialog.CanNotSaveShare";
    private static final String CAN_NOT_DELETE_KEY = "SharePlot/properties/task/Share/dialog.CanNotDeleteShare";
    private static final String NOT_VALID_KEY = "SharePlot/properties/task/Share/dialog.ShareNotValid";

    private final ShareApplicationComponent shareAC;

    /**
     * Constructor, build an empty share
     * 
     * @param shareAC the share application component
     * 
     * @see Model
     * @see ShareApplicationComponent
     */
    public Share(final ShareApplicationComponent shareAC) {
        super();
        this.shareAC = shareAC;
        setPojo2ErrorHandler(new SharePlotErrorHandler(this.shareAC.getSession()));
    }

    /**
     * Constructor, build a share from a Model
     * 
     * @param model the model representing a share entry in the table Share
     * @param shareAC the share application component
     * 
     * @see Model
     * @see ShareApplicationComponent
     */
    public Share(final Model model, final ShareApplicationComponent shareAC) {
        super(model);
        this.shareAC = shareAC;
        setPojo2ErrorHandler(new SharePlotErrorHandler(this.shareAC.getSession()));
    }

    /**
     * Copy constructor, build a share as a copy of another share
     * 
     * @param share the share to copy
     */
    public Share(final Share share) {
        super(share);
        this.shareAC = share.shareAC;
        setPojo2ErrorHandler(new SharePlotErrorHandler(this.shareAC.getSession()));
    }

    /**
     * @return <code>true</code> if this share is valid and can be saved.
     * @see Pojo2Bean
     */
    @Override
    public boolean isValid() {
        // TODO add extra validations here
        return !isNotNullableNull();
    }

    /**
     * @return <code>true</code> if this share is new.
     * @see Pojo2Bean
     */
    @Override
    public boolean isNew() {
        return getIdShare() == null;
    }

    /**
     * Register the object in the database.
     * The store will only be done if the share is valid.
     * It will updated if it already exists and create it if not.
     * 
     * @throws FormatedJetException
     * @see FormatedJetException
     * @see #isNew()
     * @see #isValid()
     * @see Pojo2Bean
     */
    @Override
    public void save() throws FormatedJetException {
        if (isValid()) {
            final StoreNut storeNut = this.shareAC.getStoreNut(SelectStoreApplicationComponent.SHARE_STORE);
            try {
                ShareResource resource;
                if (isNew()) {
                    storeNut.createDataModel(get_Model());
                    resource = new ShareResource(this, AbstractResourceNotification.NOTIFICATION_TYPE.CREATE);
                } else {
                    storeNut.updateDataModel(get_Model());
                    resource = new ShareResource(this, AbstractResourceNotification.NOTIFICATION_TYPE.UPDATE);
                }
                final ResourceNotificationApplicationComponent resourceAC = ResourceNotificationApplicationComponent.getInstance(this.shareAC.getSession());
                resourceAC.notifyListeners(ShareResource.RESOURCE_NAME, resource);
            } catch (final FinderObjectNotFoundException e) {
                this.shareAC.logp(JETLevel.SEVERE, "Share", "save", e.getMessage(), e);
                final Object[] args = { getName() };
                throw new FormatedJetException(null, CAN_NOT_SAVE_KEY, args, e);
            } catch (final JETException e) {
                this.shareAC.logp(JETLevel.SEVERE, "Share", "save", e.getMessage(), e);
                final Object[] args = { getName() };
                throw new FormatedJetException(null, CAN_NOT_SAVE_KEY, args, e);
            }
        } else {
            final Object[] args = { getName() };
            throw new FormatedJetException(null, NOT_VALID_KEY, args, null);
        }
    }

    /**
     * Remove the object from the database.
     * It will be deleted if it already exists.
     * 
     * @throws FormatedJetException
     * @see FormatedJetException
     * @see #isNew()
     * @see Pojo2Bean
     */
    @Override
    public void delete() throws FormatedJetException {
        if (!isNew()) {
            final StoreNut storeNut = this.shareAC.getStoreNut(SelectStoreApplicationComponent.SHARE_STORE);
            try {
                final ShareResource resource = new ShareResource(this, AbstractResourceNotification.NOTIFICATION_TYPE.DELETE);
                storeNut.removeDataModel(get_Model());
                final ResourceNotificationApplicationComponent resourceAC = ResourceNotificationApplicationComponent.getInstance(this.shareAC.getSession());
                resourceAC.notifyListeners(ShareResource.RESOURCE_NAME, resource);
                storeNut.removeDataModel(get_Model());
            } catch (final FinderObjectNotFoundException e) {
                this.shareAC.logp(JETLevel.SEVERE, "Share", "delete", e.getMessage(), e);
                final Object[] args = { getName() };
                throw new FormatedJetException(null, CAN_NOT_DELETE_KEY, args, e);
            } catch (final JETException e) {
                this.shareAC.logp(JETLevel.SEVERE, "Share", "delete", e.getMessage(), e);
                final Object[] args = { getName() };
                throw new FormatedJetException(null, CAN_NOT_DELETE_KEY, args, e);
            }
        }
    }

}
