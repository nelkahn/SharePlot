package jet.shareplot.persistence.finder.sharequantity;

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
import jet.shareplot.persistence.dse.ShareQuantityDSE;
import jet.shareplot.persistence.ejb.sharequantity.ShareQuantityHome;
import jet.shareplot.persistence.ejb.sharequantity.ShareQuantityRemote;
import jet.util.throwable.JETException;

/**
 * Class for the findAll FinderMethod object for the ShareQuantity component.
 *
 * SQL Query : 
 *
 * Generated by JetTools, do not edit this file directly.
 */
public class ShareQuantity_FindAll0 implements FinderCaller {

    private static final long serialVersionUID = 1077646545L;
    DataSourceExecutor2<ShareQuantityHome, ShareQuantityRemote> dse;


    @Override
    public String getFinderName() {
        return "findAll";
    }

    @Override
    public Map<String, Object> getArguments() {
        return new HashMap<String, Object>();
    }
    
    @Override
    public ModelArray callFinder() throws JETException, FinderObjectNotFoundException {

        List<ShareQuantityRemote> list;
        DataModelConverter2<ShareQuantityRemote> dmc;
        try {
            final ShareQuantityHome sharequantity = getDataSourceExecutor2().getEJBHome();
            list = (List<ShareQuantityRemote>) sharequantity.findAll();

            dmc = getDataSourceExecutor2().getDataModelConverter();
        } catch (final RemoteException e) {
            throw new JETException(e.getMessage(), e);
        } catch (final ObjectNotFoundException e) {
            throw new FinderObjectNotFoundException(e.getMessage(), e);
        } catch (final FinderException e) {
            throw new JETException(e.getMessage(), e);
        }

        return new EJBModelList2<ShareQuantityRemote>(list, dmc);
    }

    private DataSourceExecutor2<ShareQuantityHome, ShareQuantityRemote> getDataSourceExecutor2() {
        if (this.dse == null) {
            this.dse = new ShareQuantityDSE();
        }
        return this.dse;
    }
    
}
