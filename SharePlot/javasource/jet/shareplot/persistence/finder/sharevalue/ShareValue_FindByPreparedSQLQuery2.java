package jet.shareplot.persistence.finder.sharevalue;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.FinderException;
import javax.ejb.ObjectNotFoundException;

import jet.framework.manager.datamodel.interfaces.DataModelConverter2;
import jet.framework.manager.datamodel.interfaces.DataSourceExecutor2;
import jet.framework.manager.datamodel.interfaces.FinderObjectNotFoundException;
import jet.framework.manager.datamodel.interfaces.ModelArray;
import jet.framework.nuts.select.FinderCaller;
import jet.framework.util.ejb.EJBModelList2;
import jet.shareplot.persistence.dse.ShareValueDSE;
import jet.shareplot.persistence.ejb.sharevalue.ShareValueHome;
import jet.shareplot.persistence.ejb.sharevalue.ShareValueRemote;
import jet.util.throwable.JETException;

/**
 * Class for the findByPreparedSQLQuery FinderMethod object for the ShareValue component.
 *
 * SQL Query : where @@@_SQL
 *
 * Generated by JetTools, do not edit this file directly.
 */
public class ShareValue_FindByPreparedSQLQuery2 implements FinderCaller {

    private static final long serialVersionUID = 1303211696L;
    DataSourceExecutor2<ShareValueHome, ShareValueRemote> dse;

    String sqlWhereClause = null;
    Object[] sqlArguments = null;

    /**
     * Set sqlWhereClause argument value
     * @param sqlWhereClause argument value
     */
    public void setSqlWhereClause(final String sqlWhereClause) {
        this.sqlWhereClause = sqlWhereClause;
    }

    /**
     * Set sqlArguments argument value
     * @param sqlArguments argument value
     */
    public void setSqlArguments(final Object[] sqlArguments) {
        this.sqlArguments = new Object[sqlArguments.length];
        System.arraycopy(sqlArguments, 0, this.sqlArguments, 0, sqlArguments.length);
    }

    @Override
    public String getFinderName() {
        return "findByPreparedSQLQuery";
    }

    @Override
    public Map<String, Object> getArguments() {
        final Map<String, Object> args = new HashMap<String, Object>();
        args.put("sqlWhereClause", this.sqlWhereClause);
        args.put("sqlArguments", this.sqlArguments);
        return args;
    }
    
    @Override
    public ModelArray callFinder() throws JETException, FinderObjectNotFoundException {

        List<ShareValueRemote> list;
        DataModelConverter2<ShareValueRemote> dmc;
        try {
            final ShareValueHome sharevalue = getDataSourceExecutor2().getEJBHome();
            list = (List<ShareValueRemote>) sharevalue.findByPreparedSQLQuery( this.sqlWhereClause, this.sqlArguments);

            dmc = getDataSourceExecutor2().getDataModelConverter();
        } catch (final RemoteException e) {
            throw new JETException(e.getMessage(), e);
        } catch (final ObjectNotFoundException e) {
            throw new FinderObjectNotFoundException(e.getMessage(), e);
        } catch (final FinderException e) {
            throw new JETException(e.getMessage(), e);
        }

        return new EJBModelList2<ShareValueRemote>(list, dmc);
    }

    private DataSourceExecutor2<ShareValueHome, ShareValueRemote> getDataSourceExecutor2() {
        if (this.dse == null) {
            this.dse = new ShareValueDSE();
        }
        return this.dse;
    }
    
}
