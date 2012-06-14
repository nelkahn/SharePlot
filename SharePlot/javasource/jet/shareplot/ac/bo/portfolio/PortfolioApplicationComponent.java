package jet.shareplot.ac.bo.portfolio;

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
import jet.shareplot.persistence.finder.portfolio.Portfolio_FindAll0;
import jet.util.SerializableKey;
import jet.util.logger.JETLevel;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

/**
 * Portfolio manipulation API
 * 
 * Generated by JetTools, you can edit this file directly, Once created it will not be overwritten
 * 
 * @author JetToolsFramework
 */
public class PortfolioApplicationComponent extends SimpleApplicationComponent {

    private static final long serialVersionUID = 993423458L;
    /**
     * <code>NAME</code> of this application component, so it can be retrieved easily.
     */
    private final static String NAME = "PortfolioApplicationComponent";
    /**
     * <code>SESSION_KEY</code> session key
     */
    private final static Object SESSION_KEY = new SerializableKey(PortfolioApplicationComponent.class, "SESSION_KEY");

    /**
     * Get the instance of the PortfolioApplicationComponent linked to the session. If there
     * is not already one it will be created.
     * 
     * @param session
     * @return PortfolioApplicationComponent
     * @throws JETException
     */
    public static final PortfolioApplicationComponent getInstance(final Session session) throws JETException {
        PortfolioApplicationComponent portfolioAC = (PortfolioApplicationComponent) session.getProperty(SESSION_KEY);

        if (portfolioAC != null) {
            final LifeCycleState lcs = portfolioAC.getInitializableSupport().getLifeCycleState();
            if (lcs == LifeCycleState.UNINITIALIZED) {
                session.removeProperty(SESSION_KEY);
                portfolioAC = null;
            }
        }

        if (portfolioAC == null) {
            final AbstractDesktopNut desktopNut = (AbstractDesktopNut) session.getProperty(AbstractDesktopNut.SESSION_KEY_DESKTOP);
            if (desktopNut == null) {
                throw new JETException("Can only be used with an AbstractDesktopNut for the desktop.");
            }

            final ApplicationProxy appProxy = desktopNut.getApplicationProxy();
            if (appProxy.hasApplicationComponent(NAME)) {
                try {
                    final Map<String, Object> initMap = new HashMap<String, Object>();
                    portfolioAC = (PortfolioApplicationComponent) appProxy.createApplicationComponent(NAME, desktopNut.getApplicationComponent(), initMap);
                    desktopNut.registerChildApplicationComponent(portfolioAC);
                    session.setProperty(SESSION_KEY, portfolioAC);
                } catch (final JETException e) {
                    desktopNut.logp(JETLevel.SEVERE, NAME, "getInstance", e.getMessage(), e);
                    throw new JETException("Could not instantiate the PortfolioApplicationComponent.", e);
                }
            } else {
                desktopNut.logp(JETLevel.INFO, NAME, "getInstance", "NO APPLICATION COMPONENT FOUND FOR : " + NAME);
                throw new JETException("NO APPLICATION COMPONENT FOUND FOR : " + NAME);
            }
        }

        return portfolioAC;
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
     * Return all portfolio matching the FinderMethod.
     * 
     * @param finder FinderMethod to use to fetch the Portfolios
     * @return a list of portfolio matching the FinderMethod.
     * @see List
     * @see Portfolio
     */
    protected List<Portfolio> getPortfolios(final FinderMethod finder) {
        final List<Portfolio> result = new ArrayList<Portfolio>();

        final SelectNut selectNut = getSelectNut(SelectStoreApplicationComponent.PORTFOLIO_SELECT);
        final ModelArray ma = SelectNutHelper.getModelArray(selectNut, finder, getLogger());
        if (ma != null) {
            final int size = ma.getSize();
            for (int i = 0; i < size; i++) {
                final Model model = ma.get(i);
                final Portfolio portfolio = new Portfolio(model, this);
                result.add(portfolio);
            }
        }

        return result;
    }

    /**
     * Return the first portfolio matching the FinderMethod.
     * 
     * @param finder FinderMethod to use to fetch the Portfolio
     * @return the portfolio matching the FinderMethod.
     * @see Portfolio
     */
    protected Portfolio getPortfolio(final FinderMethod finder) {
        final Portfolio result;

        final SelectNut selectNut = getSelectNut(SelectStoreApplicationComponent.PORTFOLIO_SELECT);
        final Model model = SelectNutHelper.getModel(selectNut, finder, getLogger());
        if (model != null) {
            result = new Portfolio(model, this);
        } else {
            result = null;
        }

        return result;
    }

    /**
     * Get all Portfolios.
     * 
     * @return a list of all Portfolios.
     * @see List
     * @see Portfolio
     * @see #getPortfolios(FinderMethod finder)
     */
    public List<Portfolio> getPortfolios() {
        final Portfolio_FindAll0 finder = new Portfolio_FindAll0();

        return getPortfolios(finder);
    }

}
