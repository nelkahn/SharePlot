package jet.shareplot.ac.bo.share;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import javax.ejb.ObjectNotFoundException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.RollbackException;
import javax.transaction.TransactionManager;

import jet.container.managers.jta.interfaces.JTAManagerContext;
import jet.framework.component.SimpleApplicationComponent;
import jet.framework.manager.datamodel.interfaces.ModelArray;
import jet.framework.nuts.select.FinderMethod;
import jet.framework.nuts.select.SelectNutHelper;
import jet.framework.util.JetConstants;
import jet.framework.util.jta.TransactionHelper;
import jet.shareplot.ac.SelectStoreApplicationComponent;
import jet.shareplot.persistence.finder.share.Share_FindAll0;
import jet.util.logger.JETLevel;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

/**
 * Share manipulation API.
 *
 * Generated by JetTools, do not change this file, it will be overriden at each generation.
 *
 * @author JetToolsFramework
 */
abstract class AbstractShareBOApplicationComponent extends SimpleApplicationComponent {

    private static final long serialVersionUID = -1939421298L;

    private TransactionManager transactionManager;

    /**
     * Get an instance of the POJO2 business object for the data model.
     *
     * @param model Data model
     * @return instance of the POJO2 business object
     */
    protected abstract @NonNull Share getShare(final @NonNull Model model);

    /**
     * Return all share matching the FinderMethod.
     *
     * @param finder FinderMethod to use to fetch the Shares
     * @return a list of share matching the FinderMethod.
     * @see List
     * @see Share
     */
    protected @NonNull List<@NonNull Share> getShares(final @NonNull FinderMethod finder) {
        final List<@NonNull Share> result = new ArrayList<>();

        final Callable<@Nullable Object> callable = new Callable<@Nullable Object>() {
            @Override
            public Object call() throws Exception {
                final ModelArray ma = SelectNutHelper.getModelArray(finder, getLogger());
                if (ma != null) {
                    final int size = ma.getSize();
                    for (int i = 0; i < size; i++) {
                        final Model model = ma.get(i);
                        assert model != null;
                        final Share share = getShare(model);
                        result.add(share);
                    }
                }
                return null;
            }
        };
        try {
            final TransactionManager transactionMgr = getTransactionManager();
            TransactionHelper.runTransaction(callable, transactionMgr);
        } catch (final ObjectNotFoundException e) {
            logp(JETLevel.SEVERE, "AbstractShareBOApplicationComponent", "getShares", e.getMessage(), e);
        } catch (final JETException e) {
            logp(JETLevel.SEVERE, "AbstractShareBOApplicationComponent", "getShares", e.getMessage(), e);
        } catch (final RollbackException e) {
            logp(JETLevel.SEVERE, "AbstractShareBOApplicationComponent", "getShares", e.getMessage(), e);
        } catch (final NamingException e) {
            logp(JETLevel.SEVERE, "AbstractShareBOApplicationComponent", "getShares", e.getMessage(), e);
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
     * Return the first share matching the FinderMethod.
     *
     * @param finder FinderMethod to use to fetch the Share
     * @return the share matching the FinderMethod.
     * @see Share
     */
    protected @Nullable Share getShare(final @NonNull FinderMethod finder) {
        final Share result;

        final Model model = SelectNutHelper.getModel(finder, getLogger());
        if (model == null) {
            result = null;
        } else {
            result = getShare(model);
        }

        return result;
    }

    /**
     * Sample method making a call to getShares(final FinderMethod finder).
     *
     * @return a list of share matching the FinderMethod.
     * @see List
     * @see Share
     * @see #getShares(FinderMethod finder)
     */
    public @NonNull List<Share> getShares() {
        final Share_FindAll0 finder = new Share_FindAll0();

        return getShares(finder);
    }
}
