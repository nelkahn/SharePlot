package jet.shareplot.persistence.finder.portfolio;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.ejb.FinderException;
import javax.ejb.ObjectNotFoundException;

import jet.framework.manager.datamodel.interfaces.DataModelConverter2;
import jet.framework.manager.datamodel.interfaces.DataSourceExecutor2;
import jet.framework.manager.datamodel.interfaces.FinderObjectNotFoundException;
import jet.framework.manager.datamodel.interfaces.ModelArray;
import jet.framework.nuts.select.FinderMethod;
import jet.framework.util.ejb.EJBModelList2;
import jet.shareplot.persistence.dse.PortfolioDSE;
import jet.shareplot.persistence.ejb.portfolio.PortfolioHome;
import jet.shareplot.persistence.ejb.portfolio.PortfolioRemote;
import jet.util.throwable.JETException;

/**
 * Class for the findByPreparedSQLQuery FinderMethod object for the Portfolio component.
 *
 * SQL Query : where @@@_SQL
 *
 * Generated by JetTools, do not edit this file directly.
 */
public final class Portfolio_FindByPreparedSQLQuery2 implements FinderMethod {

    private static final long serialVersionUID = 993423458L;
    private DataSourceExecutor2<PortfolioHome, PortfolioRemote> dse;
    private String sqlWhereClause;
    private Object[] sqlArguments;

    /**
     * Set sqlWhereClause argument value.
     *
     * @param sqlWhereClause argument value
     */
    public void setSqlWhereClause(final String sqlWhereClause) {
        this.sqlWhereClause = sqlWhereClause;
    }

    /**
     * Set sqlArguments argument value.
     *
     * @param sqlArguments argument value
     */
    public void setSqlArguments(final Object[] sqlArguments) {
        this.sqlArguments = new Object[sqlArguments.length];
        System.arraycopy(sqlArguments, 0, this.sqlArguments, 0, sqlArguments.length);
    }


    @Override
    @Nonnull
    public String getFinderName() {
        return "findByPreparedSQLQuery";
    }

    @Override
    @Nonnull
    public Map<String, Object> getArguments() {
        final Map<String, Object> args = new HashMap<String, Object>();
        args.put("sqlWhereClause", this.sqlWhereClause);
        args.put("sqlArguments", this.sqlArguments);
        return args;
    }

    @Override
    @Nonnull
    public ModelArray callFinder() throws JETException, FinderObjectNotFoundException {
        List<PortfolioRemote> list;
        DataModelConverter2<PortfolioRemote> dmc;
        try {
            final PortfolioHome portfolio = getDataSourceExecutor2().getEJBHome();
            list = (List<PortfolioRemote>) portfolio.findByPreparedSQLQuery(this.sqlWhereClause, this.sqlArguments);

            dmc = getDataSourceExecutor2().getDataModelConverter();
        } catch (final RemoteException e) {
            throw new JETException(e.getMessage(), e);
        } catch (final ObjectNotFoundException e) {
            throw new FinderObjectNotFoundException(e.getMessage(), e);
        } catch (final FinderException e) {
            throw new JETException(e.getMessage(), e);
        }

        return new EJBModelList2<PortfolioRemote>(list, dmc);
    }

    private DataSourceExecutor2<PortfolioHome, PortfolioRemote> getDataSourceExecutor2() {
        DataSourceExecutor2<PortfolioHome, PortfolioRemote> result = this.dse;
        if (result == null) {
            result = this.dse = new PortfolioDSE();
        }
        return result;
    }
}
