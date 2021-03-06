package jet.shareplot.ui.task.share;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;

import jet.components.ui.events.MouseEvent;
import jet.components.ui.events.MouseEventType;
import jet.components.ui.events.UIEvent;
import jet.components.ui.table.common.UITableComponent2;
import jet.framework.ui.desktop.ApplicationComponentLauncher;
import jet.framework.ui.desktop.navigation.menu.CleanCloseException;
import jet.framework.ui.utils.table.UITableListDisplay3;
import jet.shareplot.ac.bo.portfolio.Portfolio;
import jet.shareplot.ac.bo.portfolio.PortfolioBOApplicationComponent;
import jet.shareplot.ac.bo.portfolio.PortfolioResource;
import jet.shareplot.ui.AbstractSharePlotListNut;
import jet.shareplot.ui.desktop.SharePlotACLauncher;
import jet.shareplot.ui.task.TaskNameConstants;
import jet.shareplot.util.BooleanConstants;
import jet.util.annotations.AnnotationsHelper;
import jet.util.logger.JETLevel;
import jet.util.throwable.JETException;

public class PortfolioListNut extends AbstractSharePlotListNut<Portfolio> {

    private PortfolioBOApplicationComponent portfolioAC;

    @Override
    public <T extends Enum<T>> void tableCellEvent(final UITableComponent2 table, final int row, final int col, final UIEvent<T> uiEvent) {
        if (this.tableList == table) {
            if (uiEvent instanceof MouseEvent) {
                // if the row is double clicked the current contact must be edited
                final MouseEvent me = (MouseEvent) uiEvent;
                if (me.getType() == MouseEventType.LEFT_CLICK) {
                    processTableLeftClick(row, col);
                }
            }
        }
    }

    private void processTableLeftClick(final int row, final int col) {
        final String colName = this.uiTableListDisplay3.getColumnName(col);

        if ("editColumn".equals(colName)) {
            final Portfolio portfolio = this.items.get(row);
            if (portfolio.getIdPortfolio() != null) {
                launchEditPortfolio(portfolio);
            }
        }
    }

    private void launchEditPortfolio(@NonNull final Portfolio portfolio) {
        final Map<String, Object> initArgs = new HashMap<String, Object>();

        final ApplicationComponentLauncher acLauncher = (ApplicationComponentLauncher) getSession().getProperty(ApplicationComponentLauncher.SESSION_KEY);

        if (acLauncher != null) {
            try {
                initArgs.put(ShareUIConstants.ARGUMENT_PORTFOLIO, new Portfolio(portfolio));
                initArgs.put(SharePlotACLauncher.AC_KEY_PARAMETER, new PortfolioDetailNutKey(portfolio.getIdPortfolio()));

                acLauncher.launchApplicationComponent(TaskNameConstants.PORTFOLIO_DETAIL, initArgs);
            } catch (final JETException e) {
                logp(JETLevel.SEVERE, "PortfolioListNut", "launchEditPortfolio", e.getMessage(), e);
            } catch (final CleanCloseException e) {
                logp(JETLevel.INFO, "PortfolioListNut", "launchEditPortfolio", e.getMessage());
            }
        }
    }

    @Override
    protected void preInit() throws JETException {
        this.portfolioAC = PortfolioBOApplicationComponent.getInstance(getSession());
    }

    @Override
    protected void postInit() throws JETException {
        // nothing to do
    }

    @Override
    protected List<Portfolio> findItems() {
        return this.portfolioAC.getPortfolios();
    }

    @Override
    protected String getListDisplayKey() {
        return "APPLICATION_COMPONENT_CONFIG.PORTFOLIO_LIST";
    }

    @Override
    protected Portfolio createNewItem() {
        final PortfolioBOApplicationComponent assertNonNull = AnnotationsHelper.assertNonNull(this.portfolioAC);
        final Portfolio portfolio = new Portfolio(assertNonNull);
        portfolio.setIsFake(BooleanConstants.NO.getDBValue());
        return portfolio;
    }

    @Override
    protected void addListDisplayProviders(final UITableListDisplay3 uiTableListDisplay) {
        // nothing to do
    }

    @Override
    @NonNull
    protected String getResourceName() {
        return AnnotationsHelper.assertNonNull(PortfolioResource.RESOURCE_NAME);
    }

    @Override
    protected Portfolio getItemCopy(@NonNull final Portfolio item) {
        return new Portfolio(item);
    }

    @Override
    protected void postSave() {
        // nothing to do
    }

    @Override
    protected void preSave() {
        // nothing to do
    }

}
