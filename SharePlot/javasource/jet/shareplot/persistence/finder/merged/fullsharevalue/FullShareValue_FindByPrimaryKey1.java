package jet.shareplot.persistence.finder.merged.fullsharevalue;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.FinderException;
import javax.ejb.ObjectNotFoundException;

import jet.framework.manager.datamodel.interfaces.DataModelConverter2;
import jet.framework.manager.datamodel.interfaces.DataSourceExecutor2;
import jet.framework.manager.datamodel.interfaces.FinderObjectNotFoundException;
import jet.framework.manager.datamodel.interfaces.ModelArray;
import jet.framework.nuts.select.FinderMethod;
import jet.framework.util.ejb.EJBModelList2;
import jet.shareplot.persistence.dse.merged.FullShareValueDSE;
import jet.shareplot.persistence.ejb.sharevalue.ShareValueHome;
import jet.shareplot.persistence.ejb.sharevalue.ShareValueRemote;
import jet.util.throwable.JETException;

/**
 * Class for the findByPrimaryKey FinderMethod object of the FullShareValue component.
 *
 * Generated by JetTools, do not edit this file directly.
 */
public class FullShareValue_FindByPrimaryKey1 implements FinderMethod {

    private static final long serialVersionUID = 1;
    DataSourceExecutor2<ShareValueHome, ShareValueRemote> dse;

    Long idShareValue = null;

    /**
     * Set idShareValue argument value
     *
     * @param idShareValue argument value
     */
    public void setIdShareValue(final Long idShareValue) {
        this.idShareValue = idShareValue;
    }

    @Override
    public String getFinderName() {
        return "findByPrimaryKey";
    }

    @Override
    public Map<String, Object> getArguments() {
        final Map<String, Object> args = new HashMap<String, Object>();
        args.put("idShareValue", this.idShareValue);
        return args;
    }

    @Override
    public ModelArray callFinder() throws JETException, FinderObjectNotFoundException {

        ShareValueRemote sharevalueRemote;
        DataModelConverter2<ShareValueRemote> dmc;
        try {
            final ShareValueHome sharevalueHome = getDataSourceExecutor2().getEJBHome();
            sharevalueRemote = sharevalueHome.findByPrimaryKey(this.idShareValue);

            dmc = getDataSourceExecutor2().getDataModelConverter();
        } catch (final RemoteException e) {
            throw new JETException(e.getMessage(), e);
        } catch (final ObjectNotFoundException e) {
            throw new FinderObjectNotFoundException(e.getMessage(), e);
        } catch (final FinderException e) {
            throw new JETException(e.getMessage(), e);
        }

        return new EJBModelList2<ShareValueRemote>(sharevalueRemote, dmc);
    }

    private DataSourceExecutor2<ShareValueHome, ShareValueRemote> getDataSourceExecutor2() {
        if (this.dse == null) {
            this.dse = new FullShareValueDSE();
        }
        return this.dse;
    }
}