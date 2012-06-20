package jet.shareplot.ac.bo.sharevalue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jet.container.managers.application.interfaces.ApplicationProxy;
import jet.container.managers.session.interfaces.Session;
import jet.framework.component.SimpleApplicationComponent;
import jet.framework.manager.datamodel.interfaces.ModelArray;
import jet.framework.nuts.select.FinderMethod;
import jet.framework.nuts.select.SelectNut;
import jet.framework.nuts.select.SelectNutHelper;
import jet.framework.ui.desktop.AbstractDesktopNut;
import jet.lifecycle.annotations.Deinitializer;
import jet.lifecycle.interfaces.LifeCycleState;
import jet.shareplot.ac.SelectStoreApplicationComponent;
import jet.shareplot.ac.bo.share.Share;
import jet.shareplot.persistence.finder.sharevalue.ShareValue_FindByShare1;
import jet.util.SerializableKey;
import jet.util.logger.JETLevel;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

/**
 * ShareValue manipulation API
 * 
 * Generated by JetTools, you can edit this file directly, Once created it will not be overwritten
 * 
 * @author JetToolsFramework
 */
public class ShareValueApplicationComponent extends SimpleApplicationComponent {

    private static final long serialVersionUID = 1461049825L;
    /**
     * <code>NAME</code> of this application component, so it can be retrieved easily.
     */
    private final static String NAME = "ShareValueApplicationComponent";
    /**
     * <code>SESSION_KEY</code> session key
     */
    private final static Object SESSION_KEY = new SerializableKey(ShareValueApplicationComponent.class, "SESSION_KEY");

    /**
     * Get the instance of the ShareValueApplicationComponent linked to the session. If there
     * is not already one it will be created.
     * 
     * @param session current session
     * @return ShareValueApplicationComponent
     * @throws JETException
     */
    public static final ShareValueApplicationComponent getInstance(final Session session) throws JETException {
        ShareValueApplicationComponent shareValueAC = (ShareValueApplicationComponent) session.getProperty(SESSION_KEY);

        if (shareValueAC != null) {
            final LifeCycleState lcs = shareValueAC.getInitializableSupport().getLifeCycleState();
            if (lcs == LifeCycleState.UNINITIALIZED) {
                session.removeProperty(SESSION_KEY);
                shareValueAC = null;
            }
        }

        if (shareValueAC == null) {
            final AbstractDesktopNut desktopNut = (AbstractDesktopNut) session.getProperty(AbstractDesktopNut.SESSION_KEY_DESKTOP);
            if (desktopNut == null) {
                throw new JETException("Can only be used with an AbstractDesktopNut for the desktop.");
            }

            final ApplicationProxy appProxy = desktopNut.getApplicationProxy();
            if (appProxy.hasApplicationComponent(NAME)) {
                try {
                    final Map<String, Object> initMap = new HashMap<String, Object>();
                    shareValueAC = (ShareValueApplicationComponent) appProxy.createApplicationComponent(NAME, desktopNut.getApplicationComponent(), initMap);
                    desktopNut.registerChildApplicationComponent(shareValueAC);
                    session.setProperty(SESSION_KEY, shareValueAC);
                } catch (final JETException e) {
                    desktopNut.logp(JETLevel.SEVERE, NAME, "getInstance", e.getMessage(), e);
                    throw new JETException("Could not instantiate the ShareValueApplicationComponent.", e);
                }
            } else {
                desktopNut.logp(JETLevel.INFO, NAME, "getInstance", "NO APPLICATION COMPONENT FOUND FOR : " + NAME);
                throw new JETException("NO APPLICATION COMPONENT FOUND FOR : " + NAME);
            }
        }

        return shareValueAC;
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

    /**
     * Return all shareValue matching the FinderMethod.
     * 
     * @param finder FinderMethod to use to fetch the ShareValues
     * @return a list of shareValue matching the FinderMethod.
     * @see List
     * @see ShareValue
     */
    protected List<ShareValue> getShareValues(final FinderMethod finder) {
        final List<ShareValue> result = new ArrayList<ShareValue>();

        final SelectNut selectNut = getSelectNut(SelectStoreApplicationComponent.SHAREVALUE_SELECT);
        final ModelArray ma = SelectNutHelper.getModelArray(selectNut, finder, getLogger());
        if (ma != null) {
            final int size = ma.getSize();
            for (int i = 0; i < size; i++) {
                final Model model = ma.get(i);
                final ShareValue shareValue = new ShareValue(model, this);
                result.add(shareValue);
            }
        }

        return result;
    }

    /**
     * Return the first shareValue matching the FinderMethod.
     * 
     * @param finder FinderMethod to use to fetch the ShareValue
     * @return the shareValue matching the FinderMethod.
     * @see ShareValue
     */
    protected ShareValue getShareValue(final FinderMethod finder) {
        final ShareValue result;

        final SelectNut selectNut = getSelectNut(SelectStoreApplicationComponent.SHAREVALUE_SELECT);
        final Model model = SelectNutHelper.getModel(selectNut, finder, getLogger());
        if (model != null) {
            result = new ShareValue(model, this);
        } else {
            result = null;
        }

        return result;
    }

    /**
     * Sample method making a call to getShareValues(final FinderMethod finder).
     * 
     * @return a list of shareValue matching the FinderMethod.
     * @see List
     * @see ShareValue
     * @see #getShareValues(FinderMethod finder)
     */
    public List<ShareValue> getShareValues(final Share share) {
        final ShareValue_FindByShare1 finder = new ShareValue_FindByShare1();
        finder.setIdShare(share.getIdShare());

        return getShareValues(finder);
    }

}
