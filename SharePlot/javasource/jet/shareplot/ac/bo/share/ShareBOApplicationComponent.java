package jet.shareplot.ac.bo.share;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import jet.container.managers.application.interfaces.ApplicationProxy;
import jet.container.managers.session.interfaces.Session;
import jet.framework.nuts.desktop.JetDesktop;
import jet.lifecycle.annotations.Deinitializer;
import jet.lifecycle.interfaces.LifeCycleState;
import jet.shareplot.persistence.finder.share.Share_FindByPrimaryKey1;
import jet.util.SerializableKey;
import jet.util.logger.JETLevel;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

/**
 * Share manipulation API.
 * 
 * Generated by JetTools, you can edit this file directly, once created it will not be overwritten
 * 
 * @author JetToolsFramework
 */
public class ShareBOApplicationComponent extends AbstractShareBOApplicationComponent {

    private static final long serialVersionUID = -1265738400L;
    /**
     * <code>NAME</code> of this application component, so it can be retrieved easily.
     */
    private static final String NAME = "ShareBOApplicationComponent";
    /**
     * <code>SESSION_KEY</code> session key.
     */
    private static final Object SESSION_KEY = new SerializableKey(ShareBOApplicationComponent.class, "SESSION_KEY");

    /**
     * Get the instance of the ShareBOApplicationComponent linked to the session. If there
     * is not already one it will be created.
     * 
     * @param session current session
     * @return ShareBOApplicationComponent
     * @throws JETException if there is an error initializing the ApplicationComponent
     */
    @Nonnull
    public static final ShareBOApplicationComponent getInstance(final Session session) throws JETException {
        ShareBOApplicationComponent shareAC = (ShareBOApplicationComponent) session.getProperty(SESSION_KEY);

        if (shareAC != null) {
            // system to bypass the test in junit tests, can not be exploited outside junit mocking mechanism
            final Object junitKey = session.getProperty(new Object());
            if (junitKey == null) {
                final LifeCycleState lcs = shareAC.getInitializableSupport().getLifeCycleState();
                if (lcs == LifeCycleState.UNINITIALIZED) {
                    session.removeProperty(SESSION_KEY);
                    shareAC = null;
                }
            }
        }

        if (shareAC == null) {
            final JetDesktop desktopNut = (JetDesktop) session.getProperty(JetDesktop.SESSION_KEY_DESKTOP);
            if (desktopNut == null) {
                throw new JETException("Can only be used with an JetDesktop for the desktop.");
            }

            final ApplicationProxy appProxy = desktopNut.getApplicationProxy();
            if (appProxy.hasApplicationComponent(NAME)) {
                try {
                    final Map<String, Object> initMap = new HashMap<String, Object>();
                    shareAC = (ShareBOApplicationComponent) appProxy.createApplicationComponent(NAME, desktopNut.getApplicationComponent(), initMap);
                    desktopNut.registerChildApplicationComponent(shareAC);
                    session.setProperty(SESSION_KEY, shareAC);
                } catch (final JETException e) {
                    desktopNut.logp(JETLevel.SEVERE, NAME, "getInstance", e.getMessage(), e);
                    throw new JETException("Could not instantiate the ShareBOApplicationComponent.", e);
                }
            } else {
                desktopNut.logp(JETLevel.INFO, NAME, "getInstance", "NO APPLICATION COMPONENT FOUND FOR : " + NAME);
                throw new JETException("NO APPLICATION COMPONENT FOUND FOR : " + NAME);
            }
        }

        return shareAC;
    }

    /**
     * Deinit, internal use only.
     * 
     * @throws JETException if there is an error deinitializing the ApplicationComponent
     */
    @Deinitializer
    public final void doShareACDeinit() throws JETException {
        getSession().removeProperty(SESSION_KEY);
    }

    @Override
    @Nonnull
    protected Share getShare(@Nonnull final Model model) {
        return new Share(model, this);
    }

    /**
     * Get a share by its primary key.
     * 
     * @param idShare Share id
     * @return The share, <code>null</code> if there is no share with that id
     */
    @Nullable
    public Share getShare(@Nonnull final Long idShare) {
        final Share_FindByPrimaryKey1 finder = new Share_FindByPrimaryKey1();
        finder.setIdShare(idShare);

        return getShare(finder);
    }

    /**
     * Get a ShareAutoCompleteProvider.
     * 
     * @return ShareAutoCompleteProvider
     */
    @Nonnull
    public ShareAutoCompleteProvider getShareAutoCompleteProvider() {
        return new ShareAutoCompleteProvider(this);
    }

}
