package jet.shareplot.ac.bo.sharevalue;

import javax.annotation.Nonnull;

import jet.framework.util.exception.FormatedJetException;
import jet.framework.util.pojo2.AbstractResourceNotification.NOTIFICATION_TYPE;
import jet.framework.util.pojo2.JFBusinessCallableHelper;
import jet.framework.util.pojo2.JFBusinessDeleteCallable;
import jet.framework.util.pojo2.JFBusinessErrorHelper;
import jet.framework.util.pojo2.JFBusinessItem;
import jet.framework.util.pojo2.JFBusinessSaveCallable;
import jet.shareplot.ac.SelectStoreApplicationComponent;
import jet.shareplot.persistence.pojo.ShareValueItem;
import jet.util.models.interfaces.Model;

/**
 * Sample bo class, extending the pojo ShareValueItem.
 * 
 * Generated by JetTools, you can edit this file directly, once created it will not be overwritten
 * 
 * @author JetToolsFramework
 */
public class ShareValue extends ShareValueItem implements JFBusinessItem, JFBusinessErrorHelper {

    private static final long serialVersionUID = 1303211696L;

    private static final String CAN_NOT_SAVE_KEY = "SharePlot/properties/task/Share/dialog.CanNotSaveShareValue";
    private static final String CAN_NOT_DELETE_KEY = "SharePlot/properties/task/Share/dialog.CanNotDeleteShareValue";
    private static final String NOT_VALID_KEY = "SharePlot/properties/task/Share/dialog.ShareValueNotValid";

    private final AbstractShareValueBOApplicationComponent shareValueAC;

    /**
     * Constructor, build an empty shareValue.
     * 
     * @param shareValueAC the shareValue application component
     * 
     * @see Model
     * @see ShareValueBOApplicationComponent
     */
    public ShareValue(@Nonnull final AbstractShareValueBOApplicationComponent shareValueAC) {
        super();
        this.shareValueAC = shareValueAC;
    }

    /**
     * Constructor, build a shareValue from a Model.
     * 
     * @param model the model representing a shareValue entry in the table ShareValue
     * @param shareValueAC the shareValue application component
     * 
     * @see Model
     * @see ShareValueBOApplicationComponent
     */
    public ShareValue(@Nonnull final Model model, @Nonnull final AbstractShareValueBOApplicationComponent shareValueAC) {
        super(model);
        this.shareValueAC = shareValueAC;
    }

    /**
     * Copy constructor, build a shareValue as a copy of another shareValue.
     * 
     * @param shareValue the shareValue to copy
     */
    public ShareValue(@Nonnull final ShareValue shareValue) {
        super(shareValue);
        this.shareValueAC = shareValue.shareValueAC;
    }

    /**
     * Check if this shareValue is valid and can be saved.
     * 
     * @return <code>true</code> if this shareValue is valid and can be saved.
     * @see JFBusinessItem
     */
    @Override
    public final boolean isValid() {
        // TODO add extra validations here
        return !isNotNullableNull();
    }

    /**
     * Register the object in the database.
     * The store will only be done if the shareValue is valid.
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
            final ShareValueResource resource;
            if (isNew()) {
                resource = new ShareValueResource(this.shareValueAC, this, NOTIFICATION_TYPE.CREATE);
            } else {
                resource = new ShareValueResource(this.shareValueAC, this, NOTIFICATION_TYPE.UPDATE);
            }

            final JFBusinessSaveCallable callable = new JFBusinessSaveCallable(this.shareValueAC, SelectStoreApplicationComponent.SHAREVALUE_STORE, this);
            JFBusinessCallableHelper.storeChange(this.shareValueAC, callable, CAN_NOT_SAVE_KEY, this);

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
            final JFBusinessDeleteCallable callable = new JFBusinessDeleteCallable(this.shareValueAC, SelectStoreApplicationComponent.SHAREVALUE_STORE, this);
            JFBusinessCallableHelper.storeChange(this.shareValueAC, callable, CAN_NOT_DELETE_KEY, this);

            final ShareValueResource resource = new ShareValueResource(this.shareValueAC, this, NOTIFICATION_TYPE.DELETE);
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
        final Object[] args = { getValueDate() };
        return new FormatedJetException(null, key, args, e);
    }
}
