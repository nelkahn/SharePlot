package jet.shareplot.ac.bo.portfolio;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import jet.framework.util.exception.FormatedJetException;
import jet.framework.util.pojo2.AbstractResourceNotification.NOTIFICATION_TYPE;
import jet.framework.util.pojo2.JFBusinessCallableHelper;
import jet.framework.util.pojo2.JFBusinessDeleteCallable;
import jet.framework.util.pojo2.JFBusinessErrorHelper;
import jet.framework.util.pojo2.JFBusinessItem;
import jet.framework.util.pojo2.JFBusinessSaveCallable;
import jet.shareplot.ac.SelectStoreApplicationComponent;
import jet.shareplot.persistence.pojo.PortfolioItem;
import jet.shareplot.util.TextUtils;
import jet.util.models.interfaces.Model;

/**
 * Sample bo class, extending the pojo PortfolioItem.
 * 
 * Generated by JetTools, you can edit this file directly, once created it will not be overwritten
 * 
 * @author JetToolsFramework
 */
public class Portfolio extends PortfolioItem implements JFBusinessItem, JFBusinessErrorHelper {

    private static final long serialVersionUID = 993423458L;

    private static final String CAN_NOT_SAVE_KEY = "SharePlot/properties/task/Share/dialog.CanNotSavePortfolio";
    private static final String CAN_NOT_DELETE_KEY = "SharePlot/properties/task/Share/dialog.CanNotDeletePortfolio";
    private static final String NOT_VALID_KEY = "SharePlot/properties/task/Share/dialog.PortfolioNotValid";

    private final PortfolioBOApplicationComponent portfolioAC;

    /**
     * Constructor, build an empty portfolio.
     * 
     * @param portfolioAC the portfolio application component
     * 
     * @see Model
     * @see PortfolioBOApplicationComponent
     */
    public Portfolio(@Nonnull final PortfolioBOApplicationComponent portfolioAC) {
        super();
        this.portfolioAC = portfolioAC;
    }

    /**
     * Constructor, build a portfolio from a Model.
     * 
     * @param model the model representing a portfolio entry in the table Portfolio
     * @param portfolioAC the portfolio application component
     * 
     * @see Model
     * @see PortfolioBOApplicationComponent
     */
    public Portfolio(@Nonnull final Model model, @Nonnull final PortfolioBOApplicationComponent portfolioAC) {
        super(model);
        this.portfolioAC = portfolioAC;
    }

    /**
     * Copy constructor, build a portfolio as a copy of another portfolio.
     * 
     * @param portfolio the portfolio to copy
     */
    public Portfolio(@Nonnull final Portfolio portfolio) {
        super(portfolio);
        this.portfolioAC = portfolio.portfolioAC;
    }

    @Override
    public final boolean isValid() {
        System.err.println("[Portfolio] isValid - isNotNullableNull() : " + isNotNullableNull());
        System.err.println("[Portfolio] isValid - TextUtils.isEmpty(getName() : " + TextUtils.isEmpty(getName()));
        return !isNotNullableNull() && !TextUtils.isEmpty(getName());
    }

    @Override
    public final void save() throws FormatedJetException {
        if (isValid()) {
            final PortfolioResource resource;
            if (isNew()) {
                resource = new PortfolioResource(this.portfolioAC, this, NOTIFICATION_TYPE.CREATE);
            } else {
                resource = new PortfolioResource(this.portfolioAC, this, NOTIFICATION_TYPE.UPDATE);
            }

            final JFBusinessSaveCallable callable = new JFBusinessSaveCallable(this.portfolioAC, SelectStoreApplicationComponent.PORTFOLIO_STORE, this);
            JFBusinessCallableHelper.storeChange(this.portfolioAC, callable, CAN_NOT_SAVE_KEY, this);

            resource.notifyResource();
        } else {
            throw getFormatedJetException(NOT_VALID_KEY, null);
        }
    }

    @Override
    public final void delete() throws FormatedJetException {
        if (!isNew()) {
            final JFBusinessDeleteCallable callable = new JFBusinessDeleteCallable(this.portfolioAC, SelectStoreApplicationComponent.PORTFOLIO_STORE, this);
            JFBusinessCallableHelper.storeChange(this.portfolioAC, callable, CAN_NOT_DELETE_KEY, this);

            final PortfolioResource resource = new PortfolioResource(this.portfolioAC, this, NOTIFICATION_TYPE.DELETE);
            resource.notifyResource();
        }
    }

    @Override
    public final FormatedJetException getFormatedJetException(@Nullable final String key, @Nullable final Exception e) {
        final Object[] args = { getName() };
        return new FormatedJetException(null, key, args, e);
    }

}
