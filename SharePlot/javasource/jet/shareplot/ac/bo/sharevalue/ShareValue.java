package jet.shareplot.ac.bo.sharevalue;

import jet.framework.manager.datamodel.interfaces.FinderObjectNotFoundException;
import jet.framework.nuts.store.StoreNut;
import jet.framework.util.exception.FormatedJetException;
import jet.shareplot.ac.SelectStoreApplicationComponent;
import jet.shareplot.persistence.pojo.ShareValueItem;
import jet.shareplot.ui.desktop.pojo2.SharePlotErrorHandler;
import jet.util.logger.JETLevel;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

/**
 * Sample bo class, extending the pojo ShareValueItem.
 * 
 * Generated by JetTools, you can edit this file directly, Once created it will not be overwritten
 * 
 * @author JetToolsFramework
 */
public class ShareValue extends ShareValueItem {

    // TODO set localized keys for error dialogs
    private static final String CAN_NOT_SAVE_KEY = "";
    private static final String CAN_NOT_DELETE_KEY = "";
    private static final String NOT_VALID_KEY = "";

    private final ShareValueApplicationComponent shareValueAC;

    public ShareValue(final ShareValueApplicationComponent shareValueAC) {
        super();
        this.shareValueAC = shareValueAC;
        setPojo2ErrorHandler(new SharePlotErrorHandler(this.shareValueAC.getSession()));
    }

    public ShareValue(final Model model, final ShareValueApplicationComponent shareValueAC) {
        super(model);
        this.shareValueAC = shareValueAC;
        setPojo2ErrorHandler(new SharePlotErrorHandler(this.shareValueAC.getSession()));
    }

    public ShareValue(final ShareValue shareValue) {
        super(shareValue);
        this.shareValueAC = shareValue.shareValueAC;
        setPojo2ErrorHandler(new SharePlotErrorHandler(this.shareValueAC.getSession()));
    }

    public boolean isValid() {
        // TODO add extra validations here
        return !isNotNullableNull();
    }

    private boolean isNew() {
        // TODO implement this method
        return false;
    }

    public void save() throws FormatedJetException {
        if (isValid()) {
            final StoreNut storeNut = this.shareValueAC.getStoreNut(SelectStoreApplicationComponent.PORTFOLIO_STORE);
            try {
                if (isNew()) {
                    storeNut.createDataModel(get_Model());
                } else {
                    storeNut.updateDataModel(get_Model());
                }
            } catch (final FinderObjectNotFoundException e) {
                this.shareValueAC.logp(JETLevel.SEVERE, "ShareValue", "save", e.getMessage(), e);
                // TODO fill in args
                final Object[] args = {};
                throw new FormatedJetException(null, CAN_NOT_SAVE_KEY, args, e);
            } catch (final JETException e) {
                this.shareValueAC.logp(JETLevel.SEVERE, "ShareValue", "save", e.getMessage(), e);
                // TODO fill in args
                final Object[] args = {};
                throw new FormatedJetException(null, CAN_NOT_SAVE_KEY, args, e);
            }
        } else {
            // TODO fill in args
            final Object[] args = {};
            throw new FormatedJetException(null, NOT_VALID_KEY, args, null);
        }
    }

    public void delete() throws FormatedJetException {
        if (!isNew()) {
            final StoreNut storeNut = this.shareValueAC.getStoreNut(SelectStoreApplicationComponent.PORTFOLIO_STORE);
            try {
                storeNut.removeDataModel(get_Model());
            } catch (final FinderObjectNotFoundException e) {
                this.shareValueAC.logp(JETLevel.SEVERE, "ShareValue", "delete", e.getMessage(), e);
                // TODO fill in args
                final Object[] args = {};
                throw new FormatedJetException(null, CAN_NOT_DELETE_KEY, args, e);
            } catch (final JETException e) {
                this.shareValueAC.logp(JETLevel.SEVERE, "ShareValue", "delete", e.getMessage(), e);
                // TODO fill in args
                final Object[] args = {};
                throw new FormatedJetException(null, CAN_NOT_DELETE_KEY, args, e);
            }
        }
    }

}
