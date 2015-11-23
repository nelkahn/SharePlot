package jet.shareplot.ac.bo.sharequantity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import javax.ejb.ObjectNotFoundException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.RollbackException;
import javax.transaction.TransactionManager;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import jet.container.managers.jta.interfaces.JTAManagerContext;
import jet.framework.component.SimpleApplicationComponent;
import jet.framework.manager.datamodel.interfaces.ModelArray;
import jet.framework.nuts.select.FinderMethod;
import jet.framework.nuts.select.SelectNutHelper;
import jet.framework.util.JetConstants;
import jet.framework.util.jta.TransactionHelper;
import jet.shareplot.persistence.finder.sharequantity.ShareQuantity_FindAll0;
import jet.util.logger.JETLevel;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

/**
 * ShareQuantity manipulation API.
 *
 * Generated by JetTools, do not change this file, it will be overriden at each generation.
 *
 * @author JetToolsFramework
 */
abstract class AbstractShareQuantityBOApplicationComponent extends SimpleApplicationComponent {

    private static final long serialVersionUID = 1612007130L;

    private TransactionManager transactionManager;

    /**
     * Get an instance of the POJO2 business object for the data model.
     *
     * @param model Data model
     * @return instance of the POJO2 business object
     */
    protected abstract @NonNull ShareQuantity getShareQuantity(final @NonNull Model model);

    /**
     * Return all shareQuantity matching the FinderMethod.
     *
     * @param finder FinderMethod to use to fetch the ShareQuantitys
     * @return a list of shareQuantity matching the FinderMethod.
     * @see List
     * @see ShareQuantity
     */
    protected @NonNull List<@NonNull ShareQuantity> getShareQuantitys(final @NonNull FinderMethod finder) {
        final List<@NonNull ShareQuantity> result = new ArrayList<>();

        final Callable<@Nullable Object> callable = new Callable<@Nullable Object>() {
            @Override
            public Object call() throws Exception {
                final ModelArray ma = SelectNutHelper.getModelArray(finder, getLogger());
                if (ma != null) {
                    final int size = ma.getSize();
                    for (int i = 0; i < size; i++) {
                        final @NonNull Model model = ma.get(i);
                        final ShareQuantity shareQuantity = getShareQuantity(model);
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
            logp(JETLevel.SEVERE, "AbstractShareQuantityBOApplicationComponent", "getShareQuantitys", e.getMessage(), e);
        } catch (final JETException e) {
            logp(JETLevel.SEVERE, "AbstractShareQuantityBOApplicationComponent", "getShareQuantitys", e.getMessage(), e);
        } catch (final RollbackException e) {
            logp(JETLevel.SEVERE, "AbstractShareQuantityBOApplicationComponent", "getShareQuantitys", e.getMessage(), e);
        } catch (final NamingException e) {
            logp(JETLevel.SEVERE, "AbstractShareQuantityBOApplicationComponent", "getShareQuantitys", e.getMessage(), e);
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
    protected @Nullable ShareQuantity getShareQuantity(final @NonNull FinderMethod finder) {
        final ShareQuantity result;

        final Model model = SelectNutHelper.getModel(finder, getLogger());
        if (model == null) {
            result = null;
        } else {
            result = getShareQuantity(model);
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
    public @NonNull List<@NonNull ShareQuantity> getShareQuantitys() {
        final ShareQuantity_FindAll0 finder = new ShareQuantity_FindAll0();

        return getShareQuantitys(finder);
    }
}
