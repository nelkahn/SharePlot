package jet.shareplot.persistence.finder.share;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.ejb.FinderException;
import javax.ejb.ObjectNotFoundException;

import jet.framework.manager.datamodel.interfaces.DataModelConverter2;
import jet.framework.manager.datamodel.interfaces.DataSourceExecutor2;
import jet.framework.manager.datamodel.interfaces.FinderObjectNotFoundException;
import jet.framework.manager.datamodel.interfaces.ModelArray;
import jet.framework.nuts.select.FinderMethod;
import jet.framework.util.ejb.EJBModelList2;
import jet.shareplot.persistence.dse.ShareDSE;
import jet.shareplot.persistence.ejb.share.ShareHome;
import jet.shareplot.persistence.ejb.share.ShareRemote;
import jet.util.throwable.JETException;

/**
 * Class for the findByPrimaryKey FinderMethod object of the Share component.
 *
 * Generated by JetTools, do not edit this file directly.
 */
public final class Share_FindByPrimaryKey1 implements FinderMethod {

    private static final long serialVersionUID = -1265738400L;
    private DataSourceExecutor2<ShareHome, ShareRemote> dse;
    private Long idShare;

    /**
     * Set idShare argument value.
     *
     * @param idShare argument value
     */
    public void setIdShare(@Nullable final Long idShare) {
        this.idShare = idShare;
    }

    @Override
    @Nonnull
    public String getFinderName() {
        return "findByPrimaryKey";
    }

    @Override
    @Nonnull
    public Map<String, Object> getArguments() {
        final Map<String, Object> args = new HashMap<String, Object>();
        args.put("idShare", this.idShare);
        return args;
    }

    @Override
    @Nonnull
    public ModelArray callFinder() throws JETException, FinderObjectNotFoundException {
        ShareRemote shareRemote;
        DataModelConverter2<ShareRemote> dmc;
        try {
            final ShareHome shareHome = getDataSourceExecutor2().getEJBHome();
            shareRemote = shareHome.findByPrimaryKey(this.idShare);

            dmc = getDataSourceExecutor2().getDataModelConverter();
        } catch (final RemoteException e) {
            throw new JETException(e.getMessage(), e);
        } catch (final ObjectNotFoundException e) {
            throw new FinderObjectNotFoundException(e.getMessage(), e);
        } catch (final FinderException e) {
            throw new JETException(e.getMessage(), e);
        }

        return new EJBModelList2<ShareRemote>(shareRemote, dmc);
    }

    @Nonnull
    private DataSourceExecutor2<ShareHome, ShareRemote> getDataSourceExecutor2() {
        DataSourceExecutor2<ShareHome, ShareRemote> result = this.dse;
        if (result == null) {
            result = this.dse = new ShareDSE();
        }
        return result;
    }
}
