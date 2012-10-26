package jet.shareplot.ac.bo.sharequantity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import javax.ejb.ObjectNotFoundException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.RollbackException;
import javax.transaction.TransactionManager;

import jet.container.managers.application.interfaces.ApplicationProxy;
import jet.container.managers.jta.interfaces.JTAManagerContext;
import jet.container.managers.session.interfaces.Session;
import jet.framework.component.SimpleApplicationComponent;
import jet.framework.manager.datamodel.interfaces.ModelArray;
import jet.framework.nuts.select.FinderMethod;
import jet.framework.nuts.select.SelectNut;
import jet.framework.nuts.select.SelectNutHelper;
import jet.framework.ui.desktop.AbstractDesktopNut;
import jet.framework.util.JetConstants;
import jet.framework.util.jta.TransactionHelper;
import jet.lifecycle.annotations.Deinitializer;
import jet.lifecycle.interfaces.LifeCycleState;
import jet.shareplot.ac.SelectStoreApplicationComponent;
import jet.shareplot.persistence.finder.sharequantity.ShareQuantity_FindAll0;
import jet.util.SerializableKey;
import jet.util.logger.JETLevel;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

/**
 * ShareQuantity manipulation API
 *
 * Generated by JetTools, do not change this file, it will be overriden at each generation
 *
 * @author JetToolsFramework
 */
abstract class AbstractShareQuantityApplicationComponent extends SimpleApplicationComponent {

    private static final long serialVersionUID = 1077646545L;

    private TransactionManager transactionManager;

    /**
     * Return all shareQuantity matching the FinderMethod.
     *
     * @param finder FinderMethod to use to fetch the ShareQuantitys
     * @return a list of shareQuantity matching the FinderMethod.
     * @see List
     * @see ShareQuantity
     */
    protected List<ShareQuantity> getShareQuantitys(final FinderMethod finder) {
        final List<ShareQuantity> result = new ArrayList<ShareQuantity>();
        final SelectNut selectNut = getSelectNut(SelectStoreApplicationComponent.SHAREQUANTITY_SELECT);
        final AbstractShareQuantityApplicationComponent shareQuantityAC = this;

        final Callable<Object> callable = new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                final ModelArray ma = SelectNutHelper.getModelArray(selectNut, finder, getLogger());
                if (ma != null) {
                    final int size = ma.getSize();
                    for (int i = 0; i < size; i++) {
                        final Model model = ma.get(i);
                        final ShareQuantity shareQuantity = new ShareQuantity(model, shareQuantityAC);
                        result.add(shareQuantity);
                    }
                }
                return null;
            }
        };
        try {
            final TransactionManager transactionMgr = getTransactionManager();
            TransactionHelper.runTransaction(callable, transactionMgr);
        } catch (final ObjectNotFoundException e) {
            logp(JETLevel.SEVERE, "AbstractShareQuantityApplicationComponent", "getShareQuantitys", e.getMessage(), e);
        } catch (final JETException e) {
            logp(JETLevel.SEVERE, "AbstractShareQuantityApplicationComponent", "getShareQuantitys", e.getMessage(), e);
        } catch (final RollbackException e) {
            logp(JETLevel.SEVERE, "AbstractShareQuantityApplicationComponent", "getShareQuantitys", e.getMessage(), e);
        } catch (final NamingException e) {
            logp(JETLevel.SEVERE, "AbstractShareQuantityApplicationComponent", "getShareQuantitys", e.getMessage(), e);
        }

        return result;
    }

    private TransactionManager getTransactionManager() throws NamingException {
        if (this.transactionManager == null) {
            final JTAManagerContext jtaCtxt = (JTAManagerContext) new InitialContext().lookup(JetConstants.MANAGERS_CONTEXT + JTAManagerContext.NAME);
            this.transactionManager = jtaCtxt.getTransactionManager();
        }
        return this.transactionManager;
    }

    /**
     * Return the first shareQuantity matching the FinderMethod.
     *
     * @param finder FinderMethod to use to fetch the ShareQuantity
     * @return the shareQuantity matching the FinderMethod.
     * @see ShareQuantity
     */
    protected ShareQuantity getShareQuantity(final FinderMethod finder) {
        final ShareQuantity result;

        final SelectNut selectNut = getSelectNut(SelectStoreApplicationComponent.SHAREQUANTITY_SELECT);
        final Model model = SelectNutHelper.getModel(selectNut, finder, getLogger());
        if (model != null) {
            result = new ShareQuantity(model, this);
        } else {
            result = null;
        }

        return result;
    }

    /**
     * Sample method making a call to getShareQuantitys(final FinderMethod finder).
     *
     * @return a list of shareQuantity matching the FinderMethod.
     * @see List
     * @see ShareQuantity
     * @see #getShareQuantitys(FinderMethod finder)
     */
    public List<ShareQuantity> getShareQuantitys() {
        final ShareQuantity_FindAll0 finder = new ShareQuantity_FindAll0();

        return getShareQuantitys(finder);
    }

}
