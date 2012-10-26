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
 * Generated by JetTools, you can edit this file directly, once created it will not be overwritten
 *
 * @author JetToolsFramework
 */
public class ShareQuantityApplicationComponent extends SimpleApplicationComponent {

    private static final long serialVersionUID = 1077646545L;
    /**
     * <code>NAME</code> of this application component, so it can be retrieved easily.
     */
    private final static String NAME = "ShareQuantityApplicationComponent";
    /**
     * <code>SESSION_KEY</code> session key
     */
    private final static Object SESSION_KEY = new SerializableKey(ShareQuantityApplicationComponent.class, "SESSION_KEY");

    /**
     * Get the instance of the ShareQuantityApplicationComponent linked to the session. If there
     * is not already one it will be created.
     *
     * @param session current session
     * @return ShareQuantityApplicationComponent
     * @throws JETException
     */
    public static final ShareQuantityApplicationComponent getInstance(final Session session) throws JETException {
        ShareQuantityApplicationComponent shareQuantityAC = (ShareQuantityApplicationComponent) session.getProperty(SESSION_KEY);

        if (shareQuantityAC != null) {
            final LifeCycleState lcs = shareQuantityAC.getInitializableSupport().getLifeCycleState();
            if (lcs == LifeCycleState.UNINITIALIZED) {
                session.removeProperty(SESSION_KEY);
                shareQuantityAC = null;
            }
        }

        if (shareQuantityAC == null) {
            final AbstractDesktopNut desktopNut = (AbstractDesktopNut) session.getProperty(AbstractDesktopNut.SESSION_KEY_DESKTOP);
            if (desktopNut == null) {
                throw new JETException("Can only be used with an AbstractDesktopNut for the desktop.");
            }

            final ApplicationProxy appProxy = desktopNut.getApplicationProxy();
            if (appProxy.hasApplicationComponent(NAME)) {
                try {
                    final Map<String, Object> initMap = new HashMap<String, Object>();
                    shareQuantityAC = (ShareQuantityApplicationComponent) appProxy.createApplicationComponent(NAME, desktopNut.getApplicationComponent(), initMap);
                    desktopNut.registerChildApplicationComponent(shareQuantityAC);
                    session.setProperty(SESSION_KEY, shareQuantityAC);
                } catch (final JETException e) {
                    desktopNut.logp(JETLevel.SEVERE, NAME, "getInstance", e.getMessage(), e);
                    throw new JETException("Could not instantiate the ShareQuantityApplicationComponent.", e);
                }
            } else {
                desktopNut.logp(JETLevel.INFO, NAME, "getInstance", "NO APPLICATION COMPONENT FOUND FOR : " + NAME);
                throw new JETException("NO APPLICATION COMPONENT FOUND FOR : " + NAME);
            }
        }

        return shareQuantityAC;
    }

    /**
     * Deinit, internal use only
     *
     * @throws JETException
     */
    @Deinitializer
    public final void doAccountACDeinit() throws JETException {
        getSession().removeProperty(SESSION_KEY);
    }

}
