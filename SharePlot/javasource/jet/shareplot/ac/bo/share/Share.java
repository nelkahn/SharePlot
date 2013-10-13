package jet.shareplot.ac.bo.share;

import javax.annotation.Nonnull;

import jet.framework.util.exception.FormatedJetException;
import jet.framework.util.pojo2.AbstractResourceNotification.NOTIFICATION_TYPE;
import jet.framework.util.pojo2.JFBusinessCallableHelper;
import jet.framework.util.pojo2.JFBusinessDeleteCallable;
import jet.framework.util.pojo2.JFBusinessErrorHelper;
import jet.framework.util.pojo2.JFBusinessItem;
import jet.framework.util.pojo2.JFBusinessSaveCallable;
import jet.shareplot.ac.SelectStoreApplicationComponent;
import jet.shareplot.persistence.pojo.ShareItem;
import jet.util.models.interfaces.Model;

/**
 * Sample bo class, extending the pojo ShareItem.
 * 
 * Generated by JetTools, you can edit this file directly, once created it will not be overwritten
 * 
 * @author JetToolsFramework
 */
public class Share extends ShareItem implements JFBusinessItem, JFBusinessErrorHelper {

    private static final long serialVersionUID = -1265738400L;

    private static final String CAN_NOT_SAVE_KEY = "SharePlot/properties/task/Share/dialog.CanNotSaveShare";
    private static final String CAN_NOT_DELETE_KEY = "SharePlot/properties/task/Share/dialog.CanNotDeleteShare";
    private static final String NOT_VALID_KEY = "SharePlot/properties/task/Share/dialog.ShareNotValid";

    private final AbstractShareBOApplicationComponent shareAC;

    /**
     * Constructor, build an empty share.
     * 
     * @param shareAC the share application component
     * 
     * @see Model
     * @see ShareBOApplicationComponent
     */
    public Share(@Nonnull final AbstractShareBOApplicationComponent shareAC) {
        super();
        this.shareAC = shareAC;
    }

    /**
     * Constructor, build a share from a Model.
     * 
     * @param model the model representing a share entry in the table Share
     * @param shareAC the share application component
     * 
     * @see Model
     * @see ShareBOApplicationComponent
     */
    public Share(@Nonnull final Model model, @Nonnull final AbstractShareBOApplicationComponent shareAC) {
        super(model);
        this.shareAC = shareAC;
    }

    /**
     * Copy constructor, build a share as a copy of another share.
     * 
     * @param share the share to copy
     */
    public Share(@Nonnull final Share share) {
        super(share);
        this.shareAC = share.shareAC;
    }

    /**
     * Check if this share is valid and can be saved.
     * 
     * @return <code>true</code> if this share is valid and can be saved.
     * @see JFBusinessItem
     */
    @Override
    public final boolean isValid() {
        // TODO add extra validations here
        return !isNotNullableNull();
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
     * @see JFBusinessItem
     */
    @Override
    public final void save() throws FormatedJetException {
        if (isValid()) {
            final ShareResource resource;
            if (isNew()) {
                resource = new ShareResource(this.shareAC, this, NOTIFICATION_TYPE.CREATE);
            } else {
                resource = new ShareResource(this.shareAC, this, NOTIFICATION_TYPE.UPDATE);
            }

            final JFBusinessSaveCallable callable = new JFBusinessSaveCallable(this.shareAC, SelectStoreApplicationComponent.SHARE_STORE, this);
            JFBusinessCallableHelper.storeChange(this.shareAC, callable, CAN_NOT_SAVE_KEY, this);

            resource.notifyResource();
        } else {
            throw getFormatedJetException(NOT_VALID_KEY, null);
        }
    }

    /**
     * Remove the object from the database.
     * It will be deleted if it already exists.
     * 
     * @throws FormatedJetException
     * @see FormatedJetException
     * @see #isNew()
     * @see JFBusinessItem
     */
    @Override
    public final void delete() throws FormatedJetException {
        if (!isNew()) {
            final JFBusinessDeleteCallable callable = new JFBusinessDeleteCallable(this.shareAC, SelectStoreApplicationComponent.SHARE_STORE, this);
            JFBusinessCallableHelper.storeChange(this.shareAC, callable, CAN_NOT_DELETE_KEY, this);

            final ShareResource resource = new ShareResource(this.shareAC, this, NOTIFICATION_TYPE.DELETE);
            resource.notifyResource();
        }
    }

    /**
     * Produce error for save / delete.
     * 
     * @return FormatedJetException
     * @see FormatedJetException
     * @see JFBusinessErrorHelper
     * @see #save()
     * @see #delete()
     */
    @Override
    public final FormatedJetException getFormatedJetException(final String key, final Exception e) {
        final Object[] args = { getName() };
        return new FormatedJetException(null, key, args, e);
    }
}
